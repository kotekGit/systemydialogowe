package pl.edu.wat.swp.repository.jpa.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import pl.edu.wat.swp.model.Operacjabankowa;
import pl.edu.wat.swp.repository.jpa.service.OperacjaBankowaRepository;

/**
 * 
 * @author Krzysztof Jedynak @email jedynakpoczta@gmail.com
 * @date 18 sty 2015
 */

@Repository
@Transactional( readOnly = true )
public class TransactionsRepository
{
    @PersistenceContext
    private EntityManager em;

    @Autowired
    OperacjaBankowaRepository operacjaBankowaRepository;

    @SuppressWarnings( { "rawtypes", "unchecked" } )
    public List<Integer> getTransactionsIdByCriteria( String type, String category, String interval )
    {

        StringBuilder query = new StringBuilder();
        query.append( "select ob.IdOB from OperacjaBankowa ob " );
        query.append( "left join RodzajOperacji ro " );
        query.append( "on ob.IdRO = ro.IdRO " );
        query.append( "where ro.NazwaRO = ?1 " );
        query.append( "and ob.Kategoria = ?2 " );
        if ( interval.equals( "1" ) )
        {
            query.append( "and year(ob.DataOB) = year(current_timestamp()) " );
        }
        else if ( interval.equals( "2" ) )
        {
            query.append( "and month(ob.DataOB) = month(current_timestamp()) " );
        }
        else if ( interval.equals( "3" ) )
        {
            query.append( "and day(ob.DataOB) =  day(current_timestamp()) " );
        }

        TypedQuery typeQuery = em.createQuery( query.toString(), Operacjabankowa.class );
        typeQuery.setParameter( 1, type );
        typeQuery.setParameter( 2, category );
        return typeQuery.getResultList();
    }

    @SuppressWarnings( { "rawtypes", "unchecked" } )
    public List<Operacjabankowa> getTransactionsByCriteria( String type, String category, String interval )
    {
        List<Integer> ids = this.getTransactionsIdByCriteria( type, category, interval );
        List<Operacjabankowa> transactions = new ArrayList<Operacjabankowa>();

        for ( Integer id : ids )
        {
            Operacjabankowa operacjabankowa = operacjaBankowaRepository.findOne( id );
            transactions.add( operacjabankowa );
        }

        return transactions;

    }

}
