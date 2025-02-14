package br.com.fiap.api_diagnosis.infrastructe.adapter;

import br.com.fiap.api_diagnosis.core.domain.Diagnosis;
import br.com.fiap.api_diagnosis.core.port.out.DiagnosisCreatedEventSupplierPortOut;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.integration.support.MessageBuilder;

@Slf4j
public class DiagnosisCreatedEventSupplierAdapterImpl implements DiagnosisCreatedEventSupplierPortOut {

    private final StreamBridge streamBridge;

    public DiagnosisCreatedEventSupplierAdapterImpl(StreamBridge streamBridge) {
        this.streamBridge = streamBridge;
    }

    @Override
    public void sendTestScheduleDiagnosisCreatedEvent(Diagnosis diagnosis) {
        streamBridge.send(
                "testScheduleDiagnosisCreatedSupplier-out-0",
                MessageBuilder.withPayload(diagnosis).build()
        );
        log.info("Test Diagnosis event sent: {}", diagnosis.getId());
    }

    @Override
    public void sendAppointmentScheduleDiagnosisCreatedEvent(Diagnosis diagnosis) {
        streamBridge.send(
                "appointmentScheduleDiagnosisCreatedSupplier-out-0",
                MessageBuilder.withPayload(diagnosis).build()
        );
        log.info("Appointment Diagnosis event sent: {}", diagnosis.getId());
    }
}
