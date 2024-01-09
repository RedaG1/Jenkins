package ma.fst.assistance.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ma.fst.assistance.model.enumeration.AssistanceStatus;

import java.time.LocalDate;

@Entity
@Data @NoArgsConstructor
@AllArgsConstructor
public class AssistanceRequest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String userEmail; // the email will be added automatically by extracting the email from the jwt
    private String type; // financial, logistical, etc
    private String description;
    @Enumerated(EnumType.STRING)
    private AssistanceStatus status;
    private LocalDate date;
}
