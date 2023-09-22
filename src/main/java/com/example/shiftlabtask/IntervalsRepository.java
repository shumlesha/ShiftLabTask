package com.example.shiftlabtask;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface IntervalsRepository extends JpaRepository<CustomInterval, Long> {

    @Query(value = "SELECT * FROM custom_interval WHERE interval_kind = :kind ORDER BY interval_begin ASC, interval_end ASC LIMIT 1", nativeQuery = true)
    CustomInterval findminimalrange(@Param("kind") String kind);

}