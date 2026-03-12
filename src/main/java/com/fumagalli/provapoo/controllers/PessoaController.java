package com.fumagalli.provapoo.controllers;

import com.fumagalli.provapoo.models.EstudanteModel;
import com.fumagalli.provapoo.services.EstudanteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/pessoas")
public class PessoaController {

    @Autowired
    private EstudanteService estudanteService;

    @GetMapping
    public ResponseEntity<List<EstudanteModel>> findAll() {
        List<EstudanteModel> requeste = estudanteService.findAll();
        return ResponseEntity.ok().body(requeste);
    }

    @PostMapping
    public ResponseEntity<EstudanteModel> criarPessoa(@RequestBody EstudanteModel estudanteModel) {

        EstudanteModel requeste = estudanteService.criarPessoa(estudanteModel);

        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(requeste.getId())
                .toUri();

        return ResponseEntity.created(uri).body(requeste);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EstudanteModel> buscarId(@PathVariable Long id) {

        Optional<EstudanteModel> estudante = estudanteService.buscarid(id);

        return estudante
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<EstudanteModel> atualizar(
            @PathVariable Long id,
            @RequestBody EstudanteModel estudanteModel) {

        EstudanteModel atualizado = estudanteService.Atualizar(id, estudanteModel);
        return ResponseEntity.ok().body(atualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<EstudanteModel> deletar (@PathVariable Long id){
        estudanteService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}