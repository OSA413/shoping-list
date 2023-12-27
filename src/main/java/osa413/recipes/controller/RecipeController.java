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
import osa413.recipes.dto.AppendDTO;
import osa413.recipes.dto.RecipeDTO;
import osa413.recipes.dto.RecipePositionDTO;
import osa413.recipes.entity.Recipe;
import osa413.recipes.entity.RecipePosition;
import osa413.recipes.repository.ProductRepository;
import osa413.recipes.repository.RecipePositionRepository;
import osa413.recipes.repository.RecipeRepository;

import java.util.Optional;

@Slf4j
@RestController
@RequestMapping("recipes/")
@RequiredArgsConstructor
public class RecipeController {

    private final RecipeRepository repo;
    private final RecipePositionRepository positionRepo;
    private final ProductRepository productRepo;

    @GetMapping
    public String index() {
        var a = repo.findAll();
        return a.toString();
    }

    @PostMapping()
    public String add(@RequestBody @Valid RecipeDTO request, BindingResult result) {
        if (result.hasErrors()) return result.getAllErrors().toString();
        repo.save(request.toEntity());
        return "OK";
    }

    @GetMapping("{id}")
    public String edit(@PathVariable Long id, Model model) {
        var entity = repo.findById(id);
        return entity.toString();
    }

    @PutMapping("{id}")
    public String edit(@Valid @RequestBody RecipeDTO request, BindingResult result) {
        if (result.hasErrors()) return result.getAllErrors().toString();
        repo.save(request.toEntity());
        return "OK";
    }

    @DeleteMapping("{id}")
    public String remove(@Positive Long id) {
        repo.deleteById(id);
        return "OK";
    }

    @PostMapping("{id}/positions")
    public String addAllergen(
            @PathVariable Long id,
            @Valid @RequestBody RecipePositionDTO request,
            BindingResult result
    ) {
        if (result.hasErrors()) return result.getAllErrors().toString();
        var product = productRepo.findById(request.productId).get();
        var position = positionRepo.save(new RecipePosition(request.amount, product));
        var recipe = repo.findById(id).get();
        recipe.positions.add(position);
        repo.save(recipe);
        return "OK";
    }

    @DeleteMapping("{id}/positions/{positionId}")
    public String removeAllergen(
            @PathVariable("id") Long id,
            @PathVariable("positionId") Long positionId
    ) {
        var recipe = repo.findById(id).get();
        recipe.positions.remove(recipe.positions.stream().filter(x -> x.id == positionId).findFirst().get());
        repo.save(recipe);
        return "OK";
    }
}
