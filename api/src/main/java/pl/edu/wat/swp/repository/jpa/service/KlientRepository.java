package pl.edu.wat.swp.repository.jpa.service;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import pl.edu.wat.swp.model.Klient;

public interface KlientRepository extends JpaRepository<Klient, Serializable>
{

    /**
     * Find klient by nik number.
     * 
     * @param nik
     * @return
     */
    Klient findBynik( Integer NIK );

}
