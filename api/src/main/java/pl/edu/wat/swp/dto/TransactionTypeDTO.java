package pl.edu.wat.swp.dto;

/**
 * 
 * @author Krzysztof Jedynak @email jedynakpoczta@gmail.com
 * @date 22 sty 2015
 */
public class TransactionTypeDTO
{
    private Integer id;
    private String type;

    public TransactionTypeDTO()
    {
    }

    public TransactionTypeDTO( Integer id, String type )
    {
        this.id = id;
        this.type = type;
    }

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

}
