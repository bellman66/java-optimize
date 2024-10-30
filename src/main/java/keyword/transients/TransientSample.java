package keyword.transients;

import org.junit.jupiter.api.Test;

import java.io.*;

public class TransientSample {

    /**
     *  pass by password Value serialization
     */
    static class TransientClass implements Serializable {

        private String name;
        private transient String password;

        public TransientClass(String name, String password) {
            this.name = name;
            this.password = password;
        }

        public String toString() {
            return "TransientClass{" +
                    "name='" + name + '\'' +
                    ", password='" + password + '\'' +
                    '}';
        }
    }

    @Test
    void transientTest() {
        // given
        TransientClass transientClass = new TransientClass("name", "password");

        // when
        try (
                ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("./transient.txt"));
        ) {
            oos.writeObject(transientClass);
            oos.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Before serialization : " + transientClass.password);
        System.out.println("Before serialization : " + transientClass.name);
    }

}
