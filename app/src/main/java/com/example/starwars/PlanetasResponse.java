package com.example.starwars;

import java.util.List;

public class PlanetasResponse {
    private int count;
    private String next;
    private String previous;
    private List<Planeta> results;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getNext() {
        return next;
    }

    public void setNext(String next) {
        this.next = next;
    }

    public String getPrevious() {
        return previous;
    }

    public void setPrevious(String previous) {
        this.previous = previous;
    }

    public List<Planeta> getResults() {
        return results;
    }

    public void setResults(List<Planeta> results) {
        this.results = results;
    }

    public PlanetasResponse(int count, String next, String previous, List<Planeta> results) {
        this.count = count;
        this.next = next;
        this.previous = previous;
        this.results = results;
    }
}
