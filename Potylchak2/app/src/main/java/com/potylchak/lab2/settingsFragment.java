package com.potylchak.lab2;

import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class settingsFragment extends Fragment {

    private OnFragmentInteractionListener mListener;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.settings_fragment, container, false);


        TextView rb1 = view.findViewById(R.id.radioButton1);
        Typeface TF1 = Typeface.SANS_SERIF;
        rb1.setTypeface(TF1);

        TextView rb2 = view.findViewById(R.id.radioButton2);
        Typeface TF2 = Typeface.createFromAsset(getActivity().getAssets(), "fonts/Inspiration.ttf");
        rb2.setTypeface(TF2);

        TextView rb3 = view.findViewById(R.id.radioButton3);
        Typeface TF3 = Typeface.createFromAsset(getActivity().getAssets(), "fonts/ApolloniaModern.ttf");
        rb3.setTypeface(TF3);

        TextView rb4 = view.findViewById(R.id.radioButton4);
        Typeface TF4 = Typeface.createFromAsset(getActivity().getAssets(), "fonts/PehleviRegular.ttf");
        rb4.setTypeface(TF4);

        Button okButton = view.findViewById(R.id.button_ok);

        okButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                outputMessage();
            }
        });

        Button cancelButton = view.findViewById(R.id.button_cancel);

        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cancelInput();
            }
        });


        if (savedInstanceState != null) {

            String savedInputText = savedInstanceState.getString(inputTextViewKey);
            EditText editText = view.findViewById(R.id.editText);

            editText.setText(savedInputText);

            int savedSelectedFont = savedInstanceState.getInt(radioButtonKey);
            if (savedSelectedFont != -1) {

                RadioGroup radioGroup = view.findViewById(R.id.fontSelection);
                radioGroup.check(savedSelectedFont);
            }
        }

        return view;
    }

    final static String inputTextViewKey = "INPUT_TEXTVIEW_TEXT";

    final static String radioButtonKey = "FONT_RADIOBUTTON_ID";

    @Override
    public void onSaveInstanceState(Bundle outState) {
        View view = getView();

        EditText editText = view.findViewById(R.id.editText);
        outState.putString(inputTextViewKey, editText.getText().toString());

        RadioGroup radioGroup = view.findViewById(R.id.fontSelection);
        outState.putInt(radioButtonKey, radioGroup.getCheckedRadioButtonId());

        super.onSaveInstanceState(outState);
    }

    interface OnFragmentInteractionListener {
        void onFragmentInteraction(String message, Typeface typeface);
    }

    @Override
    public void onAttach(Context context) {

        super.onAttach(context);

        try {

            mListener = (OnFragmentInteractionListener) context;
        } catch (ClassCastException e) {

            throw new ClassCastException(context.toString() + " должен реализовывать интерфейс OnFragmentInteractionListener");
        }
    }

    private void outputMessage() {

        View view = getView();

        InputMethodManager imm = (InputMethodManager)getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(view.getWindowToken(), 0);

        EditText editText = view.findViewById(R.id.editText);
        RadioGroup radioGroup = view.findViewById(R.id.fontSelection);

        int checkedId = radioGroup.getCheckedRadioButtonId();

        if (checkedId != -1) {

            String enteredText = editText.getText().toString();

            if (!enteredText.isEmpty()) {

                TextView checkedButtonText = radioGroup.findViewById(checkedId);

                mListener.onFragmentInteraction(editText.getText().toString(), checkedButtonText.getTypeface());

                //saveText(enteredText);

            }
        }
    }


    private void cancelInput() {

        EditText editText = getView().findViewById(R.id.editText);

        editText.setText("");

        RadioGroup radioGroup = getView().findViewById(R.id.fontSelection);

        radioGroup.clearCheck();
    }

}
