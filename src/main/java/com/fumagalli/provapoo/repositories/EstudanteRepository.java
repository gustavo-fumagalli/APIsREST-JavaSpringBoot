package com.fumagalli.provapoo.repositories;

import com.fumagalli.provapoo.models.EstudanteModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EstudanteRepository extends JpaRepository<EstudanteModel, Long> {
}
