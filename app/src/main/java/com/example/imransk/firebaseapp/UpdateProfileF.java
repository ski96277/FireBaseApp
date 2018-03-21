package com.example.imransk.firebaseapp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

/**
 * Created by imran sk on 3/20/2018.
 */

public class UpdateProfileF extends Fragment {
    EditText name_ET, number_ET, age_ET;
    Button updateBtn;
    FirebaseUser firebaseUser;
    FirebaseDatabase firebaseDatabase;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.updateprofilef, null);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        name_ET = view.findViewById(R.id.nameET);
        number_ET = view.findViewById(R.id.numberET);
        age_ET = view.findViewById(R.id.ageET);
        updateBtn = view.findViewById(R.id.update_btn);

        firebaseUser = FirebaseAuth.getInstance().getCurrentUser();
        final String userId=firebaseUser.getUid();
        Toast.makeText(getContext(), ""+userId, Toast.LENGTH_SHORT).show();
        updateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String name = name_ET.getText().toString();
                String number = number_ET.getText().toString();
                String age = age_ET.getText().toString();
                UserInformation userInformation = new UserInformation(name, number, age);


                firebaseDatabase = FirebaseDatabase.getInstance();
                DatabaseReference databaseReference=firebaseDatabase.getReference("UserInformation");
//                databaseReference.child(userId);
                databaseReference.child(userId).setValue(userInformation);

                Toast.makeText(getContext(), "You click update button", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
