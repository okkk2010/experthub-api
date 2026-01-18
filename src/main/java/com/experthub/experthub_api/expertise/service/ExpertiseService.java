package com.experthub.experthub_api.expertise.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.experthub.experthub_api.expertise.dto.ExpertiseDTO;
import com.experthub.experthub_api.expertise.entiry.ExpertiseEntity;
import com.experthub.experthub_api.expertise.repository.ExpertiseRepository;
import com.experthub.experthub_api.response.Response;

import lombok.Builder;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Builder
@Service
@RequiredArgsConstructor
@Slf4j
public class ExpertiseService {
    private final ExpertiseRepository expertiseRepository;
    private final ModelMapper modelMapper;

    public Response<List<ExpertiseDTO>> getAllExpertises() {
        List<ExpertiseEntity> expertises = expertiseRepository.findAll();
        List<ExpertiseDTO> expertiseDTOs = expertises.stream()
                .map(expertise -> modelMapper.map(expertise, ExpertiseDTO.class))
                .collect(Collectors.toList());
        return Response.<List<ExpertiseDTO>>builder()
            .data(expertiseDTOs)
            .message("Expertises retrieved successfully")
            .statusCode(200)
            .build();
    }

    public Response<ExpertiseDTO> getExpertiseByCode(Integer code) {
        Optional<ExpertiseEntity> expertiseOpt = expertiseRepository.findByCode(code);
        if (expertiseOpt.isPresent()) {
            ExpertiseEntity expertiseEntity = expertiseOpt.get();
            ExpertiseDTO expertiseDTO = modelMapper.map(expertiseEntity, ExpertiseDTO.class);
            return Response.<ExpertiseDTO>builder()
                    .data(expertiseDTO)
                    .message("Expertise found")
                    .statusCode(200)
                    .build();
        } else {
            return Response.<ExpertiseDTO>builder()
                    .data(null)
                    .message("Expertise not found")
                    .statusCode(404)
                    .build();
        }
    }

    public Response<ExpertiseDTO> getExpertiseByName(String name) {
        Optional<ExpertiseEntity> expertiseOpt = expertiseRepository.findByExpertise(name);
        if (expertiseOpt.isPresent()) {
            ExpertiseEntity expertiseEntity = expertiseOpt.get();
            ExpertiseDTO expertiseDTO = modelMapper.map(expertiseEntity, ExpertiseDTO.class);
            return Response.<ExpertiseDTO>builder()
                    .data(expertiseDTO)
                    .message("Expertise found")
                    .statusCode(200)
                    .build();
        } else {
            return Response.<ExpertiseDTO>builder()
                    .data(null)
                    .message("Expertise not found")
                    .statusCode(404)
                    .build();
        }
    }
}
