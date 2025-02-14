package br.com.fiap.api_diagnosis.framework.dto.request;

import br.com.fiap.api_diagnosis.core.domain.TestStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DiagnosisRequestDto {

    private Long glycatedHemoglobinTestId;
    private Long patientId;
    private TestStatus glycatedHemoglobinTestStatus;
}
