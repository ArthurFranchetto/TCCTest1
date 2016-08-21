package util;

import android.widget.TextView;

/**
 * Created by ArthurF on 21/08/16.
 */
public class ViewHolder {
    private TextView nomeMorador, detalhesMorador;

    public ViewHolder(TextView nomeMorador, TextView detalhesMorador ){
        this.nomeMorador = nomeMorador;
        this.detalhesMorador = detalhesMorador;
    }

    public TextView getNomeMorador() {
        return nomeMorador;
    }

    public void setNomeMorador(TextView nomeMorador) {
        this.nomeMorador = nomeMorador;
    }

    public TextView getDetalhesMorador() {
        return detalhesMorador;
    }

    public void setDetalhesMorador(TextView detalhesMorador) {
        this.detalhesMorador = detalhesMorador;
    }
}
