package edu.uaslp.objetos.taskslist;

import edu.uaslp.objetos.exceptions.TaskListException;
import edu.uaslp.objetos.exceptions.TaskNotFoundException;

import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class TaskList {

    LinkedList<Task> taskList = new LinkedList<>();

    public int getSize() {
        return 0;
    }

    public void add(Task task) {
        taskList.add(task);
    }

    public void remove(Task task) {
        taskList.remove(task);
    }


    public Task find(String title) throws TaskNotFoundException{
        int size=taskList.size();

        for (Task task : taskList) {
            if (Objects.equals(title, task.getTitle())) {
                return task;
            }
        }
        throw new TaskNotFoundException("Task with title 'Hacer ejercicio' not found");
    }


    public void markAsDone(String title) {
        Task task;
        boolean done=true;
        task=find(title);

        task.setDone(done);
    }

    public void markAsNotDone(String title) {
        Task task;
        boolean done=false;
        task=find(title);

        task.setDone(done);
    }

    public Task getNextTask() {
        LocalDateTime time = LocalDateTime.now();
        int size=taskList.size();

        for (int i=0; i<size; i++){
            if (time.compareTo(taskList.get(i).getDueDate()) > 0){
                return taskList.get(i+1);
            }
        }
        throw new TaskListException();
    }

    public List<Task> getNextTasks() {
        List<Task> taskListAux = new LinkedList<>();
        LocalDateTime time = LocalDateTime.now();

        for (int i=0; i<taskList.size(); i++){
            if (time.compareTo(taskList.get(i).getDueDate()) > 0 && taskList.get(i).isDone() == false){
                taskListAux.add(taskList.get(i));
            }
        }
        return (taskListAux);
    }
}
