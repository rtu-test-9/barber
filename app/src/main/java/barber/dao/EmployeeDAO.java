package barber.dao;

import barber.entities.Employee;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface EmployeeDAO extends CrudRepository<Employee, Long> {
    List<Employee> findAll();
    Employee findByName(String name);
    Employee findEmployeeById(Long id);
}
