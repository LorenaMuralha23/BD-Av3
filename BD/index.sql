CREATE INDEX idx_reservation_date_client ON tb_reservation (reservation_date, id_client);

CREATE INDEX idx_client_id_name ON tb_client (id, name);

CREATE INDEX idx_table_id_location ON tb_table (id, location);


