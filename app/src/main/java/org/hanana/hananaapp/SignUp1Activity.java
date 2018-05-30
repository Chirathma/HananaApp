/*
package org.hanana.hananaapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import org.hanana.hananaapp.database.HananaDB;
import org.hanana.hananaapp.exceptions.HananaException;
import org.hanana.hananaapp.models.User;

//import javax.swing.text.View;

public class SignUp1Activity extends AppCompatActivity {

    HananaDB helper = new HananaDB(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up1);
    }

    public void onSignUpClick(View v) throws HananaException {


        if (v.getId() == R.id.signUpButton)
        {
            EditText username = (EditText)findViewById(R.id.signUpUNameEditText);
            EditText email = (EditText)findViewById(R.id.emailEditText);
            //EditText phonenumber = (EditText)findViewById(R.id.phonenumber);
            EditText password = (EditText)findViewById(R.id.signUpPasswordEditText);
            EditText ConfirmPassword = (EditText)findViewById(R.id.signUpConfirmPasswordEditText);

            String usernamestr = username.getText().toString();
            String emailstr = email.getText().toString();
            //String phonenumberstr = phonenumber.getText().toString();
            String passwordstr = password.getText().toString();
            String ConfirmPasswordstr = ConfirmPassword.getText().toString();

            if (!passwordstr.equals(ConfirmPasswordstr)){
                //pop msg
                Toast pass = Toast.makeText(SignUp1Activity.this, "Password don't match" , Toast.LENGTH_SHORT);
                pass.show();
            }
            else {
               //insert the details in database
               User u = new User();
               u.setUsername(usernamestr);
               u.setEmail(emailstr);
              // u.setPhonenumber(phonenumberstr);
               u.setPassword(passwordstr);


               helper.insertUser(u);

            }

        }
    }

}
*/
