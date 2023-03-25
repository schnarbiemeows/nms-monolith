package com.schnarbiesnmeowers.nmsmonolith.repositories;

import com.schnarbiesnmeowers.nmsmonolith.pojos.FavoriteSpices;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author Dylan I. Kessler
 *
 */
public interface FavoriteSpicesRepository extends JpaRepository<FavoriteSpices, Integer> {

    @Query(value = "select * from favorite_spices fs where fs.user_id = ?1 and fs.actv='Y'", nativeQuery = true)
    public Iterable<FavoriteSpices> findFavoriteSpicesByUserId(int userId);

    @Query(value = "select * from favorite_spices fs where fs.user_id = ?1 and fs.is_local=true and fs.spice_id=?2" +
            " and fs.actv='Y'", nativeQuery = true)
    public Iterable<FavoriteSpices> findLocalSpicesInAnyUserFavorites(int userId, int spiceId);

    @Query(value = "select * from favorite_spices fs where fs.is_local=false and fs.spice_id=?1 and fs.actv='Y'",
            nativeQuery = true)
    public Iterable<FavoriteSpices> findGlobalSpicesInAnyUserFavorites(int spiceId);
}
