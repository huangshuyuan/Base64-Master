package basetest.hsy.com.base64demo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.hsy.base64.Base64Utils;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void unBase64(View view) {
        Base64Utils.generateImage("解码");
    }

    public void base64(View view) {
        Base64Utils.getImageToBase64("path");
    }
}
