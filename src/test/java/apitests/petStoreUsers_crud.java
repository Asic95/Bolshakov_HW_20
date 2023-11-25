package apitests;

import com.google.gson.Gson;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import user_model.PetStoreUsersEndPoint;
import user_model.User;
import user_model.UserDeleteResponce;
import user_model.UserPostResponce;

public class petStoreUsers_crud {

    static final int id = 10000;
    static final String username = "Vasya132";
    static final String firstName = "Vasyl";
    static final String lastName = "Tymchenko";
    static final String email = "vasya@ukr.net";
    static final String password = "vasya";
    static final String phone = "5555555";
    static final int userStatus = 1;

    @Test
    public void crete_user() {
        Gson gson = new Gson();
        UserPostResponce userPostResponce;
        SoftAssert softAssert = new SoftAssert();


        // Given
        new PetStoreUsersEndPoint().deleteUser(username);
        User user = new User(id, username, firstName, lastName, email, password, phone, userStatus);

        // When
        Response usersResponse = new PetStoreUsersEndPoint()
                .createUser(user);

        // Then
        userPostResponce = gson.fromJson(usersResponse.body().asString(), UserPostResponce.class);
        softAssert.assertEquals(userPostResponce.getCode(), 200);
        softAssert.assertEquals(userPostResponce.getType(), "unknown");
        softAssert.assertEquals(userPostResponce.getMessage(), id);
        softAssert.assertAll();
    }

    @Test
    public void read_user_data() {
        User user;
        Gson gson = new Gson();
        SoftAssert softAssert = new SoftAssert();

        // Given
        new PetStoreUsersEndPoint().deleteUser(username);
        user = new User(id, username, firstName, lastName, email, password, phone, userStatus);
        new PetStoreUsersEndPoint()
                .createUser(user);

        // When
        Response usersResponse = new PetStoreUsersEndPoint()
                .getUserByUsername(username);

        // Then
        user = gson.fromJson(usersResponse.body().asString(), User.class);
        softAssert.assertEquals(user.getID(), id);
        softAssert.assertEquals(user.getUserName(), username);
        softAssert.assertEquals(user.getFirstName(), firstName);
        softAssert.assertEquals(user.getLastName(), lastName);
        softAssert.assertEquals(user.getEmail(), email);
        softAssert.assertEquals(user.getPassword(), password);
        softAssert.assertEquals(user.getPhone(), phone);
        softAssert.assertEquals(user.getUserStatus(), userStatus);
        softAssert.assertAll();

    }

    @Test
    public void delete_user() {
        User user;
        UserDeleteResponce deletedData;
        Gson gson = new Gson();
        SoftAssert softAssert = new SoftAssert();

        // Given
        new PetStoreUsersEndPoint().deleteUser(username);
        user = new User(id, username, firstName, lastName, email, password, phone, userStatus);
        new PetStoreUsersEndPoint()
                .createUser(user);

        // When
        Response usersResponse = new PetStoreUsersEndPoint()
                .deleteUser(username);
        deletedData = gson.fromJson(usersResponse.body().asString(), UserDeleteResponce.class);
        softAssert.assertEquals(deletedData.getCode(),200);
        softAssert.assertEquals(deletedData.getType(), "unknown");
        softAssert.assertEquals(deletedData.getMessage(), username);

        // Then
        Response usersResponse2 = new PetStoreUsersEndPoint()
                .getUserByUsername(username);
        softAssert.assertEquals(usersResponse2.statusCode(), 404);
        softAssert.assertAll();
    }
}
