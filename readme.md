Предметаня область: книга рецептов
Пользователь может иметь список как любимых рецептов, так и любимых продуктов.
Каждый рецепт содержит список продуктов с количеством, время приготовления, сложность и название блюда.


```
User {
    favouriteRecipes: Recipe[]
    favouriteProducts: Product[]
}
```

```
// Рецепт блюда
Recipe {
    name: String,
    difficulty: String,
    preparationTimeMins: Integer
    products: RecipePosition[] (реализуется через многие-ко-многим)
    allergens: Allergens[]
}
```

```
// Элемент рецепта
RecipePosition {
    product: Product
    value: number
}
```

```
// Продукт
Product {
    title: string,
    price: number
    allergents: Allergen[]
}
```

```
Allerget {
    name: String
}
```