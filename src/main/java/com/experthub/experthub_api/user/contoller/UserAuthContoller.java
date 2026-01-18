package com.experthub.experthub_api.user.contoller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.experthub.experthub_api.response.Response;
import com.experthub.experthub_api.user.dto.UserDTO;
import com.experthub.experthub_api.user.service.UserAuthService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@CrossOrigin(origins = "http://localhost:5173")
@RequestMapping("/api/auth/user")
@RequiredArgsConstructor
public class UserAuthContoller {
    private final UserAuthService userAuthService;

    @PostMapping("signup")
    public ResponseEntity<Response<Void>> insertUser(@RequestBody UserDTO userDTO) {
        return ResponseEntity.ok(userAuthService.insertUser(userDTO));
    }
}
