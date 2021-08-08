package com.example.d_bee_6.logic;

import com.example.d_bee_6.logic.model.Root;
import com.example.d_bee_6.logic.network.DataService;
import com.example.d_bee_6.logic.network.ServiceCreator;



import io.reactivex.Observable;

public class Repository {
    static DataService dataService = ServiceCreator.create(DataService.class);
    public static Observable<Root> getRootBean(){
         return dataService.get();
    }

}
