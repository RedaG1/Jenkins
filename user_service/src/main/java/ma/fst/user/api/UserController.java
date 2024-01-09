package ma.fst.user.api;

import lombok.RequiredArgsConstructor;
import ma.fst.user.config.auth.RegisterRequest;
import ma.fst.user.model.Task;
import ma.fst.user.model.User;
import ma.fst.user.model.enumeration.Role;
import ma.fst.user.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PutMapping("/update")
    public ResponseEntity<User> updateUser(@RequestBody RegisterRequest request) {
        return new ResponseEntity<>(userService.update(request), HttpStatus.OK);
    }
    // assign tasks to a specific user by id
    @PostMapping("/assign/task/{id}")
    @PreAuthorize("hasAuthority('admin:write')")
    public ResponseEntity<User> assignTasks(@RequestBody List<Task> tasks, @PathVariable("id") Long id) {
        return new ResponseEntity<>(userService.assignTasks(tasks, id), HttpStatus.OK);
    }
    // get user by id
    @GetMapping("/find/{id}")
    public ResponseEntity<User> findById(@PathVariable Long id) {
        return new ResponseEntity<>(userService.get(id), HttpStatus.OK);
    }

    // search by email
    @GetMapping("/find")
    public ResponseEntity<User> findByEmail(@RequestParam String email) {
        return new ResponseEntity<>(userService.getByEmail(email), HttpStatus.OK);
    }
    // get all users
    @GetMapping("/find/all")
    @PreAuthorize("hasAuthority('admin:read')")
    public ResponseEntity<List<User>> findAll() {
        return new ResponseEntity<>(userService.getAll(), HttpStatus.OK);
    }
    @GetMapping("/find/all/{role}")
    public ResponseEntity<List<User>> findAllByRole(@PathVariable String role) {
        return new ResponseEntity<>(userService.getByRole(Role.valueOf(role.toUpperCase())), HttpStatus.OK);
    }
    @GetMapping("/find/activeregion/{regionId}")
    public ResponseEntity<List<User>> findAllVolunteersByActiveRegion(@PathVariable("regionId") Long activeRegionId) {
        return new ResponseEntity<>(userService.getVolunteersByActiveRegion(activeRegionId), HttpStatus.OK);
    }
    // delete user
    @DeleteMapping("/delete/{id}")
    @PreAuthorize("hasAuthority('admin:delete')")
    public ResponseEntity<?> deleteById(@PathVariable Long id) {
        userService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    // add role to user
    @PostMapping("/add/role/{id}")
    @PreAuthorize("hasAuthority('admin:write')")
    public ResponseEntity<?> addRoleToUser(@PathVariable Long id,@RequestBody Role role) {
        userService.addRoleToUser(id, role);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
