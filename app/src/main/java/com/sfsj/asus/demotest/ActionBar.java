package com.sfsj.asus.demotest;

import android.support.v7.widget.Toolbar;

/**
 * Created by ${zhangxiaocong} on 2017/6/25.
 */

public class ActionBar {
    public ActionBar() {
    }
    //方法接收参数context 可以任何时候使用 用于工具类 类似于C语言
    public static void initActionBar(MainActivity mainActivity) {
        Toolbar toolbar= (Toolbar) mainActivity.findViewById(R.id.toobar_self);
     //   toolbar.addView(new TextView(mainActivity, Gravity.CENTER));
        mainActivity.setTitle("你好 我是一个菜鸟");
        mainActivity.setSupportActionBar(toolbar);
    }
    //非静态方法自能创建对象使用 用于对象使用 真正的面向对象编程

}
