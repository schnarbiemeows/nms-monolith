package com.schnarbiesnmeowers.nmsmonolith.repositories;

import com.schnarbiesnmeowers.nmsmonolith.pojos.DailyJournal;
import com.schnarbiesnmeowers.nmsmonolith.pojos.DailyJournal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;
import java.util.Optional;

public interface DailyJournalRepository extends JpaRepository<DailyJournal,Integer> {

    public Iterable<DailyJournal> findDailyJournalByUserId(int userId);

    @Query(value = "select * from daily_journal ddn where ddn.user_id= ?1 " +
            "and ddn.calendar_date=?2",nativeQuery = true)
    public Optional<DailyJournal> findDailyJournalByUserIdAndDate(int userId, Date date);
}
