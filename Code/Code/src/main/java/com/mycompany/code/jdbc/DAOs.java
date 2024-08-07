package com.mycompany.code.jdbc;

import Entities.Client;
import Entities.Reservation;
import Entities.Table;
import static com.mycompany.code.jdbc.DBConnection.connection;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLType;
import java.sql.Statement;
import java.sql.Types;
import static java.sql.Types.INTEGER;
import java.util.ArrayList;

public class DAOs {

    private Connection conn;

    public DAOs(Connection conn) {
        this.conn = conn;
    }

    // Bora lá para os tutorialzinhos para usar os métodos :)
    /*Seguinte: Quando vc for fazer uma reserva, antes você cria um objeto cliente e usa o método createNewClient ali embaixo. 
    Com o table, você pega a localização da mesa e chama o método abaixo getTableByLocation(). As mesas já foram pré criadas :)
    
    Agora sobre o método. Basicamente você cria a reservation com os dados que o user botar no formulário e envia pra cá. Ele retornará um inteiro que é:
    1 - A reserva foi criada.
    0 - Já existe uma reserva para o mesmo horário na mesma mesa
     */
    public int insertReservation(Reservation reservation) throws SQLException {

        CallableStatement callableStatement = this.conn.prepareCall("{CALL reserve_table(?, ?, ?, ?, ?, ?, ?)}");

        callableStatement.setDate(1, reservation.getDate());
        callableStatement.setInt(2, reservation.getHour());
        callableStatement.setInt(3, reservation.getMinute());
        callableStatement.setInt(4, reservation.getIdClient());
        callableStatement.setInt(5, reservation.getTableId());
        callableStatement.setInt(6, reservation.getNumPeople());

        callableStatement.registerOutParameter(7, java.sql.Types.INTEGER);

        callableStatement.execute();

        int numReservationCreated = callableStatement.getInt(7);
        return numReservationCreated;

    }

    public int cancelReservation(Reservation reservation) throws SQLException {

        CallableStatement callableStatement = this.conn.prepareCall("{CALL cancel_reservation(?, ?, ?, ?, ?, ?, ?)}");

        callableStatement.setDate(1, reservation.getDate());
        callableStatement.setInt(2, reservation.getHour());
        callableStatement.setInt(3, reservation.getMinute());
        callableStatement.setInt(4, reservation.getIdClient());
        callableStatement.setInt(5, reservation.getTableId());
        callableStatement.setInt(6, reservation.getNumPeople());

        callableStatement.registerOutParameter(7, java.sql.Types.INTEGER);

        callableStatement.execute();

        int canceledStatus = callableStatement.getInt(7);
        return canceledStatus;
    }

    // esse método pega as mesas disponíveis para hoje. No caso, nem sei se vai usar pro front, mas como era a view deixei aqui se quiser :)
    public ArrayList<Table> getFreeTablesTodayView() throws SQLException {
        Statement stmt = this.conn.createStatement();
        String query = "SELECT * FROM Free_Tables_Today";
        ResultSet resultSet;
        ArrayList<Table> tables = new ArrayList<>();

        resultSet = stmt.executeQuery(query);

        while (resultSet.next()) {
            int tableNumber = resultSet.getInt("table_number");
            int tableCapacity = resultSet.getInt("table_capacity");
            int tableLocation = resultSet.getInt("table_location");
            Table table = new Table(tableNumber, tableCapacity, tableLocation);
            tables.add(table);
        }

        return tables;
    }
    
    //esse método retorna o id do cliente criado
    public int createNewClient(Client client) throws SQLException {
        CallableStatement callableStatement = conn.prepareCall("{CALL create_client(?, ?, ?, ?)}");

        callableStatement.setString(1, client.getName());
        callableStatement.setString(2, client.getEmail());
        callableStatement.setString(3, client.getPhone());

        callableStatement.registerOutParameter(4, Types.INTEGER);

        callableStatement.execute();

        int idClient = callableStatement.getInt(4);
        if (idClient != 0) {
            client.setId(idClient);
        }

        return idClient;
    }

    //retorna todas as mesmas do restaurante
    public ArrayList<Table> getTables() throws SQLException {
        String sql = "SELECT * FROM tb_table";
        ArrayList<Table> tables = new ArrayList<>();

        try ( PreparedStatement preparedStatement = this.conn.prepareStatement(sql)) {

            try ( ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    int tableNumber = resultSet.getInt("number");
                    int tableCapacity = resultSet.getInt("capacity");
                    int tableLocation = resultSet.getInt("location");
                    Table table = new Table(tableNumber, tableCapacity, tableLocation);
                    tables.add(table);
                }
            }
        }

        return tables;
    }

    public Table getTableByLocation(int location) throws SQLException {
        String sql = "SELECT * FROM tb_table WHERE tb_table.location = ?";
        Table table = null;

        try ( PreparedStatement preparedStatement = this.conn.prepareStatement(sql)) {
            preparedStatement.setInt(1, location);

            try ( ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    int tableNumber = resultSet.getInt("number");
                    int tableCapacity = resultSet.getInt("capacity");
                    int tableLocation = resultSet.getInt("location");
                    table = new Table(tableNumber, tableCapacity, tableLocation);
                }
            }
        }

        return table;
    }

}
