package ma.fst.aid.model.enumeration;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum Permission {

    ADMIN_READ("admin:read"),
    ADMIN_UPDATE("admin:update"),
    ADMIN_WRITE("admin:write"),
    ADMIN_DELETE("admin:delete"),

    VOLUNTEER_READ("volunteer:read"),
    VOLUNTEER_UPDATE("volunteer:update"),
    VOLUNTEER_WRITE("volunteer:write"),
    VOLUNTEER_DELETE("volunteer:delete"),
    ;
    private final String permission;
}



