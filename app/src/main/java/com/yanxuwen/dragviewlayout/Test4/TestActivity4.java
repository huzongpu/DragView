package com.yanxuwen.dragviewlayout.Test4;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.FloatRange;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;
import com.bumptech.glide.request.RequestOptions;
import com.yanxuwen.dragview.DragViewActivity;
import com.yanxuwen.dragview.DragViewUtil;
import com.yanxuwen.dragview.ImgFragment;
import com.yanxuwen.dragview.StatusBarUtils;
import com.yanxuwen.dragviewlayout.R;
import com.yanxuwen.dragviewlayout.Test1.MyFragment;

import java.util.ArrayList;

public class TestActivity4 extends Activity {
    public ImageView v1;
    final ArrayList<View> views = new ArrayList<>();
    final ArrayList<Object> listdata = new ArrayList<>();
    final ArrayList<Class> listfragemnt = new ArrayList<>();
    private View view_test3;
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test3);
        context = this;
        //非全屏界面，由于跳转到DragViewActivity会隐藏状态栏，然后返回的时候要显示状态栏，就但是整体界面会下滑，所以要调用下面
        StatusBarUtils.setStatusBar(this, R.color.colorPrimary);
        v1 = (ImageView) findViewById(R.id.image);
        views.add(v1);
        views.add(v1);
        views.add(v1);
        views.add(v1);


        listfragemnt.add(MyFragment.class);
        listfragemnt.add(MyFragment.class);
        listfragemnt.add(MyFragment.class);
        listfragemnt.add(MyFragment.class);
        listdata.add("http://img44.photophoto.cn/20170728/0847085729043617_s.jpg");
        listdata.add("http://img44.photophoto.cn/20170729/0847085786392651_s.jpg");
        listdata.add("http://img44.photophoto.cn/20170728/0847085761440022_s.jpg");
        listdata.add("http://img44.photophoto.cn/20170727/0847085275244570_s.jpg");


        v1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //open(views,listdata);
                DragViewUtil.showImgs(TestActivity4.this, 0, views, listdata);
            }
        });
        RequestOptions options3 = new RequestOptions()
                .centerCrop()
                .priority(Priority.HIGH);
        Glide.with(context).load("http://img44.photophoto.cn/20170728/0847085729043617_s.jpg").transition(DrawableTransitionOptions.withCrossFade()).apply(options3).into(v1);

    }

    public void open() {

        DragViewActivity.startActivity(this, 0, new DragViewActivity.OnDataListener() {
            TextView text_abstract = null;

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
                if (position == 0 && listdata.size() < 3) {
                    //更加数据
                    listdata.add("sdsds3");
                    listdata.add("sdsds4");
                    views.add(v1);
                    views.add(v1);
                    listfragemnt.add(MyFragment.class);
                    listfragemnt.add(MyFragment.class);
                    DragViewActivity.getInstance(TestActivity4.this).notifyDataSetChanged();
                }
                if (text_abstract != null) {
                    text_abstract.setText((position + 1) + "/" + 3 + " 从第一张照片XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
                }

            }

            @Override
            public boolean onBackPressed() {
                return true;
            }

            @Override
            public void init() {
                if (view_test3 == null) {
                    view_test3 = getLayoutInflater().inflate(R.layout.view_test3, null);
                    DragViewActivity.getInstance(context).getDragViewLayout().addView(view_test3);
                    text_abstract = (TextView) view_test3.findViewById(R.id.text);
                    DragViewActivity.getInstance(context).setOnDrawerOffsetListener(new DragViewActivity.OnDrawerOffsetListener() {
                        @Override
                        public void onDrawerOffset(@FloatRange(from = 0, to = 1) float offset) {
                            text_abstract.setAlpha(offset - 0.3f);
                            if (offset == 0) {
                                view_test3 = null;
                            }
                        }
                    });
                }
            }
        });
    }

    public void open(final ArrayList<View> views, final ArrayList<Object> listdata, final ArrayList<Class> listfragemnt) {

        DragViewActivity.startActivity(this, 0, new DragViewActivity.OnDataListener() {
            TextView text_abstract = null;

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
                if (position == 0 && listdata.size() < 3) {
                    //更加数据
                    listdata.add("sdsds3");
                    listdata.add("sdsds4");
                    views.add(v1);
                    views.add(v1);
                    listfragemnt.add(MyFragment.class);
                    listfragemnt.add(MyFragment.class);
                    DragViewActivity.getInstance(TestActivity4.this).notifyDataSetChanged();
                }
                if (text_abstract != null) {
                    text_abstract.setText((position + 1) + "/" + 3 + " 从第一张照片XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
                }

            }

            @Override
            public boolean onBackPressed() {
                return true;
            }

            @Override
            public void init() {
                if (view_test3 == null) {
                    view_test3 = getLayoutInflater().inflate(R.layout.view_test3, null);
                    DragViewActivity.getInstance(context).getDragViewLayout().addView(view_test3);
                    text_abstract = (TextView) view_test3.findViewById(R.id.text);
                    DragViewActivity.getInstance(context).setOnDrawerOffsetListener(new DragViewActivity.OnDrawerOffsetListener() {
                        @Override
                        public void onDrawerOffset(@FloatRange(from = 0, to = 1) float offset) {
                            text_abstract.setAlpha(offset - 0.3f);
                            if (offset == 0) {
                                view_test3 = null;
                            }
                        }
                    });
                }
            }
        });
    }

    public void open(final ArrayList<View> views, final ArrayList<Object> listdata) {
        final ArrayList<Class> listfragemnt = new ArrayList<>();

        for (int i = 0; i < listdata.size(); i++) {
            listfragemnt.add(ImgFragment.class);
        }

        DragViewActivity.startActivity(this, 0, new DragViewActivity.OnDataListener() {
            private TextView tv_index = null;
            private ImageView tb_backiv = null;
            private View view_preview = null;

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
                if (tv_index != null) {
                    tv_index.setText((position + 1) + "/" + listdata.size());
                }

            }

            @Override
            public boolean onBackPressed() {
                return true;
            }

            @Override
            public void init() {
                if (view_preview == null) {
                    view_preview = getLayoutInflater().inflate(R.layout.view_preview, null);
                    DragViewActivity.getInstance(context).getDragViewLayout().addView(view_preview);
                    tv_index = view_preview.findViewById(R.id.tv_index);
                    tb_backiv = view_preview.findViewById(R.id.tb_backiv);
                    tb_backiv.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            DragViewActivity.getInstance(context).onBackPressed();
                        }
                    });
                    DragViewActivity.getInstance(context).setOnDrawerOffsetListener(new DragViewActivity.OnDrawerOffsetListener() {
                        @Override
                        public void onDrawerOffset(@FloatRange(from = 0, to = 1) float offset) {
                            tv_index.setAlpha(offset);
                            tb_backiv.setAlpha(offset);
                            if (offset == 0) {
                                view_preview = null;
                            }
                        }
                    });
                }
            }
        });
    }
}
