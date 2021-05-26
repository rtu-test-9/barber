package barber.services;

import barber.entities.Employee;
import barber.entities.Order;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

public interface OrderService {
    void createOrder(Order order, Long service_id, Employee master);
}
