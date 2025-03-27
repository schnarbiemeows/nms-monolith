package com.schnarbiesnmeowers.nmsmonolith.repositories;

import com.schnarbiesnmeowers.nmsmonolith.entities.mostpopular.MostPopularFoodItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface MostPopularFoodItemRepository extends JpaRepository<MostPopularFoodItem, Integer> {

    @Query(value = "select q.user_id, q.bldst_id, q.ingr_id, q.ingr_desc, q.total, q.is_recipe, " +
            "q.is_local, q.num_srv, " +
            "st.serv_type_id, st.serv_type_cde from " +
            "(" +
            "select dd.user_id, dd.bldst_id, dd.ingr_id, ingr.ingr_desc, count(dd.ingr_id) as total, " +
            "dd.num_srv, " +
            "dd.is_recipe, dd.is_local, dd.serv_type_id " +
            "from daily_diet dd " +
            "join ingredients ingr on dd.ingr_id = ingr.ingr_id " +
            "where dd.user_id=?1 " +
            "and dd.is_local=0 and dd.is_recipe=0 " +
            "and dd.calendar_date > date(?2) " +
            "group by dd.bldst_id, dd.ingr_id, dd.serv_type_id, dd.num_srv, dd.is_recipe, dd.is_local " +
            "UNION " +
            "select dd.user_id, dd.bldst_id, dd.ingr_id, ingr.ingr_desc, count(dd.ingr_id) as total, dd.num_srv, " +
            "dd.is_recipe, dd.is_local, dd.serv_type_id " +
            "from daily_diet dd " +
            "join local_ingredients ingr on dd.ingr_id = ingr.ingr_id " +
            "where dd.user_id= ?1 " +
            "and dd.is_local=1 and dd.is_recipe=0 " +
            "and dd.calendar_date > date(?2) " +
            "group by dd.bldst_id, dd.ingr_id, dd.serv_type_id, dd.num_srv, dd.is_recipe, dd.is_local " +
            "UNION " +
            "select dd.user_id, dd.bldst_id, dd.ingr_id, ingr.recipe_name, count(dd.ingr_id) as total, dd.num_srv, " +
            "dd.is_recipe, dd.is_local, dd.serv_type_id " +
            "from daily_diet dd " +
            "join recipes ingr on dd.ingr_id = ingr.recipe_id " +
            "where dd.user_id=?1 " +
            "and dd.is_local=0 and dd.is_recipe=1 " +
            "and dd.calendar_date > date(?2) " +
            "group by dd.bldst_id, dd.ingr_id, dd.serv_type_id, dd.num_srv, dd.is_recipe, dd.is_local " +
            "UNION " +
            "select dd.user_id, dd.bldst_id, dd.ingr_id, ingr.recipe_name, count(dd.ingr_id) as total, dd.num_srv, " +
            "dd.is_recipe, dd.is_local, dd.serv_type_id " +
            "from daily_diet dd " +
            "join local_recipes ingr on dd.ingr_id = ingr.recipe_id " +
            "where dd.user_id=?1 " +
            "and dd.is_local=1 and dd.is_recipe=1 " +
            "and dd.calendar_date > date(?2) " +
            "group by dd.bldst_id, dd.ingr_id, dd.serv_type_id, dd.num_srv, dd.is_recipe, dd.is_local" +
            ") q, " +
            "serving_types st " +
            "where q.serv_type_id = st.serv_type_id " +
            "order by q.user_id, q.bldst_id, q.total desc, q.ingr_id, st.serv_type_cde, q.num_srv  ;",nativeQuery = true)
    public Iterable<MostPopularFoodItem> findByUserIdAndCalendarDate(int user_id, String calendarDate);

    @Query(value = "select q.user_id, q.bldst_id, q.ingr_id, q.ingr_desc, q.total, q.is_recipe, " +
            "q.is_local, q.num_srv, " +
            "st.serv_type_id, st.serv_type_cde from " +
            "(" +
            "select dd.user_id, dd.bldst_id, dd.ingr_id, ingr.ingr_desc, count(dd.ingr_id) as total, " +
            "dd.num_srv, " +
            "dd.is_recipe, dd.is_local, dd.serv_type_id " +
            "from daily_diet dd " +
            "join ingredients ingr on dd.ingr_id = ingr.ingr_id " +
            "where dd.user_id=?1 " +
            "and dd.bldst_id=?2 " +
            "and dd.is_local=0 and dd.is_recipe=0 " +
            "and dd.calendar_date > date(?2) " +
            "group by dd.bldst_id, dd.ingr_id, dd.serv_type_id, dd.num_srv, dd.is_recipe, dd.is_local " +
            "UNION " +
            "select dd.user_id, dd.bldst_id, dd.ingr_id, ingr.ingr_desc, count(dd.ingr_id) as total, dd.num_srv, " +
            "dd.is_recipe, dd.is_local, dd.serv_type_id " +
            "from daily_diet dd " +
            "join local_ingredients ingr on dd.ingr_id = ingr.ingr_id " +
            "where dd.user_id= ?1 " +
            "and dd.bldst_id=?2 " +
            "and dd.is_local=1 and dd.is_recipe=0 " +
            "and dd.calendar_date > date(?2) " +
            "group by dd.bldst_id, dd.ingr_id, dd.serv_type_id, dd.num_srv, dd.is_recipe, dd.is_local " +
            "UNION " +
            "select dd.user_id, dd.bldst_id, dd.ingr_id, ingr.recipe_name, count(dd.ingr_id) as total, dd.num_srv, " +
            "dd.is_recipe, dd.is_local, dd.serv_type_id " +
            "from daily_diet dd " +
            "join recipes ingr on dd.ingr_id = ingr.recipe_id " +
            "where dd.user_id=?1 " +
            "and dd.bldst_id=?2 " +
            "and dd.is_local=0 and dd.is_recipe=1 " +
            "and dd.calendar_date > date(?2) " +
            "group by dd.bldst_id, dd.ingr_id, dd.serv_type_id, dd.num_srv, dd.is_recipe, dd.is_local " +
            "UNION " +
            "select dd.user_id, dd.bldst_id, dd.ingr_id, ingr.recipe_name, count(dd.ingr_id) as total, dd.num_srv, " +
            "dd.is_recipe, dd.is_local, dd.serv_type_id " +
            "from daily_diet dd " +
            "join local_recipes ingr on dd.ingr_id = ingr.recipe_id " +
            "where dd.user_id=?1 " +
            "and dd.bldst_id=?2 " +
            "and dd.is_local=1 and dd.is_recipe=1 " +
            "and dd.calendar_date > date(?2) " +
            "group by dd.bldst_id, dd.ingr_id, dd.serv_type_id, dd.num_srv, dd.is_recipe, dd.is_local" +
            ") q, " +
            "serving_types st " +
            "where q.serv_type_id = st.serv_type_id " +
            "order by q.user_id, q.bldst_id, q.total desc, q.ingr_id, st.serv_type_cde, q.num_srv  ;",nativeQuery = true)
    public Iterable<MostPopularFoodItem> findByUserIdAndCalendarDateAndBldstId(int user_id, String calendarDate,
                                                                               int bldstId);


}
