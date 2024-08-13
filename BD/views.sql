/*Mesas disponíveis no dia de hoje*/
CREATE OR REPLACE VIEW Free_Tables_Today AS
SELECT tb_table.number AS table_number, tb_table.capacity AS table_capacity, tb_table.location AS table_location 
FROM tb_table LEFT JOIN tb_reservation ON tb_table.id = tb_reservation.id_table AND tb_reservation.reservation_date = CURDATE() WHERE tb_reservation.id_table IS NULL;