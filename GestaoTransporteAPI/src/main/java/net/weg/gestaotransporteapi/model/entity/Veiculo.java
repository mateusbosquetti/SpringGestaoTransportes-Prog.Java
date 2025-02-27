package net.weg.gestaotransporteapi.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.weg.gestaotransporteapi.model.dto.response.VeiculoResponseDTO;

@Builder
@Entity
@Table(name = "veiculo")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Veiculo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String marca;
    @Column(nullable = false)
    private String modelo;
    @Column(nullable = false)
    private String placa;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Motorista motorista;

    public VeiculoResponseDTO toDTO() {
        return new VeiculoResponseDTO(
                this.id,
                this.marca,
                this.modelo,
                this.placa,
                this.motorista.toDTO()
        );
    }
}
