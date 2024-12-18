package globant.talentodigital.empresatelefonica.restempresatelefonica.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "plans")
@Entity
public class Plan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "plan_name", nullable = false, length = 80)
    private String planName;

    @Column(name = "price", nullable = false)
    private double price;

    @Column(name = "is_active", nullable = false)
    private Boolean isActive;

    @Column(name = "service_provided", nullable = false, length = 200)
    private String serviceProvided;

    @OneToMany(mappedBy = "plan")
    private List<Contract> contracts = new ArrayList<>();
}
