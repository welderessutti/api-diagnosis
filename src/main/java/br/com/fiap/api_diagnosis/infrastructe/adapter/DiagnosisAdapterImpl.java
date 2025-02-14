package br.com.fiap.api_diagnosis.infrastructe.adapter;

import br.com.fiap.api_diagnosis.core.domain.Diagnosis;
import br.com.fiap.api_diagnosis.core.port.out.DiagnosisPortOut;
import br.com.fiap.api_diagnosis.infrastructe.entity.DiagnosisEntity;
import br.com.fiap.api_diagnosis.infrastructe.mapper.DiagnosisDomainEntityMapper;
import br.com.fiap.api_diagnosis.infrastructe.repository.DiagnosisRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

public class DiagnosisAdapterImpl implements DiagnosisPortOut {

    private final DiagnosisRepository diagnosisRepository;

    public DiagnosisAdapterImpl(DiagnosisRepository diagnosisRepository) {
        this.diagnosisRepository = diagnosisRepository;
    }

    @Override
    @Transactional
    public Diagnosis createDiagnosis(Diagnosis diagnosis) {
        DiagnosisEntity diagnosisEntity = DiagnosisDomainEntityMapper.toDiagnosisEntity(diagnosis);
        return DiagnosisDomainEntityMapper.toDiagnosis(diagnosisRepository.save(diagnosisEntity));
    }

    @Override
    public Page<Diagnosis> getDiagnoses(Pageable pageable) {
        return diagnosisRepository.findAll(pageable).map(DiagnosisDomainEntityMapper::toDiagnosis);
    }

//    @Override
//    public List<Diagnosis> getDiagnoses(ObtainDiagnosesRequestDto dto) {
//        PageRequest paging = PageRequest.of(dto.getPageNumber(), dto.getPageSize(), Sort.by(dto.getSortBy()));
//        Page<DiagnosisEntity> entities = diagnosisRepository.findAll(paging);
//        return entities.stream().map(DiagnosisDomainEntityMapper::toDiagnosis).toList();
//    }

    @Override
    public Optional<Diagnosis> getDiagnosisById(Long diagnosisId) {
        return diagnosisRepository.findById(diagnosisId).map(DiagnosisDomainEntityMapper::toDiagnosis);
    }

    @Override
    @Transactional
    public Diagnosis updateDiagnosis(Diagnosis updatedDiagnosis) {
        DiagnosisEntity diagnosisEntity = DiagnosisDomainEntityMapper.toDiagnosisEntity(updatedDiagnosis);
        return DiagnosisDomainEntityMapper.toDiagnosis(diagnosisRepository.save(diagnosisEntity));
    }

    @Override
    @Transactional
    public void deleteDiagnosisById(Long id) {
        diagnosisRepository.deleteById(id);
    }

    @Override
    public boolean existsDiagnosisById(Long diagnosisId) {
        return diagnosisRepository.existsById(diagnosisId);
    }
}
