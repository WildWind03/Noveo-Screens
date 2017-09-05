package com.noveogroup.screens.activities;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.noveogroup.screens.models.PersonInformation;
import com.noveogroup.screens.R;

import org.joda.time.DateTime;
import org.joda.time.Years;

public class ResultActivity extends Activity {

    public final static String PERSON_INFO_TAG = "PERSON";

    public static Intent newIntent(Context context, PersonInformation personInformation) {
        Intent intent = new Intent(context, ResultActivity.class);
        intent.putExtra(PERSON_INFO_TAG, personInformation);

        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_result);

        TextView name = (TextView) findViewById(R.id.name);
        TextView age = (TextView) findViewById(R.id.age);

        PersonInformation personInformation = getIntent().getExtras().getParcelable(PERSON_INFO_TAG);

        if (null == personInformation) {
            Toast invalidDate = Toast.makeText(getApplicationContext(), "Unexpected error", Toast.LENGTH_SHORT);
            invalidDate.show();
            return;
        }

        String firstNameStr = personInformation.getFirstName();
        String lastNameStr = personInformation.getLastName();

        int day = personInformation.getDayOfMonth();
        int month = personInformation.getMonthOfYear();
        int year = personInformation.getYear();

        String nameStr = firstNameStr + " " + lastNameStr;

        name.setText(nameStr);

        DateTime dateTime = new DateTime(year, month, day, 0, 0);
        DateTime currentTime = new DateTime();

        int ageDifference = Years.yearsBetween(dateTime, currentTime).getYears();
        String ageDiffStr = String.valueOf(ageDifference);

        String ageStr = getResources().getString(R.string.age) + ": " + ageDiffStr;
        age.setText(ageStr);
    }
}
