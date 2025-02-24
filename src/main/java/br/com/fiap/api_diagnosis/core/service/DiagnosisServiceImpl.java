package br.com.fiap.api_diagnosis.core.service;

import br.com.fiap.api_diagnosis.core.domain.Diagnosis;
import br.com.fiap.api_diagnosis.core.domain.TestStatus;
import br.com.fiap.api_diagnosis.core.exception.DiagnosisNotFoundException;
import br.com.fiap.api_diagnosis.core.port.in.DiagnosisPortIn;
import br.com.fiap.api_diagnosis.core.port.out.DiagnosisCreatedEventSupplierPortOut;
import br.com.fiap.api_diagnosis.core.port.out.DiagnosisPortOut;
import br.com.fiap.api_diagnosis.core.updater.DiagnosisUpdater;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Optional;

@Slf4j
public class DiagnosisServiceImpl implements DiagnosisPortIn {

    private final DiagnosisPortOut diagnosisPortOut;
    private final DiagnosisCreatedEventSupplierPortOut diagnosisCreatedEventSupplierPortOut;
    private static final String NOT_FOUND_WITH_ID = "Diagnosis not found with id: ";

    public DiagnosisServiceImpl(
            DiagnosisPortOut diagnosisPortOut,
            DiagnosisCreatedEventSupplierPortOut diagnosisCreatedEventSupplierPortOut
    ) {
        this.diagnosisPortOut = diagnosisPortOut;
        this.diagnosisCreatedEventSupplierPortOut = diagnosisCreatedEventSupplierPortOut;
    }

    @Override
    public Diagnosis createDiagnosis(Diagnosis diagnosis) {
        diagnosis.setDiagnosisDate(LocalDateTime.now(ZoneId.of("America/Sao_Paulo")));
        Diagnosis createdDiagnosis = diagnosisPortOut.createDiagnosis(diagnosis);
        log.info("Diagnosis created: {}", createdDiagnosis);
        sendDiagnosisCreatedEvent(createdDiagnosis);
        return createdDiagnosis;
    }

    @Override
    public Page<Diagnosis> getDiagnoses(Pageable pageable) {
        return diagnosisPortOut.getDiagnoses(pageable);
    }

    @Override
    public Diagnosis getDiagnosisById(Long diagnosisId) {
        Optional<Diagnosis> optionalDiagnosis = diagnosisPortOut.getDiagnosisById(diagnosisId);
        if (optionalDiagnosis.isEmpty()) {
            throw new DiagnosisNotFoundException(NOT_FOUND_WITH_ID + diagnosisId);
        }
        return optionalDiagnosis.get();
    }

    @Override
    public Diagnosis updateDiagnosis(Long diagnosisId, Diagnosis updatedDiagnosis) {
        Optional<Diagnosis> optionalDiagnosis = diagnosisPortOut.getDiagnosisById(diagnosisId);
        if (optionalDiagnosis.isEmpty()) {
            throw new DiagnosisNotFoundException(NOT_FOUND_WITH_ID + diagnosisId);
        }
        Diagnosis outdatedDiagnosis = optionalDiagnosis.get();
        DiagnosisUpdater.updateOutdatedDiagnosis(outdatedDiagnosis, updatedDiagnosis);
        return diagnosisPortOut.updateDiagnosis(outdatedDiagnosis);
    }

    @Override
    public void deleteDiagnosisById(Long diagnosisId) {
        if (!diagnosisPortOut.existsDiagnosisById(diagnosisId)) {
            throw new DiagnosisNotFoundException(NOT_FOUND_WITH_ID + diagnosisId);
        }
        diagnosisPortOut.deleteDiagnosisById(diagnosisId);
    }

    private void sendDiagnosisCreatedEvent(Diagnosis createdDiagnosis) {
        if (createdDiagnosis.getGlycatedHemoglobinTestStatus().equals(TestStatus.CRITICAL)) {
            diagnosisCreatedEventSupplierPortOut.sendAppointmentSchedulingDiagnosisCreatedEvent(createdDiagnosis);
        } else {
            diagnosisCreatedEventSupplierPortOut.sendTestSchedulingDiagnosisCreatedEvent(createdDiagnosis);
        }
    }
}
