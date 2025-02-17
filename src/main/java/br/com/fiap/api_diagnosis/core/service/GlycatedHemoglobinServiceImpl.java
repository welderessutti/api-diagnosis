package br.com.fiap.api_diagnosis.core.service;

import br.com.fiap.api_diagnosis.core.domain.Diagnosis;
import br.com.fiap.api_diagnosis.core.domain.GlycatedHemoglobin;
import br.com.fiap.api_diagnosis.core.domain.TestStatus;
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
        resultAnalysis(glycatedHemoglobin, diagnosis);
        diagnosisPortIn.createDiagnosis(diagnosis);
    }

    private void resultAnalysis(GlycatedHemoglobin glycatedHemoglobin, Diagnosis diagnosis) {
        Double result = glycatedHemoglobin.getResult();
        if (result < 5.7) {
            diagnosis.setGlycatedHemoglobinTestStatus(TestStatus.NORMAL);
        } else if (result >= 6.5) {
            diagnosis.setGlycatedHemoglobinTestStatus(TestStatus.CRITICAL);
        } else {
            diagnosis.setGlycatedHemoglobinTestStatus(TestStatus.ALTERED);
        }
    }
}

//Normal: Less than 5,7%
//Pre-diabetes: Between 5,7% and 6,4%
//Diabetes: 6,5% or over
