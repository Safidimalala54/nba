package ITU.WebAvance.NBA.Controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ITU.WebAvance.NBA.Models.Action;
import ITU.WebAvance.NBA.Services.ActionService;

@RestController
@RequestMapping("/actions")
public class ActionController {
    @Autowired
    private ActionService actionService;

    @GetMapping
    public List<Action> getAllActions() {
        return actionService.getAllActions();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Action> getActionById(@PathVariable Integer id){
        Optional<Action> match = actionService.getActionById(id);
        return match.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                     .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<Action> createAction(@RequestBody Action match) {
        Action saveAction = actionService.saveOrUpdateAction(match);
        return new ResponseEntity<>(saveAction, HttpStatus.CREATED);
    }
}
