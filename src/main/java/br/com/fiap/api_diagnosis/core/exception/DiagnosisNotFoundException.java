package br.com.fiap.api_diagnosis.core.exception;

public class DiagnosisNotFoundException extends RuntimeException {

    public DiagnosisNotFoundException(String message) {
        super(message);
    }
}
