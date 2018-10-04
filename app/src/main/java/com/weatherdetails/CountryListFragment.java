package com.weatherdetails;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Spinner;

import java.io.Serializable;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Palak Kansal on 04/10/2018.
 */

public class CountryListFragment extends Fragment {

    @BindView(R.id.spn_country)Spinner countrySPN;
    @BindView(R.id.btn_get_info)Button getInfoBTN;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_country, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @OnClick(R.id.btn_get_info)
    void onButtonClick(){
        TemperatureDetailFragment temperatureDetailFragment = new TemperatureDetailFragment();
        Bundle args = new Bundle();
        args.putString("city", countrySPN.getSelectedItem().toString());
        temperatureDetailFragment.setArguments(args);
        this.getFragmentManager().beginTransaction()
                .replace(R.id.activity_content, temperatureDetailFragment)
                .addToBackStack(null)
                .commit();
    }

    public static CountryListFragment newInstance() {
        Bundle args = new Bundle();
        CountryListFragment fragment = new CountryListFragment();
        fragment.setArguments(args);
        return fragment;
    }
}
