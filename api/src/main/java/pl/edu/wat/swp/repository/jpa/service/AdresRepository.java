package pl.edu.wat.swp.repository.jpa.service;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import pl.edu.wat.swp.model.Adres;

/**
 * 
 * @author Krzysztof Jedynak @email jedynakpoczta@gmail.com
 * @date 17 sty 2015
 */
public interface AdresRepository extends JpaRepository<Adres, Serializable>
{

}
