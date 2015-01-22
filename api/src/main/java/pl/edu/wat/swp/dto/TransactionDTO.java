package pl.edu.wat.swp.dto;

import java.util.Date;

import pl.edu.wat.swp.model.Operacjabankowa;

/**
 * 
 * @author Krzysztof Jedynak @email jedynakpoczta@gmail.com
 * @date 22 sty 2015
 */
public class TransactionDTO
{

    private Integer id;
    private String content;
    private Date date;

    public TransactionDTO()
    {
    }

    public TransactionDTO( Operacjabankowa ob )
    {
        this.id = ob.getIdOB();
        this.content = ob.getOpis();
        this.date = ob.getDataOB();
    }

    public Integer getId()
    {
        return id;
    }

    public void setId( Integer id )
    {
        this.id = id;
    }

    public String getContent()
    {
        return content;
    }

    public void setContent( String content )
    {
        this.content = content;
    }

    public Date getDate()
    {
        return date;
    }

    public void setDate( Date date )
    {
        this.date = date;
    }

}
