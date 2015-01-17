package pl.edu.wat.swp.dto.xmls;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * 
 * @author Krzysztof Jedynak @email jedynakpoczta@gmail.com
 * @date 17 sty 2015 This class must be use for information about district.
 */

@XmlRootElement( name = "district" )
@XmlAccessorType( XmlAccessType.FIELD )
public class District
{
    private String districtName;

    public String getDistrictName()
    {
        return districtName;
    }

    public void setDistrictName( String districtName )
    {
        this.districtName = districtName;
    }

}
