package com.api.rest_code.dto.response;

import jakarta.validation.constraints.NotBlank;
import lombok.Builder;


@Builder
public record AuthenticationResponse (
        @NotBlank String token
           ){

}
