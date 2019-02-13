package com.sandeep.RESTFW.POJOClasses;

public class Refunds
{
    private String[] data;

    private String total_count;

    private String has_more;

    private String url;

    private String object;

    public String[] getData ()
    {
        return data;
    }

    public void setData (String[] data)
    {
        this.data = data;
    }

    public String getTotal_count ()
    {
        return total_count;
    }

    public void setTotal_count (String total_count)
    {
        this.total_count = total_count;
    }

    public String getHas_more ()
    {
        return has_more;
    }

    public void setHas_more (String has_more)
    {
        this.has_more = has_more;
    }

    public String getUrl ()
    {
        return url;
    }

    public void setUrl (String url)
    {
        this.url = url;
    }

    public String getObject ()
    {
        return object;
    }

    public void setObject (String object)
    {
        this.object = object;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [data = "+data+", total_count = "+total_count+", has_more = "+has_more+", url = "+url+", object = "+object+"]";
    }
}
			
			