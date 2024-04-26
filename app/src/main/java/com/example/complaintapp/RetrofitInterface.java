package com.example.complaintapp;

import java.util.List;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface RetrofitInterface {
    @POST("submit_complaint")
    Call<Complaint> submitComplaint(@Body Complaint complaint);

    @GET("Test_GetComplaint")
    Call<List<Complaint>> getComplaints();
}
