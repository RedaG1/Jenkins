package ma.fst.logistics.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class AidDistribution {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime distributionTime;
    private int quantity;
    private String distributionStatus;
    private String distributionLocation;

    @ManyToOne
    @JoinColumn(name = "distribution_route_id")
    private DistributionRoute distributionRoute;
}