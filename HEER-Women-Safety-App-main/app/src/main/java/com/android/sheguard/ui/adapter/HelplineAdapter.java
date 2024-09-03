package com.android.sheguard.ui.adapter;

import android.content.Context;
import android.text.method.LinkMovementMethod;
import android.text.util.Linkify;
import android.util.Patterns;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.android.sheguard.R;
import com.android.sheguard.model.HelplineModel;

import java.util.ArrayList;

public class HelplineAdapter extends RecyclerView.Adapter<HelplineAdapter.ViewHolder> {

    private final Context context;
    private final ArrayList<HelplineModel> helplines;

    public HelplineAdapter(@NonNull Context context, ArrayList<HelplineModel> helplines) {
        this.helplines = helplines;
        this.context = context;
        // Add Indian emergency numbers for women's safety
        addIndianEmergencyContacts();
    }

    private void addIndianEmergencyContacts() {
        helplines.clear();
        helplines.add(new HelplineModel("Nirbhaya Police", "Dial 100 - Emergency police assistance", "100"));
        helplines.add(new HelplineModel("Women's Helpline", "Dial 1091 - Helpline for women in distress", "1091"));
        helplines.add(new HelplineModel("Sakhi One Stop Centers", "Dial 181 - Support for women affected by violence", "181"));
        helplines.add(new HelplineModel("Legal Aid Helpline", "Dial 15100 - Legal assistance for women", "15100"));
        helplines.add(new HelplineModel("Women's Shelter Homes", "Dial 10920 - Shelter homes for women in need", "10920"));
        helplines.add(new HelplineModel("Anti-Obscene Calls Cell", "Dial 1096 - Assistance for handling obscene calls", "1096"));
        helplines.add(new HelplineModel("Women's Police Stations", "Contact nearest police station with women's cell", "Check local directory"));
        helplines.add(new HelplineModel("Domestic Abuse Helpline", "Dial 181 - Assistance for victims of domestic abuse", "181"));
        helplines.add(new HelplineModel("National Commission for Women", "Dial 011-26942369 - For reporting incidents of violence against women", "011-26942369"));
        helplines.add(new HelplineModel("Child Helpline", "Dial 1098 - Helpline for children in distress", "1098"));
        helplines.add(new HelplineModel("National Emergency Helpline", "Dial 112 - All-purpose national emergency helpline", "112"));
        helplines.add(new HelplineModel("Anti-Stalking Helpline", "Dial 1091 - Helpline for reporting cases of stalking", "1091"));
        helplines.add(new HelplineModel("Acid Attack Helpline", "Dial 101 - Helpline for victims of acid attacks", "101"));
        helplines.add(new HelplineModel("Cyber Crime Helpline", "Dial 155260 - Helpline for reporting cyber crimes", "155260"));
        helplines.add(new HelplineModel("Mental Health Helpline", "Dial 104 - Helpline for mental health support", "104"));
        notifyDataSetChanged(); // Notify adapter that data has changed
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.view_helpline_list_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.name.setText(helplines.get(position).getName());

        holder.number.setText(helplines.get(position).getNumber());
        Linkify.addLinks(holder.number, Patterns.PHONE, "tel:", Linkify.sPhoneNumberMatchFilter, Linkify.sPhoneNumberTransformFilter);
        holder.number.setMovementMethod(LinkMovementMethod.getInstance());

        holder.details.setText(helplines.get(position).getDetails());
    }

    @Override
    public int getItemCount() {
        return helplines.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        TextView name, number, details;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.name);
            number = itemView.findViewById(R.id.number);
            details = itemView.findViewById(R.id.details);
        }
    }
}
