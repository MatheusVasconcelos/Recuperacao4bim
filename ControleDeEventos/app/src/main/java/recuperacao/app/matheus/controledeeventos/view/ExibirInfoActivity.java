package recuperacao.app.matheus.controledeeventos.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;
import recuperacao.app.matheus.controledeeventos.R;
import recuperacao.app.matheus.controledeeventos.model.Convidado;

public class ExibirInfoActivity extends AppCompatActivity {

    @Bind(R.id.tv_exibir_nome)
    TextView mTvExibirNome;
    @Bind(R.id.tv_exibir_code)
    TextView mTvExibirCode;

    Convidado mConvidado = new Convidado();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exibir_info);
        ButterKnife.bind(this);

        mConvidado = getIntent().getParcelableExtra("Convidado");

        mTvExibirNome.setText(mConvidado.getmNome());
        mTvExibirCode.setText(mConvidado.getmQrCode());


    }
}
