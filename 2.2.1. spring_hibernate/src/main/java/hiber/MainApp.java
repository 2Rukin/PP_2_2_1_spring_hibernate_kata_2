package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.hibernate.Transaction;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MainApp {
    public static void main(String[] args) throws SQLException {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

        UserService userService = context.getBean(UserService.class);
//               List<Car> cars = Arrays.asList(new Car("Тачка", 6),
//                new Car("Тачка4", 8),
//                new Car("Тачка6", 87),
//                new Car("Тачка5", 99));
//        List<User> users = Arrays.asList(new User("User1", "Lastname1", "user1@mail.ru"),
//                new User("User3", "Lastname3", "user3@mail.ru"),
//                new User("User4", "Lastname4", "user4@mail.ru"),
//                new User("User5", "Lastname5", "user5@mail.ru")
//        );
//
//        for (int i = 0; i < users.size(); i++) {
//            users.get(i).setCar(cars.get(i));
//            userService.add(users.get(i));
//        }

//        userService.add(new User("User1", "Lastname1", "user1@mail.ru"));
//        userService.add(new User("User2", "Lastname2", "user2@mail.ru"));
//        userService.add(new User("User3", "Lastname3", "user3@mail.ru"));
//        userService.add(new User("User4", "Lastname4", "user4@mail.ru"));
//        userService.add(new User("User5", "Lastname5", "user5@mail.ru"));

        List<User> users2 = userService.listUsers();
        for (User user : users2) {
            System.out.println("Id = " + user.getId());
            System.out.println("First Name = " + user.getFirstName());
            System.out.println("Last Name = " + user.getLastName());
            System.out.println("Email = " + user.getEmail());
            System.out.println();
        }

//       userService.getUserCarList("Тачка", 6);
        System.out.println(userService.getUserCarList("Тачка6", 87));

        context.close();
    }
}
