package br.com.fiap.api_diagnosis.framework.mapper;

import br.com.fiap.api_diagnosis.core.domain.GlycatedHemoglobin;
import br.com.fiap.api_diagnosis.framework.dto.event.consumer.GlycatedHemoglobinCreatedEventDto;

public class GlycatedHemoglobinDtoDomainMapper {

    public static GlycatedHemoglobin toGlycatedHemoglobin(
            GlycatedHemoglobinCreatedEventDto glycatedHemoglobinCreatedEventDto
    ) {
        GlycatedHemoglobin glycatedHemoglobin = new GlycatedHemoglobin();
        glycatedHemoglobin.setId(glycatedHemoglobinCreatedEventDto.getId());
        glycatedHemoglobin.setPatientId(glycatedHemoglobinCreatedEventDto.getPatientId());
        glycatedHemoglobin.setResult(glycatedHemoglobinCreatedEventDto.getResult());
        return glycatedHemoglobin;
    }
}
