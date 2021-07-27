package com.example.d_bee_6;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    BottomNavigationView bottomNavigationView;
    ViewPager viewPager;
    Fragment firstFragment = new FirstFragment();
    Fragment secondFragment = new SecondFragment();
    Fragment thirdFragment = new ThirdFragment();
    List<Fragment> fragmentList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bottomNavigationView = findViewById(R.id.btm_nav);
        viewPager = findViewById(R.id.view_pager_for_bnv);
        initView();
    }

    private void initView() {
        fragmentList.add(firstFragment);
        fragmentList.add(secondFragment);
        fragmentList.add(thirdFragment);
        MyFragmentPagerAdapter myFragmentPagerAdapter = new MyFragmentPagerAdapter(getSupportFragmentManager(), fragmentList);
        viewPager.setAdapter(myFragmentPagerAdapter);

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


}