package service;

import dao.CampaignDao;
import model.Campaign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CampaignServiceImpl implements CampaignService {

    @Autowired
    CampaignDao campaignRepository;

    @Override
    public void createCampaign(Campaign campaign){
        campaignRepository.createCampaign(campaign);
    }
    @Override
    public List<Campaign> getAllCampaigns(){
        return campaignRepository.getAllCampaigns();
    }
    //public Campaign getCampaign(int id){    }
    //public void updateCampaign(Campaign campaign){    }
    //public void deleteCampaign(int id){    }
}
