package barber.entities;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "employees_services")
public class EmployeesServices {

    @EmbeddedId
    private EmployeesServicesID id;

    @ManyToOne
    @MapsId("employeeId")
    @JoinColumn(name="employee_id")
    private Employee employee;

    @ManyToOne
    @MapsId("serviceId")
    @JoinColumn(name="service_id")
    private Service service;

    @ManyToMany(mappedBy = "employeesServices")
    private Set<Order> orders = new HashSet<>();

    public EmployeesServices(Employee employee, Service service) {
        this.employee = employee;
        this.service = service;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public void setService(Service service) {
        this.service = service;
    }

    public EmployeesServices() {}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass())
            return false;

        EmployeesServices that = (EmployeesServices) o;
        return Objects.equals(employee, that.employee) && Objects.equals(service, that.service);
    }


    public void setOrders(Set<Order> orders) {
        this.orders = orders;
    }

    public Employee getEmployee() {
        return employee;
    }

    public EmployeesServicesID getId() {
        return id;
    }

    public Service getService() {
        return service;
    }

    public Set<Order> getOrders() {
        return orders;
    }

    public void setId(EmployeesServicesID id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(employee, service);
    }
}