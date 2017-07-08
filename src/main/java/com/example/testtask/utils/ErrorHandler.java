package com.example.testtask.utils;

import com.example.testtask.entries.Message;
import com.example.testtask.exceptions.DuplicateUserIdException;
import com.example.testtask.exceptions.MessagesNotFoundException;
import com.example.testtask.exceptions.TariffPlanesNotFoundException;
import com.example.testtask.exceptions.UsersNotFoundException;

/**
 * Created by resident on 09.07.17.
 */
public class ErrorHandler {
    public static String getHandler(Throwable throwable){
        if (throwable instanceof UsersNotFoundException){
            return "Не удалось найти пользователей";
        } else if (throwable instanceof DuplicateUserIdException){
            return "Обнаружены пользователи с одинаковыми Id";
        } else if (throwable instanceof TariffPlanesNotFoundException){
            return "Не удалось найти тарифные планы";
        } else if (throwable instanceof MessagesNotFoundException){
            return "Не удалось найти уведомления";
        } else {
            return throwable.getLocalizedMessage();
        }
    }
}
