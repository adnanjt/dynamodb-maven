package alvarez.wilfredo.dynamodbmaven.controllers;

import alvarez.wilfredo.dynamodbmaven.models.User;
import alvarez.wilfredo.dynamodbmaven.services.UsersService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;
import java.util.UUID;

@RestController
@AllArgsConstructor
@RequestMapping(path = "/users")
public class UserController {

    private UsersService usersService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<List<User>> getById(@PathVariable UUID id) {
        return ResponseEntity.ok(this.usersService.obtenerPorId(id));
    }

    @PostMapping
    public ResponseEntity<Object> postUser(@RequestBody Map<String, String> usuario) {
        User user = new User();
        user.setId(UUID.randomUUID());
        user.setName(usuario.get("name"));
        this.usersService.guardar(user);
        return ResponseEntity.ok().build();
    }


}
