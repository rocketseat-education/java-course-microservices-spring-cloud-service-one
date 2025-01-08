package com.rocketseat.service.tasks;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface TasksRepository extends JpaRepository<TasksEntity, Long> {

    @Query("SELECT t from Task t where t.dueDate <= :deadline AND t.notified = false")
    List<TasksEntity> findTasksDueWithinDeadline(LocalDateTime deadline);
}
