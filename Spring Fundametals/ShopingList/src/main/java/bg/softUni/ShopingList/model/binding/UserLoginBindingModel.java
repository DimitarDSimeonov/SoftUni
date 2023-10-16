package bg.softUni.ShopingList.model.binding;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class UserLoginBindingModel {

    @NotBlank(message = "User name cannot be empty")
    @Size(min = 3, max = 20, message = "Username length must be between 3 and 20 symbol")
    private String username;

    @NotBlank (message = "Password cannot be empty!")
    @Size (min = 3, max = 20, message = "Password must be between 3 and 20 symbol")
    private String password;

    public UserLoginBindingModel() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
