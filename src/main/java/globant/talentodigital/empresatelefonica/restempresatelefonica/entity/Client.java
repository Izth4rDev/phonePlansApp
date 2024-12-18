package globant.talentodigital.empresatelefonica.restempresatelefonica.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "clients")
@Entity
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name" , nullable = false, length = 50)
    private String name;

    @Column(name = "rut", nullable = false, length = 10)
    private String rut;

    @Column(name = "address", nullable = false, length = 60)
    private String address;

    @Column(name = "is_active", nullable = false)
    private Boolean isActive;

    @Column(name = "birth_date",nullable = false)
    private LocalDate birthDate;

    //obtener los contratos asociados al cliente
    @OneToMany(mappedBy = "client")
    private List<Contract> contracts = new ArrayList<>();
}
