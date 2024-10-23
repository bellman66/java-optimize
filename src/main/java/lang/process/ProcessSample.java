package lang.process;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class ProcessSample {

    @Test
    void processTest() {
        // given
        String command = "ls -al";

        try {
            Process process = Runtime.getRuntime().exec(command);

            process.getInputStream().transferTo(System.out);

            process.waitFor();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    void processBuilderTest() {
        // given
        ProcessBuilder processBuilder = new ProcessBuilder(Arrays.asList("ping", "-c", "3", "www.google.com"));

        try {
            Process process = processBuilder.start();

            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(process.getInputStream()));

            String line;
            StringBuilder stringBuilder = new StringBuilder();
            while ((line = bufferedReader.readLine()) != null) {
                stringBuilder.append(line).append("\n");
            }

            int exit = process.waitFor();

            System.out.println(stringBuilder);
            Assertions.assertNotEquals(stringBuilder.length(), 0);
            Assertions.assertEquals(exit, 0);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
