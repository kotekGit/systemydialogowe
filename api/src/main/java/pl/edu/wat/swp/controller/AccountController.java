package pl.edu.wat.swp.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import pl.edu.wat.swp.dto.xmls.Login;
import pl.edu.wat.swp.managers.AccountManager;

/**
 * 
 * @author Krzysztof Jedynak @email jedynakpoczta@gmail.com
 * @date 17 sty 2015
 */

@Controller
public class AccountController
{
    private static Logger logger = Logger.getLogger( AccountController.class );

    @Autowired
    AccountManager accountManager;

    @RequestMapping( value = "/login/{id}/{pass}", produces = MediaType.APPLICATION_XML_VALUE )
    @ResponseBody
    public Login checkCredentials( @PathVariable( "id" ) Integer id, @PathVariable( "pass" ) String pass )
    {
        logger.debug( "Check credential for userId = " + id + " and users password." );
        return accountManager.isAccess( id, pass );

    }
}