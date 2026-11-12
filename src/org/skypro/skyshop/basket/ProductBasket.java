
package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class ProductBasket {
    private List<Product> products = new LinkedList<>();

    public void addProduct( Product product) {
        products.add(product);

    }

    public int getTotalPrice() {
        int sum = 0;
        for (Product p : products) {
            if (p != null) {
                sum += p.getPrice();
            }
        }
        return sum;
    }

    public void printBasket() {
        boolean hasProducts = false;
        int specialCount = 0;
        for (Product p : products) {
            if (p != null) {
                System.out.println(p);
                hasProducts = true;
                if (p.isSpecial()) {
                    specialCount++;
                }
            }
        }
        if (!hasProducts) {
            System.out.println("в корзине пусто");
        } else {
            System.out.println("Итого: " + getTotalPrice());
            System.out.println("Специальных товаров " + specialCount);
        }
    }

    public boolean containsProduct(String name) {
        for (Product p : products) {
            if (p != null && p.getName().equalsIgnoreCase(name)) {
                return true;
            }
        }
        return false;
    }

    public void clearBasket() {
        products.clear();
    }


    public List<Product> removeProductsByName(String name) {
        List<Product> removed = new LinkedList<>();
        Iterator<Product> it = products.iterator();
        while (it.hasNext()) {
            Product n = it.next();
            if (n.getName().equalsIgnoreCase(name) ){
                removed.add(n);
                it.remove();  
            }
        }

        return removed;
    }


}