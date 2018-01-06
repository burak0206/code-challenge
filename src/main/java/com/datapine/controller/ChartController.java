package com.datapine.controller;

import com.datapine.model.ChartRequestModel;
import com.datapine.model.ChartResponseModel;
import com.datapine.service.ChartRetrieveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;

@RestController
public class ChartController {

    @Autowired
    private ChartRetrieveService chartRetrieveService;

    @RequestMapping(value = "/chart", method = RequestMethod.POST)
    public ChartResponseModel chart(@RequestBody @Valid ChartRequestModel chartRequestModel){
        ChartResponseModel chartResponseModel = chartRetrieveService.getChartByRequestModel(chartRequestModel);
        return chartResponseModel;
    }

}
