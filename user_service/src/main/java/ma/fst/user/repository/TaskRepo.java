package ma.fst.user.repository;

import ma.fst.user.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepo extends JpaRepository<Task, Long> {
}
