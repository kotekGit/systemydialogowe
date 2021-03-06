package pl.edu.wat.swp.repository.jpa.service;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import pl.edu.wat.swp.model.Klient;
import pl.edu.wat.swp.model.Subkonto;

/**
 * 
 * @author Krzysztof Jedynak @email jedynakpoczta@gmail.com
 * @date 17 sty 2015
 */
public interface SubKontoRepository extends JpaRepository<Subkonto, Serializable>
{

    /**
     * Find klient by nik number.
     * 
     * @param nik
     * @return
     */
    Subkonto findBynrsk( Integer NRSK );
}
