package dao;

import enums.StatusCampaign;
import model.Campaign;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface CampaignJpaSpring extends JpaRepository<Campaign, Integer> {
    Campaign findByName(String name);
    List<Campaign> findByStatusAndStartDateLessThanEqual(StatusCampaign status, Date now);
    List<Campaign> findByStatusNotAndEndDateLessThanEqual(StatusCampaign status, Date now);
}
