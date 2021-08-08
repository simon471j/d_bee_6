package com.example.d_bee_6.ui;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.d_bee_6.MyApplication;
import com.example.d_bee_6.R;


public class ThirdFragment extends Fragment {


    String imagePath;

    public ThirdFragment(String imagePath) {
        this.imagePath = imagePath;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_third, container, false);
        ImageView imageview = view.findViewById(R.id.imageView);
        Glide.with(getActivity()).load(imagePath).into(imageview);
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();

    }
    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (isVisibleToUser)
            Toast.makeText(MyApplication.context, "喜乐蒂牧羊犬", Toast.LENGTH_SHORT).show();
    }

}