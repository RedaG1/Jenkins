package ma.fst.user.service;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import ma.fst.user.model.Task;
import ma.fst.user.repository.TaskRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TaskService {
    private final TaskRepo taskRepo;

    public Task saveTask(Task task) {
        return taskRepo.saveAndFlush(task);
    }

    public List<Task> saveAllTasks(List<Task> tasks) {
        return taskRepo.saveAllAndFlush(tasks);
    }

    public Task getTaskById(Long id) {
        return taskRepo.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("task by id " + id + " not found"));
    }

    public List<Task> getTasks() {
        return taskRepo.findAll();
    }

    public void deleteTask(Long id) {
        taskRepo.deleteById(id);
    }
}
