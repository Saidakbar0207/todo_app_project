package uz.pdp.todo_app.backend.domains;

import uz.pdp.todo_app.backend.enums.Category;
import uz.pdp.todo_app.backend.enums.Priority;

public class Todo {
    private String id;
    private String title;
    private Priority priority = Priority.LOW;
    private Category category = Category.DEFAULT;
    private boolean completed ;

    public Todo(){}

    public Todo(String id, String title, Priority priority, Category category, boolean completed) {
        this.id = id;
        this.title = title;
        this.priority = priority;
        this.category = category;
        this.completed = completed;
    }
    public boolean isCompleted() {
        return completed;
    }
    public Category getCategory() {
        return category;
    }
    public Priority getPriority() {
        return priority;
    }
    public void setTittle(String title) {
        this.title = title;
    }
    public String getTitle() {
        return title;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Todo{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", priority=" + priority +
                ", category=" + category +
                ", completed=" + completed +
                '}';
    }
    public static TodoBuilder builder(){
        return new TodoBuilder();
    }
    public static class TodoBuilder{
        private String id;
        private String title;
        private Priority priority = Priority.LOW;
        private Category category = Category.DEFAULT;
        private boolean completed ;
        public TodoBuilder id(String id){
            this.id = id;
            return this;
        }
        public TodoBuilder title(String title){
            this.title = title;
            return this;
        }
        public TodoBuilder priority(Priority priority){
            this.priority = priority;
            return this;
        }
        public TodoBuilder category(Category category){
            this.category = category;
            return this;
        }
        public TodoBuilder completed(boolean completed){
            this.completed = completed;
            return this;
        }
        public Todo build(){
            return new Todo(
                    this.id,
                    this.title,
                    this.priority,
                    this.category,
                    this.completed
            );
        }
    }
}
