package io.github.gustavoteo19.tinovavehiclesbackend.dtos;

//import org.w3c.dom.Text;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class VehicleDTO {
    @NotBlank
    private String veiculo;

    @NotBlank
    private String marca;

    @NotNull
    private Integer ano;

    @NotBlank
    private String descricao;

    @NotBlank
    private String cor;

    private Boolean vendido;
}
