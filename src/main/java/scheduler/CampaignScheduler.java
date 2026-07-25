package scheduler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import service.CampaignService;

@Component
public class CampaignScheduler {

    @Autowired
    CampaignService service;

    @Scheduled(fixedRate = 600000)
    public void updateCampaignStatuses(){
        service.updateCampaignsStatuses();
    }
}
