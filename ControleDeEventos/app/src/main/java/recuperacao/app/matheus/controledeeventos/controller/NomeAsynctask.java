package recuperacao.app.matheus.controledeeventos.controller;

import android.os.AsyncTask;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.net.ssl.HttpsURLConnection;

import recuperacao.app.matheus.controledeeventos.callback.PesquisaCallBack;
import recuperacao.app.matheus.controledeeventos.model.Convidado;
import recuperacao.app.matheus.controledeeventos.util.HttpService;
import recuperacao.app.matheus.controledeeventos.util.Response;

/**
 * Created by mathe on 13/04/2016.
 */
public class NomeAsynctask extends AsyncTask<String, Void, Response> {

    private PesquisaCallBack mCallBack;

    public NomeAsynctask(PesquisaCallBack mCallBack) {
        this.mCallBack = mCallBack;
    }


    @Override
    protected Response doInBackground(String... json) {

        Response response = null;

        String auxJSON = json[0];

        try {

            response = HttpService.sendGetRequest(auxJSON);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


        return response;
    }

    @Override
    protected void onPostExecute(Response response) {

        int codeHttp = response.getStatusCodeHttp();

        if (codeHttp != HttpsURLConnection.HTTP_OK) {
            mCallBack.erroPesquisaCallBack(response.getContentValue());
        } else {
            Gson gson = new Gson();
            List<Convidado> convidados = gson.fromJson(response.getContentValue(), new TypeToken<ArrayList<Convidado>>() {
            }.getType());

            mCallBack.pesquisaCallBack(convidados);
        }
    }
}
