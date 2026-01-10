package com.energy.device_service.entity;

import com.energy.device_service.model.DeviceType;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "device")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Setter
@Getter
public class Device {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    private String name;

    @Enumerated(EnumType.STRING)
    @Column(name = "type")
    private DeviceType type;

    private String location;

    @Column(name = "user_id")
    private Long userId;
}
