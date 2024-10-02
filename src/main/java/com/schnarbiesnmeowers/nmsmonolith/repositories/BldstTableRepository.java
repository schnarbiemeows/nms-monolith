package com.schnarbiesnmeowers.nmsmonolith.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.schnarbiesnmeowers.nmsmonolith.entities.BldstTable;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author Dylan I. Kessler
 *
 */
public interface BldstTableRepository extends JpaRepository<BldstTable, Integer> {

    @Query( value = "select * from bldst_table b where b.actv='Y'", nativeQuery = true)
    public Iterable<BldstTable> getAllActiveBDLST();
}
