package barber.entities;

import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name="employees")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public Employee(){}

    @ElementCollection
    private List<Date> availableDates;

    @Column(name = "name")
    private String name;

    @Column(name = "avatar")
    private String avatar;

    @OneToMany(
            mappedBy = "employee",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private Set<EmployeesServices> employeesServices = new HashSet<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAvatar() {
        return avatar;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setServices(Set<EmployeesServices> services) {
        this.employeesServices = services;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public Set<EmployeesServices> getServices() {
        return employeesServices;
    }

    public void setEmployeesServices(Set<EmployeesServices> employeesServices) {
        this.employeesServices = employeesServices;
    }

    public void setAvailableDates(List<Date> availableDates) {
        this.availableDates = availableDates;
    }

    public List<Date> getAvailableDates() {
        return availableDates;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee emp = (Employee) o; return Objects.equals(id, emp.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}
