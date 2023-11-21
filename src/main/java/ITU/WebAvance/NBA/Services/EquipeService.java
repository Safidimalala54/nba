package ITU.WebAvance.NBA.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ITU.WebAvance.NBA.Models.Equipe;
import ITU.WebAvance.NBA.Repository.EquipeRepository;

import java.util.List;
import java.util.Optional;

@Service
public class EquipeService {
    private final EquipeRepository equipeRepository;

    @Autowired
    public EquipeService(EquipeRepository equipeRepository) {
        this.equipeRepository = equipeRepository;
    }

    public List<Equipe> getAllEquipes() {
        return equipeRepository.findAll();
    }

    public Optional<Equipe> getEquipeById(Long id) {
        return equipeRepository.findById(id);
    }

    public Equipe saveOrUpdateEquipe(Equipe equipe) {
        return equipeRepository.save(equipe);
    }

    public void deleteEquipe(Long id) {
        equipeRepository.deleteById(id);
    }
}
