package org.skypro.skyshop.searchable;

public interface Searchable {
    public String searchText();
    public String searchContent();
    public String searchName();
    default String getStringRepresentation(){
        return searchName()+" - "+searchContent();
    }








}
