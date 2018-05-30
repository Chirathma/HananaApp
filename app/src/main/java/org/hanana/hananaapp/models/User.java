package org.hanana.hananaapp.models;

import org.hanana.hananaapp.exceptions.HananaException;

public class User {
    // isntance variables
    private long mId;
    private String mUsername;
    private String mPassword;
    private String mName;
    private String mEmail;
    private String mMobileNumber;

    // constructor

    public User(long id, String username, String password) throws HananaException {
        mId = id;
        setUsername(username);
        setPassword(password);
    }

    public long getId() {
        return mId;
    }

    public String getUsername() {
        return mUsername;
    }

    public void setUsername(String username) throws HananaException {
        if(isNullOrEmpty(username) || username.length() <8 )
            throw new HananaException("Minimum username length is 8.");
        mUsername = username;
    }

    public String getPassword() {
        return mPassword;
    }

    public void setPassword(String password) throws HananaException {

        if(password.length() < 8)
            throw new HananaException("Minimum password length is 8.");

        mPassword = password;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) throws HananaException {
        if(isNullOrEmpty(name))
            throw new HananaException("Name can not be empty");
        mName = name;
    }

    public String getEmail() {
        return mEmail;
    }

    public void setEmail(String email) throws HananaException {
        if(isNullOrEmpty(email))
            throw new HananaException("Email can not be empty.");
        mEmail = email;
    }

    public String getMobileNumber() {
        return mMobileNumber;
    }

    public void setMobileNumber(String mobileNumber) throws HananaException {
        if(isNullOrEmpty(mobileNumber))
            throw  new HananaException("Phone number can not be empty.");
        mMobileNumber = mobileNumber;
    }

    // helper methods
    // helper to check if an attribute is empty or null
    private boolean isNullOrEmpty(String str){
        return str == null || str.isEmpty();
    }
}
