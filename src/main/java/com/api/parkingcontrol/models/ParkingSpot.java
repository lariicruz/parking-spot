package com.api.parkingcontrol.models;

import com.api.parkingcontrol.dtos.ParkingSpotDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "TB_PARKING_SPOT")
public class ParkingSpot implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(nullable = false, unique = true, length = 10)
    private String parkingSpotNumber;

    @Column(nullable = false, unique = true, length = 7)
    private String licensePlateCar;

    @Column(nullable = false)
    private LocalDateTime solicitationDate;;

    @Column(nullable = false, length = 70)
    private String brandCar;

    @Column(nullable = false, length = 70)
    private String modelCar;

    @Column(nullable = false, length = 70)
    private String colorCar;

    @Column(nullable = false, length = 130)
    private String responsibleName;

    @Column(nullable = false, length = 30)
    private String apartment;

    @Column(nullable = false, length = 30)
    private String block;


    public ParkingSpot(ParkingSpotDTO spotyDTO) {
        super();
        this.id = spotyDTO.getId();
        this.apartment = spotyDTO.getApartment();
        this.block = spotyDTO.getBlock();
        this.brandCar = spotyDTO.getBrandCar();
        this.colorCar = spotyDTO.getColorCar();
        this.modelCar = spotyDTO.getModelCar();
        this.parkingSpotNumber = spotyDTO.getParkingSpotNumber();
        this.licensePlateCar = spotyDTO.getLicensePlateCar();
        this.responsibleName = spotyDTO.getResponsibleName();
        this.solicitationDate = spotyDTO.getSolicitationDate();
    }
}
