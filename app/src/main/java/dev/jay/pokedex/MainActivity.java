package dev.jay.pokedex;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.textfield.TextInputLayout;

public class MainActivity extends AppCompatActivity {

    EditText editUsername, editPassword;
    TextInputLayout tiUname, tiPw;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


        tiUname = findViewById(R.id.tiUname);
        tiPw = findViewById(R.id.tiPw);

        editUsername = tiUname.getEditText();
        editPassword = tiPw.getEditText();

        findViewById(R.id.btnLogin).setOnClickListener(btnView -> onLogin());
    }

    private void onLogin(){
        String uname = editUsername.getText().toString();
        String pword = editPassword.getText().toString();

        setError(tiUname, null);
        setError(tiPw, null);

        boolean isUnameEmpty = uname.isEmpty();
        boolean isPwEmpty = pword.isEmpty();
//
//
//        if(isUnameEmpty){
//            setError(tiUname, "No Username");
//        }
//
//        if(isPwEmpty){
//            setError(tiPw, "No Password");
//        }
//
//        if((!isUnameEmpty && !uname.equals("user")) || (!isPwEmpty && !pword.equals("12345"))) {
//            setError(tiPw, "Invalid password");
//        }

        if(tiUname.getError() == null && tiPw.getError() == null){
            startActivity(new Intent(MainActivity.this, PokedexActivity.class));
            finish();
        }

    }

    private void setError(TextInputLayout textInputLayout, String errMsg){
        textInputLayout.setError(errMsg);
    }
}