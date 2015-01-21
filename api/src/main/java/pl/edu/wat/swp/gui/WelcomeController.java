package pl.edu.wat.swp.gui;

import java.util.Date;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Simple controler which use jsp file.
 * 
 * @author Krzysztof Jedynak @email jedynakpoczta@gmail.com
 * @date 21 sty 2015
 */
@Controller
public class WelcomeController
{

    private String message = "Hello World";

    @RequestMapping( "/welcome" )
    public String welcome( Map<String, Object> model )
    {
        model.put( "time", new Date() );
        model.put( "message", this.message );
        return "welcome";
    }

    @RequestMapping( "/foo" )
    public String foo( Map<String, Object> model )
    {
        throw new RuntimeException( "Foo" );
    }

}
