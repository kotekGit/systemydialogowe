package pl.edu.wat.swp.managers;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import pl.edu.wat.swp.dto.xmls.Login;
import pl.edu.wat.swp.model.Klient;
import pl.edu.wat.swp.repository.jpa.KlientRepository;

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

}
