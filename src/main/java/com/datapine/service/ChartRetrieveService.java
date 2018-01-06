package com.datapine.service;

import com.datapine.model.ChartRequestModel;
import com.datapine.model.ChartResponseModel;
import com.datapine.model.SeriesModel;
import com.datapine.repository.ResultSetsDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class ChartRetrieveService {
    @Autowired
    private ResultSetsDataRepository resultSetsDataRepository;
    public Optional<ChartResponseModel> getChartByRequestModel(ChartRequestModel chartRequestModel) {
        ChartResponseModel chartResponseModel = new ChartResponseModel();
        chartResponseModel.setCategories(Arrays.asList("Real Madrid","Barcelona","Bayern Munich","Liverpool","Milan"));
        List<SeriesModel> seriesModelList = new ArrayList<SeriesModel>();
        chartRequestModel.getMeasures().stream().forEach(m ->
                resultSetsDataRepository.getDataSetsByKey(m).ifPresent( list ->{
                            List<Double> numbers =list.stream().map(l -> ((double) l.getNumber())).collect(Collectors.toList());
                            seriesModelList.add(new SeriesModel(m,numbers));
                        }
                )
        );
        chartResponseModel.setSeries(seriesModelList);
        return Optional.ofNullable(chartResponseModel);
    }
}
