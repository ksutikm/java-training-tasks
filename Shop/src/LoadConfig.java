import org.jetbrains.annotations.Nullable;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

public class LoadConfig {

    private static Properties getProperties(String path) {
        File file = new File(path);
        Properties prop = new Properties();

        try (InputStream input = new FileInputStream(file)) {
            prop.load(input);
        } catch (NullPointerException ex) {
            System.out.println("Sorry, unable to find config.properties file");
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        return prop;
    }

    public static String getPathDataCatalog(String path) {
        Properties prop = getProperties(path);

        return prop.getProperty("filePath");
    }

    public static List<String> getFilters(String path) {
        Properties prop = getProperties(path);
        String strFilters = prop.getProperty("filters");
        List<String> filters = Arrays.asList(strFilters.split(",", -1));

        return filters;
    }
}
