package com.desafiolatam.prueba4;

import retrofit2.Call;
import retrofit2.http.*;

public interface Mindicador {

    @GET("api")
    Call<Wrapper> getData();
}
