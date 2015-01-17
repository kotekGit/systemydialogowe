package pl.edu.wat.swp.dto.xmls;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * 
 * @author Krzysztof Jedynak @email jedynakpoczta@gmail.com
 * @date 17 sty 2015 This class must be use for concatenate address.
 */

@XmlRootElement( name = "addresses" )
@XmlAccessorType( XmlAccessType.FIELD )
public class Address
{

    private String fullAdress;

    public String getFullAdress()
    {
        return fullAdress;
    }

    public void setFullAdress( String fullAdress )
    {
        this.fullAdress = fullAdress;
    }

}
