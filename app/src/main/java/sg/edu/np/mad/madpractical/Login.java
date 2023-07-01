package sg.edu.np.mad.madpractical;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Objects;

public class Login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

    }

    @Override
    protected void onResume() {
        super.onResume();

        EditText name = findViewById(R.id.editTextText);
        EditText password = findViewById(R.id.editTextTextPassword);
        Button login = findViewById(R.id.login);

        login.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                if(TextUtils.isEmpty(name.getText().toString())){
                    name.setError("Please enter username");
                    name.requestFocus();
                    return;
                }
                else if(TextUtils.isEmpty(password.getText().toString())){
                    password.setError("Please enter password");
                    password.requestFocus();
                    return;
                }
                else{
                    userLogin(name,password);
                }

            }
        });
    }

    private void userLogin(EditText name, EditText password) {
        String username = name.getText().toString().trim();
        String pwd = password.getText().toString().trim();
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        database.getReference("Users").child("mad").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot)
            {
                if(snapshot.exists()){
                    String userPassword = snapshot.child("password").getValue(String.class);
                    String userName = snapshot.child("username").getValue(String.class);
                    if(pwd.equals(userPassword) && username.equals(userName)){
                        Intent intent = new Intent(Login.this,ListActivity.class);
                        startActivity(intent);
                    }
                    else{
                        Toast.makeText(Login.this,"Invalid Credentials",Toast.LENGTH_SHORT).show();

                    }

                }
                else{
                    Toast.makeText(Login.this,"Login successful",Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });


    }


}