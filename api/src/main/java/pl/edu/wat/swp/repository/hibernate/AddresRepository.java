package pl.edu.wat.swp.repository.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import pl.edu.wat.swp.model.Adres;

@Repository
public class AddresRepository
{
/*    @Qualifier("moj")
    @Autowired
    SessionFactory sessionFactory;*/
    
/*    public AddresRepository(EntityManagerFactory factory) {
        if(factory.unwrap(SessionFactory.class) == null){
          throw new NullPointerException("factory is not a hibernate factory");
        }
        this.sessionFactory = factory.unwrap(SessionFactory.class);
      }*/
    
    public AddresRepository()
    {
        
    }
    
/*    @Transactional(readOnly = false)
    public void save(Adres adres)
    {
        Session session = sessionFactory.getCurrentSession();
        session.save( adres );
        
    }*/

}
