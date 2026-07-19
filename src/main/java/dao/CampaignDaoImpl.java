package dao;

import model.Campaign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CampaignDaoImpl implements CampaignDao {

    @Autowired
    CampaignJpaSpring campaignRepository;

    @Override
    public void createCampaign(Campaign campaign){
        campaignRepository.save(campaign);
    }
    @Override
    public List<Campaign> getAllCampaigns(){
        return campaignRepository.findAll();
    }
}
