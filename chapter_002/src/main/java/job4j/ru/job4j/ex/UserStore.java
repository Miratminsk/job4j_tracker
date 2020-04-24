package job4j.ru.job4j.ex;

public class UserStore {

    public static User findUser(User[] users, String userName) throws UserNotFoundException {
        User result = null;
        for (User user : users) {
            if (user.getUsername().equals(userName)) {
                result = user;
            }
        }
        if (result == null) {
            throw new UserNotFoundException(userName + " is not found.");
        }
        return result;
    }

    public static boolean validate(User user) throws UserInvalidException {
        if (user.getUsername().length() < 3 || !user.isValid()) {
            throw new UserInvalidException(user.getUsername() + " is not valid user.");
        }
        return true;
    }

    public static void main(String[] args) throws UserNotFoundException {
        User[] users = {
                new User("Petr Arsentev", true),
                new User("Mirat", false),
        };
        try {
            User user = findUser(users, "Mirat");
            if (validate(user)) {
                System.out.println("This user has an access");
            }
        } catch (UserInvalidException uie) {
            System.out.println("User is not valid.");
        } catch (UserNotFoundException uie) {
            System.out.println("User is not found.");
        }
    }
}
