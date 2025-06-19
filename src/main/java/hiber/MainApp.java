package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.CarService;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class MainApp {
    public static void main(String[] args) throws SQLException {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

        UserService userService = context.getBean(UserService.class);
        CarService carService = context.getBean(CarService.class);

        userService.createListUsers(
                new User("User1", "LastName1", "emailUser1"),
                new User("User2", "LastName2", "emailUser2"),
                new User("User3", "LastName3", "emailUser3"),
                new User("User4", "LastName4", "emailUser4"));

        userService.addUserInListUsers(
                new User("User5", "LastName5", "emailUser5"),
                new User("User6", "LastName6", "emailUser6"));

        carService.createListCars(new Car("Model1", 1), new Car("Model2", 2));
        carService.addCarInListCars(
                new Car("Model3", 3),
                new Car("Model4", 4),
                new Car("Model5", 5),
                new Car("Model6", 6));


//        userService.addCarInUser(1,10);



        List<User> users = userService.listUsers();
        for (User user : users) {
            System.out.println("Id = "+user.getId());
            System.out.println("First Name = "+user.getFirstName());
            System.out.println("Last Name = "+user.getLastName());
            System.out.println("Email = "+user.getEmail());
            System.out.println("Car = "+user.getCar());
            System.out.println();
        }

        userService.getUserByCarModelAndSeries("Model5",5);


        context.close();
    }
}
