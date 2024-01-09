package ma.fst.logistics.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ma.fst.logistics.model.user.enumeration.AidStatus;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AidInformationTemplate {
    private Long id;
    // the type of the aid can be financial, logistical ...
    private String aidType;
    private String description;
    private LocalDate expirationDate;
    private Double availableQuantity;
    private String unit;
    private Double amount;
    private AidStatus status;
}
