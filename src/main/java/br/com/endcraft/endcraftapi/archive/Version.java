package br.com.endcraft.endcraftapi.archive;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Version implements Serializable {

    private static final long serialVersionUID = -8315087044355867390L;

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    @JoinColumn(name = "id_archive")
    @ManyToOne
    @JsonBackReference
    private Archive archive;

    @Size(max = 255, message = "error.archive.file_name.max")
    private String fileName;

    private String version;

}
