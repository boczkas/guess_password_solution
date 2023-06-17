package guess_password.password;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.security.NoSuchAlgorithmException;

@Controller
@CrossOrigin(origins = "http://localhost:4200")
public class PasswordController {

    private final PasswordService passwordService;

    public PasswordController(
            PasswordService passwordService) {
        this.passwordService = passwordService;
    }

    @GetMapping("/password")
    @ResponseBody
    public Password getPassword() throws NoSuchAlgorithmException {
        passwordService.setRandomPassword();
        passwordService.setCurrentGuess(
                passwordService.getPasswordText().replaceAll("(\\w)", "*"));
        return passwordService.getCurrentGuess();
    }

    @PostMapping("/guess")
    @ResponseBody
    public Password guess(@RequestBody String letter) {
        passwordService.updateCurrentGuess(letter);

        return passwordService.getCurrentGuess();
    }

    @PostMapping("/guess/password")
    @ResponseBody
    public boolean guessPassword(@RequestBody String password) {
        return passwordService.isPasswordCorrect(password);
    }
}
