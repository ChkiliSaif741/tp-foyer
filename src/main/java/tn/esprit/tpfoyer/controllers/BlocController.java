package tn.esprit.tpfoyer.controllers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.tpfoyer.entity.Bloc;
import tn.esprit.tpfoyer.services.IBlocServiceImp;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping(value = "/bloc")
public class BlocController {
    private final IBlocServiceImp blocService;

    @PostMapping
    public Bloc addBloc(@RequestBody Bloc bloc) {
        return blocService.addBloc(bloc);
    }

    @PutMapping
    public Bloc updateBloc(@RequestBody Bloc bloc) {
        return blocService.updateBloc(bloc);
    }

    @DeleteMapping("/{id}")
    public void deleteBloc(@PathVariable Long id) {
        blocService.deleteBloc(id);
    }

    @GetMapping
    public List<Bloc> getAllBloc() {
        return blocService.findAllBlocs();
    }

    @GetMapping("{id}")
    public Bloc getBlocById(@PathVariable Long id) {
        return blocService.findBlocById(id);
    }
}
