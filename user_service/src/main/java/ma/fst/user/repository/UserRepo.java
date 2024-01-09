package ma.fst.user.repository;

import ma.fst.user.model.User;
import ma.fst.user.model.enumeration.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepo extends JpaRepository<User, Long> {
    Optional<User> findUserByEmail(String email);
    List<User> findUserByRole(Role role);
    List<User> findUserByRoleAndActiveRegionId(Role role, Long activeRegion);
}
