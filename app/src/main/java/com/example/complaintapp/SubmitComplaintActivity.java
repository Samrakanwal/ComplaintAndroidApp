package com.example.complaintapp;


import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SubmitComplaintActivity extends AppCompatActivity {
    private EditText complaintEditText;
    private Button submitButton;
    private Button gotolistButton;
    private RetrofitInterface retrofitInterface;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_submit_complaint);

        complaintEditText = findViewById(R.id.complaintEditText);
        submitButton = findViewById(R.id.submitButton);
        gotolistButton = findViewById(R.id.gotolistButton);
        retrofitInterface = RetrofitClientInstance.getRetrofitInstance().create(RetrofitInterface.class);

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String complaintDescription = complaintEditText.getText().toString();
                Complaint complaint = new Complaint(complaintDescription);

                Call<Complaint> call = retrofitInterface.submitComplaint(complaint);
                call.enqueue(new Callback<Complaint>() {
                    @Override
                    public void onResponse(Call<Complaint> call, Response<Complaint> response) {
                        if (response.isSuccessful()) {
                            // Handle success
                            complaintEditText.setText("");
                        } else {
                            // Handle failure
                        }
                    }

                    @Override
                    public void onFailure(Call<Complaint> call, Throwable t) {
                        // Handle failure
                    }
                });
            }
        });

        gotolistButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),ComplaintListActivity.class);
                startActivity(i);
            }
        });
    }
}

