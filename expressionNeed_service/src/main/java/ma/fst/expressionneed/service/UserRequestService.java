package ma.fst.expressionneed.service;


import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ma.fst.expressionneed.model.UserRequest;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.util.Enumeration;


@Service
@RequiredArgsConstructor
@Slf4j
public class UserRequestService {
    private final RestTemplate restTemplate;

    public UserRequest getByEmail(String email) {
        // Extract headers from the current request
        String token = extractToken(
                // Get the current request attributes
            (ServletRequestAttributes) RequestContextHolder.getRequestAttributes()
        );

        return sendRequest(token, email);
    }


    public UserRequest sendRequest(String token, String email) {
        // creating headers containing the token and send a request to user-service
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setBearerAuth(token);
        HttpEntity<String> requestEntity = new HttpEntity<>(headers);
        log.info("headers: "+requestEntity.getHeaders());

        ResponseEntity<UserRequest> responseEntity = restTemplate.exchange(
                "http://user-service/find?email={email}",
                HttpMethod.GET,
                requestEntity,
                UserRequest.class,
                email);

        return responseEntity.getBody();
    }

    public String extractToken(ServletRequestAttributes requestAttributes) {
        String token = "";
        if (requestAttributes != null) {
            HttpServletRequest request = requestAttributes.getRequest();
            Enumeration<String> headerNames = request.getHeaderNames();
            while (headerNames.hasMoreElements()) {
                String headerName = headerNames.nextElement();
                String headerValue = request.getHeader(headerName);

                if (headerName.equals("authorization")) {
                    if (headerValue.startsWith("Bearer ")) {
                        token = headerValue.substring(7);
                        log.info(token);
                    } else {
                        log.error("Invalid Authorization header format");
                    }
                }
            }
        } else log.error("requestAttributes is null");
        return token;
    }
}
