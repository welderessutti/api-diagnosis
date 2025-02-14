package br.com.fiap.api_diagnosis.framework.dto.event.consumer;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GlycatedHemoglobinCreatedEventDto {

    private Long id;
    private Long patientId;
    private Double result;
}
