package ma.fst.logistics.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class DistributionRoute {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String routeName;
    private LocalDateTime plannedStartTime;
    private LocalDateTime plannedEndTime;
    private String vehicleType;


    @OneToMany(mappedBy = "distributionRoute")
    private List<AidDistribution> aidDistributions;
}