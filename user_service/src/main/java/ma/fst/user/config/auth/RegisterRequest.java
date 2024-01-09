package ma.fst.user.config.auth;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequest implements Serializable {
    private String firstname;
    private String lastname;
    private String email;
    private String password;

    // Volunteer's attributes; they could be null
    private String volunteerSkills;
    private boolean availableForTasks;
}
