package com.dahlia.shopingcartapp.Fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.dahlia.shopingcartapp.R;

/**
 * Created by Admin on 25-05-2016.
 */
public class HomeCatelogFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.content_home_catalog_actvity,container,false);
        return v;
    }
}
