package pl.edu.wat.swp.repository;

import org.springframework.data.repository.CrudRepository;

import pl.edu.wat.swp.entity.TestEntity;

public interface TestRepository extends CrudRepository<TestEntity, Long>{

}
