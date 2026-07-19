package service;

import dao.CampaignDao;
import model.Campaign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CampaignServiceImpl implements CampaignService {

    @Autowired
    CampaignDao dao;

    @Override
    public void createCampaign(Campaign campaign){
        if(isValidNameOfCampaign(campaign.getName())){
            dao.createCampaign(campaign);
        }
    }
    @Override
    public List<Campaign> getAllCampaigns(){return dao.getAllCampaigns(); }
    @Override
    public Campaign getCampaign(int id){ return dao.getCampaign(id); }
    @Override
    public void updateCampaign(Campaign campaign){ dao.updateCampaign(campaign); }
    @Override
    public void deleteCampaign(int id){ dao.deleteCampaign(id);   }

    private boolean isValidNameOfCampaign(String name){
        return dao.getCampaign(name) == null;
    }
}

