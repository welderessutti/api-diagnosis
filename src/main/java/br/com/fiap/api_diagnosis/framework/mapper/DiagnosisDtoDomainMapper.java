package br.com.fiap.api_diagnosis.framework.mapper;

import br.com.fiap.api_diagnosis.core.domain.Diagnosis;
import br.com.fiap.api_diagnosis.framework.dto.request.DiagnosisRequestDto;
import br.com.fiap.api_diagnosis.framework.dto.response.DiagnosisResponseDto;

public class DiagnosisDtoDomainMapper {

    public static Diagnosis toDiagnosis(DiagnosisRequestDto request) {
        Diagnosis diagnosis = new Diagnosis();
        diagnosis.setGlycatedHemoglobinTestId(request.getGlycatedHemoglobinTestId());
        diagnosis.setPatientId(request.getPatientId());
        diagnosis.setGlycatedHemoglobinTestStatus(request.getGlycatedHemoglobinTestStatus());
        return diagnosis;
    }

    public static DiagnosisResponseDto toDiagnosisResponseDto(Diagnosis diagnosis) {
        DiagnosisResponseDto diagnosisResponseDto = new DiagnosisResponseDto();
        diagnosisResponseDto.setId(diagnosis.getId());
        diagnosisResponseDto.setGlycatedHemoglobinTestId(diagnosis.getGlycatedHemoglobinTestId());
        diagnosisResponseDto.setPatientId(diagnosis.getPatientId());
        diagnosisResponseDto.setGlycatedHemoglobinTestStatus(diagnosis.getGlycatedHemoglobinTestStatus());
        diagnosisResponseDto.setDiagnosisDate(diagnosis.getDiagnosisDate());
        return diagnosisResponseDto;
    }
}
