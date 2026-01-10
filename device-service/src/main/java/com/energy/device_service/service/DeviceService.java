package com.energy.device_service.service;

import com.energy.device_service.dto.DeviceDto;
import com.energy.device_service.dto.response.SingleEntityResponse;
import com.energy.device_service.entity.Device;
import org.springframework.stereotype.Service;

@Service
public interface DeviceService {

    SingleEntityResponse<DeviceDto> createDevice(Device device);

    SingleEntityResponse<DeviceDto> getDeviceById(Long id);

    SingleEntityResponse<DeviceDto> updateDevice(Long id, Device device);

    SingleEntityResponse<DeviceDto> deleteDevice(Long id);
}
