package com.experthub.experthub_api.expert.service;

import com.experthub.experthub_api.response.Response;
import com.experthub.experthub_api.expert.dto.ExpertDTO;
import com.experthub.experthub_api.expert.entity.ExpertEntity;
import com.experthub.experthub_api.expert.repository.ExpertRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import lombok.Builder;
import org.modelmapper.ModelMapper;



@Builder
@Service
@RequiredArgsConstructor
@Slf4j
public class ExpertService {

    private final ExpertRepository expertRepository;
    private final ModelMapper modelMapper;

    public Response<ExpertDTO> getExpertById(Long id) {
        Optional<ExpertEntity> expertOpt = expertRepository.findById(id);
        if (expertOpt.isPresent()) {
            ExpertEntity expertEntity = expertOpt.get();
            ExpertDTO expertDTO = modelMapper.map(expertEntity, ExpertDTO.class);
            return Response.<ExpertDTO>builder()
                    .data(expertDTO)
                    .message("Expert found")
                    .statusCode(200)
                    .build();
        } else {
            return Response.<ExpertDTO>builder()
                    .data(null)
                    .message("Expert not found")
                    .statusCode(404)
                    .build();
        }
    }

    public Response<List<ExpertDTO>> getAllExperts() {
        List<ExpertEntity> experts = expertRepository.findAll();
        List<ExpertDTO> expertDTOs = experts.stream()
                .map(expert -> modelMapper.map(expert, ExpertDTO.class))
                .collect(Collectors.toList());
        return Response.<List<ExpertDTO>>builder()
                .data(expertDTOs)
                .message("Experts retrieved successfully")
                .statusCode(200)
                .build();
    }
}
