package org.skypro.skyshop.product;

import org.skypro.skyshop.searchable.Searchable;

public abstract class Product implements Searchable {
    private final String name;

    public Product(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public abstract int getPrice();

    public abstract boolean isSpecial();
    @Override
    public String searchText(){
        return getName();
    }
    @Override
    public String searchContent(){
        return "PRODUCT";
    }
    @Override
    public  String searchName(){
        return getName();
    }

}