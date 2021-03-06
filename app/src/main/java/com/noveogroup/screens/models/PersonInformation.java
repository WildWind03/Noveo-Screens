package com.noveogroup.screens.models;

import android.os.Parcel;
import android.os.Parcelable;

public class PersonInformation implements Parcelable {
    private final String firstName;
    private final String lastName;
    private final int dayOfMonth;
    private final int monthOfYear;
    private final int year;

    public PersonInformation(String firstName, String lastName, int dayOfMonth, int monthOfYear, int year) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dayOfMonth = dayOfMonth;
        this.monthOfYear = monthOfYear;
        this.year = year;
    }

    protected PersonInformation(Parcel in) {
        firstName = in.readString();
        lastName = in.readString();
        dayOfMonth = in.readInt();
        monthOfYear = in.readInt();
        year = in.readInt();
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
        return dayOfMonth;
    }

    public int getMonthOfYear() {
        return monthOfYear;
    }

    public int getYear() {
        return year;
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
