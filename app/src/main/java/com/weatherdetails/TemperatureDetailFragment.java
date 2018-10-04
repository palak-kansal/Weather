package com.weatherdetails;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.weatherdetails.dialog.LoaderDialog;
import com.weatherdetails.model.WeatherInfo;
import com.weatherdetails.presenter.TemperatureDetailPresenter;
import com.weatherdetails.view.ITemperatureDetailView;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Palak Kansal on 04/10/2018.
 */

public class TemperatureDetailFragment extends Fragment implements ITemperatureDetailView {
    private String countryName;
    private TemperatureDetailPresenter temperatureDetailPresenter;
    private LoaderDialog mDialog;
    @BindView(R.id.tv_max_temp_value)TextView maxTempValueTV;
    @BindView(R.id.tv_min_temp_value)TextView minTextValueTV;
    @BindView(R.id.tv_min_temp)TextView minTextTV;
    @BindView(R.id.tv_max_temp)TextView maxTextTV;
    @BindView(R.id.iv_temp_img)ImageView tempImgIV;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_temperature, container, false);
        ButterKnife.bind(this, view);
        countryName = getArguments().getString("city");
        temperatureDetailPresenter = new TemperatureDetailPresenter(this);

        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        temperatureDetailPresenter.loadTemperatureDetails(countryName);
    }

    @Override
    public void getTemperatureDetails(WeatherInfo weatherInfo) {
        String imagePath = "http://openweathermap.org/img/w/"+weatherInfo.getIcon().get(0).getIconName()+".png";
        maxTextTV.setVisibility(View.VISIBLE);
        minTextTV.setVisibility(View.VISIBLE);
        maxTempValueTV.setText(""+weatherInfo.getTemperatureDetails().getMaxTemp());
        minTextValueTV.setText(""+weatherInfo.getTemperatureDetails().getMinTemp());
        Glide.with(getActivity())
                .load(imagePath)
                .asBitmap()
                .placeholder(R.drawable.ic_image_placeholder)
                .fitCenter()
                .into(tempImgIV);
    }

    @Override
    public void onError(int code) {

    }

    @Override
    public void showLoading() {
        hideLoading();
        if(getActivity() != null && !getActivity().isFinishing()) {
            mDialog = new LoaderDialog(getActivity());
            mDialog.show();        }
    }

    @Override
    public void hideLoading() {
        if (mDialog != null && mDialog.isShowing()) {
            mDialog.cancel();
        }
    }
}
