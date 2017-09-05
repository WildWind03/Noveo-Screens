package com.noveogroup.screens.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import com.noveogroup.screens.models.PersonInformation;
import com.noveogroup.screens.R;

import org.joda.time.DateTime;

public class MainActivity extends AppCompatActivity {

    private DatePicker datePicker;
    private EditText firstName;
    private EditText lastName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        datePicker = (DatePicker) findViewById(R.id.datePicker);
        datePicker.setMaxDate(DateTime.now().getMillis());

        firstName = (EditText) findViewById(R.id.firstNameEditText);
        lastName = (EditText) findViewById(R.id.lastNameEditText);
    }

    public void onOkButtonClick(View view) {
        int day = datePicker.getDayOfMonth();
        int month = datePicker.getMonth();
        int year = datePicker.getYear();

        String firstNameStr = firstName.getText().toString();
        String lastNameStr = lastName.getText().toString();

        if (TextUtils.isEmpty(firstNameStr) || TextUtils.isEmpty(lastNameStr)) {
            Toast invalidDate = Toast.makeText(getApplicationContext(), "You have to type first name and last name", Toast.LENGTH_SHORT);
            invalidDate.show();
            return;
        }

        PersonInformation personInformation = new PersonInformation(firstNameStr, lastNameStr, day, month, year);
        Intent intent = ResultActivity.newIntent(this, personInformation);

        startActivity(intent);
    }
}
