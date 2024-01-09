package ma.fst.aid.service;


import lombok.RequiredArgsConstructor;
import ma.fst.aid.exception.AidNotFoundException;
import ma.fst.aid.model.AidInformation;
import ma.fst.aid.repository.AidRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AidService {
    private final AidRepo repo;
	// TODO: associating aid requests with assistance requests
    public AidInformation add(AidInformation aidInformation) {
        return repo.save(aidInformation);
    }
    public AidInformation update(AidInformation aidInformation) {
        return repo.save(aidInformation);
    }
    public AidInformation get(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new AidNotFoundException("Aid by id "+id+" not found"));
    }
    public List<AidInformation> getAll() {
        return repo.findAll();
    }
    public void delete(Long id) {
        repo.deleteById(id);
    }
}
