package security.keypair;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RsaTest {

    @Test
    void generateRsaKeyPair() throws NoSuchAlgorithmException {
        // given
        KeyPairGenerator generator = KeyPairGenerator.getInstance("RSA");
        generator.initialize(2048);

        // when
        KeyPair keyPair = generator.generateKeyPair();

        // then
        Base64.Encoder encoder = Base64.getEncoder();
        System.out.println("public key = " + encoder.encodeToString(keyPair.getPublic().getEncoded()));
        System.out.println("private key = " + encoder.encodeToString(keyPair.getPrivate().getEncoded()));

        assertEquals("RSA", keyPair.getPublic().getAlgorithm());
        assertEquals("RSA", keyPair.getPrivate().getAlgorithm());
    }
}
