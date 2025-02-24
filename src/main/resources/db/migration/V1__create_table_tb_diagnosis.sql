CREATE TABLE tb_diagnosis
(
    id                              SERIAL PRIMARY KEY,
    glycated_hemoglobin_test_id     INTEGER     NOT NULL UNIQUE,
    patient_id                      INTEGER     NOT NULL,
    glycated_hemoglobin_test_status VARCHAR(20) NOT NULL,
    diagnosis_date                  TIMESTAMP   NOT NULL
);