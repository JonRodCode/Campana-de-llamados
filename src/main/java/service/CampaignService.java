package service;

import model.Campaign;
import java.util.List;

public interface CampaignService {

    Campaign createCampaign(Campaign campaign);
    List<Campaign> getAllCampaigns();
    Campaign getCampaign(int id);
    Campaign updateCampaign(Campaign campaign);
    void deleteCampaign(int id);
}
