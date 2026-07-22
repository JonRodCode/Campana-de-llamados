package controller;

import model.Campaign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import service.CampaignService;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
public class CampaignController {

    @Autowired
    CampaignService service;

    @GetMapping(value="campaign", produces=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Campaign>> getAllCampaigns(){
        return new ResponseEntity<List<Campaign>>(service.getAllCampaigns(), HttpStatus.OK);
    }

    @PostMapping(value="campaign", consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> createCampaign(@RequestBody Campaign campaign){
        try {
            if (campaign.getId() != 0){
                throw new RuntimeException("No se debe enviar un id en el cuerpo del mensaje.");
            }
            return new ResponseEntity<Campaign>(service.createCampaign(campaign), HttpStatus.OK);
        } catch (RuntimeException ex) {
            return new ResponseEntity<String>(ex.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping(value="campaign/{id}", produces=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Campaign> getCampaign(@PathVariable("id") int id){
        return new ResponseEntity<Campaign>(service.getCampaign(id), HttpStatus.OK);
    }

    @PutMapping(value="campaign/{id}", consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> updateCampaign(@RequestBody Campaign campaign, @PathVariable("id") int id){
        try {
            if (campaign.getId() != 0 && campaign.getId() != id){
                throw new RuntimeException("El id enviado en el cuerpo no se corresponde con la url.");
            }
            campaign.setId(id);
            return new ResponseEntity<Campaign>(service.updateCampaign(campaign), HttpStatus.OK);
        } catch (RuntimeException ex) {
            return new ResponseEntity<String>(ex.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping(value = "campaign/{id}")
    public ResponseEntity<Void> deleteCampaign(@PathVariable("id") int id){
        try {
            service.deleteCampaign(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (EmptyResultDataAccessException ex) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
