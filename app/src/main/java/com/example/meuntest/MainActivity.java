package com.example.meuntest;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    //定义“字体大小”的菜单项标识-设置一个菜单表项的标识id
    private static final int FONT_10 = 0x111;
    private static final int FONT_12 = 0x112;
    private static final int FONT_14 = 0x113;
    private static final int FONT_16 = 0x114;
    private static final int FONT_18 = 0x115;
    //定义普通菜单项的标识
    private static final int PLAIN_ITEM = 0x11b;
    //定义“字体颜色”菜单项的标识
    private static final int FONT_RED = 0x116;
    private static final int FONT_BLUE = 0x117;
    private static final int FONT_GReen = 0x118;

    //
    private TextView textView;

    //popupMenu
    private PopupMenu popupMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.text);
        //创建一个button启动使用Xml构造菜单的Activity
        Button buttonXml = findViewById(R.id.buttonXml);
        buttonXml.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,newActivity.class);
                startActivity(intent);
            }
        });
        //重写onCreateOptionsMenu方法，当用户点击MENU按键时触发该方法
        Button popumenuButton = findViewById(R.id.PopupMenu);
        //创建PopupMenu对象
        popupMenu = new PopupMenu(MainActivity.this,popumenuButton);
        //将R.id.popupmenu菜单资源加载到Popup菜单中
        getMenuInflater().inflate(R.menu.menu_main,popupMenu.getMenu());
        popumenuButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this,"fahdfa",Toast.LENGTH_SHORT).show();
                popupMenu.show();
            }
        });
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //添加“”字体大小“的子菜单
        SubMenu fontMenu = menu.addSubMenu("字体大小");
        //设置菜单的图片
        fontMenu.setIcon(R.drawable.font);
        //设置菜单头的图标
        fontMenu.setHeaderIcon(R.drawable.font);
        //设置菜单头的标题
        fontMenu.setHeaderTitle("选择字体大小");
        //方法说明add(int groupId, int itemId, int order, CharSequence title);
        fontMenu.add(0,FONT_10,0,"10号字体大小");
        fontMenu.add(0,FONT_12,0,"12号字体大小");
        fontMenu.add(0,FONT_14,0,"14号字体大小");
        fontMenu.add(0,FONT_16,0,"16号字体大小");
        fontMenu.add(0,FONT_18,0,"18号字体大小");
        //向Menu中添加一个普通的菜单项
        menu.add(2,PLAIN_ITEM,0,"普通菜单项");
        //向Menu中添加“字体颜色”的子表项
        SubMenu colorMenu = menu.addSubMenu("字体颜色");
        colorMenu.setIcon(R.drawable.color);
        //设置菜单头的图标
        colorMenu.setHeaderIcon(R.drawable.color);
        colorMenu.setHeaderTitle("选择字体颜色");
        colorMenu.add(1,FONT_RED,0,"红色");
        colorMenu.add(1,FONT_GReen,0,"绿色");
        colorMenu.add(1,FONT_BLUE,0,"蓝色");
        //设置group1的菜单项为可勾选
        //colorMenu.setGroupCheckable(1,true,true);
        //设置group2的菜单项为可勾选
        //menu.setGroupCheckable(2,true,false);

        //使用菜单项启动一个新的activity
        SubMenu turnToActivity = menu.addSubMenu("跳转activity");
        //设置菜单头的图标
        //turnToActivity.setHeaderIcon(R.drawable.font);
        turnToActivity.setHeaderTitle("选择activity");
        MenuItem item = turnToActivity.add(3,0x11c,0,"查看hhh");
        /*Intent intent = new Intent(MainActivity.this,newActivity.class);
        item.setIntent(intent);   */




        return super.onCreateOptionsMenu(menu);
    }
    //重写菜单被点击的回调的方法

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case FONT_10: textView.setTextSize(10 * 2);break;
            case FONT_12: textView.setTextSize(12 * 2);break;
            case FONT_14: textView.setTextSize(14 * 2);break;
            case FONT_16: textView.setTextSize(16 * 2);break;
            case FONT_18: textView.setTextSize(18 * 2);break;
            case FONT_RED: textView.setTextColor(Color.RED);break;
            case FONT_BLUE: textView.setTextColor(Color.BLUE);break;
            case FONT_GReen: textView.setTextColor(Color.GREEN);break;
            case PLAIN_ITEM:
                Toast.makeText(MainActivity.this,"您点击了普通菜单按钮",Toast.LENGTH_SHORT).show();
                break;
            case 0x11c:
                Intent intent = new Intent(MainActivity.this,newActivity.class);
                startActivity(intent);
                break;
        }
        return true;
    }
}
