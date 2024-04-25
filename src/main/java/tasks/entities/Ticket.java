package tasks.entities;

import jakarta.persistence.*;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "ticket")
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @NotNull
    @JoinColumn(name = "client_id", nullable = false)
    private Client client;

    @ManyToOne
    @NotNull
    @JoinColumn(name = "from_planet_id", nullable = false)
    private Planet fromPlanet;

    @ManyToOne
    @NotNull
    @JoinColumn(name = "to_planet_id", nullable = false)
    private Planet toPlanet;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;



    // Додаткові поля та методи
}