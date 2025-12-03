package tn.esprit.tpfoyer.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Foyer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idFoyer;

    private String nomFoyer;

    private Long capaciteFoyer;


    @OneToOne
    @JsonIgnore
    Universite universite;
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "foyer")
    @JsonIgnore
    Set<Bloc> blocset;
}
