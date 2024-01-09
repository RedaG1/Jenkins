package ma.fst.assistance.repository;

import ma.fst.assistance.model.AssistanceRequest;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AssistanceRepo extends JpaRepository<AssistanceRequest, Long> {
    List<AssistanceRequest> findByUserEmail(String email);
}
