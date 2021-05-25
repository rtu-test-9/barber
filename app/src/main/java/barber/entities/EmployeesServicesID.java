package barber.entities;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class EmployeesServicesID implements Serializable {

    @Column(name = "employee_id")
    private Long employeeId;

    @Column(name = "service_id")
    private Long serviceId;

    public EmployeesServicesID() {}

    public EmployeesServicesID(Long employeeId, Long serviceId) {
        this.employeeId = employeeId;
        this.serviceId = serviceId;
    }

    //Getters omitted for brevity

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass())
            return false;

        EmployeesServicesID that = (EmployeesServicesID) o;
        return Objects.equals(employeeId, that.serviceId) && Objects.equals(serviceId, that.serviceId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(employeeId, serviceId);
    }
}