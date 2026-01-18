package com.experthub.experthub_api.expert.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.experthub.experthub_api.expert.dto.ExpertDTO;
import com.experthub.experthub_api.expert.service.ExpertAuthService;
import com.experthub.experthub_api.response.Response;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@CrossOrigin(origins = "http://localhost:5173")
@RequestMapping("/api/auth/expert")
@RequiredArgsConstructor
public class ExpertAuthController {
    private final ExpertAuthService expertAuthService;
    
    @PostMapping("signup")
    public ResponseEntity<Response<Void>> insertExpert(@RequestBody ExpertDTO expertDTO) {
        return ResponseEntity.ok(expertAuthService.insertExpert(expertDTO));
    }
}
