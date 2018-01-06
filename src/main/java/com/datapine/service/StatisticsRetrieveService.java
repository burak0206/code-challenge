package com.datapine.service;

import com.datapine.model.ChartResponseModel;
import com.datapine.model.SeriesModel;
import com.datapine.model.StatisticRequestModel;
import com.datapine.model.StatisticResponseModel;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class StatisticsRetrieveService {
    public StatisticResponseModel getStatisticsByRequestModel(StatisticRequestModel statisticRequestModel) {
        StatisticResponseModel statisticResponseModel = new StatisticResponseModel();
        statisticResponseModel.setTotalQueries(4500);
        statisticResponseModel.setTotalRequests(2500);

        ChartResponseModel chartResponseModel = new ChartResponseModel();
        chartResponseModel.setCategories(Arrays.asList("2017-05-05 13:00","2017-05-05 13:01","2017-05-05 13:02","2017-05-05 13:03","2017-05-05 13:04"));

        List<SeriesModel> seriesModelList = new ArrayList<SeriesModel>();

        SeriesModel seriesModel = new SeriesModel();
        seriesModel.setName("requests");
        seriesModel.setData(Arrays.asList(12.0, 5.0, 5.0, 5.0, 7.0));

        SeriesModel seriesModel2 = new SeriesModel();
        seriesModel2.setName("queries");
        seriesModel2.setData(Arrays.asList(33.0, 24.0, 26.0, 28.0, 28.0));


        SeriesModel seriesModel3 = new SeriesModel();
        seriesModel3.setName("mavg");
        seriesModel3.setData(Arrays.asList(1225.5, 750.0, 625.75, 830.5 ,750.0));

        seriesModelList.add(seriesModel);
        seriesModelList.add(seriesModel2);
        seriesModelList.add(seriesModel3);

        chartResponseModel.setSeries(seriesModelList);
        statisticResponseModel.setChart(chartResponseModel);


        return statisticResponseModel;
    }
}
