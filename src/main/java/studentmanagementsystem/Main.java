package studentmanagementsystem;

import studentmanagementsystem.controller.StudentController;
import studentmanagementsystem.repository.StudentRepository;
import studentmanagementsystem.services.StudentService;
import studentmanagementsystem.view.MenuHandler;

public class Main {

    public static void main(String[] args) {

        //  Create repository (data layer)
        StudentRepository repository = new StudentRepository();

        //  Service uses repository
        StudentService service = new StudentService(repository);

        // Controller uses service
        StudentController controller = new StudentController(service);

        // Start menu system
        MenuHandler menu = new MenuHandler(controller);
        menu.start();
    }
}