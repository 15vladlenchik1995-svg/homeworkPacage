package org.skypro.skyshop.search;

import org.skypro.skyshop.searchable.Searchable;

public class SearchEngine {
    private final Searchable[] searchables;

    public SearchEngine(int capacity) {
        this.searchables = new Searchable[capacity];

    }

    public void add(Searchable searchable) {
        for (int i = 0; i < searchables.length; i++) {
            if (searchables[i] == null) {
                searchables[i] = searchable;
                return;
            }
        }
        System.out.println("Нельзя добавить элемент в поисковой движок");
    }

    public Searchable[] search(String query) {
        Searchable[] result = new Searchable[5];
        int count = 0;
        for (int i = 0; i < searchables.length; i++) {
            if (searchables[i] == null) {
                continue;
            }
            if (searchables[i].searchText().toLowerCase().contains(query.toLowerCase())) {
                result[count] = searchables[i];
                count++;
                if (count == 5) {
                    break;
                }
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
            if (s == null) {
                continue;
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



