package br.com.endcraft.endcraftapi.archive;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Set;

@Entity
@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@NamedEntityGraph(
        name = "graph.archive",
        attributeNodes = {
                @NamedAttributeNode("fileVersions")
        })
public class Archive implements Serializable {


    private static final long serialVersionUID = -3621344448808482265L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Size(max = 255, message = "error.archive.code.max")
    private String code;

    @OneToMany(mappedBy = "archive", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Version> fileVersions;

}
