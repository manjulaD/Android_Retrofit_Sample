package com.example.manjula.networkdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import retrofit.Call;
import retrofit.Callback;
import retrofit.GsonConverterFactory;
import retrofit.Response;
import retrofit.Retrofit;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        setProgressBarIndeterminateVisibility(true);
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://rest-service.guides.spring.io")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        // prepare call in Retrofit 2.0
        GreetingAPI stackOverflowAPI = retrofit.create(GreetingAPI.class);

        Call<Greeting> call = stackOverflowAPI.getGreeting("android");
        //asynchronous call
        call.enqueue(new Callback<Greeting>() {
            @Override
            public void onResponse(Response<Greeting> response, Retrofit retrofit) {
                TextView textView= (TextView) findViewById(R.id.greetId);
                textView.setText(""+((Greeting)response.body()).getId());
            }

            @Override
            public void onFailure(Throwable t) {

            }
        });
    }


}
