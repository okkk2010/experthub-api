package com.experthub.experthub_api.user.service;

import java.util.List;
import java.util.Optional;

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
public class UserService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    public Response<UserDTO> getUserById(Long id) {
        Optional<UserEntity> userOpt = userRepository.findById(id);
        if (userOpt.isPresent()) {
            UserEntity userEntity = userOpt.get();
            UserDTO userDTO = modelMapper.map(userEntity, UserDTO.class);
            return Response.<UserDTO>builder()
                    .data(userDTO)
                    .message("User found")
                    .statusCode(200)
                    .build();
        } else {
            return Response.<UserDTO>builder()
                    .data(null)
                    .message("User not found")
                    .statusCode(404)
                    .build();
        }
    }

    public Response<List<UserDTO>> getAllUsers() {
        List<UserEntity> userEntities = userRepository.findAll();
        List<UserDTO> userDTOs = userEntities.stream()
                .map(userEntity -> modelMapper.map(userEntity, UserDTO.class))
                .toList();
        return Response.<List<UserDTO>>builder()
                .data(userDTOs)
                .message("Users found")
                .statusCode(200)
                .build();
    }
}
