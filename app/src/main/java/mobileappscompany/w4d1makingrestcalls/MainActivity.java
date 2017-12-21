package mobileappscompany.w4d1makingrestcalls;

import android.os.Handler;
import android.os.Message;
import android.os.Trace;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import org.json.JSONException;
import org.w3c.dom.Text;

import java.io.IOException;
import java.util.List;

import mobileappscompany.w4d1makingrestcalls.data.remote.RemoteDataSource;
import mobileappscompany.w4d1makingrestcalls.mocky.MockyResponse;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;


public class MainActivity extends AppCompatActivity implements Handler.Callback{

    private TextView textView ;
    public static final String  BASE_URL = " http://www.mocky.io/v2/5a3820023200004928eb6bdf";
    private Handler handler;

    private Request request;
    private OkHttpClient okHttpClient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        handler = new Handler(this);
    }

    @Override
    public boolean handleMessage(Message msg){
        textView.setText(msg.getData().getString("data"));

        /*String response = msg.getData().getString("data");

        try{
            MyParser.parseUsingGson(response);

        }catch (JSONException e){
            e.printStackTrace();
        }

        MockyResponse mockyResponse =
                MyParser.parseUsingGson(response);
        List<MenuItem> menuItems = mockyResponse
                .getMenu().getPopup().getMenuItem();
        for (MenuItem menuItem: menuItems){
            Log.d(TAG,  "handleMesage: " + menuItem.getValue() + ": " +
            menuItem.toString());

        }*/

        return false;
    }

    public void onHttpNative(View view) {
        MyHttpThread myHttpThread = new MyHttpThread(BASE_URL, handler);
        myHttpThread.start();
    }

    public void onOkHttpSync(View view) {
        new Thread(new Runnable(){
            public void run(){
                OkHttpClient okHttpClient =
                        new OkHttpClient();
                //Request request =
                     //   new Request().newBuilder();

            }
        }).start();
    }

    public void onOKHttpAsync(View view){
        okHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
               handler.sendMessage(MessageUtil.getMessage(response.body().string()));
            }
        });
    }

    public void onRetrofitSync(View view) {

    }

    public void onRetrofitAsync(View view){
        RemoteDataSource.getUser("manroopsingh");

    }
}
