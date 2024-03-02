
import java.io.*;
import java.util.concurrent.TimeUnit;

public class Shell extends Program {
    public static File location = new File("/Users/gabrieldelarosa/Desktop/java-class/project");
    public Shell(int setPID) {
        super(setPID, "shell");
        System.out.println("custom shell...");
    }

    private static boolean isWindows = System.getProperty("os.name").toLowerCase().startsWith("windows");

    // public static void main(String[] args) throws Exception {
    //     runCommand(location, "ls"); // for Mac(Linux based OS) users list files
    // }


    public void run(String arg) throws Exception{
        runCommand(location, arg);
    }
    

    public static void runCommand(File whereToRun, String command) throws Exception {
        ProcessBuilder builder = new ProcessBuilder();
        builder.directory(whereToRun);

        if(isWindows) {
            builder.command("cmd.exe", "/c", command);
        }else {
            builder.command("sh", "-c", command);
        }

        Process process = builder.start();

        OutputStream outputStream = process.getOutputStream();
        InputStream inputStream = process.getInputStream();
        InputStream errorStream = process.getErrorStream();

        printStream(inputStream);
        printStream(errorStream);

        boolean isFinished = process.waitFor(30, TimeUnit.SECONDS);
        outputStream.flush();
        outputStream.close();

        if(!isFinished) {
            process.destroyForcibly();
        }
    }

    private static void printStream(InputStream inputStream) throws IOException {
        try(BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream))) {
            String line;
            while((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            }

        }
    }
}
