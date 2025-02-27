package net.weg.gestaotransporteapi.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.weg.gestaotransporteapi.model.dto.response.RotaResponseDTO;

@Builder
@Entity
@Table(name = "rota")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Rota {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(cascade = CascadeType.REMOVE)
    private Endereco origem;

    @ManyToOne(cascade = CascadeType.REMOVE)
    private Endereco destino;

    @Column(nullable = false)
    private Double distancia;

    @ManyToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(nullable = false)
    private Motorista motorista;

    public RotaResponseDTO toDTO() {
        return new RotaResponseDTO(
                this.id,
                this.origem.toDTO(),
                this.destino.toDTO(),
                this.distancia,
                this.motorista.toDTO()
        );
    }
}
