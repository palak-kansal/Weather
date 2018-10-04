package com.weatherdetails.constant;

/**
 * This defines all the error codes.
 */
public interface HttpErrorCode {
    int BAD_REQUEST = 400;
    int UNAUTHORISED = 401;
    int FORBIDDEN = 403;
    int PAGE_NOT_FOUND = 404;
    int REQUEST_TIME_OUT = 408;
    int INTERNAL_SERVER_ERROR = 500;
    int BAD_GATEWAY = 502;
    int GATEWAY_TIMEOUT = 504;
    int UNKNOWN_HOST_CONNECTION = 21;
}
