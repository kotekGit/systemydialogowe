package pl.edu.wat.swp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import pl.edu.wat.swp.helpers.Response;
import pl.edu.wat.swp.model.Klient;
import pl.edu.wat.swp.repository.KlientRepository;

@RestController
public class KlientController {

	@Autowired
	KlientRepository repo;

	@RequestMapping(value="/checkCredentials")
	public Response checkCredentials(@RequestParam("p1") Integer id, @RequestParam("p2") String pass) {
		Klient klient = repo.findOne(id);
		Response r = new Response();
		r.setValue(false);
		r.setMsg("Credentials incorrect!");
		if (klient.getHaslo().equals(pass)) {
			r.setMsg("Credentials correct!");
			r.setValue(true);
		}
		return r;
	}
	
}
