package messaging;

import java.time.LocalDateTime;

public class CampaignStatusChangedEvent {

    private int campaignId;
    private String newStatus;
    private LocalDateTime timestamp;

    public CampaignStatusChangedEvent(int campaignId, String newStatus, LocalDateTime timestamp) {
        this.campaignId = campaignId;
        this.newStatus = newStatus;
        this.timestamp = timestamp;
    }

    public int getCampaignId() {
        return campaignId;
    }

    public String getNewStatus() {
        return newStatus;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }
}
