package com.example.d_bee_6.ui;

import androidx.lifecycle.ViewModel;

import com.example.d_bee_6.logic.Repository;
import com.example.d_bee_6.logic.model.Data;
import com.example.d_bee_6.logic.model.Root;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

public class MyViewModel extends ViewModel {

    public Observable<List<String>> getImagePath() {

        return Repository.getRootBean().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).map(new Function<Root, List<String>>() {
            @Override
            public List<String> apply(@NotNull Root root) throws Exception {
                List<String> imagePath = new ArrayList<>();
                for (Data data : root.getData()) {
                    imagePath.add(data.getImage());
                }
                return imagePath;
            }
        });
    }
}
