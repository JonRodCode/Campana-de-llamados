package dao;

import model.Campaign;

import java.util.List;

public interface CampaignDao {
    void createCampaign(Campaign campaign);
    List<Campaign> getAllCampaigns();
}
