package com.example.potylchak.potylchak;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {
    RadioGroup radioGroup;
    int i = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @BindView(R.id.editText)
    EditText editText;

    @BindView(R.id.textView)
    TextView textView;

    @OnClick(R.id.radioButton0)
    public void onClick0() {
        editText.setTypeface(Fonts.getTypefaceByString("def", this));
        i = 0;
    }
    @OnClick(R.id.radioButton1)
    public void onClick1() {
        editText.setTypeface(Fonts.getTypefaceByString("Inspiration", this));
        i = 1;
    }
    @OnClick(R.id.radioButton2)
    public void onClick2() {
        editText.setTypeface(Fonts.getTypefaceByString("ApolloniaModern", this));
        i = 2;
    }
    @OnClick(R.id.radioButton3)
    public void onClick3() {
        editText.setTypeface(Fonts.getTypefaceByString("PehleviRegular", this));
        i = 3;
    }


    @OnClick(R.id.ok)
    public void onClickOk() {
        //Toast toast = Toast.makeText(this, editText.getText(), Toast.LENGTH_SHORT);
        //toast.show();
        textView.setText(editText.getText());
        if (i == 0){
            textView.setTypeface(Fonts.getTypefaceByString("def", this));
        }
        if (i == 1){
            textView.setTypeface(Fonts.getTypefaceByString("Inspiration", this));
        }
        if (i == 2){
            textView.setTypeface(Fonts.getTypefaceByString("ApolloniaModern", this));
        }
        if (i == 3){
            textView.setTypeface(Fonts.getTypefaceByString("PehleviRegular", this));
        }
    }

    @OnClick(R.id.cancel)
    public void onClickCancel() {
        textView.setText("");
    }
}
