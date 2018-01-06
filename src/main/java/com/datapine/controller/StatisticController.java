package com.datapine.controller;

import com.datapine.validator.StatisticRequestValidator;
import com.datapine.model.ChartResponseModel;
import com.datapine.model.SeriesModel;
import com.datapine.model.StatisticRequestModel;
import com.datapine.model.StatisticResponseModel;
import com.google.gson.JsonObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by burakdagli on 5.01.2018.
 */
@RestController
public class StatisticController {

    @Autowired
    private StatisticRequestValidator statisticRequestValidator;

    @RequestMapping(value = "/statistics", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public String statistics(@Valid  StatisticRequestModel statisticRequestModel, BindingResult bindingResult){
        JsonObject status = new JsonObject();
        statisticRequestValidator.validate(statisticRequestModel,bindingResult);

        if (bindingResult.hasErrors() ) {
            status.addProperty("error","timeUnit should be minutes or seconds");
            status.addProperty("exception.message",bindingResult.toString());
            return status.toString();
        }

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
        status.addProperty("totalRequests", statisticResponseModel.getTotalRequests().toString());
        status.addProperty("totalQueries", statisticResponseModel.getTotalQueries().toString());
        status.addProperty("chart", chartResponseModel.toString());
        return status.toString();
    }

    @RequestMapping(value = "/statistic", method = RequestMethod.GET)
    public StatisticResponseModel statistic(StatisticRequestModel statisticRequestModel, BindingResult bindingResult){
        System.out.println(statisticRequestModel.getLast());
        System.out.println(statisticRequestModel.getTimeUnit());
        System.out.println(statisticRequestModel.getMavgPoints());

        statisticRequestValidator.validate(statisticRequestModel,bindingResult);

        if (bindingResult.hasErrors() ) {
            System.out.println("timeUnit should be minutes or seconds");
            System.out.println(bindingResult.toString());
        }

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
