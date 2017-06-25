package com.sfsj.asus.demotest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;

//修改样式 使之自定义 两个选项卡 并且写出布局
//api23以后 谷歌强制使用这个AppCompatActivity
public class MainActivity extends AppCompatActivity {
    private Toolbar toolbar;
    private TitleBar toolbar1;
    private ImageView imageView2;
    private Boolean aBoolean=true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //去掉了 然后设置上头的布局 写代码  必须声明静态
      //  ActionBar.initActionBar(MainActivity.this);
   //     initActionBar();
   //     setButtonPress();
        toolbar1 = (TitleBar) findViewById(R.id.title_bar);
        final ImageView imageView= (ImageView) findViewById(R.id.left_image);

           imageView.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View view) {
                   if(aBoolean){
                       toolbar1.setTitle("title change AAAAA");
                       imageView2.setImageResource(R.mipmap.left_icon);
                       aBoolean=false;//执行完以后
                   }else {
                       toolbar1.setTitle("title change BBBBB");
                       imageView2.setImageResource(R.mipmap.right_icon);
                   }

               }
           });

        imageView2 = (ImageView) findViewById(R.id.right_image);
        imageView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(aBoolean){
                    toolbar1.setTitle("title change   AAAAAAA");
                    imageView.setImageResource(R.mipmap.right_icon);
                    aBoolean=false;
                }else {
                    toolbar1.setTitle("title change   BBBBB");
                    imageView.setImageResource(R.mipmap.left_icon);
                    aBoolean=true;
                }

            }
        });
    }
    private void setButtonPress() {
        toolbar.setNavigationIcon(R.mipmap.ic_launcher);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void initActionBar() {
        toolbar = (Toolbar) findViewById(R.id.toobar_self);
/*        toolbar.setTitle("liyuanjinglyi");
        toolbar.setLogo(R.mipmap.ic_launcher);*/
            setSupportActionBar(toolbar);
    }


}
