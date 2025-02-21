package br.com.fiap.api_diagnosis.framework.dto.event.consumer;

import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GlycatedHemoglobinCreatedEventDto {

    @JsonAlias("idExame")
    private Long id;

    @JsonAlias("idPaciente")
    private Long patientId;

    @JsonAlias("resultadoExame")
    private Double result;
}
