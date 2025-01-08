package com.rocketseat.service.tasks;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class TaskNotificationSchedule {
    private final TaskService taskService;

    public TaskNotificationSchedule(TaskService taskService) {
        this.taskService = taskService;
    }

    @Scheduled(fixedRate = 360000 * 24)
    public void checkAndNotifyTasks(){
        this.taskService.sendNotificationForDueTasks();
    }

}
