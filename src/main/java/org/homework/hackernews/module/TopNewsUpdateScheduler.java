package org.homework.hackernews.module;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.io.IOException;

@Configuration
@EnableAsync
@EnableScheduling
public class TopNewsUpdateScheduler {
    private static final long SECONDS = 1000;
    private static final long MINUTES = 60 * SECONDS;

    private final TopNewsUpdater topNewsUpdater;
    private final Logger logger = LoggerFactory.getLogger(getClass());

    public TopNewsUpdateScheduler(TopNewsUpdater topNewsUpdater) {
        this.topNewsUpdater = topNewsUpdater;
    }

    @Scheduled(initialDelay = 15 * SECONDS, fixedRate = 1 * MINUTES)
    public void run(){
        try {
            logger.debug("Updating top news");
            topNewsUpdater.update();
            logger.debug("Finished updating top news");
        }
        catch(IOException e){
            logger.debug("Error while updating top news", e);
        }
    }
}
