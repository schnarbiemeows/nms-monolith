package com.schnarbiesnmeowers.nmsmonolith.repositories;

import com.schnarbiesnmeowers.nmsmonolith.entities.mostpopular.ManualFoodItemVw;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ManualFoodItemVwRepository extends JpaRepository<ManualFoodItemVw, Integer> {

    @Query(value = "select * from manual_food_items mfi where mfi.bldst_id = ?1",nativeQuery = true)
    Iterable<ManualFoodItemVw> findByBldstId(int bldstId);

    @Query(value = "select q.manual_food_item_id, q.user_id, q.bldst_id, q.ingr_id, q.ingr_desc, q.total, q.is_recipe, q.is_local, q.num_srv, " +
            "st.serv_type_id, st.serv_type_cde from " +
            "( " +
            "select mfi.manual_food_item_id, mfi.user_id, mfi.bldst_id, mfi.ingr_id, ingr.ingr_desc, 1 as total, mfi.num_srv, " +
            "mfi.is_recipe, mfi.is_local, mfi.serv_type_id " +
            "from manual_food_items mfi " +
            "join ingredients ingr on mfi.ingr_id = ingr.ingr_id " +
            "where mfi.user_id=?1  " +
            "and mfi.is_local=0 and mfi.is_recipe=0 " +
            "group by mfi.bldst_id, mfi.ingr_id, mfi.serv_type_id, mfi.num_srv, mfi.is_recipe, mfi.is_local " +
            "UNION " +
            "select mfi.manual_food_item_id, mfi.user_id, mfi.bldst_id, mfi.ingr_id, ingr.ingr_desc, 1 as total, mfi.num_srv, " +
            "mfi.is_recipe, mfi.is_local, mfi.serv_type_id " +
            "from manual_food_items mfi " +
            "join local_ingredients ingr on mfi.ingr_id = ingr.ingr_id " +
            "where mfi.user_id=?1  " +
            "and mfi.is_local=1 and mfi.is_recipe=0 " +
            "group by mfi.bldst_id, mfi.ingr_id, mfi.serv_type_id, mfi.num_srv, mfi.is_recipe, mfi.is_local " +
            "UNION " +
            "select mfi.manual_food_item_id, mfi.user_id, mfi.bldst_id, mfi.ingr_id, ingr.recipe_name, 1 as total, mfi.num_srv, " +
            "mfi.is_recipe, mfi.is_local, mfi.serv_type_id " +
            "from manual_food_items mfi " +
            "join recipes ingr on mfi.ingr_id = ingr.recipe_id " +
            "where mfi.user_id=?1  " +
            "and mfi.is_local=0 and mfi.is_recipe=1 " +
            "group by mfi.bldst_id, mfi.ingr_id, mfi.serv_type_id, mfi.num_srv, mfi.is_recipe, mfi.is_local " +
            "UNION " +
            "select mfi.manual_food_item_id,mfi.user_id, mfi.bldst_id, mfi.ingr_id, ingr.recipe_name, 1 as total, mfi.num_srv, " +
            "mfi.is_recipe, mfi.is_local, mfi.serv_type_id " +
            "from manual_food_items mfi " +
            "join local_recipes ingr on mfi.ingr_id = ingr.recipe_id " +
            "where mfi.user_id=?1  " +
            "and mfi.is_local=1 and mfi.is_recipe=1 " +
            "group by mfi.bldst_id, mfi.ingr_id, mfi.serv_type_id, mfi.num_srv, mfi.is_recipe, mfi.is_local " +
            ") q, " +
            "serving_types st " +
            "where q.serv_type_id = st.serv_type_id " +
            "order by q.user_id, q.bldst_id, q.ingr_id, st.serv_type_cde, q.num_srv  ;",nativeQuery = true)
    public List<ManualFoodItemVw> findManualItemsByUserId(int user_id);

    @Query(value = "select q.manual_food_item_id, q.user_id, q.bldst_id, q.ingr_id, q.ingr_desc, q.total, q.is_recipe," +
            " q.is_local, q.num_srv, " +
            "st.serv_type_id, st.serv_type_cde from " +
            "( " +
            "select mfi.manual_food_item_id, mfi.user_id, mfi.bldst_id, mfi.ingr_id, ingr.ingr_desc, 1 as total, " +
            "mfi.num_srv, " +
            "mfi.is_recipe, mfi.is_local, mfi.serv_type_id " +
            "from manual_food_items mfi " +
            "join ingredients ingr on mfi.ingr_id = ingr.ingr_id " +
            "where mfi.user_id=?1  " +
            "and mfi.bldst_id=?2" +
            "and mfi.is_local=0 and mfi.is_recipe=0 " +
            "group by mfi.bldst_id, mfi.ingr_id, mfi.serv_type_id, mfi.num_srv, mfi.is_recipe, mfi.is_local " +
            "UNION " +
            "select mfi.manual_food_item_id, mfi.user_id, mfi.bldst_id, mfi.ingr_id, ingr.ingr_desc, 1 as total, " +
            "mfi.num_srv, " +
            "mfi.is_recipe, mfi.is_local, mfi.serv_type_id " +
            "from manual_food_items mfi " +
            "join local_ingredients ingr on mfi.ingr_id = ingr.ingr_id " +
            "where mfi.user_id=?1  " +
            "and mfi.bldst_id=?2" +
            "and mfi.is_local=1 and mfi.is_recipe=0 " +
            "group by mfi.bldst_id, mfi.ingr_id, mfi.serv_type_id, mfi.num_srv, mfi.is_recipe, mfi.is_local " +
            "UNION " +
            "select mfi.manual_food_item_id, mfi.user_id, mfi.bldst_id, mfi.ingr_id, ingr.recipe_name, 1 as total, " +
            "mfi.num_srv, " +
            "mfi.is_recipe, mfi.is_local, mfi.serv_type_id " +
            "from manual_food_items mfi " +
            "join recipes ingr on mfi.ingr_id = ingr.recipe_id " +
            "where mfi.user_id=?1  " +
            "and mfi.bldst_id=?2" +
            "and mfi.is_local=0 and mfi.is_recipe=1 " +
            "group by mfi.bldst_id, mfi.ingr_id, mfi.serv_type_id, mfi.num_srv, mfi.is_recipe, mfi.is_local " +
            "UNION " +
            "select mfi.manual_food_item_id, mfi.user_id, mfi.bldst_id, mfi.ingr_id, ingr.recipe_name, 1 as total, " +
            "mfi.num_srv, " +
            "mfi.is_recipe, mfi.is_local, mfi.serv_type_id " +
            "from manual_food_items mfi " +
            "join local_recipes ingr on mfi.ingr_id = ingr.recipe_id " +
            "where mfi.user_id=?1  " +
            "and mfi.bldst_id=?2" +
            "and mfi.is_local=1 and mfi.is_recipe=1 " +
            "group by mfi.bldst_id, mfi.ingr_id, mfi.serv_type_id, mfi.num_srv, mfi.is_recipe, mfi.is_local " +
            ") q, " +
            "serving_types st " +
            "where q.serv_type_id = st.serv_type_id " +
            "order by q.user_id, q.bldst_id, q.ingr_id, st.serv_type_cde, q.num_srv  ;",nativeQuery = true)
    public List<ManualFoodItemVw> findManualItemsByUserIdAndBldstId(int user_id, int bldstId);
}
