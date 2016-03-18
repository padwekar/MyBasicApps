package healthsignz.com.parsingjsonurlfinal.AsyncClasses;

import android.content.Context;
import android.os.AsyncTask;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import healthsignz.com.parsingjsonurlfinal.Interfaces.Commincator;

/**
 * Created by devuser on 11-03-2016.
 */
public class FetchData extends AsyncTask<Void,Void,Void> {
    String jsonURL ;
    String jsonString ;
    Commincator commincator ;


    public FetchData(Context context , String jsonURL){
        commincator = (Commincator) context;
        this.jsonURL = jsonURL ;

    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected Void doInBackground(Void[] params) {

        jsonString = downloadJSON(jsonURL);
        commincator.setJsonResponse(jsonString);
        return null;
    }


    String downloadJSON(String jsonURL){
        HttpURLConnection connection = null;
        BufferedReader bufferedReader = null ;
        StringBuffer stringBuffer = null;
        String jsonValue = "";
        try{

            URL url = new URL(jsonURL);
            connection = (HttpURLConnection)url.openConnection();
            connection.connect();

            InputStream inputStream = connection.getInputStream();

            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);

            bufferedReader = new BufferedReader(inputStreamReader);

            stringBuffer = new StringBuffer();

            String line = "";

            while((line = bufferedReader.readLine())!=null)
                stringBuffer.append(line);

            jsonValue = stringBuffer.toString();

        }catch (Exception ex){
            ex.printStackTrace();
        }finally {
            if(connection!=null)
                connection.disconnect();


                try {
                    if(bufferedReader!=null)
                    bufferedReader.close();
                }catch (Exception e){
                    e.printStackTrace();
                }
        }

        return  jsonValue;
    }

    @Override
    protected void onProgressUpdate(Void... values) {
        super.onProgressUpdate(values);
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);
    }
}
