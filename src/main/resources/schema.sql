CREATE TABLE documento (
    id_documento   INTEGER      NOT NULL AUTO_INCREMENT,
    documento VARCHAR(128) NOT NULL,
    PRIMARY KEY (id_documento)
);

CREATE TABLE persona (
    id_persona   INTEGER      NOT NULL AUTO_INCREMENT,
    primer_nombre VARCHAR(128) NOT NULL,
    segundo_nombre VARCHAR(128) NOT NULL,
    primer_apellido VARCHAR(128) NOT NULL,
    segundo_apellido VARCHAR(128) NOT NULL,
    telefono VARCHAR(128) NOT NULL,
    direccion VARCHAR(128) NOT NULL,
    ciudad_residencia VARCHAR(128) NOT NULL,
    PRIMARY KEY (id_persona)
);

CREATE TABLE documento_persona (
    id_documento_persona   INTEGER      NOT NULL AUTO_INCREMENT,
    persona_id INTEGER NOT NULL,
    documento_id INTEGER NOT NULL,
    numero_documento INTEGER NOT NULL,
    PRIMARY KEY (id_documento_persona)

);

ALTER TABLE documento_persona
    ADD FOREIGN KEY (persona_id) REFERENCES persona(id_persona);
ALTER TABLE documento_persona
    ADD FOREIGN KEY (documento_id) REFERENCES documento(id_documento);