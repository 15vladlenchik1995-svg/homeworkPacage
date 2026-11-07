package org.skypro.skyshop;

import org.skypro.skyshop.article.Article;
import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.DiscountedProduct;
import org.skypro.skyshop.product.FixPriceProduct;
import org.skypro.skyshop.product.SimpleProduct;
import org.skypro.skyshop.search.SearchEngine;
import org.skypro.skyshop.searchable.Searchable;

import java.util.Arrays;


public class App {
    //Метод удобного вывода поиска
    public static void printSearchResult(Searchable[] results) {
        boolean foundAny = false;
        for (Searchable item : results) {
            if (item != null) {
                System.out.println(item.getStringRepresentation());
                foundAny = true;

            }
        }
        if (!foundAny) {
            System.out.println("По запросу ничего не найдено");
        }
    }

    public static void main(String[] args) {
      //  ProductBasket basket = new ProductBasket();
        SearchEngine engine = new SearchEngine(10);

        // 1. Добавление продуктов
        SimpleProduct apple = new SimpleProduct("Яблоко", 50);
        engine.add(apple);

        SimpleProduct bread = new SimpleProduct("Хлеб", 40);
        engine.add(bread);

        SimpleProduct milk = new SimpleProduct("Молоко", 80);
        engine.add(milk);


        DiscountedProduct cheese = new DiscountedProduct("Сыр", 120, 20);
        engine.add(cheese);

        FixPriceProduct juice = new FixPriceProduct("Сок");
        engine.add(juice);

        //Добавляем несколько статей
        Article article1 = new Article("Курорты", "Море этим летом особенно теплое" +
                "...Холодный сок очень кстати  ");
        engine.add(article1);

        Article article2 = new Article("Комикс", "Человек паук против железного человека");
        engine.add(article2);

        Article article3 = new Article("Звезды", "Номинацию на премию оскар получил...");
        engine.add(article3);
        /*

        // 4. Печать содержимого
        System.out.println("=== Содержимое корзины ===");
        basket.printBasket();

        // 5. Стоимость корзины
        System.out.println("Стоимость корзины: " + basket.getTotalPrice());

        // 6. Поиск товара, который есть
        System.out.println("Есть 'Молоко': " + basket.containsProduct("Молоко"));

        // 7. Поиск товара, которого нет
        System.out.println("Есть 'Сок': " + basket.containsProduct("Сок"));


        // 9. Печать пустой корзины
        basket.printBasket();

        // 10. Стоимость пустой корзины
        System.out.println("Стоимость пустой корзины: " + basket.getTotalPrice());

        // 11. Поиск в пустой корзине
        System.out.println("Есть 'Молоко': " + basket.containsProduct("Молоко")); */

        //Поиск результатов без учета регистра
        printSearchResult(engine.search("МОЛоко"));

        printSearchResult(engine.search("оскар"));

        // Проверка на несовпадение
        printSearchResult(engine.search("лыжи"));

        //Проверка на два одинаковых параметра  разных объектов
        printSearchResult(engine.search("сок"));




    }


}
