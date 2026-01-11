package com.energy.device_service.service.impl;

import com.energy.device_service.dto.DeviceDto;
import com.energy.device_service.dto.response.SingleEntityResponse;
import com.energy.device_service.entity.Device;
import com.energy.device_service.exception.DeviceNotFoundException;
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

        SingleEntityResponse<DeviceDto> response = new SingleEntityResponse<>();

        Device existingDevice=deviceRepository.findById(id)
                .orElseThrow(()->new DeviceNotFoundException("Device ID : "+id+" not found"));

        response.setData(getDeviceDto(existingDevice));
        response.setMessage("Device found successfully");

        return response;
    }

    @Override
    public SingleEntityResponse<DeviceDto> updateDevice(Long id, Device device) {

        SingleEntityResponse<DeviceDto> response = new SingleEntityResponse<>();

        Device existingDevice=deviceRepository.findById(id)
                .orElseThrow(()->new DeviceNotFoundException("Device ID : "+id+" not found"));

        existingDevice.setName(device.getName());
        existingDevice.setType(device.getType());
        existingDevice.setLocation(device.getLocation());
        existingDevice.setUserId(device.getUserId());

        Device updateDevice=deviceRepository.save(existingDevice);

        response.setData(getDeviceDto(updateDevice));
        response.setMessage("Device updated successfully");

        return response;
    }

    @Override
    public SingleEntityResponse<DeviceDto> deleteDevice(Long id) {

        SingleEntityResponse<DeviceDto> response = new SingleEntityResponse<>();

        boolean isExist=deviceRepository.existsById(id);

        if(!isExist){
            throw new DeviceNotFoundException("Device ID : "+id+" not found");
        }

        response.setMessage("Device deleted successfully");

        return response;
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
