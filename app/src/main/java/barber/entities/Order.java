package barber.entities;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="orders")
public class Order {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "email")
    private String email;

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public Order(){}

    @Column(name="time")
    private Date time;

    @ManyToMany
    @JoinTable(
            name="orders_employees_services",
            joinColumns = @JoinColumn(name = "order_id"),
            inverseJoinColumns = {@JoinColumn(name="employee_id"), @JoinColumn(name="service_id")}
    )
    private Set<EmployeesServices> employeesServices = new HashSet<>();

    public void setTime(Date time) {
        this.time = time;
    }

    public Date getTime() {
        return time;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setEmployeesServices(Set<EmployeesServices> employeesServices) {
        this.employeesServices = employeesServices;
    }

    public Set<EmployeesServices> getEmployeesServices() {
        return employeesServices;
    }

    public Long getId() {
        return id;
    }
}
