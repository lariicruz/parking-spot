package com.api.parkingcontrol.dtos;

import com.api.parkingcontrol.models.ParkingSpot;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ParkingSpotDTO {


    private Integer id;
    @NotBlank
    private String parkingSpotNumber;
    @NotBlank
    @Size(max = 7)
    private String licensePlateCar;
    @NotBlank
    private String brandCar;
    @NotBlank
    private String modelCar;
    @NotBlank
    private String colorCar;
    @NotBlank
    private String responsibleName;
    @NotBlank
    private String apartment;
    @NotBlank
    private String block;

    private LocalDateTime solicitationDate;

    public ParkingSpotDTO(ParkingSpot obj) {
        id = obj.getId();
        parkingSpotNumber = obj.getParkingSpotNumber();
        licensePlateCar = obj.getLicensePlateCar();
        brandCar = obj.getBrandCar();
        modelCar = obj.getModelCar();
        colorCar = obj.getColorCar();
        responsibleName = obj.getResponsibleName();
        apartment = obj.getApartment();
        block = obj.getBlock();
        solicitationDate = obj.getSolicitationDate();
    }
}
