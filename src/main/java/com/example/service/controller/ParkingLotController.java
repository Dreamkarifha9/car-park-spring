package com.example.service.controller;

import com.example.service.entity.ParkingLot;
import com.example.service.model.ParkingLotDto;
import com.example.service.service.ParkingLotService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping("/parking-lot")
public class ParkingLotController {
    private final ParkingLotService parkingLotService;

    public ParkingLotController(ParkingLotService parkingLotService) {
        this.parkingLotService = parkingLotService;
    }

    @GetMapping
    public ResponseEntity<?> findAll() {
        return ResponseEntity.ok(parkingLotService.findAll()) ;
    }


    @PostMapping
    public String create(@RequestBody ParkingLotDto parkingDto) {
        System.out.println(parkingDto);
        parkingLotService.create(parkingDto);
        return "";
    }
}
