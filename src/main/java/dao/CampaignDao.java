package dao;

import model.Campaign;

import java.util.List;
import java.util.Optional;

public interface CampaignDao {
    Campaign createCampaign(Campaign campaign);
    List<Campaign> getAllCampaigns();
    Campaign getCampaign(String name);
    Campaign getCampaign(int id);
    Campaign updateCampaign(Campaign campaign);
    void deleteCampaign(int id);

}
