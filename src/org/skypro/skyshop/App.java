package org.skypro.skyshop;

import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.basket.ProductBasket;

public class App {
    public static void main(String[] args) {
        ProductBasket basket = new ProductBasket();

        // 1. Добавление продуктов
        basket.addProduct(new Product("Яблоко", 50));
        basket.addProduct(new Product("Хлеб", 40));
        basket.addProduct(new Product("Молоко", 80));

        // 2. Заполняем корзину до конца
        basket.addProduct(new Product("Сыр", 120));
        basket.addProduct(new Product("Йогурт", 35));

        // 3. Пытаемся добавить в заполненную корзину
        basket.addProduct(new Product("Сок", 70)); // Должно вывести: Невозможно добавить продукт

        // 4. Печать содержимого
        System.out.println("=== Содержимое корзины ===");
        basket.printBasket();

        // 5. Стоимость корзины
        System.out.println("Стоимость корзины: " + basket.getTotalPrice());

        // 6. Поиск товара, который есть
        System.out.println("Есть 'Молоко': " + basket.containsProduct("Молоко"));

        // 7. Поиск товара, которого нет
        System.out.println("Есть 'Сок': " + basket.containsProduct("Сок"));

        // 8. Очистка корзины
        basket.clearBasket();

        // 9. Печать пустой корзины
        basket.printBasket();

        // 10. Стоимость пустой корзины
        System.out.println("Стоимость пустой корзины: " + basket.getTotalPrice());

        // 11. Поиск в пустой корзине
        System.out.println("Есть 'Молоко': " + basket.containsProduct("Молоко"));
    }
}
