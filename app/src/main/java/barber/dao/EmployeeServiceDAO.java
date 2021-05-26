package barber.dao;

import barber.entities.EmployeesServicesID;
import barber.entities.EmployeesServices;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeServiceDAO extends JpaRepository<EmployeesServices, EmployeesServicesID> {
    //EmployeesServices findByIdEmployeeIdAAndIdServiceId(Long EmployeeId, Long ServiceId);
}
