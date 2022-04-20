package com.api.parkingcontrol.resources;

import com.api.parkingcontrol.dtos.ParkingSpotDTO;
import com.api.parkingcontrol.models.ParkingSpot;
import com.api.parkingcontrol.services.ParkingSpotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.text.SimpleDateFormat;
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
    @PutMapping(value = "/id")
    public ResponseEntity< ParkingSpot> update (@RequestBody @Valid ParkingSpotDTO spotDTO, @PathVariable Integer id) {
        spotDTO.setId(id);
        ParkingSpot obj = new ParkingSpot();
       return ResponseEntity.ok().body(parkingSpotService.update(obj));

    }
}
//    @PutMapping(value = "/{id}")
//    public ResponseEntity<Void> update(@Valid @RequestBody CategoriaDTO objDTO, @PathVariable Integer id) {
//        Categoria obj = service.fromDTO(objDTO);
//        obj.setId(id);
//        service.update(obj);
//        return ResponseEntity.noContent().build();
