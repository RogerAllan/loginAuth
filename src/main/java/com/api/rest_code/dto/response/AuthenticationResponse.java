package com.api.rest_code.dto.response;

import lombok.Builder;

@Builder
public record AuthenticationResponse(String token) {}