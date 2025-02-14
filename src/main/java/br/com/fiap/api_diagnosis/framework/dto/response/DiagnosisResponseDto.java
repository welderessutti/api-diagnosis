package br.com.fiap.api_diagnosis.framework.dto.response;

import br.com.fiap.api_diagnosis.core.domain.TestStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DiagnosisResponseDto {

    private Long id;
    private Long glycatedHemoglobinTestId;
    private Long patientId;
    private TestStatus glycatedHemoglobinTestStatus;
    private LocalDateTime diagnosisDate;
}
