package br.com.fiap.api_diagnosis.core.service;

import br.com.fiap.api_diagnosis.core.domain.Diagnosis;
import br.com.fiap.api_diagnosis.core.domain.GlycatedHemoglobin;
import br.com.fiap.api_diagnosis.core.port.in.DiagnosisPortIn;
import br.com.fiap.api_diagnosis.core.port.in.GlycatedHemoglobinPortIn;

public class GlycatedHemoglobinServiceImpl implements GlycatedHemoglobinPortIn {

    private final DiagnosisPortIn diagnosisPortIn;

    public GlycatedHemoglobinServiceImpl(DiagnosisPortIn diagnosisPortIn) {
        this.diagnosisPortIn = diagnosisPortIn;
    }

    public void setDiagnosis(GlycatedHemoglobin glycatedHemoglobin) {
        Diagnosis diagnosis = new Diagnosis();
        diagnosis.setGlycatedHemoglobinTestId(glycatedHemoglobin.getId());
        diagnosis.setPatientId(glycatedHemoglobin.getPatientId());
        diagnosis.resultAnalysis(glycatedHemoglobin.getResult());
        diagnosisPortIn.createDiagnosis(diagnosis);
    }
}
