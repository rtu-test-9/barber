package barber.entities;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "employee_services")
public class EmployeesServices {

    @EmbeddedId
    private EmployeesServicesID id;

    @ManyToOne
    @MapsId("employeeId")
    private Employee employee;

    @ManyToOne
    @MapsId("serviceId")
    private Service service;

    @ManyToMany(mappedBy = "employeesServices")
    private Set<Order> orders;

    public EmployeesServices(Employee employee, Service service) {
        this.employee = employee;
        this.service = service;
    }

    public EmployeesServices() {

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass())
            return false;

        EmployeesServices that = (EmployeesServices) o;
        return Objects.equals(employee, that.employee) && Objects.equals(service, that.service);
    }

    @Override
    public int hashCode() {
        return Objects.hash(employee, service);
    }
}