package rali;

/**
 * Created by Vladislav on 31.10.2016.
 */
public class UserStore {
    public static void main(String[] args) {
        User user = new User();
        System.out.println(user.getName());

        user = new User("Vlad");
        System.out.println(user.getName());
    }
}
