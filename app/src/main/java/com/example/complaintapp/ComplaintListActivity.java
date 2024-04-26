package com.example.complaintapp;

import android.os.Bundle;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ComplaintListActivity extends AppCompatActivity {
    private ListView complaintListView;
    private RetrofitInterface retrofitInterface;
    private ComplaintAdapter complaintAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_complaint_list);

        complaintListView = findViewById(R.id.complaintListView);
        retrofitInterface = RetrofitClientInstance.getRetrofitInstance().create(RetrofitInterface.class);

        Call<List<Complaint>> call = retrofitInterface.getComplaints();
        call.enqueue(new Callback<List<Complaint>>() {
            @Override
            public void onResponse(Call<List<Complaint>> call, Response<List<Complaint>> response) {
                if (response.isSuccessful()) {
                    List<Complaint> complaints = response.body();
                    complaintAdapter = new ComplaintAdapter(ComplaintListActivity.this, complaints);
                    complaintListView.setAdapter(complaintAdapter);
                } else {
                    // Handle failure
                }
            }

            @Override
            public void onFailure(Call<List<Complaint>> call, Throwable t) {
                // Handle failure
            }
        });
    }
}

