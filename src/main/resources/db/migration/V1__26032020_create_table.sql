CREATE TABLE archive (
    id INT PRIMARY KEY AUTO_INCREMENT,
    code VARCHAR(255),
    file_name VARCHAR(255)
);
CREATE TABLE downloads (
   id INT AUTO_INCREMENT,
   id_archive INT,
   download_times INT(32) NOT NULL DEFAULT 0,
   PRIMARY KEY(id),
   CONSTRAINT download_times_fk FOREIGN KEY (id_archive) REFERENCES archive(id)
);