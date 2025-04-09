package uz.pdp.todo_app.backend.services;

import uz.pdp.todo_app.backend.domains.Todo;
import uz.pdp.todo_app.backend.dtos.TodoUpdateDTO;

public interface TodoService {
    Todo[] todos =new Todo[100];
    Todo create(Todo todo);
    boolean delete(String todoId);
    boolean update(TodoUpdateDTO dto);
    Todo get(String todoId);
    Todo[] getAll();
}
