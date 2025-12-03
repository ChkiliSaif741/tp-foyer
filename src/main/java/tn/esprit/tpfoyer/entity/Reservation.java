package tn.esprit.tpfoyer.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idReservation;

    private Date anneeUniversitaire;

    private Boolean estValide;

    @ManyToMany (mappedBy = "reservations2")
    @JsonIgnore
    Set<Etudiant> etudiants;

    @ManyToOne
    @JsonIgnore
    private Chambre chambre;
}
