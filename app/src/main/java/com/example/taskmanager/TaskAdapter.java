package com.example.taskmanager;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.Switch;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import android.view.View;

import java.util.List;

public class TaskAdapter extends RecyclerView.Adapter<TaskAdapter.TaskViewHolder> {
    private List<Task> taskList;
    private Context context;

    public TaskAdapter(Context context, List<Task> taskList) {
        this.taskList = taskList;
        this.context = context;
    }

    public static class TaskViewHolder extends RecyclerView.ViewHolder{
        public TextView textViewTaskName;
        public TextView textViewTaskDesc;
        public Switch switchTaskStatus;
        public CardView cardView;

        public TaskViewHolder (View itemView){
            super(itemView);
            textViewTaskName = itemView.findViewById(R.id.textViewTaskName);
            textViewTaskDesc = itemView.findViewById(R.id.textViewTaskDescription);
            switchTaskStatus = itemView.findViewById(R.id.switchTaskStatus);
            cardView = itemView.findViewById(R.id.cardViewTask);
        }
    }

    @NonNull
    @Override
    public TaskAdapter.TaskViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.task_item, parent, false);
        return new TaskViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TaskAdapter.TaskViewHolder holder, int position) {
        Task task = taskList.get(position);
        holder.textViewTaskName.setText(task.getTaskName());
        holder.textViewTaskDesc.setText(task.getTaskDescription());

        // Set task status switch
        holder.switchTaskStatus.setChecked(task.isCompleted());
        holder.switchTaskStatus.setOnCheckedChangeListener((buttonView, isChecked) -> {
            task.setCompleted(isChecked);

            // Change the background color based on the task status
            if (isChecked) {
                holder.cardView.setBackgroundColor(ContextCompat.getColor(context, R.color.completedTaskColor));
            } else {
                holder.cardView.setBackgroundColor(ContextCompat.getColor(context, R.color.pendingTaskColor));
            }
        });
    }

    @Override
    public int getItemCount() {
        return taskList.size();
    }
}
