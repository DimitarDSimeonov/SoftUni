package bg.softUni.ShopingList.model.binding;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class UserRegisterBindingModel {

    @NotBlank (message = "User name cannot be empty")
    @Size (min = 3, max = 20, message = "Username length must be between 3 and 20 symbol")
    private String username;


    @Email (message = "Email must be valid")
    @NotBlank (message = "Email cannot be empty")
    private String email;

    @NotBlank (message = "Password cannot be empty!")
    @Size (min = 3, max = 20, message = "Password must be between 3 and 20 symbol")
    private String password;

    @NotBlank (message = "Password cannot be empty!")
    @Size (min = 3, max = 20, message = "Password must be between 3 and 20 symbol")
    private String confirmPassword;

    public UserRegisterBindingModel() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }
}
