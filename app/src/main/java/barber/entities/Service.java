package barber.entities;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name="services")
public class Service {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "price")
    private float price;

    public Service() {}

    @OneToMany(
            mappedBy = "service",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private Set<EmployeesServices> employeesServices = new HashSet<>();

    public void setEmployeesServices(Set<EmployeesServices> employeesServices) {
        this.employeesServices = employeesServices;
    }

    public Set<EmployeesServices> getEmployeesServices() {
        return employeesServices;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public float getPrice() {
        return price;
    }

    public Long getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass())
            return false;

        Service serv = (Service) o; return Objects.equals(id, serv.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
