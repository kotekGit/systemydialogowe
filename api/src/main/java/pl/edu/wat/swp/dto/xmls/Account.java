package pl.edu.wat.swp.dto.xmls;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * 
 * @author Krzysztof Jedynak @email jedynakpoczta@gmail.com
 * @date 17 sty 2015 This class must be use for account balance.
 */

@XmlRootElement( name = "account" )
@XmlAccessorType( XmlAccessType.FIELD )
public class Account
{
    private String balance;

    public String getBalance()
    {
        return balance;
    }

    public void setBalance( String balance )
    {
        this.balance = balance;
    }

}
