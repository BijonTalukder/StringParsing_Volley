package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    TextView tv;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv = findViewById(R.id.textView);
        progressBar = findViewById(R.id.progressBar);
        StringRequest stringRequest  = new StringRequest(Request.Method.GET, "https://abdominous-balls.000webhostapp.com/new.php",
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        tv.setText("Response id"+response);
                        progressBar.setVisibility(View.GONE);

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                tv.setText("that did not work");
                progressBar.setVisibility(View.GONE);

            }
        });


        RequestQueue requestQueue = Volley.newRequestQueue(MainActivity.this);
        requestQueue.add(stringRequest);
    }
}