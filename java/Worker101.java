import java.io.*;
import java.nio.MappedByteBuffer;
import java.nio.charset.Charset;
import java.nio.channels.FileChannel;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonArray;
import com.google.gson.JsonParser;

import java.net.URL;

import org.json.JSONArray;
import org.json.JSONObject;
import io.iron.ironworker.client.helpers.WorkerHelper;

public class Worker101 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        System.out.println("Running worker");
        WorkerHelper helper = WorkerHelper.fromArgs(args);
        BufferedReader in = new BufferedReader(
                new InputStreamReader(System.in));
        String urlstr = "http://en.wikipedia.org/w/api.php?action=query&prop=revisions&rvprop=content&rvsection=0&format=json&titles=";
        StringBuffer buff = new StringBuffer();

        // Get payload data with the IronWorker helper
        PayloadData payload = helper.getPayload(PayloadData.class);
        System.out.println("Hello " + payload.getName());

    }

    private static void writeFile(String path, String content) throws IOException {
        Writer out = new OutputStreamWriter(new FileOutputStream(path));
        try {
            out.write(content);
        } finally {
            out.close();
        }

    }
}
