package osa413.recipes.controller;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Positive;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import osa413.recipes.dto.AllergenDTO;
import osa413.recipes.entity.User;
import osa413.recipes.repository.UserRepository;

import java.util.Optional;

@Slf4j
@RestController
@RequestMapping("users/")
@RequiredArgsConstructor
public class UserController {

    private final UserRepository repo;

    @GetMapping
    public String index() {
        var a = repo.findAll();
        return a.toString();
    }

    @PostMapping()
    public String add() {
        repo.save(new User());
        return "OK";
    }

    @GetMapping("{id}")
    public String edit(@PathVariable Long id, Model model) {
        var entity = repo.findById(id);
        return entity.toString();
    }

    @DeleteMapping("{id}")
    public String remove(@Positive @PathVariable Long id) {
        repo.deleteById(id);
        return "OK";
    }
}
