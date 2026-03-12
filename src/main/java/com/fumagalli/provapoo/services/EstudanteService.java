package com.fumagalli.provapoo.services;

import com.fumagalli.provapoo.models.EstudanteModel;
import com.fumagalli.provapoo.repositories.EstudanteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EstudanteService {

    @Autowired
    private EstudanteRepository estudanteRepository;

    public List<EstudanteModel> findAll() {
        return estudanteRepository.findAll();
    }

    public EstudanteModel criarPessoa(EstudanteModel estudanteModel) {
        return estudanteRepository.save(estudanteModel);
    }

    public Optional<EstudanteModel> buscarid(Long id) {
        return estudanteRepository.findById(id);
    }

    public EstudanteModel Atualizar(long id, EstudanteModel estudanteModel) {
        EstudanteModel model = estudanteRepository.findById(id).get(); //usa o .get() pra pegar o elemento do optional

        model.setNome(estudanteModel.getNome());

        return estudanteRepository.save(estudanteModel);
    }


    public void deletar(Long id){
        estudanteRepository.deleteById(id);
    }
}