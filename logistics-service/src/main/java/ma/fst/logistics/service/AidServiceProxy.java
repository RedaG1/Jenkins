package ma.fst.logistics.service;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ma.fst.logistics.model.AidInformationTemplate;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.util.Enumeration;

@Service
@RequiredArgsConstructor
@Slf4j
public class AidServiceProxy {
    private final RestTemplate restTemplate;

    public AidInformationTemplate getAidInformationById(Long id) {
        String token = extractToken(
                (ServletRequestAttributes) RequestContextHolder.getRequestAttributes()
        );

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setBearerAuth(token);
        HttpEntity<?> requestEntity = new HttpEntity<>(headers);
        ResponseEntity<AidInformationTemplate> responseEntity = restTemplate.exchange(
                "http://aid-service/find/{id}",
                HttpMethod.GET,
                requestEntity,
                AidInformationTemplate.class,
                id);
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
                    } else {
                        log.error("Invalid Authorization header format");
                    }
                }
            }
        } else log.error("requestAttributes is null");
        return token;
    }
}
