package com.energy.device_service.exception.error;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class DeviceErrorResponse {
    private Integer status;
    private String message;
    private Long timestamp;
}
