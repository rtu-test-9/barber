package barber.services;

import barber.dao.ServiceDAO;
import barber.entities.Service;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

@org.springframework.stereotype.Service
public class ServicesServiceImpl implements ServicesService{
    @Autowired
    private ServiceDAO serviceDAO;

    @Override
    public List<Service> getAll() {
        return serviceDAO.findAll();
    }
}
