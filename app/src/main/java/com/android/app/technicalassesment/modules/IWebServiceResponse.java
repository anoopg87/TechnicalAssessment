package com.android.app.technicalassesment.modules;

import java.util.List;

public interface IWebServiceResponse<T> {
    /*
    Interface for Webservice callBack

     */

    void onSuccess(List<T> result);
    void onError(String error);
}
