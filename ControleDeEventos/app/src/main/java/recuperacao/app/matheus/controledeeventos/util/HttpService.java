package recuperacao.app.matheus.controledeeventos.util;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

/**
 * Created by mathe on 12/04/2016.
 */
public class HttpService {

    private static final String URL_GET = "http://ladoss.com.br:8773/Convite_SERVICE/convidado/pesquisar/nome/Jose";
    private static final String URL_POST = "http://ladoss.com.br:8773/Convite_SERVICE/convidado/pesquisar/qrcode";

    public static Response sendGetRequest(String Json)
            throws MalformedURLException, IOException {

        HttpURLConnection connection;
        URL url = new URL(URL_GET);
        Response response;

        connection = (HttpURLConnection) url.openConnection();
        connection.setDoOutput(true);
        connection.setDoInput(true);
        connection.setRequestMethod("GET");
        connection.setRequestProperty("Content-type", "application/json");
        connection.connect();

        DataOutputStream outputStream = new DataOutputStream(connection.getOutputStream());
        outputStream.writeBytes(Json.toString());
        outputStream.flush();
        outputStream.close();

        int httpCode = connection.getResponseCode();
        String content = getHttpContent(connection);
        response = new Response(httpCode, content);

        return response;

    }

    public static Response sendPostRequest(String Json)
            throws MalformedURLException, IOException {

        HttpURLConnection connection;
        Response response;
        URL url = new URL(URL_POST);

        connection = (HttpURLConnection) url.openConnection();
        connection.setDoOutput(true);
        connection.setDoInput(true);
        connection.setRequestMethod("POST");
        connection.setRequestProperty("Content-type", "application/json");
        connection.connect();

        DataOutputStream outputStream = new DataOutputStream(connection.getOutputStream());
        outputStream.writeBytes(Json.toString());
        outputStream.flush();
        outputStream.close();

        int httpCode = connection.getResponseCode();
        String content = getHttpContent(connection);
        response = new Response(httpCode, content);

        return response;
    }

    public static String getHttpContent(HttpURLConnection connection) {

        StringBuilder builder = new StringBuilder();

        try {
            InputStream content;

            if (connection.getResponseCode() <= HttpURLConnection.HTTP_BAD_REQUEST) {
                content = connection.getInputStream();
            } else {
                content = connection.getErrorStream();

                BufferedReader reader = new BufferedReader(new InputStreamReader(content, "UTF-8"), 8);

                String line;

                while ((line = reader.readLine()) != null) {
                    builder.append(line);
                }
            }

            content.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

        return builder.toString();
    }
}
