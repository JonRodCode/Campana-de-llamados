package enums;

public enum StatusCampaign {
    ACTIVE("ACTIVE"), WAITING("WAITING"), FINISHED("FINISHED");

    private String code;

    StatusCampaign(String code) { this.code = code; }

    public String getCode() {return code;}


}
