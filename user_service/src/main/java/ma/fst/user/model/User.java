package ma.fst.user.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ma.fst.user.model.enumeration.Role;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "_user")
public class User implements UserDetails {
    @Id
    @Column(name = "user_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstname;
    private String lastname;
    @Column(unique = true)
    private String email;
    private String password;
    @Enumerated(EnumType.STRING)
    private Role role;

    // Volunteer-specific attributes
    private String volunteerSkills;
    private Long activeRegionId;
    @ManyToMany
    @JoinTable(name = "assigned_tasks",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "assigned_task_id"))
    private List<Task> assignTask;
    private boolean availableForTasks;



    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return role.getAuthorities();
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}







//        +-------------------+
//        |   User            |
//        +-------------------+
//        | - id: String      |
//        | - name: String    |
//        | - email: String   |
//        +-------------------+