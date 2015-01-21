package pl.edu.wat.swp;

import java.util.Arrays;

import org.apache.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.embedded.FilterRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
@EnableAutoConfiguration
/*@EnableWebMvc*/
public class Application
{

    private static Logger logger = Logger.getLogger( Application.class );
    
    public static void main( String[] args )
    {
        ApplicationContext ctx = SpringApplication.run( Application.class, args );

        // sprawdzam dostępną listę beanów w Spring Boot dla tej konfiguracji
        if ( logger.isDebugEnabled() )
        {
            logger.debug( "Let's inspect the beans provided by Spring Boot" );

            String[] beanNames = ctx.getBeanDefinitionNames();
            Arrays.sort( beanNames );

            for ( String beanName : beanNames )
            {
                logger.debug( beanName );
            }
        }
    }
    
    @Bean
    public FilterRegistrationBean siteMeshFilter() {
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
        filterRegistrationBean.setFilter(new MySiteMeshFilter());
        return filterRegistrationBean;
    }

}
