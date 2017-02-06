package com.jikexueyuan.guessnumber.guessnumber;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    //    初始化变量
    private EditText input;
    private TextView compare;
    private int randNum;
    //    计数变量
    int i = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //      为变量出入参数
        input = (EditText) findViewById(R.id.editText);
        compare = (TextView) findViewById(R.id.compare);
//      使用math方法获得随机数
        randNum = (int) (Math.random() * 100);

//        判断点击猜数案件后运行对比代码
        findViewById(R.id.check).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                将输入的数字赋值给ennter
                if (input.getText().toString().equals("")) {
                    compare.setText("未输入数字");
                } else {
                    int entered = Integer.valueOf(input.getText().toString());
//                根据enter与随机数大小对比反馈不同若未猜对i会增长
                    if (entered > randNum) {
                        compare.setText("太大了再猜猜！");
                        i++;
                    } else if (entered < randNum) {
                        compare.setText("太小了再猜猜！");
                        i++;
                    } else {
                        compare.setText("恭喜你在经过" + i + "次尝试后你猜对了");
                    }
                }
            }
        });

        findViewById(R.id.reset).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                重新获取随机数
                randNum = (int) (Math.random() * 100);
//                重置计数参数
                i = 1;
                compare.setText("数字已重置请重新猜测");
            }
        });
    }

}