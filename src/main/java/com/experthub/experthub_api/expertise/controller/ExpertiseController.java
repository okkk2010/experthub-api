package com.experthub.experthub_api.expertise.controller;

import com.experthub.experthub_api.expertise.dto.ExpertiseDTO;
import com.experthub.experthub_api.expertise.service.ExpertiseService;
import com.experthub.experthub_api.response.Response;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@CrossOrigin(origins = "http://localhost:5173")
@RequestMapping("/api/expertises")
@RequiredArgsConstructor
public class ExpertiseController {
    private final ExpertiseService expertiseService;

    @GetMapping()
    public ResponseEntity<Response<List<ExpertiseDTO>>> getAllExpertises() {
        return ResponseEntity.ok(expertiseService.getAllExpertises());
    }

    @GetMapping("/{code}")
    public ResponseEntity<Response<ExpertiseDTO>> getExpertiseByCode(@PathVariable Integer code) {
        return ResponseEntity.ok(expertiseService.getExpertiseByCode(code));
    }

    @GetMapping("/{name}")
    public ResponseEntity<Response<ExpertiseDTO>> getExpertiseByName(@PathVariable String name) {
        return ResponseEntity.ok(expertiseService.getExpertiseByName(name));
    }
}
