package com.example.dbdemotodolist.view;

import com.example.dbdemotodolist.model.bean.ToDo;

import java.util.List;

public interface MVCMainActivityView extends MVCView{
    public void bindDataToView();

    public void showAllToDos(List<ToDo> toDoList);
    public void updateViewonAdd(List<ToDo> toDoList);
    public void upDateViewOnRemove(List<ToDo> toDoList);
    public void updateViewOnModify(List<ToDo> toDoList);

    public void showErrorToast(String errorMessage);
}
