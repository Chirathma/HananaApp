package org.hanana.hananaapp.models;

import java.util.Date;

public class Event {
    private long mId;
    private long mUserId;
    private String mTitle;
    private float mLongitude;
    private float mLatitude;
    private Date mDate;
    private String mVenue;
    private String time;

    public Event(long id, long userId) {
        mId = id;
        mUserId = userId;
    }

    public Event() {

    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        mTitle = title;
    }

    public float getLongitude() {
        return mLongitude;
    }

    public void setLongitude(float longitude) {
        mLongitude = longitude;
    }

    public float getLatitude() {
        return mLatitude;
    }

    public void setLatitude(float latitude) {
        mLatitude = latitude;
    }

    public Date getDate() {
        return mDate;
    }

    public void setDate(Date date) {
        mDate = date;
    }

    public String getVenue() {
        return mVenue;
    }

    public void setVenue(String venue) {
        mVenue = venue;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
