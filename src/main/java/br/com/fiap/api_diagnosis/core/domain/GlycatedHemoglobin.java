package br.com.fiap.api_diagnosis.core.domain;

import java.util.Objects;

public class GlycatedHemoglobin {

    private Long id;
    private Long patientId;
    private Double result;

    public GlycatedHemoglobin() {
    }

    public GlycatedHemoglobin(Long id, Long patientId, Double result) {
        this.id = id;
        this.patientId = patientId;
        this.result = result;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPatientId() {
        return patientId;
    }

    public void setPatientId(Long patientId) {
        this.patientId = patientId;
    }

    public Double getResult() {
        return result;
    }

    public void setResult(Double result) {
        this.result = result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GlycatedHemoglobin glycatedHemoglobin = (GlycatedHemoglobin) o;
        return Objects.equals(id, glycatedHemoglobin.id)
                && Objects.equals(patientId, glycatedHemoglobin.patientId)
                && Objects.equals(result, glycatedHemoglobin.result);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, patientId, result);
    }

    @Override
    public String toString() {
        return "Exam{" +
                "id=" + id +
                ", patientId=" + patientId +
                ", result=" + result +
                '}';
    }
}
