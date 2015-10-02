package com.example.bunty.sharetheride.Fragments;


import android.app.DatePickerDialog;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;

import com.example.bunty.sharetheride.R;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

/**
 * A simple {@link Fragment} subclass.
 */
public class Find_A_Ride extends Fragment implements View.OnClickListener, View.OnFocusChangeListener {


    EditText Fsource,Fdestination,Fdate;
    ImageButton FsourceX,FdestinationX;
    Button Search;
    private DatePickerDialog FPickDate;
    private SimpleDateFormat dateFormatter;
    public Find_A_Ride() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View v=inflater.inflate(R.layout.fragment_find__a__ride, container, false);
        dateFormatter = new SimpleDateFormat("dd-MM-yyyy", Locale.US);
        Fsource= (EditText) v.findViewById(R.id.Fsource);
        Fdestination=(EditText) v.findViewById(R.id.Fdestination);
        Fdate=(EditText) v.findViewById(R.id.Fdate);
        FsourceX= (ImageButton) v.findViewById(R.id.FsourceX);
        FdestinationX= (ImageButton) v.findViewById(R.id.FdestinationX);
        Search= (Button) v.findViewById(R.id.Fsearch);
        FsourceX.setOnClickListener(this);
        FdestinationX.setOnClickListener(this);
        Search.setOnClickListener(this);
        Fdate.setOnClickListener(this);
        setDateTimeField();
        Fdate.setOnFocusChangeListener(this);


        return v;
    }

    private void setDateTimeField() {

        Calendar newCalendar = Calendar.getInstance();
        FPickDate = new DatePickerDialog(getActivity(), new DatePickerDialog.OnDateSetListener() {

            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                Calendar newDate = Calendar.getInstance();
                newDate.set(year, monthOfYear, dayOfMonth);
                Fdate.setText(dateFormatter.format(newDate.getTime()));
            }

        },newCalendar.get(Calendar.YEAR), newCalendar.get(Calendar.MONTH), newCalendar.get(Calendar.DAY_OF_MONTH));


    }

    @Override
    public void onClick(View view) {

        switch(view.getId())
        {
            case R.id.FsourceX:
                Fsource.setText("");
                break;


            case R.id.FdestinationX:
                Fdestination.setText("");
                break;


            case R.id.Fsearch:
                break;

            case R.id.Fdate:
                FPickDate.show();

        }
    }

    @Override
    public void onFocusChange(View view, boolean b) {
        if(b)
        {
            setDateTimeField();
            FPickDate.show();
        }
    }
}
