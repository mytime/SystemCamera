package com.jikexueyuan.systemcamera;

import android.content.Intent;
import android.graphics.Bitmap;
import android.media.Image;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private static final int TAKE_CAPTURE = 1;
    private Button btnCamera;
    private ImageView ivCamera;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnCamera = (Button) findViewById(R.id.btnCamera);
        ivCamera = (ImageView) findViewById(R.id.ivCamera);

        btnCamera.setOnClickListener(this);
    }



    @Override
    public void onClick(View v) {
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE); //图片扑获
        startActivityForResult(intent,TAKE_CAPTURE);// 意图，返回码；
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode ==RESULT_OK){
            if ( requestCode == TAKE_CAPTURE){
                if (data != null){
                    if (data.hasExtra("data")){ //intent-> key(data):value(bitmap)
                        Bitmap bitmap = data.getParcelableExtra("data");
                        ivCamera.setImageBitmap(bitmap);//设置ImageView显示的图片

                    }
                }
            }
        }
    }
}













