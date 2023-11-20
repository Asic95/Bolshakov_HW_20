package apitests;

import com.google.gson.Gson;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import user_model.PetStoreUsersEndPoint;
import user_model.User;

public class petStoreUsers {

    static final int id = 10000;
    static final String username = "Vasya132";
    static final String firstName = "Vasyl";
    static final String lastName = "Tymchenko";
    static final String email = "vasya@ukr.net";
    static final String password = "vasya";
    static final String phone = "5555555";
    static final int userStatus = 1;

    @Test(priority = 1)
    public void Exercise_1() {
        User user = new User(id, username, firstName, lastName, email, password, phone, userStatus);
        Response usersResponse = new PetStoreUsersEndPoint()
                .createUser(user);

        Assert.assertEquals(usersResponse.statusCode(), 200);
    }

    @Test(priority = 2)
    public void Exercise_2() {
        User user;
        Gson gson = new Gson();

        Response usersResponse = new PetStoreUsersEndPoint()
                .getUserByUsername(username);

        user = gson.fromJson(usersResponse.body().asString(), User.class);
        System.out.println("\n");
        System.out.println("Виведення зчитаних даних з сервера: ");
        System.out.print(user.toString());

        Assert.assertNotNull(user.getID());
        Assert.assertNotEquals(0, user.getID());
    }

    @Test(priority = 3)
    public void Exercise_3() {
        Response usersResponse = new PetStoreUsersEndPoint()
                .deleteUser(username);
        Assert.assertEquals(usersResponse.statusCode(), 200);

        Response usersResponse2 = new PetStoreUsersEndPoint()
                .getUserByUsername(username);
        Assert.assertEquals(usersResponse2.statusCode(), 404);
    }
}
