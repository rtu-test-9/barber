package barber.services;

import barber.entities.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> getAll();
    Employee getByName(String name);
}
