package com.noveogroup.screens.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.noveogroup.screens.utils.DateUtil;
import com.noveogroup.screens.models.PersonInformation;
import com.noveogroup.screens.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class ResultFragment extends Fragment {

    public final static String PERSON_INFO_TAG = "PERSON";

    @BindView(R.id.name) TextView name;
    @BindView(R.id.age) TextView age;

    private Unbinder unbinder;

    public static ResultFragment newInstance(PersonInformation personInformation) {
        ResultFragment fragment = new ResultFragment();

        Bundle bundle = new Bundle();
        bundle.putParcelable(PERSON_INFO_TAG, personInformation);
        fragment.setArguments(bundle);

        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.result_fragment, container, false);

        unbinder = ButterKnife.bind(this, view);
        Bundle bundle = getArguments();
        PersonInformation personInformation = bundle.getParcelable(PERSON_INFO_TAG);

        if (null == personInformation) {
            Toast invalidDate = Toast.makeText(getContext(), getString(R.string.errorSending), Toast.LENGTH_SHORT);
            invalidDate.show();
            return view;
        }

        String firstNameStr = personInformation.getFirstName();
        String lastNameStr = personInformation.getLastName();

        name.setText(getString(R.string.shownName, firstNameStr, lastNameStr));
        age.setText(getString(R.string.shownAge, getString(R.string.age), DateUtil.getAge(personInformation.getBirthday())));

        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
