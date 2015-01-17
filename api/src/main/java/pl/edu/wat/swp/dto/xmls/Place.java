package pl.edu.wat.swp.dto.xmls;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;


/**
 * 
 * @author Krzysztof Jedynak @email jedynakpoczta@gmail.com
 * @date 17 sty 2015 This class must be use for information about places.
 */

@XmlRootElement( name = "place" )
@XmlAccessorType( XmlAccessType.FIELD )
public class Place
{
    private String placeName;

    public String getPlaceName()
    {
        return placeName;
    }

    public void setPlaceName( String placeName )
    {
        this.placeName = placeName;
    }

}
