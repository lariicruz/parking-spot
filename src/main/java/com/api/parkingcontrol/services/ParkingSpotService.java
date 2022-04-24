package com.api.parkingcontrol.services;

import com.api.parkingcontrol.dtos.ParkingSpotDTO;
import com.api.parkingcontrol.models.ParkingSpot;
import com.api.parkingcontrol.repositories.ParkingSpotRepository;
import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ParkingSpotService {

    @Autowired
    ParkingSpotRepository parkingSpotRepository;

    @Transactional
    public ParkingSpotDTO insert (ParkingSpotDTO spotyDTO) {
        ParkingSpot obj = new ParkingSpot(spotyDTO);
        obj.setSolicitationDate(LocalDateTime.now(ZoneId.of("UTC")));
        return new ParkingSpotDTO(parkingSpotRepository.save(obj));
    }
    @Transactional
    public ParkingSpotDTO findById(Integer id) {
        return new ParkingSpotDTO(parkingSpotRepository.findById(id).orElseThrow(() -> new ObjectNotFoundException("Registration not found: " + id, "ParkingSpot")));
    }
    @Transactional
    public List<ParkingSpotDTO> findAll() {
        return parkingSpotRepository.findAll().stream().map(obj -> new ParkingSpotDTO(obj)).collect(Collectors.toList());
    }
    @Transactional
    public ParkingSpotDTO update (ParkingSpotDTO spotDTO, Integer id) {

        spotDTO.setId(id);
        ParkingSpot obj = new ParkingSpot(spotDTO);
        findById(obj.getId());
        if(spotDTO.getSolicitationDate() == null) {
            obj.setSolicitationDate(LocalDateTime.now(ZoneId.of("UTC")));
        }
        return new ParkingSpotDTO(parkingSpotRepository.save(obj));

    }
    public void delete (Integer id) {
        findById(id);
        parkingSpotRepository.deleteById(id);
    }
}
