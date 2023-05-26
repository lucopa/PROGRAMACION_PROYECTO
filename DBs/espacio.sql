PRAGMA FOREIGN_KEYS = ON;


DROP TABLE IF EXISTS RESERVA;
CREATE TABLE RESERVA (
	codigo_reserva INTEGER PRIMARY KEY,
	fecha_reserva TEXT,
	duracion REAL,
	hora INTEGER,
	motivo TEXT,
	id_espacio INTEGER,
	FOREIGN KEY(id_espacio) REFERENCES ESPACIO(id_espacio) ON DELETE CASCADE ON UPDATE CASCADE
); 




DROP TABLE IF EXISTS ESPACIO;
CREATE TABLE ESPACIO (
	id_espacio INTEGER primary key,
	descripcion TEXT,
	capacidad INTEGER CHECK (capacidad>0 AND capacidad<30),
	ordenadores INTEGER CHECK (ordenadores = 0 OR ordenadores = 1),
	pizarra INTEGER CHECK (pizarra = 0 OR pizarra = 1),
	proyector INTEGER CHECK (proyector = 0 OR proyector = 1),
  	nombre TEXT CHECK(nombre IN ("1.1", "1.2","2.1","2.2","0.1")),
  	codigo_reserva INTEGER,
  	FOREIGN KEY(codigo_reserva) REFERENCES RESERVA(codigo_reserva) ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE INDEX id_espacio_equipamiento ON espacio(pizarra, proyector, ordenadores);

DROP VIEW IF EXISTS vista_reserva_espacio;
CREATE VIEW vista_reserva_espacio AS
SELECT r.codigo_reserva, r.hora, r.fecha_reserva, e.nombre, e.capacidad, e.proyector, e.ordenadores, e.pizarra
FROM reserva r, espacios e
WHERE r.id_espacio = e.id_espacio;


DROP TABLE IF EXISTS historial;
CREATE TABLE historial(
	nombre_borrado INTEGER,
	descripcion_borrado TEXT,
	fecha TEXT
);
		

DROP TRIGGER IF EXISTS borrado_espacio;
CREATE TRIGGER borrado_espacio BEFORE DELETE
ON espacio
BEGIN 
	INSERT INTO historial (nombre_borrado,descripcion_borrado,fecha) VALUES (old.nombre, old.descripcion, DATETIME());
END;


