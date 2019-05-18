package com.example.starwars;

import java.util.List;

public class PersonagemResponse {
    private int count;
    private String next;
    private String previous;
    private List<Personagem> results;

    @Override
    public String toString() {
        return "count: " + count + '\n' + "next: " + next + "'\nprevious" + previous + "\nresults" + results;
    }

    public PersonagemResponse(int count, String next, String previous, List<Personagem> results) {
        this.count = count;
        this.next = next;
        this.previous = previous;
        this.results = results;
    }

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

    public List<Personagem> getResults() {
        return results;
    }

    public void setResults(List<Personagem> results) {
        this.results = results;
    }
}
