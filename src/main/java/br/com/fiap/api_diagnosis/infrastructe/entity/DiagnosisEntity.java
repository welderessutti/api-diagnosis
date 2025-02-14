package br.com.fiap.api_diagnosis.infrastructe.entity;

import br.com.fiap.api_diagnosis.core.domain.TestStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "tb_diagnosis")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DiagnosisEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "glycated_hemoglobin_test_id")
    private Long glycatedHemoglobinTestId;

    @Column(name = "patient_id")
    private Long patientId;

    @Column(name = "glycated_hemoglobin_test_status")
    @Enumerated(EnumType.STRING)
    private TestStatus glycatedHemoglobinTestStatus;

    @Column(name = "diagnosis_date")
    private LocalDateTime diagnosisDate;
}
