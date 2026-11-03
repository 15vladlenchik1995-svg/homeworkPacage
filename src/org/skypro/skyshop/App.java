package org.skypro.skyshop;

import org.skypro.skyshop.product.DiscountedProduct;
import org.skypro.skyshop.product.FixPriceProduct;
import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.SimpleProduct;


public class App {
    public static void main(String[] args) {
        ProductBasket basket = new ProductBasket();

        // 1. Добавление продуктов
        basket.addProduct(new SimpleProduct("Яблоко", 50));
        basket.addProduct(new SimpleProduct("Хлеб", 40));
        basket.addProduct(new SimpleProduct("Молоко", 80));

        // 2. Заполняем корзину до конца
        basket.addProduct(new DiscountedProduct("Сыр", 120,20));
        basket.addProduct(new FixPriceProduct("Йогурт"));

        // 3. Пытаемся добавить в заполненную корзину
        basket.addProduct(new SimpleProduct("Сок", 70));

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
