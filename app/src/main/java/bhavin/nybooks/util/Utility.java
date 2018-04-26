package bhavin.nybooks.util;

import org.json.JSONObject;

import java.io.IOException;
import java.net.SocketTimeoutException;

import okhttp3.ResponseBody;
import retrofit2.HttpException;

/**
 * Created by Bhavin on 4/25/2018.
 */

public class Utility {

    public static String getErrorMessage(Throwable e) {
        if (e instanceof HttpException) {
            ResponseBody responseBody = ((HttpException)e).response().errorBody();
            return getErrorMessage(responseBody);
        } else if (e instanceof SocketTimeoutException) {
            return "SocketTimeOutException";
        } else if (e instanceof IOException) {
            return "Network Error";
        } else {
            return "Duh!!";
        }
    }

    private static String getErrorMessage(ResponseBody responseBody) {
        try {
            JSONObject jsonObject = new JSONObject(responseBody.string());
            return jsonObject.getString("message");
        } catch (Exception e) {
            return e.getMessage();
        }
    }
}
