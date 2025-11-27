package tn.esprit.tpfoyer.dto;

import lombok.Data;

import java.util.List;

@Data
public class AffecterChambresRequest {
    private List<Long> numChambres;
    private String nomBloc;
}

