package pl.edu.wat.swp.dto.xmls;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


/**
 * 
 * @author Krzysztof Jedynak @email jedynakpoczta@gmail.com
 * @date 17 sty 2015 This element must be use for login. Return true or false.
 */

@XmlRootElement( name = "login" )
@XmlAccessorType( XmlAccessType.FIELD )
public class Login
{
    @XmlElement
    private Boolean status;

    public Boolean getStatus()
    {
        return status;
    }

    public void setStatus( Boolean status )
    {
        this.status = status;
    }

}
