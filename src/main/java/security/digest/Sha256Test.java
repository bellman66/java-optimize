package security.digest;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Sha256Test {

    @Test
    void encryptSha256() throws NoSuchAlgorithmException {
        // given
        String password = "password";

        // when
        MessageDigest instance = MessageDigest.getInstance("SHA-256");
        byte[] result = instance.digest(password.getBytes());

        // then
        assertEquals(32, result.length);
    }
}
