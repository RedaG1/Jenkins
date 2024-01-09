package ma.fst.expressionneed.service;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import ma.fst.expressionneed.config.JwtService;
import ma.fst.expressionneed.exception.ExpressionNeedNotFoundException;
import ma.fst.expressionneed.model.ExpressionNeed;
import ma.fst.expressionneed.repository.ExpressionNeedRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ExpressionNeedService {
    private final ExpressionNeedRepo repo;
    private final JwtService jwtService;
    private final HttpServletRequest request;
    public ExpressionNeed add(ExpressionNeed expressionNeed) {
        final String jwt = request.getHeader("Authorization").substring(7);
        expressionNeed.setUserEmail(jwtService.extractUsername(jwt));
        return repo.save(expressionNeed);
    }
    public ExpressionNeed update(ExpressionNeed expressionNeed) {
        return repo.save(expressionNeed);
    }
    public ExpressionNeed get(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new ExpressionNeedNotFoundException("expressionNeed by id "+id+" not found"));
    }
    public List<ExpressionNeed> getAll() {
        return repo.findAll();
    }
    public void delete(Long id) {
        repo.deleteById(id);
    }

    public List<ExpressionNeed> getAllByUserMail(String mail) {
        return repo.findAllByUserEmail(mail);
    }
}
