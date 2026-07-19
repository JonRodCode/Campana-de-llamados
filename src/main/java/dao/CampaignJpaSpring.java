package dao;

import model.Campaign;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CampaignJpaSpring extends JpaRepository<Campaign, Integer> {
    Campaign findByName(String name);
}
