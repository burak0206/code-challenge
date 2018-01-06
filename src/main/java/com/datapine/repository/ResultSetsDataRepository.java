package com.datapine.repository;

import com.datapine.entity.Row;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class ResultSetsDataRepository {
    private ConcurrentHashMap<String,List<Row>> dataSets = new ConcurrentHashMap<String,List<Row>>();

    private List<Row> revenueList = new ArrayList<>();
    private List<Row> championsList = new ArrayList<>();
    private List<Row> leaguesList = new ArrayList<>();

    @PostConstruct
    public void init(){
        revenueList.add(new Row("Real Madrid", 625));
        revenueList.add(new Row("Barcelona", 620));
        revenueList.add(new Row("Bayern Munich", 600));
        revenueList.add(new Row("Liverpool", 400));
        revenueList.add(new Row("Milan", 250));

        championsList.add(new Row("Real Madrid", 12));
        championsList.add(new Row("Barcelona", 5));
        championsList.add(new Row("Bayern Munich", 5));
        championsList.add(new Row("Liverpool", 5));
        championsList.add(new Row("Milan", 7));

        leaguesList.add(new Row("Real Madrid", 33));
        leaguesList.add(new Row("Barcelona", 24));
        leaguesList.add(new Row("Bayern Munich", 26));
        leaguesList.add(new Row("Liverpool", 18));
        leaguesList.add(new Row("Milan", 18));

        dataSets.put("revenue",revenueList);
        dataSets.put("champions",championsList);
        dataSets.put("leagues",leaguesList);
    }

    public Optional<List<Row>> getDataSetsByKey(String key){
        return Optional.ofNullable(dataSets.getOrDefault(key,null));
    }

}
