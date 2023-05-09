import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.awt.*;
public class App {

    public static void main(String[] args) throws Exception {

        File file = new File("testfile.html");//TODO Crear un fitxer amb la classe File
        //el nom del fitxer serà testfile.html


        String str = urlReader("http://inslaguineueta.cat");

        saveToFile(str, file, false);//TODO cridar la funció perquè guardi str al fitxer


        String fileContent = readFromFile(file);
        System.out.println(fileContent);//TODO LLegir el contingut del fitxer i imprimir-lo
        //per pantalla.
        // Abrir el archivo con el navegador por defecto
        if (Desktop.isDesktopSupported()) {
            Desktop.getDesktop().browse(file.toURI());
        }
    }

    static String readFromFile(File file) throws IOException {
        FileReader fr = new FileReader(file);
        BufferedReader bufr = new BufferedReader(fr);
        StringBuilder sb = new StringBuilder();
        String line;
        while((line = bufr.readLine()) != null){
            sb.append(line);
        }
        bufr.close();
        return sb.toString();//TODO usant FileReader i BufferedReader
    }

    static void saveToFile(String str, File file, boolean append) throws IOException {
        FileWriter fw = new FileWriter(file, append);

        BufferedWriter bufw = new BufferedWriter(fw);

        bufw.write(str);

        bufw.close();//TODO usant FileWriter i BufferedWriter
    }

    public static String urlReader(String url) throws Exception {
            URL oracle = new URL(url);
            URLConnection yc = oracle.openConnection();
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(
                            yc.getInputStream()));
            String inputLine;
            StringBuilder sb = new StringBuilder();
            while ((inputLine = in.readLine()) != null)
                sb.append(inputLine);
            in.close();
            return sb.toString();
    }

}

