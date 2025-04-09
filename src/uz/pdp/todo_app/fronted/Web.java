package uz.pdp.todo_app.fronted;

import uz.pdp.todo_app.backend.domains.Todo;
import uz.pdp.todo_app.backend.dtos.TodoUpdateDTO;
import uz.pdp.todo_app.backend.enums.Category;
import uz.pdp.todo_app.backend.enums.Priority;
import uz.pdp.todo_app.backend.services.TodoService;
import uz.pdp.todo_app.backend.services.TodoServiceImpl;

import java.util.Scanner;

public class Web {
    static TodoService todoService = new TodoServiceImpl();
    public static void main(String[] args) {
        testGetAllTodoMethod();
        testGetAllTodoMethod();
        testGetAllTodoMethod();
        testUpdateTodoMethod();
        testGetAllTodoMethod();

    }
    static void testCreateTodoMethod(){
        Todo todo1=Todo.builder().title("read a book").priority(Priority.HIGH).category(Category.STUDY).build();
        Todo todo2=Todo.builder().title("read a book 2").build();
        Todo todo3=Todo.builder().title("read a book 3").build();
        todoService.create(todo1);
        todoService.create(todo2);
        todoService.create(todo3);
    }
     static void testGetAllTodoMethod(){
         System.out.println("----------------------------");
         for (Todo todo: todoService.getAll()){
             System.out.println(todo);
         }
     }
     static void testDeleteTodoMethod(){
        final Scanner scanner = new Scanner(System.in);
        System.out.print("Enter id: ");
        String id = scanner.nextLine();
         todoService.delete(id);
     }
     static void testUpdateTodoMethod(){
        final Scanner scanner = new Scanner(System.in);
        System.out.print("Enter id: ");
        String id = scanner.nextLine();
         System.out.print("Enter title: ");
         String title = scanner.nextLine();
         TodoUpdateDTO dto=new TodoUpdateDTO(id,title);
         todoService.update(dto);
     }
}
