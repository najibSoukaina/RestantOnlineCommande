package com.example.unme.app.outil;

import
        android.app.Application;
import com.example.unme.app.model.User;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;

public class BaseApplication extends Application {

    FirebaseAuth mAuth;
    DatabaseReference reference;
    User currentUser;

    public BaseApplication() {}

    public User getCurrentPlayer() {
        return currentUser;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        this.currentUser = new User();
        /*
        mAuth = FirebaseAuth.getInstance();
        String currentUserId = mAuth.getCurrentUser().getUid();
        // Get Current User References.
        reference = FirebaseDatabase.getInstance().getReference("players/"+currentUserId);
        //reference = FirebaseDatabase.getInstance().getReference().child("players").child(currentUserId); */
    }

/*
    public void getPlayerName () {
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                currentPlayer.setFirstName(snapshot.child("firstName").getValue().toString());
                currentPlayer.setLastName(snapshot.child("lastName").getValue().toString());
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                throw error.toException(); // Don't ignore errors
            }
        });
    }

    public void getPlayerEmail () {
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                currentPlayer.setEmail(snapshot.child("email").getValue().toString());
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                throw error.toException(); // Don't ignore errors
            }
        });
    }

    public void getPlayerUsername () {
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                currentPlayer.setUsername(snapshot.child("username").getValue().toString());
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                throw error.toException(); // Don't ignore errors
            }
        });
    } */
}
