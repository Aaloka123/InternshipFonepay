package studentmanagementsystem;

import studentmanagementsystem.controller.StudentController;
import studentmanagementsystem.repository.StudentRepository;
import studentmanagementsystem.services.StudentService;
import studentmanagementsystem.view.MenuHandler;

public class Main {

    public static void main(String[] args) {

        // STEP 1: Create repository (data layer)
        StudentRepository repository = new StudentRepository();

        // STEP 2: Service uses repository
        StudentService service = new StudentService(repository);

        // STEP 3: Controller uses service
        StudentController controller = new StudentController(service);

        // STEP 4: Start menu system
        MenuHandler menu = new MenuHandler(controller);
        menu.start();
    }
}