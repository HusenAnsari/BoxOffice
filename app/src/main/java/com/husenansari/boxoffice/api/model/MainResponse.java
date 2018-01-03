package com.husenansari.boxoffice.api.model;

import java.util.ArrayList;

/**
 * Created by gulamhusen on 05-07-2017.
 */

public class MainResponse {

    private int page;
    private int total_results;
    private int total_pages;
    private ArrayList<results> results;

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getTotal_results() {
        return total_results;
    }

    public void setTotal_results(int total_results) {
        this.total_results = total_results;
    }

    public int getTotal_pages() {
        return total_pages;
    }

    public void setTotal_pages(int total_pages) {
        this.total_pages = total_pages;
    }

    public ArrayList<results> getResults() {
        return results;
    }

    public void setResults(ArrayList<results> results) {
        this.results = results;
    }
}

/*
        page: 1,
        total_results: 316429,
        total_pages: 15822,
        results: []
*/
