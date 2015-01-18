package pl.edu.wat.swp.managers;

import java.math.BigDecimal;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import pl.edu.wat.swp.dto.xmls.Account;
import pl.edu.wat.swp.dto.xmls.Login;
import pl.edu.wat.swp.dto.xmls.Transaction;
import pl.edu.wat.swp.helpers.CommonVariables;
import pl.edu.wat.swp.model.Klient;
import pl.edu.wat.swp.model.Operacjabankowa;
import pl.edu.wat.swp.model.Subkonto;
import pl.edu.wat.swp.repository.jpa.impl.TransactionsRepository;
import pl.edu.wat.swp.repository.jpa.service.KlientRepository;
import pl.edu.wat.swp.repository.jpa.service.SubKontoRepository;

/**
 * 
 * @author Krzysztof Jedynak @email jedynakpoczta@gmail.com
 * @date 17 sty 2015
 */

@Component
public class AccountManager
{

    private static Logger logger = Logger.getLogger( AccountManager.class );

    @Autowired
    KlientRepository klientRepository;

    @Autowired
    SubKontoRepository subKontoRepository;

    @Autowired
    TransactionsRepository transactionsRepository;

    public Login isAccess( Integer userId, String usserPassword )
    {
        Klient klient = null;
        Login login = new Login();
        login.setStatus( false );

        try
        {
            klient = klientRepository.findBynik( userId );
        }
        catch ( NullPointerException npe )
        {
            logger.debug( "User not found!" );
            login.setStatus( false );
            return login;
        }

        if ( klient != null && klient.getHaslo().equals( usserPassword ) )
        {
            logger.debug( "Credenetial corret for userId = " + userId );
            login.setStatus( true );
        }
        return login;
    }

    /**
     * Get balance for subkonto nrsk.
     * 
     * @param subKontoId
     * @return
     */
    public Account getBalanceForSubKontoId( Integer subKontoId )
    {
        Subkonto subkonto = new Subkonto();
        Account account = new Account();

        try
        {
            subkonto = subKontoRepository.findBynrsk( subKontoId );
        }
        catch ( NullPointerException npe )
        {
            logger.debug( "SubKonto not found!" );
            return account;
        }

        if ( subkonto != null )
        {
            BigDecimal saldo = null;
            if ( subkonto.getStanKonta() != null )
            {
                saldo = subkonto.getStanKonta();
                account.setBalance( saldo.toString() + CommonVariables.DOLLAR );
            }

        }

        return account;

    }

    /**
     * Get all transactions by criteria.
     * 
     * @param type
     * @param food
     * @param interval
     * @return
     */
    public Transaction getTransactionsForCriteria( String type, String category, String interval )
    {
        Transaction transaction = new Transaction();
        List<Operacjabankowa> transactions = transactionsRepository.getTransactionsByCriteria( type, category, interval );
        transaction = this.makeXMLForEntities( transactions );
        return transaction;
    }

    /**
     * Make transaction xml for entities.
     * 
     * @param transactions
     * @return
     */
    public Transaction makeXMLForEntities( List<Operacjabankowa> transactions )
    {
        Transaction transaction = new Transaction();
        StringBuilder describeTrans = new StringBuilder();

        for ( Operacjabankowa ob : transactions )
        {
            StringBuilder currentTrans = new StringBuilder();
            currentTrans.append( CommonVariables.TRANSACTION_DELIMITER );
            currentTrans.append( CommonVariables.TRANSACTION_DATE );

            if ( ob.getDataOB() != null )
            {
                currentTrans.append( ob.getDataOB() + CommonVariables.TRANSACTION_DATE );
            }
            currentTrans.append( CommonVariables.TRANSACTION_ELEMENT_DELIMITER );
            if ( ob.getOpis() != null )
            {
                currentTrans.append( ob.getOpis() + CommonVariables.ADDRESS_ELEMENT_DELIMITER );
            }

            describeTrans.append( currentTrans );
        }

        transaction.setInfo( describeTrans.toString() );
        return transaction;
    }
}
