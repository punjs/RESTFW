package com.sandeep.RESTFW.POJOClasses;

public class Fee_details
{
    private String amount;

    private String application;

    private String description;

    private String type;

    private String currency;

    public String getAmount ()
    {
        return amount;
    }

    public void setAmount (String amount)
    {
        this.amount = amount;
    }

    public String getApplication ()
    {
        return application;
    }

    public void setApplication (String application)
    {
        this.application = application;
    }

    public String getDescription ()
    {
        return description;
    }

    public void setDescription (String description)
    {
        this.description = description;
    }

    public String getType ()
    {
        return type;
    }

    public void setType (String type)
    {
        this.type = type;
    }

    public String getCurrency ()
    {
        return currency;
    }

    public void setCurrency (String currency)
    {
        this.currency = currency;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [amount = "+amount+", application = "+application+", description = "+description+", type = "+type+", currency = "+currency+"]";
    }
}
			
			