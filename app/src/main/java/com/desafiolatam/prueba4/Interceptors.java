package com.desafiolatam.prueba4;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Interceptors {

    private static final String BASE_URL = "https://mindicador.cl/";

    public Mindicador theMostBasicInterceptor() {
        Retrofit interceptor = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                /*Never forget about adding the converter, otherwise you can not parse the data*/
                .addConverterFactory(GsonConverterFactory.create()).build();
        Mindicador someRequest = interceptor.create(Mindicador.class);
        /*The interceptor must return an interface, is the same interface where you wrote the methods for the request http*/
        return someRequest;
    }

}
