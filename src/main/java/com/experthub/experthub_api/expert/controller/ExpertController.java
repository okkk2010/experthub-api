package com.experthub.experthub_api.expert.controller;

import com.experthub.experthub_api.expert.dto.ExpertDTO;
import com.experthub.experthub_api.expert.service.ExpertService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/experts")
public class ExpertController {
    private ExpertService expertService;

    @GetMapping("/{id}")
    public ExpertDTO getExpertById(@PathVariable Long id) {
        return expertService.getExpertById(id);
    }

    @GetMapping()
    public List<ExpertDTO> getAllExperts() {
        return expertService.getAllExperts();
    }
}
