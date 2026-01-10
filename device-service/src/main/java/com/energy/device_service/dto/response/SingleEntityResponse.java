package com.energy.device_service.dto.response;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class SingleEntityResponse<T> {

    private String message;
    private T data;
}
