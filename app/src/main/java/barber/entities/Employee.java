package barber.entities;

import javax.persistence.*;

@Entity
@Table(name="employees")
public class Employee {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
}
