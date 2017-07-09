package com.example.testtask.utils;

import com.example.testtask.request.RequestError;
import com.example.testtask.request.RequestSuccess;
import com.google.gson.Gson;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by resident on 09.07.17.
 * класс подготавливает response для отправки клиенту
 */
public class ResponseModified {

    private static final int STATUS_SUCCESS = 200;
    private static final int STATUS_FAIL = 500;

    private static void configResponse(HttpServletResponse response, int status, String data) throws IOException {
        response.setStatus(status);
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(data);
    }

    public static <T> void toSuccess(HttpServletResponse response, List<T> list) throws IOException {
        configResponse(response, STATUS_SUCCESS, new Gson().toJson(new RequestSuccess<>(list)));
    }

    public static void toFail(HttpServletResponse response, String message) throws IOException {
        configResponse(response, STATUS_FAIL, new Gson().toJson(new RequestError(message)));
    }
}
