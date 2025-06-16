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


//        userService.add(new User("User1", "LastName1", "emailUser1"));
//        userService.add(new User("User2", "LastName2", "emailUser2"));
//        userService.add(new User("User3", "LastName3", "emailUser3"));
//        userService.add(new User("User4", "LastName4", "emailUser4"));

//         User user5 = new User("User5", "LastName5", "emailUser5");
//         User user6 = new User("User6", "LastName6", "emailUser6");
//
//        Car carForUser5 = new Car("Model5",1);
//        Car carForUser6 = new Car("Model6",2);
//
//        user5.setCar(carForUser5);
//        user6.setCar(carForUser6);
//        carForUser5.setUser(user5);
//        carForUser6.setUser(user6);
//
//        userService.add(user5);
//        userService.add(user6);

        List<User> users = userService.listUsers();
        for (User user : users) {
            System.out.println("Id = "+user.getId());
            System.out.println("First Name = "+user.getFirstName());
            System.out.println("Last Name = "+user.getLastName());
            System.out.println("Email = "+user.getEmail());
            System.out.println("Car = "+user.getCar());
            System.out.println();
        }



        userService.getUserByCarModelAndSeries("Model5",1);





        context.close();
    }
}
