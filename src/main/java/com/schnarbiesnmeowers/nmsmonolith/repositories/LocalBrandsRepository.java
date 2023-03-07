package com.schnarbiesnmeowers.nmsmonolith.repositories;

import com.schnarbiesnmeowers.nmsmonolith.pojos.LocalIngredients;
import org.springframework.data.jpa.repository.JpaRepository;
import com.schnarbiesnmeowers.nmsmonolith.pojos.LocalBrands;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author Dylan I. Kessler
 *
 */
public interface LocalBrandsRepository extends JpaRepository<LocalBrands, Integer>{

    @Query(value = "select * from local_brands lb where lb.user_id = ?1 and lb.actv='Y' order by lb.brand_name", nativeQuery = true)
    public Iterable<LocalBrands> findLocalBrandsByUserId(int userId);

    Iterable<LocalBrands> findLocalBrandsByImageLoc(Integer id);

}
