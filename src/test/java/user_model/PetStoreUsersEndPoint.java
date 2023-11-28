package user_model;

import com.google.gson.Gson;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class PetStoreUsersEndPoint {

    public Response getUserByUsername(String username) {
        return given()
                .baseUri(Config.PETSTORE_BASE_URL)
                .pathParam("username", username)
                .when()
                .get(Config.USER_BY_USERNAME)
                .then().extract().response();
    }

    public Response createUser(User user) {
        Gson gson = new Gson();
        String json;
        json = gson.toJson(user);

        return given()
                .baseUri(Config.PETSTORE_BASE_URL)
                .contentType("application/json")
                .body(json)
                .when()
                .post(Config.CREATE_USER)
                .then().extract().response();
    }
        public void updateUser(String username, User user) {
        Gson gson = new Gson();
        String json;
        json = gson.toJson(user);

        given()
                .baseUri(Config.PETSTORE_BASE_URL)
                .contentType("application/json")
                .body(json)
                .when()
                .put(Config.USER_BY_USERNAME, username)
                .then().extract().response();
    }

    public Response deleteUser(String username) {
        return given()
                .baseUri(Config.PETSTORE_BASE_URL)
                .when()
                .delete(Config.USER_BY_USERNAME, username)
                .then().extract().response();
    }
}
