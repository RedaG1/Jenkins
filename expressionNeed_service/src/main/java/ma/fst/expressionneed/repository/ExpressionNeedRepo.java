package ma.fst.expressionneed.repository;

import ma.fst.expressionneed.model.ExpressionNeed;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ExpressionNeedRepo extends JpaRepository<ExpressionNeed, Long> {
    List<ExpressionNeed> findAllByUserEmail(String mail);
}
