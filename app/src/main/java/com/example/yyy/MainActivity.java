package com.example.yyy;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

//AS的根文件
public class MainActivity extends AppCompatActivity {
    private  EditText etDlgNumber;
    private  EditText etDlgCode;
    private Button btnDlgSubmit;
    private AlertDialog dlg;

    //提交按钮的点击事件
    public View.OnClickListener listener=new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            String number = etDlgNumber.getText().toString();
            String code = etDlgCode.getText().toString();
            //关掉对话框
            dlg.dismiss();
            Log.i("DEMO#", number + "," + code);//输入信息打印到日志里

        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //R.layout R类里面的一个布局文件
        //activity_main引用的一个布局资源
        //      activity_main引用的名字
       // setContentView(R.layout.active_linear3);
        setContentView(R.layout.activity_login);
        findViewById(R.id.btnLogin1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                attemptLogin();
            }
        });

        //验证码处理框的点击事件
        findViewById(R.id.tvCode).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popupDialog();
            }
        });



    }

    //显示验证码对话框
    private void popupDialog(){
        //生成一个布局填充器对象
        LayoutInflater inflater = LayoutInflater.from(this);
        //加载视图文件生成View对象

        View view = inflater.inflate(R.layout.code_layout,null);
        etDlgNumber=view.findViewById(R.id.etNumber);
        etDlgCode=view.findViewById(R.id.etCode);
        btnDlgSubmit=view.findViewById(R.id.btnSubmit);
        btnDlgSubmit.setOnClickListener(listener);

        //通过这样一连串创建对话框
        //这样写是为了保存之后再关掉
        AlertDialog.Builder builder =new AlertDialog.Builder(this)
                .setView(view);
            dlg=builder.create();
            dlg.show();
    }



    private void attemptLogin(){//登陆按钮点击事件处理函数
        EditText etName = findViewById(R.id.etName);
        EditText etPassword1  = findViewById(R.id.etPassword1);
        CheckBox cbRemember = findViewById(R.id.cbRemember);
        RadioGroup rgSex= findViewById(R.id.rgSex);

        String name = etName.getText().toString();//获得第一个编辑框里的文本内容
        String password = etPassword1.getText().toString();
        boolean isChecked = cbRemember.isChecked();

        int rbId = rgSex.getCheckedRadioButtonId();
        String sex = "";
        switch (rbId){
            case R.id.rbFeMan:
                 sex="男";
                 break;
            case R.id.rbFeMale:
                 sex="女";
                 break;
        }
        Log.i("DEMO#","欢迎登陆"+name+" "+password+" "+isChecked+" "+sex);//输入信息打印到日志里
    }


        //模拟登录
    public void handleClick(View v){
        EditText etAccount=findViewById(R.id.etAccount);//通过配置文件找到对应文件的输入框id
        EditText etPassword=findViewById(R.id.etPassword);
        String account=etAccount.getText().toString();//获取编辑框的内容
        String password=etPassword.getText().toString();
        //弹出消息框 这个类的静态方法
        Toast.makeText(this,"欢迎您",Toast.LENGTH_LONG).show();
    }
}