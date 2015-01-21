package pl.edu.wat.swp.repository.jpa.impl;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import pl.edu.wat.swp.model.Oferta;
import pl.edu.wat.swp.repository.jpa.service.OfertaRepository;

/**
 * 
 * @author Krzysztof Jedynak @email jedynakpoczta@gmail.com
 * @date 18 sty 2015
 */

@Repository
@Transactional( readOnly = true )
public class OfferRepositoryImpl
{
    @PersistenceContext
    private EntityManager em;

    @Autowired
    OfertaRepository ofertaRepository;

    @Transactional( readOnly = false )
    public void save( Oferta oferta )
    {
        ofertaRepository.save( oferta );
    }

    @SuppressWarnings( { "rawtypes", "unchecked" } )
    public List<Oferta> findCurrentOfferWithoutDuplicate( Date currentDate )
    {

        TypedQuery query = em.createQuery( "select o from Oferta o where o.dataOd < ?1 and o.dataDo > ?1", Oferta.class );
        query.setParameter( 1, currentDate );
        return query.getResultList();
    }

    public List<Oferta> findAll()
    {
        return ofertaRepository.findAll();
    }

}
