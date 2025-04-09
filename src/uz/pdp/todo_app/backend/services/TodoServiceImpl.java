package uz.pdp.todo_app.backend.services;

import uz.pdp.todo_app.backend.domains.Todo;
import uz.pdp.todo_app.backend.dtos.TodoUpdateDTO;
import uz.pdp.todo_app.backend.utils.TodoUtil;

import java.util.Arrays;

public class TodoServiceImpl implements TodoService{
    private int index = 0;
    @Override
    public Todo create(Todo todo) {
        todo.setId(TodoUtil.generateUniqueId());
        todos[index++] = todo;
        return todo;
    }

    @Override
    public boolean delete(String todoId) {
        int deleteIndex = getTodoIndexByToId(todoId);
        if(deleteIndex == -1) return false;
        for(int i = deleteIndex; i < index; i++) {
            todos[i]=todos[i+1];
        }
        index--;
        return true;
    }

    private int getTodoIndexByToId(String todoId) {
        for (int i = 0; i < index; i++) {
            Todo todo =todos[i];
            if(todo.getId().equals(todoId)){
                return i;

            }
        }
        return -1;
    }

    @Override
    public boolean update(TodoUpdateDTO dto) {
        int todoIndex = getTodoIndexByToId(dto.id());
        if(todoIndex==-1) return false;
        Todo todo =todos[todoIndex];
        todo.setTittle(dto.title());
        todos[todoIndex]=todo;
        return true;
    }

    @Override
    public Todo get(String todoId) {
        return null;
    }

    @Override
    public Todo[] getAll() {
        return Arrays.copyOf(todos,index);
    }
    private static int getFirstNullIndex(){
        int index=-1;
        for(int i =0;i<todos.length;i++){
            index=i;
            break;
        }
        return index;
    }
}
