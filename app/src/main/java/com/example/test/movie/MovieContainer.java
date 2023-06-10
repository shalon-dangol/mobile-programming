package com.example.test.movie;

import java.util.List;

public class MovieContainer {
    @SerializedName("page")
    @Expose
    int page;

    @SerializedName("results")
    @Expose
    List<Results> resultsList;

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public List<Results> getResultsList() {
        return resultsList;
    }

    public void setResultsList(List<Results> resultsList) {
        this.resultsList = resultsList;
    }
}
