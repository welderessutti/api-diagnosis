package br.com.fiap.api_diagnosis.infrastructe.mapper;

import br.com.fiap.api_diagnosis.core.domain.Diagnosis;
import br.com.fiap.api_diagnosis.infrastructe.entity.DiagnosisEntity;

import static java.util.Objects.nonNull;

public class DiagnosisDomainEntityMapper {

    public static DiagnosisEntity toDiagnosisEntity(Diagnosis diagnosis) {
        DiagnosisEntity diagnosisEntity = new DiagnosisEntity();
        if (nonNull(diagnosis.getId())) {
            diagnosisEntity.setId(diagnosis.getId());
        }
        diagnosisEntity.setGlycatedHemoglobinTestId(diagnosis.getGlycatedHemoglobinTestId());
        diagnosisEntity.setPatientId(diagnosis.getPatientId());
        diagnosisEntity.setGlycatedHemoglobinTestStatus(diagnosis.getGlycatedHemoglobinTestStatus());
        diagnosisEntity.setDiagnosisDate(diagnosis.getDiagnosisDate());
        return diagnosisEntity;
    }

    public static Diagnosis toDiagnosis(DiagnosisEntity diagnosisEntity) {
        Diagnosis diagnosis = new Diagnosis();
        diagnosis.setId(diagnosisEntity.getId());
        diagnosis.setGlycatedHemoglobinTestId(diagnosisEntity.getGlycatedHemoglobinTestId());
        diagnosis.setPatientId(diagnosisEntity.getPatientId());
        diagnosis.setGlycatedHemoglobinTestStatus(diagnosisEntity.getGlycatedHemoglobinTestStatus());
        diagnosis.setDiagnosisDate(diagnosisEntity.getDiagnosisDate());
        return diagnosis;
    }
}
