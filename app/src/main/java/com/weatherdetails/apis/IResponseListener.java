package com.weatherdetails.apis;


/**
 * Retrofit response Listener
 */
public interface IResponseListener<RESULT> {

    /**
     * Response
     * @param exception ApiException if exception occurs
     * @param response  Successfull response if code = 200
     */
    void onResponse(ApiException exception, RESULT response);
}
