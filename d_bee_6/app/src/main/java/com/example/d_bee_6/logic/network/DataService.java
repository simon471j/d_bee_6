package com.example.d_bee_6.logic.network;

import com.example.d_bee_6.logic.model.Root;

import io.reactivex.Observable;
import retrofit2.Call;
import retrofit2.http.GET;

public interface DataService {
    @GET("api/v2/banners")
    Observable<Root> get();
}
