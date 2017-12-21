package mobileappscompany.w4d1makingrestcalls.data.remote;

import mobileappscompany.w4d1makingrestcalls.github.GithubResponse;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by fallaye on 12/18/17.
 */

public class RemoteDataSource {

    public static final String BASE_URL = "https://api.github.com";
    public static Retrofit create(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return  retrofit;
    }

    public static Call<GithubResponse> getUser(@Path("user") String user) {

        Retrofit retrofit  = create();
        RemoteServie remoteServie = retrofit.create(RemoteServie.class);

        //return remoteServie.getUser();
        return null;

    }


    public interface RemoteServie{
        @GET("/users/{user}")
        Call<GithubResponse> getUser(@Path("user") String user);

    }
}
