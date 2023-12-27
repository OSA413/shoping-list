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
import osa413.recipes.entity.User;
import osa413.recipes.repository.AllergenRepository;
import osa413.recipes.repository.ProductRepository;
import osa413.recipes.repository.RecipeRepository;
import osa413.recipes.repository.UserRepository;

import java.util.Optional;

@Slf4j
@RestController
@RequestMapping("users/")
@RequiredArgsConstructor
public class UserController {

    private final UserRepository repo;
    private final AllergenRepository allergenRepo;
    private final ProductRepository productRepo;
    private final RecipeRepository recipeRepo;

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

    @PostMapping("{id}/allergens")
    public String addAllergen(
            @PathVariable Long id,
            @Valid @RequestBody AppendDTO request,
            BindingResult result
    ) {
        if (result.hasErrors()) return result.getAllErrors().toString();
        var allergen = allergenRepo.findById(request.id).get();
        var user = repo.findById(id).get();
        user.allergens.add(allergen);
        repo.save(user);
        return "OK";
    }

    @DeleteMapping("{id}/allergens/{allergenId}")
    public String removeAllergen(
            @PathVariable("id") Long id,
            @PathVariable("allergenId") Long allergenId
    ) {
        var user = repo.findById(id).get();
        user.allergens.remove(user.allergens.stream().filter(x -> x.id == allergenId).findFirst().get());
        repo.save(user);
        return "OK";
    }

    @PostMapping("{id}/products")
    public String addProduct(
            @PathVariable Long id,
            @Valid @RequestBody AppendDTO request,
            BindingResult result
    ) {
        if (result.hasErrors()) return result.getAllErrors().toString();
        var product = productRepo.findById(request.id).get();
        var user = repo.findById(id).get();
        user.favoriteProduct.add(product);
        repo.save(user);
        return "OK";
    }

    @DeleteMapping("{id}/products/{productId}")
    public String removeProduct(
            @PathVariable("id") Long id,
            @PathVariable("productId") Long prodictId
    ) {
        var user = repo.findById(id).get();
        user.favoriteProduct.remove(user.favoriteProduct.stream().filter(x -> x.id == prodictId).findFirst().get());
        repo.save(user);
        return "OK";
    }

    @PostMapping("{id}/recipes")
    public String addRecipe(
            @PathVariable Long id,
            @Valid @RequestBody AppendDTO request,
            BindingResult result
    ) {
        if (result.hasErrors()) return result.getAllErrors().toString();
        var recipe = recipeRepo.findById(request.id).get();
        var user = repo.findById(id).get();
        user.favoriteRecipes.add(recipe);
        repo.save(user);
        return "OK";
    }

    @DeleteMapping("{id}/recipes/{recipesId}")
    public String removeRecipe(
            @PathVariable("id") Long id,
            @PathVariable("recipesId") Long recipeId
    ) {
        var user = repo.findById(id).get();
        user.favoriteRecipes.remove(user.favoriteRecipes.stream().filter(x -> x.id == recipeId).findFirst().get());
        repo.save(user);
        return "OK";
    }
}
