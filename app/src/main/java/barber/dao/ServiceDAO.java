package barber.dao;

import barber.entities.Service;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ServiceDAO extends CrudRepository <Service, Long> {
    List<Service> findAll();
}
