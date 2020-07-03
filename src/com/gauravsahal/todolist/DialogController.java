package com.gauravsahal.todolist;

import com.gauravsahal.todolist.dataModel.TodoData;
import com.gauravsahal.todolist.dataModel.TodoItem;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.time.LocalDate;

/**
 * Created by GauravSahal on 07-06-2020
 */

public class DialogController {

    @FXML
    private TextField shortDescriptionField;

    @FXML
    private TextArea detailsArea;

    @FXML
    private DatePicker deadlinePicker;

    public TodoItem processResults(){
        String shortDescription = shortDescriptionField.getText().trim();
        String details = detailsArea.getText().trim();
        LocalDate deadlineValue = deadlinePicker.getValue();

        TodoItem newItem = new TodoItem(shortDescription,details,deadlineValue);
        TodoData.getInstance().addTodoItem(newItem);
        return newItem;
    }
}
