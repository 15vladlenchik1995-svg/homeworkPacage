package org.skypro.skyshop.search;

import org.skypro.skyshop.searchable.Searchable;

import java.util.LinkedList;
import java.util.List;

public class SearchEngine {
    private final List <Searchable> searchables = new LinkedList<>();



    public void add(Searchable searchable) {
        searchables.add(searchable);

    }

    public List<Searchable> search(String query) {
        List<Searchable> result = new LinkedList<>();
        for(Searchable c : searchables){
            if(c.searchText().toLowerCase().contains(query.toLowerCase())){
                result.add(c);
            }
        }

        return result;
    }

    public int countOccurrences(String text, String sub) {
        int count = 0;
        int index = 0;
        int found = text.indexOf(sub, index);

        while (found != -1) {
            count++;
            index = found + sub.length();
            found = text.indexOf(sub, index);
        }
        return count;
    }

    public Searchable findBestResult(String search) throws BestResultNotFound {
        if (search == null || search.isBlank()){
            throw new BestResultNotFound(search);
        }
        Searchable best = null;
        int bestCount = 0;
        for (Searchable s : searchables) {
            if( s == null){
                throw new IllegalArgumentException("Название продукта не может быть пустым ");
            }
            int count = countOccurrences(s.searchText().toLowerCase(), search.toLowerCase());
            if (count > bestCount) {
                bestCount = count;
                best = s;
            }
        }
        if (best==null){
            throw new BestResultNotFound(search);
        }
        return  best;
    }



}



