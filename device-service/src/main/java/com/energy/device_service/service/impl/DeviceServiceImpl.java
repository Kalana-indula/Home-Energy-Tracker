package com.energy.device_service.service.impl;

import com.energy.device_service.dto.DeviceDto;
import com.energy.device_service.dto.response.SingleEntityResponse;
import com.energy.device_service.entity.Device;
import com.energy.device_service.repository.DeviceRepository;
import com.energy.device_service.service.DeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeviceServiceImpl implements DeviceService {

    private final DeviceRepository deviceRepository;

    @Autowired
    public DeviceServiceImpl(DeviceRepository deviceRepository) {
        this.deviceRepository = deviceRepository;
    }

    @Override
    public SingleEntityResponse<DeviceDto> createDevice(Device device) {
        SingleEntityResponse<DeviceDto> response = new SingleEntityResponse<>();

        Device createDevice=deviceRepository.save(device);

        DeviceDto dto=getDeviceDto(createDevice);

        response.setData(dto);
        response.setMessage("Device created successfully");
        return response;
    }

    @Override
    public SingleEntityResponse<DeviceDto> getDeviceById(Long id) {
        return null;
    }

    @Override
    public SingleEntityResponse<DeviceDto> updateDevice(Long id, Device device) {
        return null;
    }

    @Override
    public SingleEntityResponse<DeviceDto> deleteDevice(Long id) {
        return null;
    }

    private DeviceDto getDeviceDto(Device device) {
        return DeviceDto.builder()
                .id(device.getId())
                .name(device.getName())
                .type(device.getType())
                .location(device.getLocation())
                .userId(device.getUserId())
                .build();
    }
}
