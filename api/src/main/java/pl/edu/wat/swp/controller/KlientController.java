package pl.edu.wat.swp.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pl.edu.wat.swp.helpers.Response;
import pl.edu.wat.swp.model.Adres;
import pl.edu.wat.swp.model.Klient;
import pl.edu.wat.swp.model.Operacjabankowa;
import pl.edu.wat.swp.repository.jpa.KlientRepository;

@RestController
public class KlientController {

	@Autowired
	KlientRepository repo;

	@RequestMapping(value = "/checkCredentials/{id}/{pass}")
	public Response checkCredentials(@PathVariable("id") Integer id, @PathVariable("pass") String pass) {
		Klient klient = null;
		
		Response r = new Response();
		r.setValue(false);
		
		try {
			klient = repo.findOne(id);
		} catch (NullPointerException npe) {
			r.setMsg("User not found!");
			return r;
		}

		r.setMsg("Credentials incorrect!");
		if (klient.getHaslo().equals(pass)) {
			r.setMsg("Credentials correct!");
			r.setValue(true);
		}
		return r;
	}
	
	
	@RequestMapping(value = "/save")
	public void save() {
		Klient k = new Klient();
		k.setIdAdresu(null);
		k.setEmail("dupa");
		k.setHaslo("asdsa");
		k.setImie("asdasd");
		k.setLogin("dupaLogin");
		
//		Adres adres = new Adres();
//		adres.setIdAdresu(123);
//		adres.setKodPocztowy("2434324");
//		adres.setNrBudynku("12");
//		k.setIdAdresu(adres);
		
		repo.save(k);
	}
	
	@RequestMapping(value = "/getAccountBalance/{id}")
	public Integer getAccountBalanceForUser(Integer id) {
		Klient klient = repo.findOne(id);
		
		
		
		Collection<Operacjabankowa> operacje = klient.getOperacjabankowaCollection();
		
		for (Operacjabankowa o : operacje) {
			if (o.getRodzajoperacji().getNazwaRO() == "PRZYPŁYWY") {
				o.getKwotaOB();
			} else {
				
			}
		}
		
		
		return null;
	}
	
}
