package Entities;

import java.sql.Date;

public class Reservation {

    private int id;
    private Date date;
    private int hour;
    private int minute;
    private Client client;
    private Table table;
    private int idClient;
    private int idTable;
    private int numPeople;

    public Reservation() {
    }

    public Reservation(Date date, int hour, int minute, Client client, Table table, int numPeople) {
        this.date = date;
        this.hour = hour;
        this.minute = minute;
        this.client = client;
        this.table = table;
        this.numPeople = numPeople;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getHour() {
        return hour;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }

    public int getMinute() {
        return minute;
    }

    public void setMinute(int minute) {
        this.minute = minute;
    }

    public int getNumPeople() {
        return numPeople;
    }

    public void setNumPeople(int numPeople) {
        this.numPeople = numPeople;
    }

    public int getIdClient() {
        return idClient;
    }

    public void setClientId(Client client) {
        this.idClient = client.getId();
    }
    
    public int getTableId() {
        return idTable;
    }

    public void setTable(Table table) {
        this.idTable = table.getId();
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + this.id;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Reservation other = (Reservation) obj;
        return this.id == other.id;
    }

}
