import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> mainDirs = Arrays.asList("src", "res", "savegames", "temp");
        List<String> srcDirs = Arrays.asList("main", "test");
        List<String> srcFiles = Arrays.asList("Main.java", "Utils.java");
        List<String> resDirs = Arrays.asList("drawables", "vectors", "icons");
        List<String> tempFiles = Arrays.asList("temp.txt");
        //Создаём StringBuilder
        StringBuilder sb = new StringBuilder();
        //Изначально создаём все директории
        for (String dir : mainDirs) {
            new File("D:/Games/" + dir).mkdirs();
            log(sb, dir, "dir");
        }
        for (String dir : srcDirs) {
            new File("D:/Games/src/" + dir).mkdirs();
            log(sb, dir, "dir");
        }
        for (String dir : resDirs) {
            new File("D:/Games/res/" + dir).mkdirs();
            log(sb, dir, "dir");
        }
        //Далее по уже знакомым расположениям создаём файлы в каталогах
        for (String file : srcFiles) {
            File srcFile = new File("D:/Games/src/main/" + file);
            try {
                srcFile.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
            log(sb, file, "file");
        }
        for (String file : tempFiles) {
            File tempFile = new File("D:/Games/temp/" + file);
            try {
                tempFile.createNewFile();
                FileWriter fw = new FileWriter(tempFile);
                fw.write(sb.toString());
                fw.flush();
                fw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            log(sb, file, "file");
        }
    }

    public static void log(StringBuilder log, String name, String format) {
        if (format.equals("dir")) {
            log.append("Каталог " + name + " Создан успешно\n");
        } else if (format.equals("file")) {
            log.append("Файл " + name + " Создан успешно\n");
        }
    }
}
