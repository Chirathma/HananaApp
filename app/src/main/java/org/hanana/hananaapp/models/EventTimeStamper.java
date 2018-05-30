package org.hanana.hananaapp.models;

public abstract class EventTimeStamper implements TimeStamper {
    private int mMinute;
    private int mHour;
    private int mDayOfMonth;
    private int mMonth;
    private int mYear;
    // booleans to check if if time and date are set
    private boolean isTimeSet = false;
    private boolean isDateSet = false;

    @Override
    public void setTime(int minute, int hourOfDay) {
        if (!isTimeSet)
            isTimeSet = true;
        mMinute = minute;
        mHour = hourOfDay;
    }

    @Override
    public void setDate(int day, int month, int year) {
        if (!isDateSet)
            isDateSet = true;
        mDayOfMonth = day;
        mMonth = month + 1;
        mYear = year;
    }

    @Override
    public boolean isTimeSet() {
        return isTimeSet;
    }

    @Override
    public boolean isDateSet() {
        return isDateSet;
    }

    @Override
    public String getDateTimeStamp() {
        return  "" + mYear + "-" +
                addZeros(mMonth) + mMonth + "-" +
                addZeros(mDayOfMonth) + mDayOfMonth + " " +
                addZeros(mHour) + mHour + ":" + addZeros(mMinute) +
                mMinute + "\n";
    }

    private String addZeros(int number) {
        return (number < 10) ? ("" + 0):"";
    }

    @Override
    public String getTimeStamp() {
        return null;
    }

    @Override
    public String getDateStamp() {
        return null;
    }

    @Override
    public String getDateTimeStampFormat() {
        return null;
    }
}
