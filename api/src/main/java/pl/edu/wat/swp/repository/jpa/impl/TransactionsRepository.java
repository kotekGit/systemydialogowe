package pl.edu.wat.swp.repository.jpa.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import pl.edu.wat.swp.model.Klient;
import pl.edu.wat.swp.model.Kontobankowe;
import pl.edu.wat.swp.model.Operacjabankowa;
import pl.edu.wat.swp.model.Subkonto;
import pl.edu.wat.swp.repository.jpa.service.KlientRepository;
import pl.edu.wat.swp.repository.jpa.service.KontoBankoweRepository;
import pl.edu.wat.swp.repository.jpa.service.OperacjaBankowaRepository;
import pl.edu.wat.swp.repository.jpa.service.SubKontoRepository;

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

    @Autowired
    KlientRepository klientRepository;

    @SuppressWarnings( { "rawtypes", "unchecked" } )
    public List<Integer> getTransactionsIdByCriteria( String type, String category, String interval )
    {

        //System.out.println( "1: " + type + " 2: " + category );
        StringBuilder query = new StringBuilder();
        query.append( "select ob.idOB from Operacjabankowa ob " );
        query.append( "left join ob.rodzajoperacji r " );
        // query.append( "where ob.rodzajoperacji.nazwaRO = :type " );
        //query.append( "where ob.kategoria = :category " );
        if ( interval.equals( "1" ) )
        {
            query.append( "where year(ob.dataOB) =  year(current_timestamp()) " );
        }
        else if ( interval.equals( "2" ) )
        {
            query.append( "where month(ob.dataOB) = month(current_timestamp()) " );
        }
        else if ( interval.equals( "3" ) )
        {
            query.append( "where day(ob.dataOB) =  day(current_timestamp()) " );
        }

        TypedQuery typeQuery = em.createQuery( query.toString(), Integer.class );
        // typeQuery.setParameter( "type", type.trim() );
        //typeQuery.setParameter( "category", category.trim() );
        List<Integer> results = typeQuery.getResultList();

        //System.out.println( "Size: " + results.size() );
        return results;
    }

    public List<Operacjabankowa> getTransactionsByCriteria( Klient klient, String type, String category, String interval )
    {
        List<Integer> ids = this.getTransactionsIdByCriteria( type, category, interval );
        List<Operacjabankowa> transactions = new ArrayList<Operacjabankowa>();

        // filtered by type
        for ( Integer id : ids )
        {
            Operacjabankowa operacjabankowa = operacjaBankowaRepository.findOne( id );
            
            Klient k = operacjabankowa.getNik();
            
            if (klient.equals(k)) {
                if ( operacjabankowa.getRodzajoperacji() != null && operacjabankowa.getRodzajoperacji().getNazwaRO()!= null
                        && operacjabankowa.getRodzajoperacji().getNazwaRO().equalsIgnoreCase( type )
                        && operacjabankowa.getKategoria().equals(category))
                {
                    transactions.add( operacjabankowa );
                }
            }

        }

        return transactions;

    }

}
