package com.ninnanovila.datapersistent;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class EmployeeRecyclerViewAdapter extends RecyclerView.Adapter<EmployeeRecyclerViewAdapter.EmployeeViewHolder> implements Filterable {

    private Context context;
    private List<Employee> employeeList;
    private List<Employee> filteredEmployee;

    public EmployeeRecyclerViewAdapter(Context context, List<Employee> employeeList) {
        this.context = context;
        this.employeeList = employeeList;
        this.filteredEmployee = employeeList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public EmployeeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_employee, parent, false);
        return new EmployeeViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull EmployeeViewHolder holder, int position) {
        Employee employee = employeeList.get(position);
        holder.number.setText(employee.getNumber());
        holder.name.setText(employee.getFullName());
        holder.age.setText(employee.getAge()+" years old");
    }

    @Override
    public int getItemCount() {
        return employeeList.size();
    }

    @Override
    public Filter getFilter() {
        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence constraint) {
                String charString = constraint.toString();
                if (charString.isEmpty()) {
                    employeeList = filteredEmployee;
                } else {
                    ArrayList<Employee> filteredList = new ArrayList<>();
                    for (Employee employee: filteredEmployee) {
                        if ( employee.getFullName().toLowerCase().contains(charString)) {
                            filteredList.add(employee);
                        }
                    }
                    employeeList = filteredList;
                }
                FilterResults filterResults = new FilterResults();
                filterResults.values = employeeList;
                return filterResults;
            }

            @Override
            protected void publishResults(CharSequence constraint, FilterResults results) {
                employeeList = (ArrayList<Employee>) results.values;
                notifyDataSetChanged();
            }
        };
    }


    public class EmployeeViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView number, name, age;

        public EmployeeViewHolder(@NonNull View itemView) {
            super(itemView);
            number = itemView.findViewById(R.id.number_text);
            name = itemView.findViewById(R.id.full_name_text);
            age = itemView.findViewById(R.id.age_text);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            AppCompatActivity activity = (AppCompatActivity) v.getContext();
            Employee employee = employeeList.get(getAdapterPosition());
            Bundle data = new Bundle();
            data.putSerializable("employee", employee);
            UpdateFragment updateFragment = new UpdateFragment();
            updateFragment.setArguments(data);
            activity.getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.frame_layout, updateFragment)
                    .commit();
        }
    }
}

//hint
//https://stackoverflow.com/questions/47711088/how-to-implement-searchview-with-listview-using-custom-object-arraylist
