/*Retorna se existe uma mesa disponível para aquele determinado dia
DELIMITER $$
CREATE PROCEDURE reserved_tables_by_date (
	IN reservation_date DATE,
    IN reservation_hour INT,
    IN reservation_minute INT,
    IN num_people INT, 
    OUT num_reservations INT
)
BEGIN
    SELECT COUNT(*) INTO num_reservations FROM tb_table JOIN tb_reservation WHERE tb_table.id = tb_reservation.id_table 
    AND (tb_reservation.num_people = num_people OR tb_reservation.num_people > num_people) AND tb_reservation.reservation_hour = reservation_hour AND tb_reservation.reservation_minute = reservation_minute 
    AND tb_reservation.reservation_date = reservation_date;
END$$
DELIMITER ;*/

/*Faz uma reserva
DELIMITER $$
CREATE PROCEDURE reserve_table (
	IN reservation_date DATE,
    IN reservation_hour INT,
    IN reservation_minute INT,
    IN id_client INT,
    IN id_table INT,
    IN num_people INT
)
BEGIN
    DECLARE num_reservations INT;
    
    CALL reserved_tables_by_date(reservation_date, reservation_hour, reservation_minute, num_people,  num_reservations);
    
    IF num_reservations = 0 THEN
        INSERT INTO tb_reservation (reservation_date, reservation_hour, reservation_minute, id_client, id_table, num_people)
        VALUES (reservation_date, reservation_hour, reservation_minute, id_client, id_table, num_people);
		SELECT num_reservations AS db_message; 
	ELSE
		SELECT num_reservations AS db_message; 
    END IF;
    
    
END$$
DELIMITER ;*/

DELIMITER $$
CREATE PROCEDURE cancel_reservation (
	IN reservation_date DATE,
    IN reservation_hour INT,
    IN reservation_minute INT,
    IN id_client INT,
    IN id_table INT,
    IN num_people INT
)
BEGIN
    DECLARE num_reservations INT;
    
    CALL reserved_tables_by_date(reservation_date, reservation_hour, reservation_minute, num_people,  num_reservations);
    
    IF num_reservations > 0 THEN
       DELETE FROM tb_reservation WHERE tb_reservation.reservation_date = reservation_date AND
       tb_reservation.reservation_hour = reservation_hour AND tb_reservation.reservation_minute = reservation_minute AND tb_reservation.id_client = id_client AND
       tb_reservation.id_table = id_table AND tb_reservation.num_people = num_people;
       
       SELECT "Reservation canceled!" as db_message;
	ELSE
		SELECT "Reservation not founded!" as db_message;
	END IF;

END$$
DELIMITER ;
