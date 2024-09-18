package com.example.taskmanager;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private EditText editTextTaskName, editTaksDesc;
    private Button buttonAddTask;
    private RecyclerView recyclerViewTask;
    private TaskAdapter taskAdapter;
    private List<Task> taskList;
//    private FloatingActionButton fab;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        inittilize ui elements
        editTextTaskName = findViewById(R.id.editTextTaskName);
        editTaksDesc = findViewById(R.id.editTextTaskDesc);
        buttonAddTask = findViewById(R.id.buttonAddTask);
        recyclerViewTask = findViewById(R.id.recyclerViewTasks);
//        fab = findViewById(R.id.fab);
//        initilize the task list and adapter
        taskList = new ArrayList<>();
        taskAdapter = new TaskAdapter(this, taskList);
//        setup recycler view wtih LinearLayoutmanager and adapter
        recyclerViewTask.setLayoutManager(new LinearLayoutManager(this));
        recyclerViewTask.setAdapter(taskAdapter);
        buttonAddTask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String taskName = editTextTaskName.getText().toString().trim();
                String taskDesc = editTaksDesc.getText().toString().trim();
                if(!taskName.isEmpty()&& !taskDesc.isEmpty()){
                    Task newTask = new Task(taskName,taskDesc);
                    taskList.add(newTask);
                    taskAdapter.notifyItemInserted(taskList.size() -1);
                    taskAdapter.notifyDataSetChanged();
                    editTextTaskName.setText("");
                    editTaksDesc.setText("");

                    Snackbar.make(view,"Task Added", Snackbar.LENGTH_LONG).show();
                }else{
                    Toast.makeText(MainActivity.this,"Please fill out both fields",Toast.LENGTH_SHORT).show();
                }
//                fab.setOnClickListener(new View.OnClickListener() {
//
//
//                    @Override
//                    public void onClick(View view) {
//                        Snackbar.make(view,"Fab Clicked",Snackbar.LENGTH_LONG).show();
//                    }
//                });

            }
        });


    }
}