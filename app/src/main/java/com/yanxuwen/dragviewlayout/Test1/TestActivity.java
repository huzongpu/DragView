package com.yanxuwen.dragviewlayout.Test1;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

import com.yanxuwen.dragview.DragViewActivity;
import com.yanxuwen.dragview.StatusBarUtils;
import com.yanxuwen.dragviewlayout.R;

import java.util.ArrayList;

public class TestActivity extends Activity {
    public View v1;
    public View v2;
    final ArrayList<View> views=new ArrayList<>();
    final ArrayList<Object> listdata=new ArrayList<>();
    final ArrayList<Class> listfragemnt=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        //非全屏界面，由于跳转到DragViewActivity会隐藏状态栏，然后返回的时候要显示状态栏，就但是整体界面会下滑，所以要调用下面
        StatusBarUtils.setStatusBar(this,R.color.colorPrimary);
        v1=findViewById(R.id.text);
        v2=findViewById(R.id.text2);
        views.add(v1);
        views.add(v2);
        listfragemnt.add(MyFragment.class);
        listfragemnt.add(MyFragment.class);

        listdata.add("sdsds1");
        listdata.add("sdsds2");
        v1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                open(0);
            }
        });

        v2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                open(1);
            }
        });

    }
    public void open(int position){
        DragViewActivity.startActivity(this,position,new DragViewActivity.OnDataListener() {
            @Override
            public ArrayList<View> getListView() {
                return views;
            }
            @Override
            public ArrayList<Object> getListData() {
                return listdata;
            }
            @Override
            public ArrayList<Class> getListFragmentClass() {
                return listfragemnt;
            }
            @Override
            public void onPageSelected(int position) {
                if(position==1&&listdata.size()<4) {
                    //更加数据
                    listdata.add("sdsds3");
                    listdata.add("sdsds4");
                    views.add(v1);
                    views.add(v2);
                    listfragemnt.add(MyFragment.class);
                    listfragemnt.add(MyFragment.class);
                    DragViewActivity.getInstance(TestActivity.this).notifyDataSetChanged();
                }
            }
            @Override
            public boolean onBackPressed() {
                return false;
            }

            @Override
            public void init() {}
        });
    }
}
