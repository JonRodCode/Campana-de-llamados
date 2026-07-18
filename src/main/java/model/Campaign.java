package model;

import enums.StatusCampaign;

import java.util.Date;

public class Campaign {
    private String name;
    private String description;
    private Date startDate;
    private Date endDate;
    private StatusCampaign status;

    //Constructor para mapear una campaña existente
    public Campaign(String name,
                    String description,
                    Date startDate,
                    Date endDate ) {
        this.name = name;
        this.description = description;
        this.startDate = startDate;
        this.endDate = endDate;
        this.status = StatusCampaign.WAITING;
    }


    //Constructor de nueva campaña, aca estará la validacion de fecha
    public Campaign(String name,
                    String description,
                    Date startDate,
                    Date endDate,
                    StatusCampaign status) {
        this.name = name;
        this.description = description;
        this.startDate = startDate;
        this.endDate = endDate;
        this.status = status;
    }
}
