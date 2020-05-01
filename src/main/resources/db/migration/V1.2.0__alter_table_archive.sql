ALTER TABLE archive DROP COLUMN version;
ALTER TABLE archive DROP COLUMN file_name;

CREATE TABLE version (
  id INT(8),
  id_archive INT,
  file_name VARCHAR(255),
  version VARCHAR(255),
  CONSTRAINT id_version_pk PRIMARY KEY (id),
  CONSTRAINT id_archive_fk_archive FOREIGN KEY (id_archive) REFERENCES archive(id)
);