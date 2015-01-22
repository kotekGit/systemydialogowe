package pl.edu.wat.swp.managers;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;

import pl.edu.wat.swp.dto.SubAccountDTO;
import pl.edu.wat.swp.dto.TransactionDTO;
import pl.edu.wat.swp.dto.TransactionTypeDTO;
import pl.edu.wat.swp.dto.UserDTO;
import pl.edu.wat.swp.dto.xmls.Account;
import pl.edu.wat.swp.dto.xmls.ChangeData;
import pl.edu.wat.swp.dto.xmls.Login;
import pl.edu.wat.swp.dto.xmls.Transaction;
import pl.edu.wat.swp.helpers.CommonVariables;
import pl.edu.wat.swp.model.Adres;
import pl.edu.wat.swp.model.Klient;
import pl.edu.wat.swp.model.Kontobankowe;
import pl.edu.wat.swp.model.Operacjabankowa;
import pl.edu.wat.swp.model.Rodzajoperacji;
import pl.edu.wat.swp.model.Subkonto;
import pl.edu.wat.swp.repository.jpa.impl.TransactionsRepository;
import pl.edu.wat.swp.repository.jpa.service.AdresRepository;
import pl.edu.wat.swp.repository.jpa.service.KlientRepository;
import pl.edu.wat.swp.repository.jpa.service.RodzajOperacjiRepository;
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

    @Autowired
    RodzajOperacjiRepository rodzajOperacjiRepository;

    @Autowired
    AdresRepository adresRepository;

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
     * @param interval2
     * @return
     */
    public Transaction getTransactionsForCriteria( Integer id, String type, String category, String interval )
    {
        Transaction transaction = new Transaction();

        Klient klient = null;

        try
        {
            klient = klientRepository.findBynik( id );
        }
        catch ( NullPointerException npe )
        {
            logger.debug( "User not found!" );
        }

        List<Operacjabankowa> transactions = transactionsRepository.getTransactionsByCriteria( klient, type, category,
                interval );
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
        SimpleDateFormat sdf = new SimpleDateFormat( CommonVariables.DATE_WITHOUT_TIME_FORMAT );

        for ( Operacjabankowa ob : transactions )
        {
            StringBuilder currentTrans = new StringBuilder();
            currentTrans.append( CommonVariables.TRANSACTION_DELIMITER );
            currentTrans.append( CommonVariables.TRANSACTION_DATE );

            if ( ob.getDataOB() != null )
            {
                currentTrans.append( sdf.format( ob.getDataOB() ) + CommonVariables.TRANSACTION_ELEMENT_DELIMITER );
            }
            currentTrans.append( CommonVariables.TRANSACTION_DESCRIBE );
            if ( ob.getOpis() != null )
            {
                currentTrans.append( ob.getOpis() );
            }

            describeTrans.append( currentTrans );
        }

        if ( transactions.size() > 0 )
        {
            transaction.setInfo( describeTrans.toString() );
        }
        else
        {
            transaction.setInfo( CommonVariables.NOT_FOUND_MESSAGE );
        }

        return transaction;
    }

    public List<Rodzajoperacji> getTransactionTypes()
    {
        List<Rodzajoperacji> all = rodzajOperacjiRepository.findAll();
        List<Rodzajoperacji> distinct = new ArrayList<Rodzajoperacji>();
        distinct.add( all.get( 0 ) );
        for ( Rodzajoperacji a : all )
        {
            for ( Rodzajoperacji d : distinct )
            {
                if ( d.getNazwaRO() != a.getNazwaRO() )
                {
                    distinct.add( a );
                    break;
                }
            }
        }
        return distinct;
    }

    /**
     * Change customer address data.
     * 
     * @param id
     * @param place
     * @param district
     * @param street
     * @return
     */
    public ChangeData changeCustomerData( Integer id, String place, String district, String street )
    {
        ChangeData changeData = new ChangeData();
        changeData.setStatus( true );
        Klient klient = null;

        try
        {
            klient = klientRepository.findBynik( id );
        }
        catch ( NullPointerException npe )
        {
            logger.debug( "User not found!" );
            changeData.setStatus( false );
            return changeData;
        }

        if ( klient != null && klient.getIdAdresu() != null )
        {
            Adres adres = klient.getIdAdresu();
            adres.setMiejscowosc( place );
            adres.setDzielnica( district );
            adres.setUlica( street );
            adresRepository.save( adres );
            changeData.setStatus( true );
            return changeData;
        }
        else
        {
            logger.debug( "User don't have address" );
            changeData.setStatus( false );
            return changeData;
        }

    }

    /**
     * Get data for all users.
     * 
     * @return
     */
    public List<UserDTO> getAllUsersData()
    {
        List<Klient> allUsers = klientRepository.findAll();
        List<UserDTO> allUsersDTOs = new ArrayList<UserDTO>();
        for ( Klient klient : allUsers )
        {
            Adres userAddress = klient.getIdAdresu();
            UserDTO userDTO = new UserDTO( klient, userAddress );
            allUsersDTOs.add( userDTO );

        }
        return allUsersDTOs;
    }

    /**
     * Get data for all subaccounts.
     * 
     * @return
     */
    public List<SubAccountDTO> getAllSubAccountsData()
    {
        List<Klient> allUsers = klientRepository.findAll();
        List<SubAccountDTO> allSubAccountDTOs = new ArrayList<SubAccountDTO>();
        for ( Klient klient : allUsers )
        {
            for ( Kontobankowe kontobankowe : klient.getKontobankoweCollection() )
            {
                for ( Subkonto subkonto : kontobankowe.getSubkontoCollection() )
                {
                    SubAccountDTO subAccountDTO = new SubAccountDTO( klient, subkonto );
                    allSubAccountDTOs.add( subAccountDTO );
                }
            }

        }
        return allSubAccountDTOs;
    }

    /**
     * Get transaction entity by criteria.
     * 
     * @param id
     * @param type
     * @param category
     * @param interval
     * @return
     */
    public List<TransactionDTO> getTransactionsEntityForCriteria( Integer id, String type, String category,
            String interval )
    {

        List<TransactionDTO> transactionResult = new ArrayList<TransactionDTO>();
        Klient klient = null;

        try
        {
            klient = klientRepository.findBynik( id );
        }
        catch ( NullPointerException npe )
        {
            logger.debug( "User not found!" );
        }

        String typeTransaction = this.getTransactionTypeForKey( type );
        String intervalTransaction = this.getTransactionTypeForKey( type );
        List<Operacjabankowa> transactions = transactionsRepository.getTransactionsByCriteria( klient, typeTransaction,
                category, intervalTransaction );

        for ( Operacjabankowa ob : transactions )
        {
            TransactionDTO transactionDTO = new TransactionDTO( ob );
            transactionResult.add( transactionDTO );
        }
        return transactionResult;
    }

    /**
     * Get all transaction types.
     * 
     * @return
     */
    public List<TransactionTypeDTO> getAllTransactionType()
    {
        List<TransactionTypeDTO> types = new ArrayList<TransactionTypeDTO>();
        List<Rodzajoperacji> kindOfOperations = rodzajOperacjiRepository.findAll();

        for ( Rodzajoperacji rodzajoperacji : kindOfOperations )
        {
            if ( rodzajoperacji.getNazwaRO() != null )
            {
                TransactionTypeDTO transactionTypeDTO = new TransactionTypeDTO( rodzajoperacji.getIdRO(),
                        rodzajoperacji.getNazwaRO() );
                types.add( transactionTypeDTO );
            }
        }

        return types;
    }

    private String getTransactionTypeForKey( String key )
    {
        HashMap<Integer, String> types = new HashMap<Integer, String>();
        List<TransactionTypeDTO> transactionTypes = this.getAllTransactionType();

        for ( TransactionTypeDTO transactionTypeDTO : transactionTypes )
        {
            types.put( transactionTypeDTO.getId(), transactionTypeDTO.getType() );
        }
        return types.get( key );
    }

    private String getIntervalForKey( String key )
    {
        HashMap<Integer, String> intervals = new HashMap<Integer, String>();
        intervals.put( 1, "Year" );
        intervals.put( 2, "Month" );
        intervals.put( 3, "Day" );
        return intervals.get( key );
    }

}
