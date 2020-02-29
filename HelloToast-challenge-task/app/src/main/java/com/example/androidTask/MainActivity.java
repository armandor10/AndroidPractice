package com.example.androidTask;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Button;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
    private int mCount = 0;
    private TextView mShowCount;
    private Button btn;
    private int violetColor = Color.parseColor("#ff00ff");
    private int greenColor = Color.parseColor("#00ff00");
    private int defaultColor = Color.parseColor("#0000ff");
    private boolean isCounting = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mShowCount = findViewById(R.id.show_count);
    }

    public void showToast(View view) {
        Toast toast = Toast.makeText(this, R.string.toast_message,
                Toast.LENGTH_SHORT);
        toast.show();
    }

    public void countUp(View view) {
        ++mCount;
        if (mShowCount != null) {
            isCounting = true;
            // Enable zeroButton
            btn = findViewById(R.id.button_zero);
            btn.setBackgroundColor(violetColor);

            mShowCount.setText(Integer.toString(mCount));
            if( mCount % 2 == 0 )
                view.setBackgroundColor(greenColor);
            else
                view.setBackgroundColor(defaultColor);
        }
    }

    public void setZero(View view) {
        if(isCounting){
            mShowCount.setText("0");
            isCounting = false;
            btn.setBackgroundColor(Color.GRAY);
            mCount = 0;
        }
    }
}
