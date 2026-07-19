package dao;

import model.Campaign;

import java.util.List;
import java.util.Optional;

public interface CampaignDao {
    void createCampaign(Campaign campaign);
    List<Campaign> getAllCampaigns();
    Campaign getCampaign(String name);
    Campaign getCampaign(int id);
    void updateCampaign(Campaign campaign);
    void deleteCampaign(int id);

}
