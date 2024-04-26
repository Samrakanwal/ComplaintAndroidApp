package com.example.complaintapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import java.util.List;

public class ComplaintAdapter extends ArrayAdapter<Complaint> {
    private Context context;
    private List<Complaint> complaints;

    public ComplaintAdapter(Context context, List<Complaint> complaints) {
        super(context, 0, complaints);
        this.context = context;
        this.complaints = complaints;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listItem = convertView;
        if (listItem == null) {
            listItem = LayoutInflater.from(context).inflate(R.layout.complaint_list_item, parent, false);
        }

        Complaint currentComplaint = complaints.get(position);

        TextView complaintTextView = listItem.findViewById(R.id.complaintTextView);
        TextView complaintTextViewAddress = listItem.findViewById(R.id.complaintTextViewAddress);
        TextView complaintTextViewContact = listItem.findViewById(R.id.complaintTextViewContact);
        complaintTextView.setText(currentComplaint.getName());
        complaintTextViewAddress.setText(currentComplaint.getAddress());
        complaintTextViewContact.setText(currentComplaint.getContact());
        return listItem;
    }
}
