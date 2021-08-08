package com.example.d_bee_6.ui;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.viewpager.widget.ViewPager;

import android.content.Context;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.example.d_bee_6.MyApplication;
import com.example.d_bee_6.R;
import com.example.d_bee_6.logic.model.Data;
import com.example.d_bee_6.logic.model.Root;
import com.example.d_bee_6.logic.network.DataService;
import com.example.d_bee_6.logic.network.ServiceCreator;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    BottomNavigationView bottomNavigationView;
    ViewPager viewPager;
    Fragment firstFragment;
    Fragment secondFragment;
    Fragment thirdFragment;
    MyViewModel myViewModel;
    List<String> imagePath = new ArrayList<>();

    List<Fragment> fragmentList = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bottomNavigationView = findViewById(R.id.btm_nav);
        viewPager = findViewById(R.id.view_pager_for_bnv);
        myViewModel = new ViewModelProvider(this, new ViewModelProvider.AndroidViewModelFactory(getApplication())).get(MyViewModel.class);

        initView();

    }

    private void initView() {

       myViewModel.getImagePath().subscribe(new Observer<List<String>>() {
            @Override
            public void onSubscribe(@NotNull Disposable d) {

            }

            @Override
            public void onNext(@NotNull List<String> imagePath) {
                firstFragment = new FirstFragment(imagePath.get(0));
                secondFragment = new SecondFragment(imagePath.get(1));
                thirdFragment = new ThirdFragment(imagePath.get(2));
                fragmentList.add(firstFragment);
                fragmentList.add(secondFragment);
                fragmentList.add(thirdFragment);
                MyFragmentPagerAdapter myFragmentPagerAdapter = new MyFragmentPagerAdapter(getSupportFragmentManager(), fragmentList);
                viewPager.setAdapter(myFragmentPagerAdapter);
            }

            @Override
            public void onError(@NotNull Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        });



//        the listener for the bottom navigation view
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {
//                switch case ; once the navigation changed, viewPager changes two.
                switch (item.getItemId()) {
                    case R.id.item_home:
                        viewPager.setCurrentItem(0);
                        break;
                    case R.id.item_contact:
                        viewPager.setCurrentItem(1);
                        break;
                    case R.id.item_zone:
                        viewPager.setCurrentItem(2);
                        break;
                    default:
                }
                return false;
            }
        });

//        it's the same ,if viewPager changed, navigation changes as well
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                bottomNavigationView.getMenu().getItem(position).setChecked(true);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    @Nullable
    @org.jetbrains.annotations.Nullable
    @Override
    public View onCreateView(@NonNull @NotNull String name, @NonNull @NotNull Context context, @NonNull @NotNull AttributeSet attrs) {


        return super.onCreateView(name, context, attrs);
    }
}