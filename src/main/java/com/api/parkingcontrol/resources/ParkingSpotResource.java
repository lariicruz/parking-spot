package com.api.parkingcontrol.resources;

import com.api.parkingcontrol.dtos.ParkingSpotDTO;
import com.api.parkingcontrol.models.ParkingSpot;
import com.api.parkingcontrol.services.ParkingSpotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/parking-spot")
public class ParkingSpotResource {

    @Autowired
    ParkingSpotService parkingSpotService;

    @PostMapping
    public ResponseEntity<ParkingSpotDTO> create(@RequestBody @Valid ParkingSpotDTO spotDTO) {
        return ResponseEntity.created(null).body(parkingSpotService.insert(spotDTO));
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<ParkingSpotDTO> findById(@PathVariable Integer id) {
        return ResponseEntity.ok().body(parkingSpotService.findById(id));
    }

    @GetMapping
    public ResponseEntity<List<ParkingSpotDTO>> findAll() {
        return ResponseEntity.ok().body(parkingSpotService.findAll());
    }
    @PutMapping(value = "/{id}")
    public ResponseEntity< ParkingSpotDTO> update (@RequestBody @Valid ParkingSpotDTO spotDTO, @PathVariable Integer id) {
       return ResponseEntity.ok().body(parkingSpotService.update(spotDTO, id));
    }
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete (@PathVariable Integer id) {
        parkingSpotService.delete(id);
        return ResponseEntity.noContent().build();
    }
}

