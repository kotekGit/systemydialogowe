package pl.edu.wat.swp.dto;

/**
 * 
 * @author Krzysztof Jedynak @email jedynakpoczta@gmail.com
 * @date 22 sty 2015
 */
public class SearchTransactionsDTO
{

    private Integer id;
    private String type;
    private String category;
    private String interval;

    public Integer getId()
    {
        return id;
    }

    public void setId( Integer id )
    {
        this.id = id;
    }

    public String getType()
    {
        return type;
    }

    public void setType( String type )
    {
        this.type = type;
    }

    public String getCategory()
    {
        return category;
    }

    public void setCategory( String category )
    {
        this.category = category;
    }

    public String getInterval()
    {
        return interval;
    }

    public void setInterval( String interval )
    {
        this.interval = interval;
    }

}
