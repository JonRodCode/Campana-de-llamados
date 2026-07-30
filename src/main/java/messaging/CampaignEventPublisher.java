package messaging;

import model.Campaign;

public interface CampaignEventPublisher {
    void publishCampaignStatusChanged(Campaign campaign);
}
