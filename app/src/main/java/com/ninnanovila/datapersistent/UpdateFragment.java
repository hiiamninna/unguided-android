package com.ninnanovila.datapersistent;

import android.content.DialogInterface;
import android.os.AsyncTask;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class UpdateFragment extends Fragment {

    TextInputEditText numberText, nameText, ageText;
    TextInputLayout number, name, age;
    Button saveBtn, cancelBtn, deleteBtn;
    Employee employee;

    public UpdateFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_update, container, false);

        employee = (Employee) getArguments().getSerializable("employee");

        numberText = view.findViewById(R.id.input_number);
        nameText = view.findViewById(R.id.input_name);
        ageText = view.findViewById(R.id.input_age);
        number = view.findViewById(R.id.input_number_layout);
        name = view.findViewById(R.id.input_name_layout);
        age = view.findViewById(R.id.input_age_layout);
        saveBtn = view.findViewById(R.id.btn_update);
        cancelBtn = view.findViewById(R.id.btn_cancel);
        deleteBtn = view.findViewById(R.id.btn_delete);

        try {
            if (employee.getNumber() != null||employee.getFullName() != null||employee.getAge() != null) {
                numberText.setText(employee.getNumber());
                nameText.setText(employee.getFullName());
                ageText.setText(employee.getAge().toString());
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                employee.setNumber(numberText.getText().toString());
                employee.setFullName(nameText.getText().toString());
                employee.setAge(Integer.parseInt(ageText.getText().toString()));
                update(employee);
            }
        });

        deleteBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                builder.setMessage("Are you sure to delete?")
                        .setPositiveButton("YES", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.dismiss();
                                delete(employee);
                            }
                        })
                        .setNegativeButton("NO", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        })
                        .show();
            }
        });

        cancelBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.hide(UpdateFragment.this).commit();
            }
        });
    }

    private void update(final Employee employee){
        class UpdateEmployee extends AsyncTask<Void, Void, Void> {

            @Override
            protected Void doInBackground(Void... voids) {

                DatabaseClient.getInstance(getActivity().getApplicationContext()).getDatabase()
                        .employeeDao()
                        .update(employee);
                return null;
            }

            @Override
            protected void onPostExecute(Void aVoid) {
                super.onPostExecute(aVoid);
                Toast.makeText(getActivity().getApplicationContext(), "Employee updated", Toast.LENGTH_SHORT).show();
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.hide(UpdateFragment.this).commit();
            }
        }

        UpdateEmployee update = new UpdateEmployee();
        update.execute();
    }

    private void delete(final Employee employee){
        class DeleteEmployee extends AsyncTask<Void, Void, Void> {

            @Override
            protected Void doInBackground(Void... voids) {

                DatabaseClient.getInstance(getActivity().getApplicationContext()).getDatabase()
                        .employeeDao()
                        .delete(employee);
                return null;
            }

            @Override
            protected void onPostExecute(Void aVoid) {
                super.onPostExecute(aVoid);
                Toast.makeText(getActivity().getApplicationContext(), "Employee deleted", Toast.LENGTH_SHORT).show();
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.hide(UpdateFragment.this).commit();
            }
        }

        DeleteEmployee delete = new DeleteEmployee();
        delete.execute();
    }
}