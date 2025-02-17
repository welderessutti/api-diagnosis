package br.com.fiap.api_diagnosis.framework.controller;

import br.com.fiap.api_diagnosis.core.domain.Diagnosis;
import br.com.fiap.api_diagnosis.core.port.in.DiagnosisPortIn;
import br.com.fiap.api_diagnosis.framework.dto.request.DiagnosisRequestDto;
import br.com.fiap.api_diagnosis.framework.dto.response.DiagnosisResponseDto;
import br.com.fiap.api_diagnosis.framework.mapper.DiagnosisDtoDomainMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/diagnosis")
public class DiagnosisController {

    private final DiagnosisPortIn diagnosisPortIn;

    public DiagnosisController(DiagnosisPortIn diagnosisPortIn) {
        this.diagnosisPortIn = diagnosisPortIn;
    }

    @PostMapping
    public ResponseEntity<DiagnosisResponseDto> createDiagnosis(@RequestBody DiagnosisRequestDto request) {
        Diagnosis diagnosis = DiagnosisDtoDomainMapper.toDiagnosis(request);
        DiagnosisResponseDto diagnosisResponseDto = DiagnosisDtoDomainMapper
                .toDiagnosisResponseDto(diagnosisPortIn.createDiagnosis(diagnosis));
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{diagnosisId}")
                .buildAndExpand(diagnosisResponseDto.getId())
                .toUri();
        return ResponseEntity.status(HttpStatus.CREATED).location(location).body(diagnosisResponseDto);
    }

    @GetMapping
    public ResponseEntity<Page<DiagnosisResponseDto>> getDiagnoses(
            @PageableDefault(page = 0, size = 3, sort = "id", direction = Sort.Direction.ASC)
            Pageable pageable
    ) {
        Page<Diagnosis> diagnoses = diagnosisPortIn.getDiagnoses(pageable);
        return ResponseEntity.status(HttpStatus.OK).body(
                diagnoses.map(DiagnosisDtoDomainMapper::toDiagnosisResponseDto));
    }

    @GetMapping("/{diagnosisId}")
    public ResponseEntity<DiagnosisResponseDto> getDiagnosisById(@PathVariable Long diagnosisId) {
        Diagnosis diagnosis = diagnosisPortIn.getDiagnosisById(diagnosisId);
        return ResponseEntity.status(HttpStatus.OK).body(DiagnosisDtoDomainMapper.toDiagnosisResponseDto(diagnosis));
    }

    @PutMapping("/{diagnosisId}")
    public ResponseEntity<DiagnosisResponseDto> updateDiagnosis(
            @PathVariable Long diagnosisId, @RequestBody DiagnosisRequestDto request) {
        Diagnosis diagnosis = DiagnosisDtoDomainMapper.toDiagnosis(request);
        DiagnosisResponseDto diagnosisResponseDto = DiagnosisDtoDomainMapper.toDiagnosisResponseDto(
                diagnosisPortIn.updateDiagnosis(diagnosisId, diagnosis));
        return ResponseEntity.status(HttpStatus.OK).body(diagnosisResponseDto);
    }

    @DeleteMapping("/{diagnosisId}")
    public ResponseEntity<Void> deleteDiagnosis(@PathVariable Long diagnosisId) {
        diagnosisPortIn.deleteDiagnosisById(diagnosisId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
