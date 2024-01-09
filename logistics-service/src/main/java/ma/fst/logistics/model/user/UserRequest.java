package ma.fst.logistics.model.user;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ma.fst.logistics.model.user.enumeration.Role;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@JsonDeserialize(using = UserRequestDeserializer.class)
public class UserRequest implements UserDetails {
    private Long id;
    private String firstname;
    private String lastname;
    private String email;
    private String password;
    @Enumerated(EnumType.STRING)
    private Role role;


    private List<SimpleGrantedAuthority> authorities;


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
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
        return true; // You can implement this based on your business logic
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true; // You can implement this based on your business logic
    }

    @Override
    public boolean isEnabled() {
        return true; // You can implement this based on your business logic
    }
}
