package com.sandeep.RESTFW.POJOClasses;

public class Evidence_details
{
    private String submission_count;

    private String due_by;

    private String has_evidence;

    private String past_due;

    public String getSubmission_count ()
    {
        return submission_count;
    }

    public void setSubmission_count (String submission_count)
    {
        this.submission_count = submission_count;
    }

    public String getDue_by ()
    {
        return due_by;
    }

    public void setDue_by (String due_by)
    {
        this.due_by = due_by;
    }

    public String getHas_evidence ()
    {
        return has_evidence;
    }

    public void setHas_evidence (String has_evidence)
    {
        this.has_evidence = has_evidence;
    }

    public String getPast_due ()
    {
        return past_due;
    }

    public void setPast_due (String past_due)
    {
        this.past_due = past_due;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [submission_count = "+submission_count+", due_by = "+due_by+", has_evidence = "+has_evidence+", past_due = "+past_due+"]";
    }
}
			
			