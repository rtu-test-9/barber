package barber.entities;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="orders")
public class Order {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="is_active")
    private boolean is_active;

    @ManyToMany
    @JoinTable(
            name="orders_employees_services",
            joinColumns = @JoinColumn(name = "order_id"),
            inverseJoinColumns = {@JoinColumn(name="employee_id"), @JoinColumn(name="service_id")}
    )
    private Set<EmployeesServices> employeesServices;
}
