package service;

import model.Exposition;
import org.springframework.stereotype.Service;
import repository.ExpositionRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ExpositionService {

    private final ExpositionRepository expositionRepository;

    public ExpositionService(ExpositionRepository expositionRepository) {
        this.expositionRepository = expositionRepository;
    }

    public List<Exposition> getAllExpositions() {
        return expositionRepository.findAll();
    }

    public Optional<Exposition> getExpositionById(Integer id) {
        return expositionRepository.findById(id);
    }

    public Exposition saveOrUpdateExposition(Exposition exposition) {
        return expositionRepository.save(exposition);
    }

    public void deleteExpositionById(Integer id) {
        expositionRepository.deleteById(id);
    }
}
