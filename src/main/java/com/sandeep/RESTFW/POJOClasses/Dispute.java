package com.sandeep.RESTFW.POJOClasses;

public class Dispute
{
    private String status;

    private String reason;

    private String balance_transaction;

    private Evidence evidence;

    private String object;

    private String currency;

    private String id;

    private String amount;

    private Evidence_details evidence_details;

    private String is_charge_refundable;

    private String charge;

    private String created;

    private Balance_transactions[] balance_transactions;

    private String livemode;

    private Metadata metadata;

    public String getStatus ()
    {
        return status;
    }

    public void setStatus (String status)
    {
        this.status = status;
    }

    public String getReason ()
    {
        return reason;
    }

    public void setReason (String reason)
    {
        this.reason = reason;
    }

    public String getBalance_transaction ()
    {
        return balance_transaction;
    }

    public void setBalance_transaction (String balance_transaction)
    {
        this.balance_transaction = balance_transaction;
    }

    public Evidence getEvidence ()
    {
        return evidence;
    }

    public void setEvidence (Evidence evidence)
    {
        this.evidence = evidence;
    }

    public String getObject ()
    {
        return object;
    }

    public void setObject (String object)
    {
        this.object = object;
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

    public Evidence_details getEvidence_details ()
    {
        return evidence_details;
    }

    public void setEvidence_details (Evidence_details evidence_details)
    {
        this.evidence_details = evidence_details;
    }

    public String getIs_charge_refundable ()
    {
        return is_charge_refundable;
    }

    public void setIs_charge_refundable (String is_charge_refundable)
    {
        this.is_charge_refundable = is_charge_refundable;
    }

    public String getCharge ()
    {
        return charge;
    }

    public void setCharge (String charge)
    {
        this.charge = charge;
    }

    public String getCreated ()
    {
        return created;
    }

    public void setCreated (String created)
    {
        this.created = created;
    }

    public Balance_transactions[] getBalance_transactions ()
    {
        return balance_transactions;
    }

    public void setBalance_transactions (Balance_transactions[] balance_transactions)
    {
        this.balance_transactions = balance_transactions;
    }

    public String getLivemode ()
    {
        return livemode;
    }

    public void setLivemode (String livemode)
    {
        this.livemode = livemode;
    }

    public Metadata getMetadata ()
    {
        return metadata;
    }

    public void setMetadata (Metadata metadata)
    {
        this.metadata = metadata;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [status = "+status+", reason = "+reason+", balance_transaction = "+balance_transaction+", evidence = "+evidence+", object = "+object+", currency = "+currency+", id = "+id+", amount = "+amount+", evidence_details = "+evidence_details+", is_charge_refundable = "+is_charge_refundable+", charge = "+charge+", created = "+created+", balance_transactions = "+balance_transactions+", livemode = "+livemode+", metadata = "+metadata+"]";
    }
}
			
			