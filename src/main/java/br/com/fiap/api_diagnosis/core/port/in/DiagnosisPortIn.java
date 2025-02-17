package br.com.fiap.api_diagnosis.core.port.in;

import br.com.fiap.api_diagnosis.core.domain.Diagnosis;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface DiagnosisPortIn {

    Diagnosis createDiagnosis(Diagnosis diagnosis);

    Page<Diagnosis> getDiagnoses(Pageable pageable);

    Diagnosis getDiagnosisById(Long diagnosisId);

    Diagnosis updateDiagnosis(Long diagnosisId, Diagnosis updatedDiagnosis);

    void deleteDiagnosisById(Long diagnosisId);
}
