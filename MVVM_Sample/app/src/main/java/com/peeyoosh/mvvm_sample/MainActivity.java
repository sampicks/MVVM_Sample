package com.peeyoosh.mvvm_sample;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Toast;

import com.peeyoosh.mvvm_sample.models.GreetMessage;
import com.peeyoosh.mvvm_sample.viewmodel.GreetViewModel;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";

    // ui components
    private TextInputEditText etTime;
    private TextInputEditText etMessage;
    // viewmodel
    private GreetViewModel greetViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();
    }

    private void initViews() {
        etTime = findViewById(R.id.tiet_time);
        etMessage = findViewById(R.id.tiet_message);

        greetViewModel = ViewModelProviders.of(this).get(GreetViewModel.class);
        subsribeObservers();

        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String msg = etMessage.getText().toString();
                if (!TextUtils.isEmpty(msg) && TextUtils.isDigitsOnly(etTime.getText())) {
                    int time = Integer.parseInt(etTime.getText().toString());
                    greetViewModel.doGreetRequest(time, msg);
                } else
                    Toast.makeText(MainActivity.this, getString(R.string.pls_provide_values), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void subsribeObservers() {
        greetViewModel.getMessage().observe(this, new Observer<GreetMessage>() {
            @Override
            public void onChanged(@Nullable GreetMessage greetMessage) {
                Toast.makeText(MainActivity.this, greetMessage.getMessage(), greetMessage.getTimeDuration() * 1000).show();
            }
        });
    }
}
