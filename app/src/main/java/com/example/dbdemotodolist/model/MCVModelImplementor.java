package com.example.dbdemotodolist.model;

import com.example.dbdemotodolist.exception.ToDoNotFoundException;
import com.example.dbdemotodolist.model.bean.ToDo;
import com.example.dbdemotodolist.model.db.ToDoListDBAdapter;

import java.util.ArrayList;
import java.util.List;

public class MCVModelImplementor implements MVCModel{
    ToDoListDBAdapter toDoListDBAdapter;
    List<ToDo> toDoItems;
    public MCVModelImplementor(ToDoListDBAdapter toDoListDBAdapter){
        this.toDoListDBAdapter = toDoListDBAdapter;
        List<ToDo> alistTemp = this.toDoListDBAdapter.getAllToDos();
       if(alistTemp != null){
           if(toDoItems == null){
               toDoItems = new ArrayList<>();
           }
           toDoItems = alistTemp;
       }
    }
    private void refresh(){
        toDoItems.clear();
        toDoItems = this.toDoListDBAdapter.getAllToDos();
    }
    @Override
    public List<ToDo> getAllToDos() throws Exception {
        if(this.toDoItems!=null && this.toDoItems.size()>0){
            return this.toDoItems;
        } else {
            throw new Exception("Empty To Do List");
        }
    }

    @Override
    public boolean addToDoItem(String toDoItem, String place) throws Exception {
        boolean addSuccess = toDoListDBAdapter.insert(toDoItem, place);
        if (addSuccess){
            refresh();
        }else{
            throw new Exception("Some thing went wrong!!!");
        }

        return addSuccess;    }

    @Override
    public boolean removeToDoItem(int id) throws Exception {
        boolean deleteSuccess = toDoListDBAdapter.delete(id);
        if(deleteSuccess){
            refresh();
        }else{
            throw new ToDoNotFoundException("Id is wrong");
        }
        return deleteSuccess;
    }

    @Override
    public boolean modifyToDoItem(int id, String newToDoValuel) throws Exception {
        boolean modifySuccess = toDoListDBAdapter.modify(id,newToDoValuel);
        if(modifySuccess){
            refresh();
        } else{
            throw new ToDoNotFoundException("Id is wrong");
        }
        return modifySuccess;
    }
}
