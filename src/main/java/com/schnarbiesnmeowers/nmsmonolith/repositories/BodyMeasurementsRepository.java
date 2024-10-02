package com.schnarbiesnmeowers.nmsmonolith.repositories;

import com.schnarbiesnmeowers.nmsmonolith.entities.BodyMeasurements;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface BodyMeasurementsRepository extends JpaRepository<BodyMeasurements,Integer> {

    @Query(value = "select * from body_measurements bm where bm.user_id = ?1 " +
            "and bm.actv = 'Y' order by bm.calendar_date", nativeQuery = true)
    Iterable<BodyMeasurements> findBodyMeasurementsByUserId(int userId);
}
