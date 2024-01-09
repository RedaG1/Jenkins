package ma.fst.expressionneed.model;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import ma.fst.expressionneed.model.enumeration.Role;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class UserRequestDeserializer extends StdDeserializer<UserRequest> {

    public UserRequestDeserializer() {
        this(null);
    }

    public UserRequestDeserializer(Class<?> vc) {
        super(vc);
    }

    @Override
    public UserRequest deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException {
        JsonNode node = jp.getCodec().readTree(jp);

        // Deserialize other fields
        Long id = node.get("id").asLong();
        String firstname = node.get("firstname").asText();
        String lastname = node.get("lastname").asText();
        String email = node.get("email").asText();
        String password = node.get("password").asText();
        String role = node.get("role").asText();
        // you can deserialize here other fields if you want

        // Handle the authorities field
        JsonNode authoritiesNode = node.get("authorities");
        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
        if (authoritiesNode != null && authoritiesNode.isArray()) {
            for (JsonNode authorityNode : authoritiesNode) {
                String authority = authorityNode.get("authority").asText();
                authorities.add(new SimpleGrantedAuthority(authority));
            }
        }


        UserRequest userRequest = new UserRequest();
        userRequest.setId(id);
        userRequest.setFirstname(firstname);
        userRequest.setLastname(lastname);
        userRequest.setEmail(email);
        userRequest.setPassword(password);
        userRequest.setRole(Role.valueOf(role));
        userRequest.setAuthorities(authorities);
        // if you add some other deserialize fields don't forget to set them to userRequest here.
        return userRequest;
    }
}
