package com.example.aruuke_rakhmanova_hw06;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText username = findViewById(R.id.edd1);
        EditText password = findViewById(R.id.edd2);
        Button button = findViewById(R.id.edd3);
        TextView tv1 = findViewById(R.id.vhod);
        TextView welcome = findViewById(R.id.welcome);
        TextView tv3 = findViewById(R.id.op);
        TextView tv4 = findViewById(R.id.zp);
        TextView tv5 = findViewById(R.id.z6);

        TextWatcher textWatcher = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (username.getText().length() > 0 && password.getText().length() > 0) {
                    button.setBackgroundResource(R.drawable.ed4);
                } else {
                    button.setBackgroundResource(R.drawable.ed3);
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {
            }
        };

        username.addTextChangedListener(textWatcher);
        password.addTextChangedListener(textWatcher);

        button.setOnClickListener(v -> {
            String userText = username.getText().toString();
            String passText = password.getText().toString();
            if ("admin".equals(userText) && "admin".equals(passText)) {
                Toast.makeText(this, "Вы успешно зарегистрировались", Toast.LENGTH_SHORT).show();
                welcome.setText("Добро пожаловать, " + userText + "!");
                welcome.setVisibility(View.VISIBLE);
                tv3.setVisibility(View.GONE);
                tv1.setVisibility(View.GONE);
                tv4.setVisibility(View.GONE);
                tv5.setVisibility(View.GONE);
                username.setVisibility(View.GONE);
                password.setVisibility(View.GONE);
                button.setVisibility(View.GONE);
            } else {
                Toast.makeText(this, "Неправильный логин или пароль", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
