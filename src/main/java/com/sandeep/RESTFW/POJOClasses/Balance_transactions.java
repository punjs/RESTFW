package com.sandeep.RESTFW.POJOClasses;

public class Balance_transactions
{
    private String available_on;

    private String exchange_rate;

    private String status;

    private Fee_details[] fee_details;

    private String object;

    private String type;

    private String net;

    private String currency;

    private String id;

    private String amount;

    private String fee;

    private String source;

    private String created;

    private String description;

    public String getAvailable_on ()
    {
        return available_on;
    }

    public void setAvailable_on (String available_on)
    {
        this.available_on = available_on;
    }

    public String getExchange_rate ()
    {
        return exchange_rate;
    }

    public void setExchange_rate (String exchange_rate)
    {
        this.exchange_rate = exchange_rate;
    }

    public String getStatus ()
    {
        return status;
    }

    public void setStatus (String status)
    {
        this.status = status;
    }

    public Fee_details[] getFee_details ()
    {
        return fee_details;
    }

    public void setFee_details (Fee_details[] fee_details)
    {
        this.fee_details = fee_details;
    }

    public String getObject ()
    {
        return object;
    }

    public void setObject (String object)
    {
        this.object = object;
    }

    public String getType ()
    {
        return type;
    }

    public void setType (String type)
    {
        this.type = type;
    }

    public String getNet ()
    {
        return net;
    }

    public void setNet (String net)
    {
        this.net = net;
    }

    public String getCurrency ()
    {
        return currency;
    }

    public void setCurrency (String currency)
    {
        this.currency = currency;
    }

    public String getId ()
    {
        return id;
    }

    public void setId (String id)
    {
        this.id = id;
    }

    public String getAmount ()
    {
        return amount;
    }

    public void setAmount (String amount)
    {
        this.amount = amount;
    }

    public String getFee ()
    {
        return fee;
    }

    public void setFee (String fee)
    {
        this.fee = fee;
    }

    public String getSource ()
    {
        return source;
    }

    public void setSource (String source)
    {
        this.source = source;
    }

    public String getCreated ()
    {
        return created;
    }

    public void setCreated (String created)
    {
        this.created = created;
    }

    public String getDescription ()
    {
        return description;
    }

    public void setDescription (String description)
    {
        this.description = description;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [available_on = "+available_on+", exchange_rate = "+exchange_rate+", status = "+status+", fee_details = "+fee_details+", object = "+object+", type = "+type+", net = "+net+", currency = "+currency+", id = "+id+", amount = "+amount+", fee = "+fee+", source = "+source+", created = "+created+", description = "+description+"]";
    }
}
			
			