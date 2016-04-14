package recuperacao.app.matheus.controledeeventos.callback;

import java.util.List;

import recuperacao.app.matheus.controledeeventos.model.Convidado;

/**
 * Created by mathe on 12/04/2016.
 */
public interface PesquisaCallBack {

    void pesquisaCallBack(List<Convidado> convidados);

    void erroPesquisaCallBack(String erro);
}
