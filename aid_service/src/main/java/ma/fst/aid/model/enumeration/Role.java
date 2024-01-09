package ma.fst.aid.model.enumeration;


import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static ma.fst.aid.model.enumeration.Permission.*;

@RequiredArgsConstructor
@Getter
public enum Role {
    USER(Collections.emptySet()),
    ADMIN(
            Set.of(
                    ADMIN_READ,
                    ADMIN_WRITE,
                    ADMIN_UPDATE,
                    ADMIN_DELETE,
                    VOLUNTEER_READ,
                    VOLUNTEER_WRITE,
                    VOLUNTEER_UPDATE,
                    VOLUNTEER_DELETE
            )
    ),
    VOLUNTEER(
            Set.of(
                    VOLUNTEER_READ,
                    VOLUNTEER_WRITE,
                    VOLUNTEER_UPDATE,
                    VOLUNTEER_DELETE
            )
    );

    private final Set<Permission> permissions;

    public List<SimpleGrantedAuthority> getAuthorities() {
        List<SimpleGrantedAuthority> authorities = getPermissions()
                .stream()
                .map(permission -> new SimpleGrantedAuthority(permission.getPermission()))
                .collect(Collectors.toList());
        authorities.add(new SimpleGrantedAuthority("ROLE_" + this.name()));
        return authorities;
    }
}
