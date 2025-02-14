package br.com.fiap.api_diagnosis.core.domain;

import java.time.LocalDateTime;
import java.util.Objects;

public class Diagnosis {

    private Long id;
    private Long glycatedHemoglobinTestId;
    private Long patientId;
    private TestStatus glycatedHemoglobinTestStatus;
    private LocalDateTime diagnosisDate;

    public Diagnosis() {
    }

    public Diagnosis(
            Long id,
            Long glycatedHemoglobinTestId,
            Long patientId,
            TestStatus glycatedHemoglobinTestStatus,
            LocalDateTime diagnosisDate
    ) {
        this.id = id;
        this.glycatedHemoglobinTestId = glycatedHemoglobinTestId;
        this.patientId = patientId;
        this.glycatedHemoglobinTestStatus = glycatedHemoglobinTestStatus;
        this.diagnosisDate = diagnosisDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getGlycatedHemoglobinTestId() {
        return glycatedHemoglobinTestId;
    }

    public void setGlycatedHemoglobinTestId(Long glycatedHemoglobinTestId) {
        this.glycatedHemoglobinTestId = glycatedHemoglobinTestId;
    }

    public Long getPatientId() {
        return patientId;
    }

    public void setPatientId(Long patientId) {
        this.patientId = patientId;
    }

    public TestStatus getGlycatedHemoglobinTestStatus() {
        return glycatedHemoglobinTestStatus;
    }

    public void setGlycatedHemoglobinTestStatus(TestStatus glycatedHemoglobinTestStatus) {
        this.glycatedHemoglobinTestStatus = glycatedHemoglobinTestStatus;
    }

    public LocalDateTime getDiagnosisDate() {
        return diagnosisDate;
    }

    public void setDiagnosisDate(LocalDateTime diagnosisDate) {
        this.diagnosisDate = diagnosisDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Diagnosis diagnosis = (Diagnosis) o;
        return Objects.equals(id, diagnosis.id)
                && Objects.equals(glycatedHemoglobinTestId, diagnosis.glycatedHemoglobinTestId)
                && Objects.equals(patientId, diagnosis.patientId)
                && glycatedHemoglobinTestStatus == diagnosis.glycatedHemoglobinTestStatus
                && Objects.equals(diagnosisDate, diagnosis.diagnosisDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, glycatedHemoglobinTestId, patientId, glycatedHemoglobinTestStatus, diagnosisDate);
    }

    @Override
    public String toString() {
        return "Diagnosis{" +
                "id=" + id +
                ", glycatedHemoglobinTestId=" + glycatedHemoglobinTestId +
                ", patientId=" + patientId +
                ", glycatedHemoglobinTestStatus=" + glycatedHemoglobinTestStatus +
                ", diagnosisDate=" + diagnosisDate +
                '}';
    }
}
