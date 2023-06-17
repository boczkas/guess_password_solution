package guess_password.password;

import org.springframework.stereotype.Repository;

@Repository
public class PasswordRepository {

    private Password password;
    private Password currentGuess;

    public void setPassword(Password password) {
        this.password = password;
    }

    public void setCurrentGuess(Password currentGuess) {
        this.currentGuess = currentGuess;
    }

    public Password getPassword() {
        return password;
    }

    public Password getCurrentGuess() {
        return currentGuess;
    }
}
