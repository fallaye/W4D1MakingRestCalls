package mobileappscompany.w4d1makingrestcalls;

import android.util.Log;

import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import mobileappscompany.w4d1makingrestcalls.mocky.MockyResponse;

/**
 * Created by fallaye on 12/18/17.
 */

public class MyParser {

    String response;

    public static final String TAG = "MyParser";

    public MyParser(String response){
        this.response  = response;
    }

    public static void parseUsingJSON(String unparsed) throws JSONException{
        JSONObject mockyObject = new JSONObject(unparsed);
        JSONObject menuObject = mockyObject.getJSONObject("menu");
        JSONObject popupObject = menuObject.getJSONObject("popup");
        JSONArray menuItemArray = popupObject.getJSONArray("menuItem");

        JSONObject jsonObject = (JSONObject) menuItemArray.get(0);

        //Log.d()

        for (int i = 0; i < 3; i++) {
                JSONObject jsonObject1 = (JSONObject) menuItemArray.get(i);
                Log.d(TAG, "parseUsingJSON: " + jsonObject.getString("value"));
        }

    }

    public static MockyResponse parseUsingGson(String response){
        Gson gson = new Gson();
        //MockyResponse

        return null;
    }


}
