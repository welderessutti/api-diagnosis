package br.com.fiap.api_diagnosis.infrastructe.repository;

import br.com.fiap.api_diagnosis.infrastructe.entity.DiagnosisEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DiagnosisRepository extends JpaRepository<DiagnosisEntity, Long> {
}
