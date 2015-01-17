package pl.edu.wat.swp.dto.xmls;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * 
 * @author Krzysztof Jedynak @email jedynakpoczta@gmail.com
 * @date 17 sty 2015 This element must be use for information about offer.
 */

@XmlRootElement( name = "offers" )
@XmlAccessorType( XmlAccessType.FIELD )
public class Offer
{
    private String nameAndContents;

    public String getNameAndContents()
    {
        return nameAndContents;
    }

    public void setNameAndContents( String nameAndContents )
    {
        this.nameAndContents = nameAndContents;
    }

}
