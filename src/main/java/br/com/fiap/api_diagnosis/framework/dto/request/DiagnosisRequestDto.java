package br.com.fiap.api_diagnosis.framework.dto.request;

import br.com.fiap.api_diagnosis.core.domain.TestStatus;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DiagnosisRequestDto {

    @NotNull
    private Long glycatedHemoglobinTestId;

    @NotNull
    private Long patientId;

    @NotNull
    private TestStatus glycatedHemoglobinTestStatus;
}
