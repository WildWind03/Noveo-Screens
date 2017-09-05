package com.noveogroup.screens.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import com.noveogroup.screens.models.MyDate;
import com.noveogroup.screens.utils.DateUtil;
import com.noveogroup.screens.models.PersonInformation;
import com.noveogroup.screens.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

public class TypeInformationFragment extends Fragment {

    public final static String RESULT_TAG = "RESULT";

    @BindView(R.id.date_picker) DatePicker datePicker;
    @BindView(R.id.first_name_edit_text) EditText firstName;
    @BindView(R.id.last_name_edit_text) EditText lastName;

    private Unbinder unbinder;

    public static TypeInformationFragment newInstance() {
        return new TypeInformationFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.type_info_fragment, container, false);

        unbinder = ButterKnife.bind(this, view);

        datePicker.setMaxDate(DateUtil.getCurrentTimeInMillis());

        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();

        datePicker = null;
        firstName = null;
        lastName = null;
    }

    @OnClick(R.id.ok_button)
    public void onClick(View view) {
        MyDate myDate = DateUtil.getDate(datePicker);

        String firstNameStr = firstName.getText().toString();
        String lastNameStr = lastName.getText().toString();

        if (TextUtils.isEmpty(firstNameStr) || TextUtils.isEmpty(lastNameStr)) {
            Toast invalidDate = Toast.makeText(getContext(), getString(R.string.notLastOrFirstName), Toast.LENGTH_SHORT);
            invalidDate.show();
            return;
        }

        PersonInformation personInformation = new PersonInformation(firstNameStr, lastNameStr, myDate.getDay(), myDate.getMonth(), myDate.getYear());
        Fragment resultFragment = getFragmentManager().findFragmentByTag(RESULT_TAG);

        if (null == resultFragment) {
            resultFragment = ResultFragment.newInstance(personInformation);
        }

        getFragmentManager().beginTransaction().replace(R.id.root, resultFragment, RESULT_TAG).addToBackStack(ResultFragment.class.getSimpleName()).commit();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        unbinder.unbind();
    }
}
