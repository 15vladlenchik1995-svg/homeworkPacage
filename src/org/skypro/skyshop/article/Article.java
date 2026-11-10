package org.skypro.skyshop.article;

import org.skypro.skyshop.searchable.Searchable;

public class Article implements Searchable {
    private final String title;
    private final String text;

   public Article(String title,String text){
       this.title=title;
       this.text=text;

    }
    public String getTitle() {
        return title;
    }

    public String getText() {
        return text;
    }


    @Override
    public  String searchName(){
        return getTitle();
    }
    @Override
    public String searchContent(){
        return "ARTICLE";
    }
    @Override
    public String searchText(){
        return toString();
    }



    @Override
    public String toString() {
        return title + "\n" +getText();
    }


}
