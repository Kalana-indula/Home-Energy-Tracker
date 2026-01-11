package com.energy.device_service.exception;

import com.energy.device_service.exception.error.DeviceErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class DeviceExceptionHandler {

//    handle device not found exception
    @ExceptionHandler(DeviceNotFoundException.class)
    public ResponseEntity<DeviceErrorResponse> handleDeviceNotFound(DeviceNotFoundException exc){

        DeviceErrorResponse deviceErrorResponse = new DeviceErrorResponse();
        deviceErrorResponse.setStatus(HttpStatus.NOT_FOUND.value());
        deviceErrorResponse.setMessage(exc.getMessage());
        deviceErrorResponse.setTimestamp(System.currentTimeMillis());

        return new ResponseEntity<>(deviceErrorResponse, HttpStatus.NOT_FOUND);
    }
}
