package ma.fst.expressionneed.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ma.fst.expressionneed.model.enumeration.ExpressionNeedStatus;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ExpressionNeed {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String userEmail; // the email will be added automatically by extracting the email from the jwt
    private String description;
    @Enumerated(EnumType.STRING)
    private ExpressionNeedStatus status;
}