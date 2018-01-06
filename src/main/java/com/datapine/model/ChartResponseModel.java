package com.datapine.model;

import java.util.List;

/**
 * Created by burakdagli on 5.01.2018.
 */
public class ChartResponseModel {
    private List<String> categories;
    private List<SeriesModel> series;

    public List<String> getCategories() {
        return categories;
    }

    public void setCategories(List<String> categories) {
        this.categories = categories;
    }

    public List<SeriesModel> getSeries() {
        return series;
    }

    public void setSeries(List<SeriesModel> seriesModelList) {
        this.series = seriesModelList;
    }

    @Override
    public String toString() {
        return "{categories:" + categories + ",series:" + series + "}";
    }
}
