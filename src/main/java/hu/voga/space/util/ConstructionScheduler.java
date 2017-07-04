package hu.voga.space.util;


import hu.voga.space.entity.Construction;
import hu.voga.space.service.ConstructionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.concurrent.ConcurrentTaskScheduler;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

@Component
public class ConstructionScheduler {


    @Autowired
    private ConstructionService constructionService;

    public void scheduleConstruction(Construction construction){
        ScheduledExecutorService localExecutor = Executors.newSingleThreadScheduledExecutor();
        TaskScheduler scheduler = new ConcurrentTaskScheduler(localExecutor);

        Runnable constructionRunnable = () -> constructionService.build(construction);
        final LocalDateTime constructionEndDate = LocalDateTime.ofInstant(construction.getCtEnd().toInstant(), ZoneId.systemDefault());
        scheduler.schedule(constructionRunnable,
                Date.from(constructionEndDate.plusSeconds(1).atZone(ZoneId.systemDefault()).toInstant()));
    }
}
