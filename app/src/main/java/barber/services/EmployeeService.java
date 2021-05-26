package barber.services;

import barber.entities.Employee;
import barber.entities.EmployeesServices;
import barber.entities.Service;

import java.util.List;

public interface EmployeeService {
    List<Employee> getAll();
    Employee getByName(String name);
    EmployeesServices getServiceById(Long service_id, Employee master);
    Employee findById(Long id);
}
