package com.weatherdetails.apis;

/**
 * This class extends exception and displays the exception message
 * and its code
 */
public class ApiException extends Exception {
    private int mCode;
    private String mMessage;

    public ApiException(int code, String message) {
        mCode = code;
        mMessage = message;
    }

    @Override
    public String getMessage() {
        return mMessage;
    }

    public int getCode() {
        return mCode;
    }
}
