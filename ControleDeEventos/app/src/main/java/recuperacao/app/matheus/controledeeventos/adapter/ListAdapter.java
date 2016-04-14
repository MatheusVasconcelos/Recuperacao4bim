package recuperacao.app.matheus.controledeeventos.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import recuperacao.app.matheus.controledeeventos.R;
import recuperacao.app.matheus.controledeeventos.model.Convidado;

/**
 * Created by mathe on 12/04/2016.
 */
public class ListAdapter extends BaseAdapter {

    Context mContext;
    List<Convidado> mConvidados;
    LayoutInflater mInflater;

    public ListAdapter(Activity mContext, List<Convidado> mConvidados) {
        this.mContext = mContext;
        this.mConvidados = mConvidados;
        mInflater = LayoutInflater.from(mContext);
    }



    @Override
    public int getCount() {
        return mConvidados.size();
    }

    @Override
    public Object getItem(int position) {
        return mConvidados.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View view;
        ViewHolder holder;

        if (convertView == null){

            view = mInflater.inflate(R.layout.list_item_convidados, parent, false);
            holder = new ViewHolder(view);
            Convidado convidado = mConvidados.get(position);

            holder.mTvNomeConvidado.setText(convidado.getmNome());
            holder.mTvQrCode.setText(convidado.getmQrCode());
        }else {
            view = convertView;
        }

        return view;
    }

    class ViewHolder{

        @Bind(R.id.nome_list)
        TextView mTvNomeConvidado;
        @Bind(R.id.code_list)
        TextView mTvQrCode;

        public ViewHolder(View view){
            ButterKnife.bind(this, view);
        }
    }
}
