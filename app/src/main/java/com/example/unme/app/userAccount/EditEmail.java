package com.example.unme.app.userAccount;

import
        android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.unme.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.EmailAuthProvider;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;


public class EditEmail extends AppCompatActivity implements View.OnClickListener {
    private static final String TAG = "EditEmail";
    Button back, submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_email);

        back = (Button) findViewById(R.id.back_btn);
        back.setOnClickListener(this);

        submit = (Button) findViewById(R.id.submitBtnEmail);
        submit.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.back_btn :
                finish();
                break;
            case R.id.submitBtnEmail :
                FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
                AuthCredential credential = EmailAuthProvider
                        .getCredential("soukainanajib222@gmail.com", "azdcgbjml");
                user.reauthenticate(credential)
                        .addOnCompleteListener(new OnCompleteListener<Void>() {
                            @Override
                            public void onComplete(@NonNull Task<Void> task) {
                                Log.d(TAG, "User re-authenticated.");

                                FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
                                user.updateEmail("moamed@example.com")
                                        .addOnCompleteListener(new OnCompleteListener<Void>() {
                                            @Override
                                            public void onComplete(@NonNull Task<Void> task) {
                                                if (task.isSuccessful()) {
                                                    Log.d(TAG, "User email address updated.");
                                                }
                                            }
                                        });
                            }
                        });
                break;

        }
    }

}