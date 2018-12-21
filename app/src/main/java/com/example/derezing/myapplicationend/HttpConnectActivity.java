package com.example.derezing.myapplicationend;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpConnectActivity extends AppCompatActivity implements View.OnClickListener {
    TextView responseText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_http_connect );
        Button sendRequest = findViewById( R.id.btn_send_request );
        responseText = findViewById( R.id.tv_response );
        sendRequest.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.btn_send_request){
            sendRequestWithHttpURLConnection();
        }
    }

    private void sendRequestWithHttpURLConnection() {
        //开启线程来发起网络请求
        new Thread( new Runnable() {
            @Override
            public void run() {
                HttpURLConnection connection = null;
                BufferedReader reader = null;
                try{
//                    URL url = new URL("http://www.apiopen.top/novelSesrchApi?name");
                    URL url = new URL("http://www.baidu.com");
                    connection = (HttpURLConnection) url.openConnection();
                    connection.setRequestMethod( "GET" );
                    connection.setReadTimeout( 8000 );
                    connection.setReadTimeout(6000);//读取超时时间
                    InputStream in = connection.getInputStream();
                    //下面对获取到的输入流进行读取
                    reader = new BufferedReader( new InputStreamReader( in ) );
                    StringBuilder response = new StringBuilder(  );
                    String line;
                    while((line = reader.readLine()) != null){
                        response.append( line );
                    }
                    showResponse(response.toString());
                } catch (Exception e) {
                    e.printStackTrace();
                }finally {
                    if(reader!=null){
                        try {
                            reader.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                    if(connection != null){
                        connection.disconnect();
                    }
                }
            }
        } ).start();
    }
    private void showResponse(final String response){
        runOnUiThread( new Runnable() {
            @Override
            public void run() {
                //在这里进行UI操作

                responseText.setText(response);
            }
        } );
    }
}
