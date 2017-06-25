package com.sfsj.asus.demotest;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * Created by ${zhangxiaocong} on 2017/6/25.
 */
//自定义View
public class TitleBar extends RelativeLayout {
    public TitleBar(Context context) {
        this(context,null);
    }
//传入xml布局参数 在这里进行设置
    public TitleBar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context,attrs);
    }

    public TitleBar(Context context, AttributeSet attrs) {
       // super(context, attrs);
        this(context,attrs,0);//调用上面的
    }
//我们写了一个布局 来使用我们的自定义title bar
    private RelativeLayout leftlayout;
    private ImageView leftImage;
    private RelativeLayout rightLayout;
    private ImageView rightImage;
    private TextView titleView;
    private RelativeLayout rootLayout;

//初始化 先加载这个类
    private void init(Context context, AttributeSet attrs){
        //需要参数
        LayoutInflater.from(context).inflate(R.layout.title_bar,this);
        leftlayout = (RelativeLayout) findViewById(R.id.left_layout);
        leftImage = (ImageView) findViewById(R.id.left_image);
        rightLayout = (RelativeLayout) findViewById(R.id.right_layout);
        rightImage = (ImageView) findViewById(R.id.right_image);
        titleView = (TextView) findViewById(R.id.title);
        rootLayout = (RelativeLayout) findViewById(R.id.root);
//        通过attrs设置相关属性
        setStyle(context,attrs);
    }

    private void setStyle(Context context, AttributeSet attrs) {
        if (attrs != null){
            TypedArray array = context.obtainStyledAttributes(attrs,R.styleable.TitleBar);
//            获取title
            String title = array.getString(R.styleable.TitleBar_titleBar_title);
            titleView.setText(title);
//            获取左侧图片
            Drawable lDrawable = array.getDrawable(R.styleable.TitleBar_titleBar_left_image);
            if (lDrawable != null){
                leftImage.setImageDrawable(lDrawable);
            }
//            获取右侧图片
            Drawable rDrawable = array.getDrawable(R.styleable.TitleBar_titleBar_right_image);
            if (rDrawable != null){
                rightImage.setImageDrawable(rDrawable);
            }
//            获取背景图片
            Drawable bgDrawable = array.getDrawable(R.styleable.TitleBar_titleBar_background);
            if (bgDrawable != null){
                rootLayout.setBackgroundDrawable(bgDrawable);
            }

            array.recycle();
        }
    }
    /*
    设置监听
     */
    public void setLeftlayoutClick(OnClickListener listenser){
        leftlayout.setOnClickListener(listenser);
    }
    //   右侧布局监听
    public void setRightLayoutClickListener(OnClickListener listener) {
        rightLayout.setOnClickListener(listener);
    }
    /*
    设置资源图片 备用 直接可替换
     */
    public void setLeftImageResource(int resId){
        leftImage.setImageResource(resId);
    }
    public void setRightImageResource(int resId){
        rightImage.setImageResource(resId);
    }
    /*
    设置中间的
     */
    public void setTitle(String title){
        titleView.setText(title);
    }
     /*
        设置背景
         */
    public void setBackgroundColor(int color){
        rootLayout.setBackgroundColor(color);
    }

}
