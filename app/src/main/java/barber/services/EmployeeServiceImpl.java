package barber.services;

import barber.dao.EmployeeDAO;
import barber.entities.Employee;
import barber.entities.EmployeesServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {

    EmployeeDAO employeeDAO;

    @Autowired
    public void setEmployeeDAO(EmployeeDAO employeeDAO) {
        this.employeeDAO = employeeDAO;
    }

    @Override
    public List<Employee> getAll() {
        return employeeDAO.findAll();
    }

    @Override
    public Employee getByName(String name) {return employeeDAO.findByName(name);}

    @Override
    public EmployeesServices getServiceById(Long service_id, Employee master) {
        for (EmployeesServices es:master.getServices()) {
            if (es.getService().getId() == service_id) {
                return es;
            }
        }
        return null;
    }

    @Override
    public Employee findById(Long id) {
        return employeeDAO.findEmployeeById(id);
    }
}
