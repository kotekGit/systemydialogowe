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

        //System.out.println( "1: " + type + " 2: " + category );
        StringBuilder query = new StringBuilder();
        query.append( "select ob.idOB from Operacjabankowa ob " );
        query.append( "left join ob.rodzajoperacji r " );
        // query.append( "where ob.rodzajoperacji.nazwaRO = :type " );
        query.append( "where ob.kategoria = :category " );
        if ( interval.equals( "1" ) )
        {
            query.append( "and year(ob.dataOB) =  year(current_timestamp()) " );
        }
        else if ( interval.equals( "2" ) )
        {
            query.append( "and month(ob.dataOB) = month(current_timestamp()) " );
        }
        else if ( interval.equals( "3" ) )
        {
            query.append( "and day(ob.dataOB) =  day(current_timestamp()) " );
        }

        TypedQuery typeQuery = em.createQuery( query.toString(), Integer.class );
        // typeQuery.setParameter( "type", type.trim() );
        typeQuery.setParameter( "category", category.trim() );
        List<Integer> results = typeQuery.getResultList();

        //System.out.println( "Size: " + results.size() );
        return results;
    }

    @SuppressWarnings( { "rawtypes", "unchecked" } )
    public List<Operacjabankowa> getTransactionsByCriteria( String type, String category, String interval )
    {
        List<Integer> ids = this.getTransactionsIdByCriteria( type, category, interval );
        List<Operacjabankowa> transactions = new ArrayList<Operacjabankowa>();

        // filtred by type
        for ( Integer id : ids )
        {
            Operacjabankowa operacjabankowa = operacjaBankowaRepository.findOne( id );
            if ( operacjabankowa.getKategoria().equalsIgnoreCase( category ) )
            {
                transactions.add( operacjabankowa );
            }

        }

        return transactions;

    }

}
