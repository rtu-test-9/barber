package barber.entities;

import javax.persistence.*;

@Entity
@Table(name="orders")
public class Order {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

}
