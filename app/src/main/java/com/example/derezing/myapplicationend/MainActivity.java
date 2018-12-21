package com.example.derezing.myapplicationend;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

//    TextView responseText;//

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );
        initView();

//        setContentView( R.layout.activity_http_connect );//
//        Button sendRequest = findViewById( R.id.btn_send_request );
//        responseText = findViewById( R.id.tv_response );
//        sendRequest.setOnClickListener(this);
    }

    private void initView() {
        ImageButton homePage = findViewById( R.id.home_page_img );
        ImageButton notificaction = findViewById( R.id.notification_img );
        ImageButton circle = findViewById( R.id.circle_img );
        ImageButton personalCenter = findViewById( R.id.personal_center_img );

        homePage.setOnClickListener(this);
        notificaction.setOnClickListener(this);
        circle.setOnClickListener(this);
        personalCenter.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.home_page_img:
                startActivity(new Intent(MainActivity.this,HttpConnectActivity.class));
                break;
            case R.id.notification_img:
                startActivity(new Intent(MainActivity.this,RecyclerViewActivity.class));
                break;
            case R.id.circle_img:
                startActivity(new Intent(MainActivity.this, RecyclerViewActivity.class));
                break;
            case R.id.personal_center_img:
                startActivity(new Intent(MainActivity.this, RecyclerViewActivity.class));
                break;
        }

//        if(v.getId() == R.id.btn_send_request){
//            sendRequestWithHttpURLConnection();
//        }
//    }
//
//    private void sendRequestWithHttpURLConnection() {
//        //开启线程来发起网络请求
//        new Thread( new Runnable() {
//            @Override
//            public void run() {
//                HttpURLConnection connection = null;
//                BufferedReader reader = null;
//                try{
//                    URL url = new URL("http://www.apiopen.top/novelSearchApi?name");
////                    URL url = new URL("http://www.baidu.com");
//                    connection = (HttpURLConnection) url.openConnection();
//                    connection.setRequestMethod( "GET" );
//                    connection.setReadTimeout( 8000 );
//                    InputStream in = connection.getInputStream();
//                    //下面对获取到的输入流进行读取
//                    reader = new BufferedReader( new InputStreamReader( in ) );
//                    StringBuilder response = new StringBuilder(  );
//                    String line;
//                    while((line = reader.readLine()) != null){
//                        response.append( line );
//                    }
//                    showResponse(response.toString());
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }finally {
//                    if(reader!=null){
//                        try {
//                            reader.close();
//                        } catch (IOException e) {
//                            e.printStackTrace();
//                        }
//                    }
//                    if(connection != null){
//                        connection.disconnect();
//                    }
//                }
//            }
//        } ).start();
//    }
//    private void showResponse(final String response){
//        runOnUiThread( new Runnable() {
//            @Override
//            public void run() {
//                //在这里进行UI操作
//                responseText.setText(response);
//            }
//        } );
    }
}
