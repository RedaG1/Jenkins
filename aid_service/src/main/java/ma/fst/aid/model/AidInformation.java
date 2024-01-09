package ma.fst.aid.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ma.fst.aid.model.enumeration.AidStatus;

import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AidInformation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    // the type of the aid can be financial, logistical ...
    private String aidType;
    private String description;
    private LocalDate expirationDate;
    private Double availableQuantity;
    private String unit;
    private Double amount;
    @Enumerated(EnumType.STRING)
    private AidStatus status;

}
