package com.experthub.experthub_api.user.service;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.experthub.experthub_api.response.Response;
import com.experthub.experthub_api.user.dto.UserDTO;
import com.experthub.experthub_api.user.entity.UserEntity;
import com.experthub.experthub_api.user.repository.UserRepository;

import lombok.Builder;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Builder
@Service
@RequiredArgsConstructor
@Slf4j
public class UserAuthService {
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    public Response<Void> insertUser(UserDTO userDTO) {
        UserEntity userEntity = modelMapper.map(userDTO, UserEntity.class);
        UserEntity saved = userRepository.save(userEntity);
        if(saved.getId() != null) {
            return Response.<Void>builder()
                    .data(null)
                    .message("User inserted successfully")
                    .statusCode(201)
                    .build();
        } else {
            return Response.<Void>builder()
                    .data(null)
                    .message("User insertion failed")
                    .statusCode(500)
                    .build();
        }
    }
        
}
