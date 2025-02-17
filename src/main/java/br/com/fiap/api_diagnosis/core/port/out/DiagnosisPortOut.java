package br.com.fiap.api_diagnosis.core.port.out;

import br.com.fiap.api_diagnosis.core.domain.Diagnosis;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface DiagnosisPortOut {

    Diagnosis createDiagnosis(Diagnosis diagnosis);

    Page<Diagnosis> getDiagnoses(Pageable pageable);

    Optional<Diagnosis> getDiagnosisById(Long diagnosisId);

    Diagnosis updateDiagnosis(Diagnosis updatedDiagnosis);

    void deleteDiagnosisById(Long id);

    boolean existsDiagnosisById(Long diagnosisId);
}
