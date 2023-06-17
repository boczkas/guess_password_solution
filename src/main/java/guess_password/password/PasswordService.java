package guess_password.password;

import org.springframework.stereotype.Service;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class PasswordService {

    private final PasswordRepository passwordRepository;

    public PasswordService(PasswordRepository passwordRepository) {
        this.passwordRepository = passwordRepository;
    }

    public void setCurrentGuess(String currentGuess) {
        Password replacedPassword = new Password(currentGuess);
        passwordRepository.setCurrentGuess(replacedPassword);
    }

    public Password getCurrentGuess() {
        return passwordRepository.getCurrentGuess();
    }

    public void updateCurrentGuess(String letter) {
        String passwordText = passwordRepository.getPassword().getText();
        if (passwordText.contains(letter)) {
            String updatedText =
                    getUpdatedText(
                            passwordText, passwordRepository.getCurrentGuess().getText(), letter);
            passwordRepository.setCurrentGuess(new Password(updatedText));
        }
    }

    private String getUpdatedText(String passwordText, String currentGuessText, String letter) {
        int index = passwordText.indexOf(letter);
        List<Integer> indexesOfLetter = new ArrayList<>();

        while (index >= 0) {
            indexesOfLetter.add(index);
            index = passwordText.indexOf(letter, index + 1);
        }

        StringBuilder stringBuilder = new StringBuilder(currentGuessText);
        for (int i : indexesOfLetter) {
            stringBuilder.setCharAt(i, letter.charAt(0));
        }

        return stringBuilder.toString();
    }

    public boolean isPasswordCorrect(String password) {
        return passwordRepository.getPassword().getText().equals(password);
    }

    public void setRandomPassword() throws NoSuchAlgorithmException {
        Random rand = SecureRandom.getInstanceStrong();
        List<String> passwords = WordList.getWORDS();
        int index = rand.nextInt(passwords.size());
        String passwordText = passwords.get(index);
        passwordRepository.setPassword(new Password(passwordText));
        System.out.println("Ustawiam haslo na " + passwordText);
    }

    public String getPasswordText() {
        return passwordRepository.getPassword().getText();
    }
}
