package service;

import model.Campaign;
import java.util.List;

public interface CampaignService {

    void createCampaign(Campaign campaign);
    List<Campaign> getAllCampaigns();
    //Campaign getCampaign(int id);
    //void updateCampaign(Campaign campaign);
    //void deleteCampaign(int id);
}
