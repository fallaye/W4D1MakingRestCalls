package mobileappscompany.w4d1makingrestcalls;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.BaseAdapter;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpCookie;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

import mobileappscompany.w4d1makingrestcalls.data.remote.RemoteDataSource;
import mobileappscompany.w4d1makingrestcalls.github.GithubResponse;

/**
 * Created by fallaye on 12/18/17.
 */

public class MyHttpThread extends Thread {

    String BASE_URL;
    android.os.Handler handler;

    public static final String TAG = "MyHttpThrea";
    StringBuilder stringBuilder;

    public MyHttpThread(String url, Handler handler){
        this.BASE_URL = url;
        this.handler = handler;

    }

    @Override
    public void run(){
        super.run();
        try {
            URL url = new URL(BASE_URL);

            HttpURLConnection urlConnection =
                    (HttpURLConnection) url.openConnection();

            InputStream inputStream =
                    new BufferedInputStream(urlConnection.getInputStream());

            Scanner scanner =
                    new Scanner(inputStream);

            stringBuilder = new StringBuilder();

            while (scanner.hasNext()){

                stringBuilder.append(scanner.nextLine());
                //Log.d(TAG, "run: " + scanner.nextLine());
            }

            Bundle bundle = new Bundle();
            bundle.putString("data", stringBuilder.toString());
            Message message = new Message();
            message.setData(bundle);
            handler.sendMessage(message);

        } catch (MalformedURLException e) {
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }

    }

public void OnRetrofitSync(View view) {

    /*RemoteDataSource.getUser("manroopsingh")
            .enqueue(new retrofit2.Callback<GithubResponse>{
        @Override
                public void onResponse(retrofit2.Call<GithubResponse> call,
        retrofit2<GithubResponse)

        @Override
                public void onFailure(retrofit2.Call<GithubResponse> call, Throwable)


            }*/

}


}
