package com.example.derezing.myapplicationend;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class RecyclerViewActivity extends AppCompatActivity {
    RecyclerView mRecyclerView;
    RecTestAdapter mAdapter;
//    ImageView mBack;
//    TextView mTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_recycler_view );
        initView();//初始化所有view
        setRec();
    }
    private void initView() {
        mRecyclerView = findViewById( R.id.rec_status_list );
//        mBack = findViewById(  )
//        mBack.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                finish();
//            }
//        });
    }
    private void setRec() {
        mAdapter = new RecTestAdapter();
        mAdapter.setData(generateData(10));//给adapter设置数据
        mRecyclerView.setAdapter(mAdapter);//给mRecyclerView设置adapter
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        //给mRecyclerView设置LayoutManager
    }
    //xjb随机生成一个数据列表
    @SuppressLint("ResourceType")
    private List<Status> generateData(int size) {
        List<Status> data = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            Status status = new Status();
            if (i%2==0){
                status.setHeadPortraitResId(R.drawable.ic_head_girl1);
                status.setName("万事通");
                status.setContent(getString(R.id.tv_main_body));
                status.setTitle("实锤了！");
            }

            else {
                status.setHeadPortraitResId( R.drawable.ic_head_boy1);
                status.setName("壮实家狍子");
                status.setContent(getString(R.id.tv_main_body));
                status.setTitle("点击下方领取现金红包，先到先得哟！");
            }
            status.setUpdateTime("更新于"+new Date().toString().substring(0,19));
            data.add(status);
        }
        return data;
    }
}
