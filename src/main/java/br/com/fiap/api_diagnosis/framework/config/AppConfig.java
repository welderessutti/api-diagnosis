package br.com.fiap.api_diagnosis.framework.config;

import br.com.fiap.api_diagnosis.core.port.in.DiagnosisPortIn;
import br.com.fiap.api_diagnosis.core.port.in.GlycatedHemoglobinPortIn;
import br.com.fiap.api_diagnosis.core.port.out.DiagnosisCreatedEventSupplierPortOut;
import br.com.fiap.api_diagnosis.core.port.out.DiagnosisPortOut;
import br.com.fiap.api_diagnosis.core.service.DiagnosisServiceImpl;
import br.com.fiap.api_diagnosis.core.service.GlycatedHemoglobinServiceImpl;
import br.com.fiap.api_diagnosis.infrastructe.adapter.DiagnosisAdapterImpl;
import br.com.fiap.api_diagnosis.infrastructe.adapter.DiagnosisCreatedEventSupplierAdapterImpl;
import br.com.fiap.api_diagnosis.infrastructe.repository.DiagnosisRepository;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public DiagnosisPortOut diagnosisAdapterImpl(DiagnosisRepository diagnosisRepository) {
        return new DiagnosisAdapterImpl(diagnosisRepository);
    }

    @Bean
    public DiagnosisPortIn diagnosisServiceImpl(
            DiagnosisPortOut diagnosisPortOut,
            DiagnosisCreatedEventSupplierPortOut diagnosisCreatedEventSupplierPortOut
    ) {
        return new DiagnosisServiceImpl(diagnosisPortOut, diagnosisCreatedEventSupplierPortOut);
    }

    @Bean
    public GlycatedHemoglobinPortIn glycatedHemoglobinServiceImpl(DiagnosisPortIn diagnosisPortIn) {
        return new GlycatedHemoglobinServiceImpl(diagnosisPortIn);
    }

    @Bean
    public DiagnosisCreatedEventSupplierPortOut diagnosisEventAdapterImpl(StreamBridge streamBridge) {
        return new DiagnosisCreatedEventSupplierAdapterImpl(streamBridge);
    }
}
