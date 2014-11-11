package pl.edu.wat.swp.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pl.edu.wat.swp.entity.TestEntity;
import pl.edu.wat.swp.repository.TestRepository;

@RestController
public class TestController {
	
	@Autowired
	TestRepository repo;
	
	@RequestMapping("/findAll")
    public Iterable<TestEntity> findAll() {
		Iterable<TestEntity> all = repo.findAll();
        return all;
    }
	
	@RequestMapping("/saveTestEntity/{name}")
    public void save(@PathVariable("name") final String name) {
		repo.save(new TestEntity(name));
    }
	
	
	@RequestMapping("/")
    public String welcome(Map<String, Object> model) {
        return "index";
    }
}
