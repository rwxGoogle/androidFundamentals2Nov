package com.example.androidfundamentals2nov;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class PersonsAdapter extends RecyclerView.Adapter<PersonsAdapter.PersonsViewHolder> {
    private static final String TAG = PersonsAdapter.class.getSimpleName();
    private List<Person> persons;

    PersonsAdapter(List<Person> personList) {
        this.persons = personList;
    }

    @NonNull
    @Override
    public PersonsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Log.d(TAG, "onCreateViewHolder()");
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.item_person, parent, false);
        return new PersonsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PersonsViewHolder holder, int position) {
        Log.d(TAG, "onBindViewHolder(), position= " + position);
        String name = persons.get(position).getName();
        holder.name.setText(name);

        String country = persons.get(position).getCountry();
        holder.country.setText(country);

        String age = persons.get(position).getAge();
        holder.age.setText(age);

        holder.sendEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "sendEmail to " + name);
            }
        });

        if(position == 3){
            holder.sendEmail.setVisibility(View.GONE);
        }
    }

    @Override
    public int getItemCount() {
        return persons.size();
    }

    static class PersonsViewHolder extends RecyclerView.ViewHolder {
        private TextView name;
        private TextView country;
        private TextView age;
        private Button sendEmail;

        PersonsViewHolder(View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.name);
            country = itemView.findViewById(R.id.homeCountry);
            age = itemView.findViewById(R.id.age);
            sendEmail = itemView.findViewById(R.id.sendEmailButton);
        }
    }
}
