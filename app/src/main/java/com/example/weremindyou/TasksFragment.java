package com.example.weremindyou;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;

import androidx.fragment.app.Fragment;

public class TasksFragment extends Fragment {

    private ListView taskList;
    Button newtask;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tasks, container, false);
        taskList = (ListView)view.findViewById(R.id.task_list);
//         TaskListAdapter taskListAdapter = listener.getTaskListAdapter();
//         taskList.setAdapter(taskListAdapter);
//        taskList.setOnItemClickListener(listOnItemClickListener); // making it editable
//    registerForContextMenu(taskList); // choose edit or delete


        return view;
    }
//  public void onNewbutton(View v)
//  {
//    Intent in = new Intent(this,EditActivity.class);
//      startActivity(in);
//    setContentView(R.layout.activity_edit);
//
//   }

}


