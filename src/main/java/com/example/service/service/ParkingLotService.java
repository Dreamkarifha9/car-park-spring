package com.example.service.service;


import com.example.service.entity.ParkingLot;
import com.example.service.model.ParkingLotDto;
import com.example.service.repository.ParkingLotRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ParkingLotService {
    private final ParkingLotRepository repository;

    public  ParkingLotService(ParkingLotRepository repository) {
        this.repository = repository;
    }

    public Iterable<ParkingLot> findAll() {
        Iterable<ParkingLot> all = repository.findAll();

        return  all;
    }
    public ParkingLot create(ParkingLotDto createDto) {
        System.out.println(createDto);
        ParkingLot entity = new ParkingLot();
        entity.setName(createDto.getName());
        entity.setActive(true);
        entity.setDeleted(false);
        entity.setCreatedBy("system");
        entity.setUpdatedBy("system");
        return  repository.save(entity);
    }
}
