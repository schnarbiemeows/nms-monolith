package com.schnarbiesnmeowers.nmsmonolith.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.schnarbiesnmeowers.nmsmonolith.entities.FavoriteBrands;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author Dylan I. Kessler
 *
 */
public interface FavoriteBrandsRepository extends JpaRepository<FavoriteBrands, Integer>{

    @Query(value = "select * from favorite_brands fb where fb.user_id = ?1 and fb.actv='Y'", nativeQuery = true)
    public Iterable<FavoriteBrands> findFavoriteBrandsByUserId(int userId);

    @Query(value = "select * from favorite_brands fb where fb.user_id = ?1 and fb.brand_id = ?2 and fb.actv='Y'", nativeQuery = true)
    public Iterable<FavoriteBrands> findFavoriteBrandsByUserIdAndBrandId(int userId, int brandId);

    @Query(value = "select * from favorite_brands fb where fb.user_id = ?1 and fb.brand_id = ?2 and fb.actv='N'", nativeQuery = true)
    public Iterable<FavoriteBrands> findInactiveFavoriteBrandsByUserIdAndBrandId(int userId, int brandId);

    @Query(value = "select * from favorite_brands fb where fb.user_id = ?1 and fb.brand_id = ?2 and fb.actv='Y' and is_local=true", nativeQuery = true)
    public Iterable<FavoriteBrands> findLocalFavoriteBrandsByUserIdAndBrandId(int userId, int brandId);

    @Query(value = "select * from favorite_brands fb where fb.brand_id = ?1 and fb.actv='Y' and is_local=false", nativeQuery = true)
    public Iterable<FavoriteBrands> findGlobalFavoriteBrandsByBrandId(int id);
}
