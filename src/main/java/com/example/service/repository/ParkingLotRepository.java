package com.example.service.repository;

import com.example.service.entity.ParkingLot;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ParkingLotRepository extends CrudRepository<ParkingLot, Integer> {

    Optional<ParkingLot> findByName(String name);

    boolean existsByName(String name);

}
