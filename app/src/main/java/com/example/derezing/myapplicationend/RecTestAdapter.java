package com.example.derezing.myapplicationend;

import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class RecTestAdapter extends RecyclerView.Adapter<RecTestAdapter.MyViewHolder> {
    private List <Status> mDataList = new ArrayList <>();

//    private Context mContext;
//    public RecTestAdapter(List<Status> mDataList,Context context) {
//        this.mDataList = mDataList;
//        mContext=context;
//    }


    //添加新的数据
    public void addNewData(List <Status> dataList) {
        mDataList.addAll( dataList );//把所有数据加入原列表
        notifyDataSetChanged();//告诉RecyclerView我数据更新了，赶快重新绘制
    }

    //直接设置数据
    public void setData(List <Status> dataList) {
        mDataList.clear();//清空原来的数据
        mDataList.addAll( dataList );//把新数据加入原列表
        notifyDataSetChanged();//告诉RecyclerView： 数据更新了
    }
    @NonNull
    @Override
    //为每个 单位布局 创建ViewHolder
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from( viewGroup.getContext() ).inflate( R.layout.activity_recycler_view, viewGroup, false );
        MyViewHolder holder = new MyViewHolder( itemView );
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {

        Status status = mDataList.get( i );
        myViewHolder.headPortrait.setImageResource(status.getHeadPortraitResId());
        myViewHolder.name.setText(status.getNameResId());
        myViewHolder.title.setText(status.getTitle());
        myViewHolder.content.setText(status.getContent());
        myViewHolder.updateTime.setText(status.getUpdateTime());

//        myViewHolder.title.setText(mDataList.get(i).getTitle());
//        Glide.with(mContext).load(mDataList.get(i).getContent()).into(myViewHolder.imageView);
    }

    @Override
    public int getItemCount() {
        return mDataList.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{
//        ImageView imageView;

        CardView rootView;
        ImageView headPortrait;
        TextView name;
        TextView title;
        TextView content;
        TextView updateTime;

        public MyViewHolder(@NonNull View itemView) {
            super( itemView );
            rootView = (CardView) itemView;
            headPortrait = itemView.findViewById(R.id.head_portrait);
            name = itemView.findViewById(R.id.tv_name);
            title = itemView.findViewById(R.id.tv_title);
            content = itemView.findViewById(R.id.tv_main_body);
            updateTime = itemView.findViewById(R.id.tv_update);
        }
    }
}
