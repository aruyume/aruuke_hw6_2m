package com.example.aruuke_rakhmanova_hw06;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.example.aruuke_rakhmanova_hw06.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        TextWatcher textWatcher = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (binding.etEmail.getText().length() > 0 && binding.etPassword.getText().length() > 0) {
                    binding.btnSignIn.setBackgroundResource(R.drawable.bg_btn_orange);
                } else {
                    binding.btnSignIn.setBackgroundResource(R.drawable.bg_btn_gray);
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {
            }
        };
        binding.etEmail.addTextChangedListener(textWatcher);
        binding.etPassword.addTextChangedListener(textWatcher);

        binding.btnSignIn.setOnClickListener(v -> {
            String username = binding.etEmail.getText().toString();
            String password = binding.etPassword.getText().toString();
            if ("admin".equals(username) && "admin".equals(password)) {
                Toast.makeText(this, "Вы успешно зарегистрировались", Toast.LENGTH_SHORT).show();
                binding.tvWelcome.setText("Добро пожаловать, " + username + "!");

                binding.tvWelcome.setVisibility(View.VISIBLE);
                binding.tvDescription.setVisibility(View.GONE);
                binding.tvForgotPassword.setVisibility(View.GONE);
                binding.tvTapHere.setVisibility(View.GONE);
                binding.tvEnter.setVisibility(View.GONE);
                binding.etEmail.setVisibility(View.GONE);
                binding.etPassword.setVisibility(View.GONE);
                binding.btnSignIn.setVisibility(View.GONE);

            } else {
                Toast.makeText(this, "Неправильный логин или пароль", Toast.LENGTH_SHORT).show();
            }
        });
    }
}