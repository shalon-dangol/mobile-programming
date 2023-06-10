package com.example.test;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class HomeFragment extends Fragment {

    private View mainView;
    private RadioGroup rdgGender;
    private Button btnSendData;
    private CheckBox chk1, chk2, chk3;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        mainView = inflater.inflate(R.layout.fragment_home, container, false);
        return mainView;
    }

    private void findViews() {
        rdgGender = mainView.findViewById(R.id.rdgGender);
        btnSendData = mainView.findViewById(R.id.btnSendData);
        chk1 = mainView.findViewById(R.id.chk1);
        chk2 = mainView.findViewById(R.id.chk2);
        chk3 = mainView.findViewById(R.id.chk3);

        btnSendData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String skills = "";
                if(chk1.isChecked()){
                    skills = " "+chk1.getText().toString();
                }
                if(chk2.isChecked()){
                    skills = " "+chk2.getText().toString();
                }
                if(chk3.isChecked()){
                    skills = " "+chk3.getText().toString();
                }

                String value = ((RadioButton) mainView.findViewById(rdgGender.getCheckedRadioButtonId())).getText().toString();
                Toast.makeText(getContext(), value, Toast.LENGTH_SHORT).show();
                Toast.makeText(getContext(),"Skills user have chosen: "+skills, Toast.LENGTH_SHORT).show();
                                           }
                                       }
        );

    }
}