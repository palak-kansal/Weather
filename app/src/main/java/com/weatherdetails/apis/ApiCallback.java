package com.weatherdetails.apis;

import java.lang.ref.WeakReference;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * This class handles the retrofit response and failure callback.
 */
public class ApiCallback<RESULT> implements Callback<RESULT> {

    private WeakReference<IResponseListener<RESULT>> weakReference;

    public ApiCallback(IResponseListener<RESULT> listener) {
        weakReference = new WeakReference<>(listener);
    }

    @Override
    public void onResponse(Call<RESULT> call, Response<RESULT> response) {
        IResponseListener<RESULT> listener = weakReference.get();
        if (listener != null) {
            if (response.isSuccessful()) {
                listener.onResponse(null, response.body());
            } else {
                String error = ErrorUtils.parseError(response).message();
                listener.onResponse(ApiUtils.getResponseError(response, error), null);
            }
        }
        //call.cancel();
    }

    @Override
    public void onFailure(Call<RESULT> call, Throwable t) {
        IResponseListener<RESULT> listener = weakReference.get();
        if (listener != null) {
            listener.onResponse(ApiUtils.getException(t), null);
        }
    }
}
