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
import osa413.recipes.dto.ProductDTO;
import osa413.recipes.entity.Product;
import osa413.recipes.repository.ProductRepository;

import java.util.Optional;

@Slf4j
@Controller
@RequestMapping("products/")
@RequiredArgsConstructor
public class ProductController {

    private final ProductRepository repo;

    @GetMapping
    public String index(Model model, Integer pageNumber) {
        if (pageNumber == null) pageNumber = 0;
        model.addAttribute("list",  repo.findAll(PageRequest.of(pageNumber,10)));
        return "genres";
    }

    @PostMapping()
    public String add(@Valid ProductDTO request, BindingResult result, Model model) {
        if (result.hasErrors()) return "Not OK";
        repo.save(request.toEntity());
        return "OK";
    }

    @GetMapping("{id}")
    public String edit(@PathVariable Long id, Model model) {
        Optional<Product> product = repo.findById(id);
        return "OK";
    }

    @PutMapping
    public String edit(@Valid ProductDTO request, BindingResult result) {
        if (result.hasErrors()) return "Not OK";
        repo.save(request.toEntity());
        return "OK";
    }

    @DeleteMapping
    public String remove(@Positive Long id) {
        repo.deleteById(id);
        return "OK";
    }
}
