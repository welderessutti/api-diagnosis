package br.com.fiap.api_diagnosis.framework.event;

import br.com.fiap.api_diagnosis.core.domain.GlycatedHemoglobin;
import br.com.fiap.api_diagnosis.core.port.in.GlycatedHemoglobinPortIn;
import br.com.fiap.api_diagnosis.framework.dto.event.consumer.GlycatedHemoglobinCreatedEventDto;
import br.com.fiap.api_diagnosis.framework.mapper.GlycatedHemoglobinDtoDomainMapper;
import org.springframework.stereotype.Component;

import java.util.function.Consumer;

@Component
public class GlycatedHemoglobinCreatedEventListener implements Consumer<GlycatedHemoglobinCreatedEventDto> {

    private final GlycatedHemoglobinPortIn glycatedHemoglobinPortIn;

    public GlycatedHemoglobinCreatedEventListener(GlycatedHemoglobinPortIn glycatedHemoglobinPortIn) {
        this.glycatedHemoglobinPortIn = glycatedHemoglobinPortIn;
    }

    @Override
    public void accept(GlycatedHemoglobinCreatedEventDto glycatedHemoglobinCreatedEventDto) {
        GlycatedHemoglobin glycatedHemoglobin = GlycatedHemoglobinDtoDomainMapper
                .toGlycatedHemoglobin(glycatedHemoglobinCreatedEventDto);
        glycatedHemoglobinPortIn.setDiagnosis(glycatedHemoglobin);
    }
}
