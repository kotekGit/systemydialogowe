package pl.edu.wat.swp.dto.xmls;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * 
 * @author Krzysztof Jedynak @email jedynakpoczta@gmail.com
 * @date 17 sty 2015 List for transaction.
 */

@XmlRootElement( name = "transactions" )
@XmlAccessorType( XmlAccessType.FIELD )
public class Transactions
{

    @XmlElement( name = "transaction" )
    private List<Transaction> transactions = null;

    public List<Transaction> getTransactions()
    {
        return transactions;
    }

    public void setTransactions( List<Transaction> transactions )
    {
        this.transactions = transactions;
    }

}
