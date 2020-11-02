package com.example.dbdemotodolist.model;

import com.example.dbdemotodolist.model.bean.ToDo;

import java.util.List;

public interface MVCModel {
    public List<ToDo> getAllToDos() throws Exception;
    public boolean addToDoItem(String toDoItem, String place) throws Exception;
    public boolean removeToDoItem(int id) throws Exception;
    public boolean modifyToDoItem(int id, String newToDoValuel) throws Exception;
}
