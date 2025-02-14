package br.com.fiap.api_diagnosis.core.updater;

import br.com.fiap.api_diagnosis.core.domain.Diagnosis;

import static java.util.Objects.nonNull;

public class DiagnosisUpdater {

    private DiagnosisUpdater() {
    }

    public static void updateOutdatedDiagnosis(Diagnosis outdated, Diagnosis updated) {
        if (nonNull(updated.getGlycatedHemoglobinTestId())) {
            outdated.setGlycatedHemoglobinTestId(updated.getGlycatedHemoglobinTestId());
        }
        if (nonNull(updated.getPatientId())) {
            outdated.setPatientId(updated.getPatientId());
        }
        if (nonNull(updated.getGlycatedHemoglobinTestStatus())) {
            outdated.setGlycatedHemoglobinTestStatus(updated.getGlycatedHemoglobinTestStatus());
        }
        if (nonNull(updated.getDiagnosisDate())) {
            outdated.setDiagnosisDate(updated.getDiagnosisDate());
        }
    }
}
