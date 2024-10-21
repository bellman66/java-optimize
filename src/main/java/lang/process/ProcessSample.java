package lang.process;

import org.junit.jupiter.api.Test;

public class ProcessSample {

    @Test
    void processTest() {
        // given
        String command =  "ls -al";

        try {
            Process process = Runtime.getRuntime().exec(command);

            process.getInputStream().transferTo(System.out);

            process.waitFor();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
