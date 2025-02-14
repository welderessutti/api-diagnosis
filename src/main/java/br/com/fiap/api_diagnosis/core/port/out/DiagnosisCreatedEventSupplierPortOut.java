package br.com.fiap.api_diagnosis.core.port.out;

import br.com.fiap.api_diagnosis.core.domain.Diagnosis;

public interface DiagnosisCreatedEventSupplierPortOut {

    void sendTestScheduleDiagnosisCreatedEvent(Diagnosis diagnosis);

    void sendAppointmentScheduleDiagnosisCreatedEvent(Diagnosis diagnosis);
}
