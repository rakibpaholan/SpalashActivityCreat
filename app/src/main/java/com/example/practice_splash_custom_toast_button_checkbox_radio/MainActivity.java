package com.example.practice_splash_custom_toast_button_checkbox_radio;

import androidx.appcompat.app.AppCompatActivity;

import android.media.Rating;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button toastButton,checkButton,clickableRadioButton;
    private CheckBox milkCheckBox,saltCheckBox,sugarCheckBox;
    private TextView showProduct,showRadioButtonInfo,showRatingValue;
    private RadioGroup radioButtonGroupId;
    private RadioButton maleId,femaleId,genderButton;
    private RatingBar ratingBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        toastButton = (Button) findViewById(R.id.toastButton);
        toastButton.setOnClickListener(this);

        checkButton = (Button) findViewById(R.id.checkButton);
        checkButton.setOnClickListener(this);

        clickableRadioButton = (Button) findViewById(R.id.clickableRadioButton);
        clickableRadioButton.setOnClickListener(this);

        /*CheckBox View tools*/
        milkCheckBox = (CheckBox) findViewById(R.id.milkCheckBox);
        saltCheckBox = (CheckBox) findViewById(R.id.saltCheckBox);
        sugarCheckBox = (CheckBox) findViewById(R.id.sugarCheckBox);
        showProduct = (TextView) findViewById(R.id.showProduct);

        /*Radio Button View findOut*/
        showRadioButtonInfo = (TextView) findViewById(R.id.showRadioButtonInfo);
        radioButtonGroupId = (RadioGroup) findViewById(R.id.radioButtonGroupId);
        maleId = (RadioButton) findViewById(R.id.maleId);
        femaleId = (RadioButton) findViewById(R.id.femaleId);

        /*Rating Bar*/
        ratingBar = (RatingBar) findViewById(R.id.ratingBar);
        showRatingValue = (TextView) findViewById(R.id.showRatingValue);

        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float v, boolean b) {
             showRatingValue.setText("Rating Value is " + v);
            }
        });




    }



    @Override
    public void onClick(View v) {

        if (v.getId()==R.id.toastButton){
            toast_maker("toast");
        }
        if (v.getId()==R.id.checkButton){
            StringBuilder newStringBuilder = new StringBuilder();
            if (milkCheckBox.isChecked()) {
                String value = milkCheckBox.getText().toString();
                newStringBuilder.append(value+"is ordered"+"\n");
            }
            if (saltCheckBox.isChecked()) {
                String value = saltCheckBox.getText().toString();
                newStringBuilder.append(value+"is Ordered"+"\n");
            }
            if (sugarCheckBox.isChecked()) {
                String value = sugarCheckBox.getText().toString();
                newStringBuilder.append(value+"is ordered"+"\n");
            }
            showProduct.setText(newStringBuilder);
            toast_maker("button");
        }
        if (v.getId()==R.id.clickableRadioButton){

            int selectedId = radioButtonGroupId.getCheckedRadioButtonId();
            genderButton = (RadioButton) findViewById(selectedId);
            String value = genderButton.getText().toString();
            showRadioButtonInfo.setText("You Selected "+ value);


        }
    }


    void toast_maker(String a){
        LayoutInflater newInflater = getLayoutInflater();
        View customToast = newInflater.inflate(R.layout.custom_toast,findViewById(R.id.customLayOut));
        String button = a;
        Toast newToast = new  Toast(MainActivity.this);
        newToast.setDuration(Toast.LENGTH_LONG);
        newToast.setGravity(Gravity.CENTER,0,400);
        newToast.setView(customToast);
        newToast.show();
    }
}

