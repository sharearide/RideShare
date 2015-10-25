package com.example.bunty.sharetheride.Fragments;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Toast;

import com.example.bunty.sharetheride.Each_User;
import com.example.bunty.sharetheride.R;

/**
 * Created by bunty on 10/26/2015.
 */
public class BookARide extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.book_a_ride);

        Each_User each_user = getIntent().getParcelableExtra("user_data");

        Toast.makeText(BookARide.this, "name is" + each_user.getUname(), Toast.LENGTH_SHORT).show();
    }
}
