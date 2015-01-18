package pl.edu.wat.swp.controller;

import java.util.ArrayList;
import java.util.Date;
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
import pl.edu.wat.swp.model.Bank;
import pl.edu.wat.swp.model.Bankomat;
import pl.edu.wat.swp.model.Oddzial;
import pl.edu.wat.swp.model.Oferta;
import pl.edu.wat.swp.model.TestEntity;
import pl.edu.wat.swp.repository.TestRepository;
import pl.edu.wat.swp.repository.hibernate.AddresRepository;
import pl.edu.wat.swp.repository.jpa.impl.OfferRepositoryImpl;
import pl.edu.wat.swp.repository.jpa.service.AdresRepository;
import pl.edu.wat.swp.repository.jpa.service.BankRepository;
import pl.edu.wat.swp.repository.jpa.service.BankomatRepository;
import pl.edu.wat.swp.repository.jpa.service.OddzialReposirory;

@Controller
public class TestController
{

    @Autowired
    TestRepository repo;
    
    @Autowired
    AddresRepository addresRepository;
    
    @Autowired
    AdresRepository adresRepository;
    
    @Autowired
    BankomatRepository bankomatRepository;
    
    @Autowired
    OddzialReposirory oddzialReposirory;
    
    @Autowired
    BankRepository bankRepository;
    
    @Autowired
    OfferRepositoryImpl offerRepositoryImpl;
    
/*    @Autowired
    OddzialPKRepository oddzialPKRepository;
*/
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
    
    @ResponseBody
    @RequestMapping( value = "/test4")
    public String testowaMetoda3(  )
    {
        Adres adres = new Adres();
        adres.setMiejscowosc( "Warsaw" );
        adres.setDzielnica( "Bemowo" );
        adres.setUlica( "Nowa" );
        adres.setNrLokalu( "44" );
        adresRepository.save( adres );
        
        Adres adres2 = new Adres();
        adres2.setMiejscowosc( "Wrocław" );
        adres2.setDzielnica( "Odrzańska" );
        adres2.setUlica( "Nowowiejsca" );
        adres2.setNrLokalu( "2" );
        adresRepository.save( adres2 );
        
        Bankomat bankomat = new Bankomat();
        bankomat.setIdAdresu( adres );
        bankomatRepository.save( bankomat );
        
        Bankomat bankomat2 = new Bankomat();
        bankomat2.setIdAdresu( adres );
        bankomatRepository.save( bankomat2 );
        
        Bankomat bankomat3 = new Bankomat();
        bankomat3.setIdAdresu( adres2 );
        bankomatRepository.save( bankomat3 );
        
        return "ok";
    }
    
