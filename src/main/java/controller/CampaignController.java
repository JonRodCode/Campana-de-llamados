package controller;

import model.Campaign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import service.CampaignService;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
public class CampaignController {

    @Autowired
    CampaignService service;

    @GetMapping(value="campaign", produces=MediaType.APPLICATION_JSON_VALUE)
    public List<Campaign> getAllCampaigns(){
        return service.getAllCampaigns();
    }

    @PostMapping(value="campaign", consumes=MediaType.APPLICATION_JSON_VALUE)
    public void createCampaign(@RequestBody Campaign campaign){
        service.createCampaign(campaign);
    }

    @GetMapping(value="campaign/{id}", produces=MediaType.APPLICATION_JSON_VALUE)
    public Campaign getCampaign(@PathVariable("id") int id){
        return service.getCampaign(id);
    }

    @PutMapping(value="campaign/{id}", consumes=MediaType.APPLICATION_JSON_VALUE)
    public void updateCampaign(@RequestBody Campaign campaign, @PathVariable("id") int id){
        campaign.setId(id);
        service.updateCampaign(campaign);
    }

    @DeleteMapping(value = "campaign/{id}")
    public void deleteCampaign(@PathVariable("id") int id){
        service.deleteCampaign(id);
    }
}
