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

    @GetMapping(value="campaign", produces= MediaType.APPLICATION_JSON_VALUE)
    public List<Campaign> getAllCampaigns(){
        return service.getAllCampaigns();
    }

    @PostMapping(value="campaign", consumes=MediaType.APPLICATION_JSON_VALUE)
    public void createCampaign(@RequestBody Campaign campaign){
        service.createCampaign(campaign);
    }
}
