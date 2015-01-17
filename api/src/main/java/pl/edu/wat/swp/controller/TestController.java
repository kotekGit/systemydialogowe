package pl.edu.wat.swp.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import pl.edu.wat.swp.dto.xmls.Login;
import pl.edu.wat.swp.dto.xmls.Transaction;
import pl.edu.wat.swp.dto.xmls.Transactions;
import pl.edu.wat.swp.model.Adres;
import pl.edu.wat.swp.model.TestEntity;
import pl.edu.wat.swp.repository.TestRepository;
import pl.edu.wat.swp.repository.hibernate.AddresRepository;
import pl.edu.wat.swp.repository.jpa.AdresRepository;

@Controller
public class TestController
{

    @Autowired
    TestRepository repo;
    
    @Autowired
    AddresRepository addresRepository;
    
    @Autowired
    AdresRepository adresRepository;

    @RequestMapping( "/findAll" )
    public Iterable<TestEntity> findAll()
    {
        Iterable<TestEntity> all = repo.findAll();
        return all;
    }

    @RequestMapping( "/saveTestEntity/{name}" )
    public void save( @PathVariable( "name" ) final String name )
    {
        repo.save( new TestEntity( name ) );
    }

    @RequestMapping( "/" )
    public String welcome( Map<String, Object> model )
    {
        return "index";
    }

    
    @RequestMapping( value = "/tests/{jedynka}", produces = MediaType.APPLICATION_XML_VALUE)
    @ResponseBody
    public Transactions testowaMetoda( @PathVariable( "jedynka" ) String cos )
    {
        
        List<Transaction> others = new ArrayList<Transaction>();
        Transaction one = new Transaction();
        one.setInfo( "dasdasd adasdasd dsasdasd" );
        Transaction two = new Transaction();
        two.setInfo( "dsadad dasdasd dsadasd" );
        others.add( one );
        others.add( two );
        Transactions transactions = new Transactions();
        transactions.setTransactions( others );
        System.out.println(transactions);
        
        Adres a = new Adres();
        a.setIdAdresu( new Integer( 1000 ) );
        a.setKodPocztowy( "dasd" );
        adresRepository.save( a );
        
        return transactions;
    }
    
    @RequestMapping( value = "/test2", produces = MediaType.APPLICATION_XML_VALUE)
    @ResponseBody
    public Login testowaMetoda(  )
    {
        Login login = new Login();
        login.setStatus( true );
        
        return login;
    }
    
    @RequestMapping( value = "/test3")
    public String testowaMetoda2(  )
    {
        Adres adres = new Adres();
        adres.setIdAdresu( new Integer( 23 ) );
        adres.setKodPocztowy( "ddasd" );
        adresRepository.save( adres );
        
        return "ok";
    }
}
