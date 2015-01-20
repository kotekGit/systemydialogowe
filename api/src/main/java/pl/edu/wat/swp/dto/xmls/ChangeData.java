package pl.edu.wat.swp.dto.xmls;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement( name = "changedata" )
@XmlAccessorType( XmlAccessType.FIELD )
public class ChangeData
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
