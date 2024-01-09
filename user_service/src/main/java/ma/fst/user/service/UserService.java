package ma.fst.user.service;

import lombok.RequiredArgsConstructor;
import ma.fst.user.config.auth.RegisterRequest;
import ma.fst.user.exception.UserNotFoundException;
import ma.fst.user.model.Task;
import ma.fst.user.model.User;
import ma.fst.user.model.enumeration.Role;
import ma.fst.user.repository.UserRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepo repo;
    private final TaskService taskService;

    public User add(User user) {
        return repo.saveAndFlush(user);
    }
    public User update(RegisterRequest request) {
        User user = User.builder()
                .firstname(request.getFirstname())
                .lastname(request.getLastname())
                .email(request.getEmail())
                .password(request.getPassword())
                .volunteerSkills(request.getVolunteerSkills())
                .availableForTasks(request.isAvailableForTasks())
                .build();
        return repo.saveAndFlush(user);
    }
    public User assignTasks(List<Task> tasks, Long id) {
        taskService.saveAllTasks(tasks);
        User user = get(id);
        user.setAssignTask(tasks);
        return user;
    }
    public void addRoleToUser(Long id, Role role) {
        User user = get(id);
        user.setRole(role);
        repo.save(user);
    }
    public User get(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new UserNotFoundException("User by id "+id+" not found"));
    }
    public User getByEmail(String email) {
        return repo.findUserByEmail(email)
                .orElseThrow(() -> new UserNotFoundException("User by email "+email+" not found"));
    }
    public List<User> getByRole(Role role) {
        return repo.findUserByRole(role);
    }
    public List<User> getVolunteersByActiveRegion(Long activeRegionId) {
        return repo.findUserByRoleAndActiveRegionId(Role.VOLUNTEER, activeRegionId);
    }
    public List<User> getAll() {
        return repo.findAll();
    }
    public void delete(Long id) {
        repo.deleteById(id);
    }
}
