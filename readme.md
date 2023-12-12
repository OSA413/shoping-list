Предметаня область: список покупок
Есть продукты, есть список покупок, есть поход в магаин
Поход в магазин содержит один список покупок, список покупок содержит несколько продуктов.

```
Purchase {
    shoppingList: ShoppingList
}
```

```
ShoppingList {
    products: ProductShoppingPosition[] (реализуется через многие-ко-многим)
}
```

```
ProductShoppingPosition {
    product: Product
    value: number
}
```

```
Product {
    title: string,
    price: number,
    
}
```