package barber.dao;

import barber.entities.Employee;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface EmployeeDAO extends CrudRepository<Employee, Long> {
    List<Employee> findAll();
    Employee findByName(String name);
}
