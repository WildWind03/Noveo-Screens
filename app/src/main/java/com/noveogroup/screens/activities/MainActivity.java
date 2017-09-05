package com.noveogroup.screens.activities;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.noveogroup.screens.R;
import com.noveogroup.screens.fragments.TypeInformationFragment;

public class MainActivity extends AppCompatActivity {

    public final static String TYPE_INFO_TAG = "ROOT";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.main_layout);

        if (null == savedInstanceState) {
            Fragment typeInformationFragment = TypeInformationFragment.newInstance();
            getSupportFragmentManager().beginTransaction().add(R.id.root, typeInformationFragment, TYPE_INFO_TAG).commit();
        }
    }
}
