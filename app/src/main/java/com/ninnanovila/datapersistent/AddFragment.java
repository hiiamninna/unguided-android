package com.ninnanovila.datapersistent;

import android.os.AsyncTask;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class AddFragment extends Fragment {

    TextInputEditText numberText, nameText, ageText;
    TextInputLayout number, name, age;
    Button addBtn, cancelBtn;

    public AddFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_add, container, false);

        numberText = view.findViewById(R.id.input_number);
        nameText = view.findViewById(R.id.input_name);
        ageText = view.findViewById(R.id.input_age);
        number = view.findViewById(R.id.input_number_layout);
        name = view.findViewById(R.id.input_name_layout);
        age = view.findViewById(R.id.input_age_layout);
        addBtn = view.findViewById(R.id.btn_add);
        cancelBtn = view.findViewById(R.id.btn_cancel);

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (numberText.getText().toString().isEmpty() || nameText.getText().toString().isEmpty() || ageText.getText().toString().isEmpty()){
                    number.setError("Please fill number correctly.");
                    name.setError("Please fill name correctly.");
                    age.setError("Please fill age correctly.");
                }else {
                    addEmployee();
                }

            }
        });

        cancelBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.hide(AddFragment.this).commit();
            }
        });
    }

    private void addEmployee(){
        final String number = numberText.getText().toString();
        final String name = nameText.getText().toString();
        final String age = ageText.getText().toString();


        class AddEmployee extends AsyncTask<Void, Void, Void> {

            @Override
            protected Void doInBackground(Void... voids) {
                Employee employee = new Employee();
                employee.setNumber(number);
                employee.setFullName(name);
                employee.setAge(Integer.parseInt(age));

                DatabaseClient.getInstance(getActivity().getApplicationContext()).getDatabase()
                        .employeeDao()
                        .insert(employee);
                return null;
            }

            @Override
            protected void onPostExecute(Void aVoid) {
                super.onPostExecute(aVoid);
                Toast.makeText(getActivity().getApplicationContext(), "Employee saved", Toast.LENGTH_SHORT).show();
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.hide(AddFragment.this).commit();
            }
        }

        AddEmployee add = new AddEmployee();
        add.execute();
    }
}