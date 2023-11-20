package user_model;

public class Config {
    public static final String PETSTORE_BASE_URL = "https://petstore.swagger.io/v2";
    public static final String USER_BY_USERNAME = "/user/{username}";
    public static final String CREATE_USER = "/user";

//    public static void setup() {
//        RestAssured.baseURI = PETSTORE_BASE_URL;
//    }
//    private static String requestBody = "{\n" +
//            "  \"id\": \"id1\",\n" +
//            "  \"username\": \"username1\",\n" +
//            "  \"firstName\": \"firstName1\",\n" +
//            "  \"lastName\": \"lastName1\",\n" +
//            "  \"email\": \"email1\",\n" +
//            "  \"password\": \"password1\",\n" +
//            "  \"phone\": \"phone1\",\n" +
//            "  \"userStatus\": \"userStatus1\" \n}";

//    public static void main(String[] args) {
//        generateBodyRequest();
//    }

//    public static String generateBodyRequest() {
//        Scanner in = new Scanner(System.in);
//        User userData = new User();
//        String newBodyRequest = "";
//        System.out.println("\n");
//        System.out.println("Створюємо нового користувача ");
//
//        System.out.println("Введіть ID користувача (integer value): ");
//        userData.setID(in.nextInt());
//        newBodyRequest = requestBody.replaceAll("id1", String.valueOf(userData.getID()));
//        in.nextLine();
//
//        System.out.println("Введіть username (string value): ");
//        userData.setUserName(in.nextLine());
//        newBodyRequest = newBodyRequest.replaceAll("username1", userData.getUserName());
//
//        System.out.println("Введіть First Name (string value): ");
//        userData.setFirstName(in.nextLine());
//        newBodyRequest = newBodyRequest.replaceAll("firstName1", userData.getFirstName());
//
//        System.out.println("Введіть Last Name (string value): ");
//        userData.setLastName(in.nextLine());
//        newBodyRequest = newBodyRequest.replaceAll("lastName1", userData.getLastName());
//
//        System.out.println("Введіть User Email (string value): ");
//        userData.setEmail(in.nextLine());
//        newBodyRequest = newBodyRequest.replaceAll("email1", userData.getEmail());
//
//        System.out.println("Введіть User Password (string value): ");
//        userData.setPassword(in.nextLine());
//        newBodyRequest = newBodyRequest.replaceAll("password1", userData.getPassword());
//
//        System.out.println("Введіть User Phone (string value): ");
//        userData.setPhone(in.nextLine());
//        newBodyRequest = newBodyRequest.replaceAll("phone1", userData.getPhone());
//
//        System.out.println("Введіть User Status (integer value): ");
//        userData.setUserStatus(in.nextInt());
//        newBodyRequest = newBodyRequest.replaceAll("userStatus1", String.valueOf(userData.getUserStatus()));
//
//        return newBodyRequest;
//    }

}
