package pl.edu.wat.swp.dto.xmls;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;


/**
 * 
 * @author Krzysztof Jedynak @email jedynakpoczta@gmail.com
 * @date 17 sty 2015 This element must be use for information about offer.
 */

@XmlRootElement( name = "offer" )
@XmlAccessorType( XmlAccessType.FIELD )
public class Offer
{
    private String offerName;
    private String contents;

    public String getOfferName()
    {
        return offerName;
    }

    public void setOfferName( String offerName )
    {
        this.offerName = offerName;
    }

    public String getContents()
    {
        return contents;
    }

    public void setContents( String contents )
    {
        this.contents = contents;
    }

}
