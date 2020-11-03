package com.naimur.weatherapptest;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONObject;
import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    final String TAG = "MainActivity";

    TextView sCityName, sTemp, sFeelike, sTimeZone, sWeather;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sCityName = (TextView) findViewById(R.id.city_name);
        sTemp = (TextView) findViewById(R.id.temp);
        sFeelike = (TextView) findViewById(R.id.feel_like);
        sTimeZone = (TextView) findViewById(R.id.weather);

        makeJSONRequest();
        Log.e(TAG, "Error i am");

    }

    private void makeJSONRequest() {

        String tag_json_obj = "json_obj_req";

        String url = "http://api.openweathermap.org/data/2.5/weather?q=Dhaka&appid=843be7120dc2c5acc6b5f79c756933b8";


        JsonObjectRequest jsonObjReq = new JsonObjectRequest(Request.Method.GET,
                url, null,
                new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject response) {
                        Log.e(TAG, response.toString());

                    }
                }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                VolleyLog.d(TAG, "Error: " + error.getMessage());

            }
        });

        AppController.getInstance().addToRequestQueue(jsonObjReq, tag_json_obj);
    }
}



