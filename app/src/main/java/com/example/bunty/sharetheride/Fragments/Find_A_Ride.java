package com.example.bunty.sharetheride.Fragments;


import android.app.DatePickerDialog;
import android.location.Address;
import android.location.Geocoder;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.bunty.sharetheride.R;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

/**
 * A simple {@link Fragment} subclass.
 */
public class Find_A_Ride extends Fragment implements View.OnClickListener, View.OnFocusChangeListener {


    AutoCompleteTextView Fsource,Fdestination;
            EditText Fdate;
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
        Fsource= (AutoCompleteTextView) v.findViewById(R.id.Fsource);
        Fdestination= (AutoCompleteTextView) v.findViewById(R.id.Fdestination);
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
                /*Find_Ride_Search_Result find_ride_search_result = new Find_Ride_Search_Result();
                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.findARide,find_ride_search_result);
                fragmentTransaction.commit();*/
                checkEntries();



                break;
            case R.id.Fdate:
                FPickDate.show();
                break;

        }
    }

    private void checkEntries() {
        if(!Fdate.getText().toString().equals("") && !Fsource.getText().toString().equals("")
           && !Fdestination.getText().toString().equals(""))
        {
            String Date=Fdate.getText().toString();
            String source=Fsource.getText().toString();
            String destination=Fdestination.getText().toString();
            convertAddress(Fsource.getText().toString());

        }




    }

    public void convertAddress(String address) {
        if (address != null && !address.isEmpty()) {
            try {
                Geocoder geoCoder=null;
                List<Address> addressList = geoCoder.getFromLocationName(address, 1);
                if (addressList != null && addressList.size() > 0) {
                    double lat = addressList.get(0).getLatitude();
                    double lng = addressList.get(0).getLongitude();
                    Toast.makeText(getContext(),""+lat+""+lng,Toast.LENGTH_SHORT).show();
                }
            } catch (Exception e) {
                e.printStackTrace();
            } // end catch
        } // end if
    } // end convert

    @Override
    public void onFocusChange(View view, boolean b) {
        if(b)
        {
            setDateTimeField();
            FPickDate.show();
        }
    }
}
