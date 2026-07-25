package dao;

import enums.StatusCampaign;
import model.Campaign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public class CampaignDaoImpl implements CampaignDao {

    @Autowired
    CampaignJpaSpring campaignRepository;

    @Override
    public Campaign createCampaign(Campaign campaign){
        return campaignRepository.save(campaign);
    }
    @Override
    public List<Campaign> getAllCampaigns(){
        return campaignRepository.findAll();
    }
    @Override
    public Campaign getCampaign(String name){ return campaignRepository.findByName(name); }
    @Override
    public Campaign getCampaign(int id) { return campaignRepository.findById(id).orElse(null); }
    @Override
    public Campaign updateCampaign(Campaign campaign) { return campaignRepository.save(campaign); }

    @Override
    public void deleteCampaign(int id) { campaignRepository.deleteById(id);  }

    @Override
    public List<Campaign> getCampaignsToActivate(Date now) {
        return campaignRepository.findByStatusAndStartDateLessThanEqual(StatusCampaign.WAITING, now);
    }

    @Override
    public List<Campaign> getCampaignsToFinish(Date now) {
        return campaignRepository.findByStatusNotAndEndDateLessThanEqual(StatusCampaign.FINISHED, now);
    }
}
