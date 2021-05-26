package barber.services;

import barber.dao.OrderDAO;
import barber.entities.Employee;
import barber.entities.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class OrderServiceImpl implements OrderService{

    OrderDAO orderDAO;

    EmployeeService employeeService;

    @Autowired
    public void setEmployeeService(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @Autowired
    public void setOrderDAO(OrderDAO orderDAO) {
        this.orderDAO = orderDAO;
    }

    @Override
    public void createOrder(Order order, Long service_id, Employee master) {
        order.getEmployeesServices().add(employeeService.getServiceById(service_id, master));
        orderDAO.save(order);
    }
}
