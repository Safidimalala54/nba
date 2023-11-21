package ITU.WebAvance.NBA.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ITU.WebAvance.NBA.Models.Action;
import ITU.WebAvance.NBA.Repository.ActionRepository;

@Service
public class ActionService {
    private final ActionRepository actionRepository;

    @Autowired
    public ActionService(ActionRepository actionRepository){
        this.actionRepository = actionRepository;
    }

    public List<Action> getAllActions() {
        return actionRepository.findAll();
    }

    public Optional<Action> getActionById(Integer id) {
        return actionRepository.findById(id);
    }

    public Action saveOrUpdateAction(Action Action) {
        return actionRepository.save(Action);
    }

    public void deleteAction(Integer id) {
        actionRepository.deleteById(id);
    }
}
