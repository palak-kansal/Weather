package com.weatherdetails.apis;

import com.weatherdetails.constant.HttpErrorCode;

import java.net.ConnectException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;

import retrofit2.Response;

/**
 * This class handles retrofit error codes and on the basis of error code
 * displays the error message.
 */
public class ApiUtils implements HttpErrorCode {

    /**
     * Get the retrofit response error code and its error message
     * @param response Retrofit response
     * @return APiException object with error code and error message
     */
    public static ApiException getResponseError(Response response, String errMessage) {
        int code = response.code();


        if(errMessage == null){
            errMessage = getErrorMessage(code, response.message());
        }
        return new ApiException(code, errMessage);
    }

    /**
     * Get the retrofit failure error code and its error message
     * @param throwable Retrofit Throwable Exception
     * @return APiException object with error code and error message
     */
    public static ApiException getException(Throwable throwable) {
        if (throwable instanceof SocketTimeoutException)
            return new ApiException(REQUEST_TIME_OUT, "Request time out");
        else if(throwable instanceof UnknownHostException)
            return new ApiException(UNKNOWN_HOST_CONNECTION, "No Internet Connection");
        else if(throwable instanceof ConnectException)
            return new ApiException(UNKNOWN_HOST_CONNECTION, "No Internet Connection");
        return new ApiException(INTERNAL_SERVER_ERROR, throwable.getMessage());
    }

    /**
     * Parse the Error code
     * @param errorCode on the basis of this we display error message
     * @param message message
     * @return error message
     */
    private static String getErrorMessage(int errorCode, String message) {
        switch (errorCode) {
            case BAD_GATEWAY:
                message = "bad_gateway";
                break;
            case BAD_REQUEST:
                message = "bad_request";
                break;
            case UNAUTHORISED:
                message = "unauthorized_access";
                break;
            case FORBIDDEN:
                message = "access_is_forbidden";
                break;
            case PAGE_NOT_FOUND:
                message = "page_not_found";
                break;
            case REQUEST_TIME_OUT:
                message = "request_time_out";
                break;
            case INTERNAL_SERVER_ERROR:
                message = "internal_server_error";
                break;
            case GATEWAY_TIMEOUT:
                message = "gateway_time_out";
                break;
        }
        if (message == null)
            message = "something_went_wrong";
        return message;
    }
}
