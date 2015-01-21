package pl.edu.wat.swp.dto;

import java.util.Date;

import pl.edu.wat.swp.model.Oferta;

/**
 * 
 * @author Krzysztof Jedynak @email jedynakpoczta@gmail.com
 * @date 21 sty 2015
 */
public class OfferDTO
{
    private Integer id;
    private String describe;
    private Date dateFrom;
    private Date dateTo;

    public OfferDTO()
    {

    }

    public OfferDTO( Oferta oferta )
    {
        this.id = oferta.getIdOferty();
        this.dateFrom = oferta.getDataOd();
        this.dateTo = oferta.getDataDo();
        this.describe = oferta.getOpis();
    }

    public Integer getId()
    {
        return id;
    }

    public void setId( Integer id )
    {
        this.id = id;
    }

    public String getDescribe()
    {
        return describe;
    }

    public void setDescribe( String describe )
    {
        this.describe = describe;
    }

    public Date getDateFrom()
    {
        return dateFrom;
    }

    public void setDateFrom( Date dateFrom )
    {
        this.dateFrom = dateFrom;
    }

    public Date getDateTo()
    {
        return dateTo;
    }

    public void setDateTo( Date dateTo )
    {
        this.dateTo = dateTo;
    }

}
