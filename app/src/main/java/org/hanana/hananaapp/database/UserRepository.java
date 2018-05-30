package org.hanana.hananaapp.database;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import org.hanana.hananaapp.exceptions.HananaException;
import org.hanana.hananaapp.models.User;

public class UserRepository extends HananaDB {


    public UserRepository(Context context) {
        super(context);
    }

    public void insertUser(User user){
        // TODO: Check for existing users with the same username
        SQLiteDatabase database = getWritableDatabase();
        String insertQuery = "insert into " + TABLE_USER;
        insertQuery += " values( null, '" + user.getUsername();
        insertQuery += "', '" + user.getPassword();
        insertQuery += "', '" + user.getName();
        insertQuery += "', '" + user.getEmail();
        insertQuery += "', '" + user.getMobileNumber();
        insertQuery += "' )";

        database.execSQL(insertQuery);
        database.close();
        Log.i("HANANA", user.getName() + " is added!");
    }


    public User getUserByUsernameAndPassword(String username, String password) throws HananaException{
        // select query
        String selectUserQuery = "SELECT * FROM " + TABLE_USER;
        selectUserQuery += " WHERE "+ U_USER_NAME + "='" + username + "' AND ";
        selectUserQuery += U_PASSWORD + "='" + password + "' LIMIT 1";

        // database instance
        SQLiteDatabase database = getReadableDatabase();
        Cursor cursor = database.rawQuery(selectUserQuery, null);

        User user = null;

        while(cursor.moveToNext()){
            user = new User(
                    cursor.getLong(0),
                    cursor.getString(1),
                    cursor.getString(2));

            user.setName(cursor.getString(3));
            user.setEmail(cursor.getString(4));
            user.setMobileNumber(cursor.getString(5));
        }

        // check if a user is found
        if(user == null)
            throw new HananaException("User does not exist.");

        Log.i("HANANA", user.getName() + " is found!");
        return user;
    }
}
