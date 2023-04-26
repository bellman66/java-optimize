package contents.regex;

import checker.CheckUtil;
import checker.Command;
import contents.common.Optimizer;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.regex.Pattern;

public class ReplaceRegex extends Optimizer {
    private String text;
    private final String from;
    private final String to;

    public ReplaceRegex(String from, String to) {
        text = "";
        this.from = from;
        this.to = to;

        Path path = Paths.get("src/main/java/contents/regex");
        File file = new File(path.toString(), "input.txt");

        try (
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(file)))
        ){
            StringBuilder builder = new StringBuilder();
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                builder.append(line).append("\n");
            }
            text = builder.toString();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void run() {
        Pattern pattern = Pattern.compile(from);

        while(text.contains(from)) {
            text = text.replaceAll(from, to);
        }
    }

    public static void main(String[] args) {
        ReplaceRegex runner = new ReplaceRegex("AWS", "");
        Command command = CheckUtil.create(runner::run);

        command.execute();
    }
}
