package com.gauravsahal.todolist.dataModel;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Iterator;

/**
 * Created By GauravSahal on 04-06-2020
 */

public class TodoData {

    private static TodoData instance = new TodoData();
    private static String filename = "TodoListItems.txt";

    private ObservableList<TodoItem> todoItems;
    private DateTimeFormatter formatter;

    public static TodoData getInstance()
    {
        return instance;
    }

    private TodoData()
    {
        formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
    }

    public ObservableList<TodoItem> getTodoItems()
    {
        return todoItems;
    }

    public void addTodoItem(TodoItem item){
        todoItems.add(item);
    }


    public void loadTodoItems() throws IOException{

        todoItems = FXCollections.observableArrayList();
        Path path = Paths.get(filename);
        BufferedReader br = Files.newBufferedReader(path);

        String input;

        try{
            while((input = br.readLine()) != null){
                String[] itemPieces = input.split("###");

                if(itemPieces[0]==null){
                    br.readLine();
                }
                String shortDescription = itemPieces[0];
                if(itemPieces[1]==null){
                    br.readLine();
                }
                String details = itemPieces[1];
                if(itemPieces[2]==null){
                    br.readLine();
                }
                String dateString = itemPieces[2];

                LocalDate date = LocalDate.parse(dateString, formatter);
                TodoItem todoItem = new TodoItem(shortDescription, details, date);
                todoItems.add(todoItem);
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        finally{
            if(br != null)
            {
                br.close();
            }
        }
    }

    public void storeTodoItems() throws IOException{
        Path path = Paths.get(filename);
        BufferedWriter bw = Files.newBufferedWriter(path);
        try{
            Iterator<TodoItem> iter = todoItems.iterator();
            while(iter.hasNext()){
                TodoItem item = iter.next();
                bw.write(String.format("%s###%s###%s",
                            item.getShortDescription(),
                            item.getDetails(),
                            item.getDeadLine().format(formatter)));
                bw.newLine();
            }
        }finally{
            if(bw != null){
                bw.close();
            }
        }
    }

    public void deleteTodoItem(TodoItem item){
        todoItems.remove(item);
    }
}
