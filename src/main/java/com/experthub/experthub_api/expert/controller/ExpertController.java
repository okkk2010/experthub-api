package com.experthub.experthub_api.expert.controller;

import com.experthub.experthub_api.expert.dto.ExpertDTO;
import com.experthub.experthub_api.expert.service.ExpertService;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.experthub.experthub_api.response.Response;
import org.springframework.http.ResponseEntity;
import lombok.extern.slf4j.Slf4j;
import lombok.RequiredArgsConstructor;
import java.util.List;

@Slf4j
@RestController
@CrossOrigin(origins = "http://localhost:5173")
@RequestMapping("/api/experts")
@RequiredArgsConstructor
public class ExpertController {
    private final ExpertService expertService;

    @GetMapping("/{id}")
    public ResponseEntity<Response<ExpertDTO>> getExpertById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(expertService.getExpertById(id));
    }

    @GetMapping()
    public ResponseEntity<Response<List<ExpertDTO>>> getAllExperts() {
        return ResponseEntity.ok(expertService.getAllExperts());
    }


}