    @ResponseBody
    @RequestMapping( value = "/test5")
    public String testowaMetoda4(  )
    {
        Bank bank = new Bank();
        bank.setCwb( "1" );
        bankRepository.save( bank );
        

        
        
        Adres adres = new Adres();
        adres.setMiejscowosc( "Warsaw" );
        adres.setDzielnica( "Bemowo" );
        adres.setUlica( "Nowa" );
        adres.setNrLokalu( "44" );
        adresRepository.save( adres );
        
        Adres adres2 = new Adres();
        adres2.setMiejscowosc( "Wrocław" );
        adres2.setDzielnica( "Odrzańska" );
        adres2.setUlica( "Nowowiejsca" );
        adres2.setNrLokalu( "2" );
        adresRepository.save( adres2 );
        
        Adres adres3 = new Adres();
        adres2.setMiejscowosc( "Gdańsk" );
        adres2.setDzielnica( "Wola" );
        adres2.setUlica( "Wiejscka" );
        adres2.setNrLokalu( "22" );
        adresRepository.save( adres3 );
        
        Adres adres4 = new Adres();
        adres4.setMiejscowosc( "Warsaw" );
        adres4.setDzielnica( "Bemowo" );
        adres4.setUlica( "Wolności" );
        adres4.setNrLokalu( "23" );
        adresRepository.save( adres4 );
        
        Oddzial oddzial = new Oddzial();
        oddzial.setNazwaOddzialu( "dasdasd" );
        oddzial.setIdAdresu( adres );
        //oddzial.setBank( bank );
        
/*        OddzialPK oddzialPK = new OddzialPK();
        oddzialPK.setCwb( bank.getCwb() );
        oddzialPKRepository.save( oddzialPK );
        oddzial.setOddzialPK( oddzialPK );*/
        oddzialReposirory.save( oddzial );

        
        Oddzial oddzial1 = new Oddzial();
        oddzial1.setNazwaOddzialu( "dasdasd1" );
        oddzial1.setIdAdresu( adres );
        //oddzial1.setBank( bank );
        oddzialReposirory.save( oddzial1 );
        
/*        OddzialPK oddzialPK2 = new OddzialPK();
        oddzialPK2.setCwb( bank.getCwb() );
        oddzialPKRepository.save( oddzialPK2 );
        oddzial.setOddzialPK( oddzialPK2 );
        oddzialReposirory.save( oddzial1 );*/
        
        Oddzial oddzial2 = new Oddzial();
        oddzial2.setNazwaOddzialu( "dasdasd3" );
        oddzial2.setIdAdresu( adres3 );
        //oddzial2.setBank( bank );
        oddzialReposirory.save( oddzial2 );
        
/*        OddzialPK oddzialPK3 = new OddzialPK();
        oddzialPK3.setCwb( bank.getCwb() );
        oddzialPKRepository.save( oddzialPK3 );
        oddzial2.setOddzialPK( oddzialPK3 );
        oddzialReposirory.save( oddzial2 );*/
        
        Oddzial oddzial3 = new Oddzial();
        oddzial3.setNazwaOddzialu( "dasdasd3" );
        oddzial3.setIdAdresu( adres4 );
        //oddzial3.setBank( bank );
        oddzialReposirory.save( oddzial3 );
        
/*        OddzialPK oddzialPK4 = new OddzialPK();
        oddzialPK4.setCwb( bank.getCwb() );
        oddzialPKRepository.save( oddzialPK4 );
        oddzial3.setOddzialPK( oddzialPK4 );
        oddzialReposirory.save( oddzial3 );*/
        
        return "ok";
    }
    
    public Date addDate(int n)
    {
        return new Date(new Date().getTime() + n * 24 * 3600 * 1000 );
    }
    
    public Date minusDate(int n)
    {
        return new Date(new Date().getTime() - n * 24 * 3600 * 1000 );
    }
    
    @SuppressWarnings( "deprecation" )
    @ResponseBody
    @RequestMapping( value = "/test6")
    public String testowaMetoda5(  )
    {
        Date currentDate = new Date();
        Oferta oferta = new Oferta();
        oferta.setDataOd( minusDate( 1 ) );
        oferta.setDataDo( addDate( 1 ) );
        oferta.setOpis( "To jest opis oferty");
        
        Oferta oferta2 = new Oferta();
        oferta2.setDataOd( minusDate( 3 )   );
        oferta2.setDataDo( addDate( 2 ));
        oferta2.setOpis( "To jest opis oferty 2");
        
        Oferta oferta3 = new Oferta();
        oferta3.setDataOd( minusDate( 20 )  );
        oferta3.setDataDo( minusDate( 10 )  );
        oferta3.setOpis( "Tego nie powinno tutaj być");
        
        offerRepositoryImpl.save( oferta );
        offerRepositoryImpl.save( oferta2 );
        offerRepositoryImpl.save( oferta3 );
        
        List<Oferta> allCurrentOffer = offerRepositoryImpl.findCurrentOfferWithoutDuplicate( currentDate );
        for(Oferta of : allCurrentOffer)
        {
            System.out.println(of.getOpis());
        }
        
        return "OK";
    }
}
