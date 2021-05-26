package barber.entities;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class EmployeesServicesID implements Serializable {

    @Column(name = "employee_id")
    public Long employeeId;

    @Column(name = "service_id")
    public Long serviceId;

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    public void setServiceId(Long serviceId) {
        this.serviceId = serviceId;
    }

    public Long getEmployeeId() {
        return employeeId;
    }

    public Long getServiceId() {
        return serviceId;
    }

    public EmployeesServicesID() {}

    public EmployeesServicesID(Long employeeId, Long serviceId) {
        this.employeeId = employeeId;
        this.serviceId = serviceId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass())
            return false;

        EmployeesServicesID that = (EmployeesServicesID) o;
        return Objects.equals(employeeId, that.employeeId) && Objects.equals(serviceId, that.serviceId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(employeeId, serviceId);
    }
}