package rali;

public class ArrayExample {
	public static void main(String[] args) {

		User[] users = new User[5];
		users[0] = new User("Vlad");
		users[1] = new User("Vasya");
		users[2] = new User("Pert");
		users[3] = new User("Make");
		users[4] = new User("Misha");
		
		User user = ArrayExample.findByName(users, users[3].name);
		
	}
	public static User findByName(User[] users, String name) {
		User result = null;
		for (User user : users) {
			if (name.equals(user.name)) {
				return user;
			}
		}
		return result;
	}
}