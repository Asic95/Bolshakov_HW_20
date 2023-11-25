package user_model;

import java.util.Objects;

public class UserDeleteResponce {
    private int code;
    private String type;
    private String message;

    public int getCode() {
        return code;
    }

    public String getType() {
        return type;
    }

    public String getMessage() {
        return message;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserDeleteResponce that = (UserDeleteResponce) o;
        return code == that.code && Objects.equals(type, that.type) && Objects.equals(message, that.message);
    }

    @Override
    public int hashCode() {
        return Objects.hash(code, type, message);
    }

    @Override
    public String toString() {
        return "UserPostResponce{" +
                "code=" + code +
                ", type='" + type + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}
