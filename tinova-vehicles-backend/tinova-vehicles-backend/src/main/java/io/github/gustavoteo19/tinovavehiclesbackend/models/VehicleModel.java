package io.github.gustavoteo19.tinovavehiclesbackend.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
//import org.w3c.dom.Text;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "tb_vehicles")
@Table(name = "TB_VEHICLES")
public class VehicleModel implements Serializable {
    private static final long serialVersionUID = 1L;

//    @GeneratedValue(strategy = GenerationType.AUTO)
//    private UUID id;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, length = 70)
    private String veiculo;

    @Column(nullable = false, length = 70)
    private String marca;

    @Column(nullable = false, length = 70)
    private Integer ano;

    @Column(nullable = false, length = 70)
    private String descricao;

    @Column(nullable = false, length = 70)
    private String cor;

    @Column(nullable = false, length = 70)
    private Boolean vendido;

    @Column(nullable = false)
    private LocalDateTime created;

    @Column(nullable = false)
    private LocalDateTime updated;
}
