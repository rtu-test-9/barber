package barber.services;

import barber.dao.EmployeeDAO;
import barber.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    EmployeeDAO employeeDAO;

    @Override
    public List<Employee> getAll() {
        return employeeDAO.findAll();
    }

    @Override
    public Employee getByName(String name) {return employeeDAO.findByName(name);}
}
