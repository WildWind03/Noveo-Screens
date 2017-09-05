package com.noveogroup.screens.models;

import android.os.Parcel;
import android.os.Parcelable;

public class PersonInformation implements Parcelable {
    private final String firstName;
    private final String lastName;
    private final MyDate birthday;

    public PersonInformation(String firstName, String lastName, int dayOfMonth, int monthOfYear, int year) {
        this.firstName = firstName;
        this.lastName = lastName;
        birthday = new MyDate(dayOfMonth, monthOfYear, year);
    }

    protected PersonInformation(Parcel in) {
        firstName = in.readString();
        lastName = in.readString();

        int dayOfMonth = in.readInt();
        int monthOfYear = in.readInt();
        int year = in.readInt();

        birthday = new MyDate(dayOfMonth, monthOfYear, year);
    }

    public static final Creator<PersonInformation> CREATOR = new Creator<PersonInformation>() {
        @Override
        public PersonInformation createFromParcel(Parcel in) {
            return new PersonInformation(in);
        }

        @Override
        public PersonInformation[] newArray(int size) {
            return new PersonInformation[size];
        }
    };

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getDayOfMonth() {
        return birthday.getDay();
    }

    public int getMonthOfYear() {
        return birthday.getMonth();
    }

    public int getYear() {
        return birthday.getYear();
    }

    public MyDate getBirthday() {
        return birthday;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(getFirstName());
        parcel.writeString(getLastName());
        parcel.writeInt(getDayOfMonth());
        parcel.writeInt(getMonthOfYear());
        parcel.writeInt(getYear());
    }
}
