package recuperacao.app.matheus.controledeeventos.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import recuperacao.app.matheus.controledeeventos.R;
import recuperacao.app.matheus.controledeeventos.adapter.ListAdapter;
import recuperacao.app.matheus.controledeeventos.callback.PesquisaCallBack;
import recuperacao.app.matheus.controledeeventos.controller.NomeAsynctask;
import recuperacao.app.matheus.controledeeventos.exclusion.ExclusaoJson;
import recuperacao.app.matheus.controledeeventos.model.Convidado;

public class PesquisarPorNomeActivity extends AppCompatActivity implements TextWatcher,
        AdapterView.OnItemClickListener, PesquisaCallBack{

    @Bind(R.id.ed_nomes)
    EditText mEdNomes;
    @Bind(R.id.lv_nomes)
    ListView mLvNomes;

    private static int TAMANHO_FONTE = 4;
    private PesquisaCallBack mCallBack;
    Convidado mConvidado = new Convidado();
    List<Convidado> mConvidadosList;
    ListAdapter mAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pesquisar_por_nome);
        ButterKnife.bind(this);

        mEdNomes.addTextChangedListener(this);

        mConvidadosList = new ArrayList<Convidado>();
        mAdapter = new ListAdapter(this,mConvidadosList);

        mLvNomes.setAdapter(mAdapter);
        mLvNomes.setOnItemClickListener(this);
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence charSequence, int start, int before, int count) {

        String nome = charSequence.toString();
        Convidado convidado = new Convidado();
        convidado.setmNome(nome);

        if (nome.length() >= TAMANHO_FONTE){

            Gson gson = new GsonBuilder().setExclusionStrategies(new ExclusaoJson()).create();
            String Json = gson.toJson(convidado);
            NomeAsynctask nomeAsynctask = new NomeAsynctask(this);
            nomeAsynctask.execute(Json);
        }

    }

    @Override
    public void afterTextChanged(Editable s) {

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

        Convidado convidado = (Convidado) mLvNomes.getItemAtPosition(position);
        Intent intent = new Intent(this, ExibirInfoActivity.class);
        intent.putExtra("Convidado", convidado);
        startActivity(intent);


    }

    @Override
    public void pesquisaCallBack(List<Convidado> convidados) {
        this.mConvidadosList.clear();
        this.mConvidadosList.addAll(mConvidadosList);
        mAdapter.notifyDataSetChanged();

    }

    @Override
    public void erroPesquisaCallBack(String erro) {
        this.mConvidadosList.clear();
        mAdapter.notifyDataSetChanged();


    }
}
