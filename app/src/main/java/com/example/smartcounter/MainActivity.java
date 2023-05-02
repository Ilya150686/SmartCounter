package com.example.smartcounter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private TextView textCount;
    private Button button;
    private int count = 0;

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {

        // Save UI state changes to the savedInstanceState.
        // This bundle will be passed to onCreate if the process is
        // killed and restarted.

        savedInstanceState.putBoolean("MyBoolean", true);
        savedInstanceState.putDouble("myDouble", 1.9);
        savedInstanceState.putInt("MyInt", 1);
        savedInstanceState.putString("MyString", "Welcome back to Android");

        super.onSaveInstanceState(savedInstanceState);
    }
    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState) {

        super.onRestoreInstanceState(savedInstanceState);

        boolean myBoolean = savedInstanceState.getBoolean("MyBoolean");
        double myDouble = savedInstanceState.getDouble("myDouble");
        int myInt = savedInstanceState.getInt("MyInt");
        String myString = savedInstanceState.getString("MyString");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textCount = findViewById(R.id.textCount);
        button = findViewById(R.id.button);

        button.setOnClickListener(listener);
    }
    private View.OnClickListener listener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            count++;
            textCount.setText(Integer.toString(count));
        }
    };

    @Override
    protected void onStart() {
        Toast toast = Toast.makeText(this, "Старт активности", Toast.LENGTH_SHORT);
        toast.show();
        super.onStart();
    }

    @Override
    protected void onStop() {
        Toast toast = Toast.makeText(this, "Стоп активности", Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.LEFT, 0,0);
        toast.show();
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        Toast toast = Toast.makeText(this, "Уничтожение активности", Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.BOTTOM, 0,0);
        toast.show();
        super.onDestroy();
    }

    @Override
    protected void onPause() {
        Toast toast = Toast.makeText(this, R.string.pause_activity, Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.TOP, 0,0);
        toast.show();
        super.onPause();
    }

    @Override
    protected void onResume() {
        Toast toast = Toast.makeText(this, R.string.resume_activity, Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.CENTER, 0,0);
        LinearLayout toastContainer = (LinearLayout) toast.getView();
        ImageView cat = new ImageView(this);
        cat.setImageResource(R.drawable.cat);
        toastContainer.addView(cat, 1);
        toast.show();
        super.onResume();
    }
}
