package ma.fst.assistance.service;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ma.fst.assistance.config.JwtService;
import ma.fst.assistance.exception.AssistanceNotFoundException;
import ma.fst.assistance.model.AssistanceRequest;
import ma.fst.assistance.repository.AssistanceRepo;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class AssistanceService {
    private final AssistanceRepo assistanceRepo;
    private final JwtService jwtService;
    private final HttpServletRequest request;

    public AssistanceRequest addAssistance(AssistanceRequest assistanceRequest) {
        final String jwt = request.getHeader("Authorization").substring(7);
        assistanceRequest.setUserEmail(jwtService.extractUsername(jwt));
        assistanceRequest.setDate(LocalDate.now());
        return assistanceRepo.save(assistanceRequest);
    }
    public List<AssistanceRequest> findAssistanceByUserEmail(String email) {
        return assistanceRepo.findByUserEmail(email);
    }

    public AssistanceRequest updateAssistance(AssistanceRequest assistanceRequest) {
        return assistanceRepo.save(assistanceRequest);
    }
    public AssistanceRequest findAssistanceById(Long id) {
        return assistanceRepo.findById(id)
                .orElseThrow(()-> new AssistanceNotFoundException("assistance by id "+id+" not found"));
    }
    public List<AssistanceRequest> findAll() {
        return assistanceRepo.findAll();
    }
    public void deleteAssistance(Long id) {
        assistanceRepo.deleteById(id);
    }
}
