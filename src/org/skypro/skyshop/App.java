package org.skypro.skyshop;

import org.skypro.skyshop.article.Article;
import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.DiscountedProduct;
import org.skypro.skyshop.product.FixPriceProduct;
import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.product.SimpleProduct;
import org.skypro.skyshop.search.BestResultNotFound;
import org.skypro.skyshop.search.SearchEngine;
import org.skypro.skyshop.searchable.Searchable;

import java.util.List;


public class App {
    //Метод удобного вывода поиска
    public static void printSearchResult(List<Searchable> results) {
        if(results.isEmpty()){
            System.out.println("Ничего не найдено");
            return;

        }
        for(Searchable c : results){
            System.out.println(c.getStringRepresentation());
        }

    }

    public static void main(String[] args) {

        SearchEngine engine = new SearchEngine();

        //Содание продуктов с одинаковым именем
        SimpleProduct apple = new SimpleProduct("яблоко", 50);
        engine.add(apple);

        SimpleProduct apple1 = new SimpleProduct("Яблоко", 50);
        engine.add(apple1);

        SimpleProduct bread = new SimpleProduct("Хлеб", 40);
        engine.add(bread);

        SimpleProduct bread1 = new SimpleProduct("Хлеб", 40);
        engine.add(bread1);


        //Java Collections Framework: List Домашнее задание
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();

        ProductBasket basket = new ProductBasket();
        basket.addProduct(apple);
        basket.addProduct(bread);
        basket.addProduct(apple1);
        basket.addProduct(bread1);

        System.out.println("Java Collections Framework: List Домашнее задание :");
        System.out.println("Корзина до удаления продуктов :");
        System.out.println();
        basket.printBasket();
        System.out.println();
        //Переменная для хранения удаленных продуктов(регистр не учитывается)
        List<Product> removed = basket.removeProductsByName("яБлоко");

        for(Product c : removed){
            System.out.println("Удалён продукт :"+c);
        }
        System.out.println();
        System.out.println("=== Демонстрация корзины после удаления продуктов ===");
        System.out.println();
        basket.printBasket();

        List<Product> removed2 = basket.removeProductsByName("мороженое");

        if (removed2.isEmpty()) {
            System.out.println("Список пуст");
        }

        basket.printBasket();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();










        System.out.println("Проверка №1 :  создание объекта без имени(одни пробелы):");
        try {
            SimpleProduct milk = new SimpleProduct("  ", 100);
            engine.add(milk);
            System.out.println("Создалось :" + milk);
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка :" + e.getMessage());
        }
        System.out.println("\n");


        System.out.println("Проверка №2 : создание объкта с неположительной базовой ценой :");
        try {
            DiscountedProduct cheese = new DiscountedProduct("Сыр", 0, 80);
            engine.add(cheese);
            System.out.println("Создалось :" + cheese);
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка :" + e.getMessage());
        }
        System.out.println("\n");


        System.out.println("Проверка №3 : создание объкта со скидкой в % вне диапазона 0-100 :");
        try {
            DiscountedProduct cupcake = new DiscountedProduct("Кекс", 20, 101);
            engine.add(cupcake);
            System.out.println("Создалось :" + cupcake);
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка :" + e.getMessage());
        }
        System.out.println("\n");

        FixPriceProduct juice = new FixPriceProduct("Сок");
        engine.add(juice);

        //Добавляем несколько статей
        Article article1 = new Article("Курорты", "Море этим летом особенно теплое" +
                "...Холодный сок очень кстати , сок соку рознь ");
        engine.add(article1);

        Article article2 = new Article("Комикс", "Человек паук против железного человека");
        engine.add(article2);

        Article article3 = new Article("Звезды", "Номинацию на премию оскар получил...");
        engine.add(article3);


        // 4. Печать содержимого
        System.out.println("=== Содержимое корзины ===");
        basket.printBasket();

        // 5. Стоимость корзины
        System.out.println("Стоимость корзины: " + basket.getTotalPrice());

        // 6. Поиск товара, который есть
        System.out.println("Есть 'хлеб': " + basket.containsProduct("ХлЕб"));

        // 7. Поиск товара, которого нет
        System.out.println("Есть 'Сок': " + basket.containsProduct("Сок"));

        // 8. Удаление корзины
        basket.clearBasket();


        // 9. Печать пустой корзины
        basket.printBasket();

        // 10. Стоимость пустой корзины
        System.out.println("Стоимость пустой корзины: " + basket.getTotalPrice());

        // 11. Поиск в пустой корзине
        System.out.println("Есть 'хлеб': " + basket.containsProduct("хлеб"));

        //Поиск результатов без учета регистра
        printSearchResult(engine.search("МОЛоко"));

        printSearchResult(engine.search("оскар"));

        // Проверка на несовпадение
        printSearchResult(engine.search("лыжи"));

        //Проверка на два одинаковых параметра  разных объектов
        printSearchResult(engine.search("квас"));
        // Сценарий 1 : результат существуeт

        System.out.println("Поиск лучшего результата : "+"\"сок\"");
        try {
           Searchable best = engine.findBestResult("сок");
            System.out.println("Лучший результат :"+best.getStringRepresentation());
        } catch (BestResultNotFound e) {
            System.out.println("Ошибка :"+e.getMessage());
        }
        System.out.println();

        // Сценарий 2 : результат отсутствует(проверка краевых ситуаций)
        System.out.println("Поиск пустого запроса : "+"\"\"");
        try {
           Searchable best = engine.findBestResult("");
            System.out.println("Лучший результат :"+best.getStringRepresentation());
        } catch (BestResultNotFound e) {
            System.out.println("Ошибка :"+e.getMessage());
        }




    }


}
