package pl.edu.wat.swp.repository.jpa;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import pl.edu.wat.swp.model.Klient;

public interface KlientRepository extends JpaRepository<Klient, Serializable>{

}
