package com.experthub.experthub_api.expert.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ExpertDTO {
    private Long id;
    private String name;
    private String expertise;
    private String email;
    private String phoneNumber;

}
