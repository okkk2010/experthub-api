package com.experthub.experthub_api.expertise.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ExpertiseDTO {
    private Long id;
    private Integer code;
    private String expertise;
}
