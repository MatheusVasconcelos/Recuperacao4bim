package recuperacao.app.matheus.controledeeventos.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import recuperacao.app.matheus.controledeeventos.R;

public class MainActivity extends AppCompatActivity {

    @Bind(R.id.tv_pesquisa_code)
    TextView mBtQrCode;
    @Bind(R.id.tv_Pesquisa_nome)
    TextView mBtNome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

    }

    @OnClick(R.id.tv_pesquisa_code)
    public void btnQrCodeListener(){

        Intent intent = new Intent(MainActivity.this, QrCodeActivity.class);
        startActivity(intent);
    }

    @OnClick(R.id.tv_Pesquisa_nome)
    public void btnPesquisaNomeListener(){

        Intent intent = new Intent(MainActivity.this, PesquisarPorNomeActivity.class);
        startActivity(intent);
    }
}
