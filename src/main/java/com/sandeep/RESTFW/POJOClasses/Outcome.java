package com.sandeep.RESTFW.POJOClasses;


public class Outcome
{
    private String reason;

    private String risk_level;

    private String risk_score;

    private String seller_message;

    private String network_status;

    private String type;

    public String getReason ()
    {
        return reason;
    }

    public void setReason (String reason)
    {
        this.reason = reason;
    }

    public String getRisk_level ()
    {
        return risk_level;
    }

    public void setRisk_level (String risk_level)
    {
        this.risk_level = risk_level;
    }

    public String getRisk_score ()
    {
        return risk_score;
    }

    public void setRisk_score (String risk_score)
    {
        this.risk_score = risk_score;
    }

    public String getSeller_message ()
    {
        return seller_message;
    }

    public void setSeller_message (String seller_message)
    {
        this.seller_message = seller_message;
    }

    public String getNetwork_status ()
    {
        return network_status;
    }

    public void setNetwork_status (String network_status)
    {
        this.network_status = network_status;
    }

    public String getType ()
    {
        return type;
    }

    public void setType (String type)
    {
        this.type = type;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [reason = "+reason+", risk_level = "+risk_level+", risk_score = "+risk_score+", seller_message = "+seller_message+", network_status = "+network_status+", type = "+type+"]";
    }
}
			
			