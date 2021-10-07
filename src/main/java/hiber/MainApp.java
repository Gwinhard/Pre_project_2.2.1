package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class MainApp {
   public static void main(String[] args) throws SQLException {
      AnnotationConfigApplicationContext context = 
            new AnnotationConfigApplicationContext(AppConfig.class);

      UserService userService = context.getBean(UserService.class);

      Car toyota = new Car("Land Cruiser", 1);
      User user1 = new User("Ivan", "Petrov", "user1@mail.ru");
      user1.setCar(toyota);
      userService.add(user1);

      Car ford = new Car("Focus", 2);
      User user2 = new User("Petr", "Ivanov", "user2@mail.ru");
      user2.setCar(ford);
      userService.add(user2);

      Car subaru = new Car("Impreza", 3);
      User user3 = new User("Vladislav", "Harlamov", "user3@mail.ru");
      user3.setCar(subaru);
      userService.add(user3);

      Car uaz = new Car("Patriot", 4);
      User user4 = new User("Andrey", "Semenov", "user4@mail.ru");
      user4.setCar(uaz);
      userService.add(user4);


      List<User> users = userService.listUsers();
      for (User user : users) {
         System.out.println("Id = "+user.getId());
         System.out.println("First Name = "+user.getFirstName());
         System.out.println("Last Name = "+user.getLastName());
         System.out.println("Email = "+user.getEmail());
         System.out.println();
      }

      System.out.println(userService.getUserByModelAndSeries("Land Cruiser", 1));
      System.out.println(userService.getUserByModelAndSeries("Focus", 2));
      System.out.println(userService.getUserByModelAndSeries("Impreza", 3));
      System.out.println(userService.getUserByModelAndSeries("Patriot", 4));


      context.close();
   }
}
