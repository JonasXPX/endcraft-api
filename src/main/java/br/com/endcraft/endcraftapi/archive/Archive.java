package br.com.endcraft.endcraftapi.archive;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Size;

@Entity
@Setter
@Getter
public class Archive {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Size(max = 255, message = "error.archive.code.max")
    private String code;

    @Size(max = 255, message = "error.archive.file_name.max")
    private String fileName;

}
