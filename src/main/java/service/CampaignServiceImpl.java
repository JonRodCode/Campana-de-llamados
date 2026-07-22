package service;

import dao.CampaignDao;
import enums.StatusCampaign;
import model.Campaign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CampaignServiceImpl implements CampaignService {

    @Autowired
    CampaignDao dao;

    @Override
    public Campaign createCampaign(Campaign campaign){
        if(isValidCreateCampaign(campaign)){
            campaign.setStatus(StatusCampaign.WAITING);
            return dao.createCampaign(campaign);
        }
        else throw new RuntimeException("Datos de campaña no válidos.");
    }
    @Override
    public List<Campaign> getAllCampaigns(){return dao.getAllCampaigns(); }
    @Override
    public Campaign getCampaign(int id){ return dao.getCampaign(id); }
    @Override
    public Campaign updateCampaign(Campaign campaign){
        if (isValidUpdateCampaign(campaign)){
            return dao.updateCampaign(campaign);
        }
        else throw new RuntimeException("Datos de campaña no válidos.");
    }
    @Override
    public void deleteCampaign(int id){ dao.deleteCampaign(id);   }

    private boolean isValidUpdateCampaign(Campaign campaign) {
        return isValidCreateCampaign(campaign) && !isStatusFINISHED(campaign.getId());
    }

    private boolean isValidCreateCampaign(Campaign campaign){
        return isUniqueTheNameOfCampaign(campaign) && isStartDateBeforeEndDate(campaign);
    }

    private boolean isUniqueTheNameOfCampaign(Campaign campaign){
        Campaign existentCampaign = dao.getCampaign(campaign.getName());
        if (existentCampaign == null){
            return true;
        }
        return existentCampaign.getId() == campaign.getId();
    }

    private boolean isStartDateBeforeEndDate(Campaign campaign){
        return campaign.getStartDate().before(campaign.getEndDate());
    }

    private boolean isStatusFINISHED(int id){
        Campaign oldCampaign = dao.getCampaign(id);
        return oldCampaign.getStatus() == StatusCampaign.FINISHED;
    }
}

