package com.datapine.controller;

import com.datapine.model.ChartRequestModel;
import com.datapine.model.ChartResponseModel;
import com.datapine.model.SeriesModel;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by burakdagli on 5.01.2018.
 */
@RestController
public class ChartController {

    @RequestMapping(value = "/chart", method = RequestMethod.POST)
    public ChartResponseModel chart(@RequestBody @Valid ChartRequestModel chartRequestModel){
        chartRequestModel.getDimensions().stream().forEach(d -> System.out.println(d));
        chartRequestModel.getMeasures().stream().forEach(d -> System.out.println(d));


        ChartResponseModel chartResponseModel = new ChartResponseModel();
        chartResponseModel.setCategories(Arrays.asList("Real Madrid","Barcelona","Bayern Munich","Liverpool","Milan"));

        List<SeriesModel> seriesModelList = new ArrayList<SeriesModel>();

        SeriesModel seriesModel = new SeriesModel();
        seriesModel.setName("champions");
        seriesModel.setData(Arrays.asList(12.0, 5.0, 5.0, 5.0, 7.0));

        SeriesModel seriesModel2 = new SeriesModel();
        seriesModel2.setName("leagues");
        seriesModel2.setData(Arrays.asList(33.0, 24.0, 26.0, 28.0, 28.0));

        seriesModelList.add(seriesModel);
        seriesModelList.add(seriesModel2);

        chartResponseModel.setSeries(seriesModelList);
        return chartResponseModel;
    }

}
