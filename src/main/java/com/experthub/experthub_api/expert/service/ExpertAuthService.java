package com.experthub.experthub_api.expert.service;

import org.modelmapper.ModelMapper;
import org.springframework.data.convert.ReadingConverter;
import org.springframework.stereotype.Service;

import com.experthub.experthub_api.expert.dto.ExpertDTO;
import com.experthub.experthub_api.expert.entity.ExpertEntity;
import com.experthub.experthub_api.expert.repository.ExpertRepository;
import com.experthub.experthub_api.response.Response;

import lombok.Builder;
import lombok.extern.slf4j.Slf4j;

@Builder
@Service
@ReadingConverter
@Slf4j
public class ExpertAuthService {
    private final ExpertRepository expertRepository;
    private final ModelMapper modelMapper;

    public Response<Void> insertExpert(ExpertDTO expertDTO) {
        ExpertEntity expertEntity = modelMapper.map(expertDTO, ExpertEntity.class);
        ExpertEntity saved = expertRepository.save(expertEntity);
        if (saved.getId() != null) {
            return Response.<Void>builder()
                    .data(null)
                    .message("Expert inserted successfully")
                    .statusCode(201)
                    .build();
        } else {
            return Response.<Void>builder()
                    .data(null)
                    .message("Failed to insert expert")
                    .statusCode(500)
                    .build();
        }
    }
}
