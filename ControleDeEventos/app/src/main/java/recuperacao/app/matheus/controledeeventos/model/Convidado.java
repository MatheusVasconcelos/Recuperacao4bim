package recuperacao.app.matheus.controledeeventos.model;

import android.os.Parcel;
import android.os.Parcelable;

import recuperacao.app.matheus.controledeeventos.exclusion.ExcluirJSON;

/**
 * Created by mathe on 12/04/2016.
 */
public class Convidado implements Parcelable {

    @ExcluirJSON
    private String mId;
    @ExcluirJSON
    private String mNome;
    @ExcluirJSON
    private String mQrCode;

    public Convidado() {

    }

    public Convidado(String mId, String mNome, String mQrCode) {
        this.mId = mId;
        this.mNome = mNome;
        this.mQrCode = mQrCode;
    }

    protected Convidado(Parcel in) {
        mId = in.readString();
        mNome = in.readString();
        mQrCode = in.readString();
    }

    public static final Creator<Convidado> CREATOR = new Creator<Convidado>() {
        @Override
        public Convidado createFromParcel(Parcel in) {
            return new Convidado(in);
        }

        @Override
        public Convidado[] newArray(int size) {
            return new Convidado[size];
        }
    };

    public String getmId() {
        return mId;
    }

    public void setmId(String mId) {
        this.mId = mId;
    }

    public String getmNome() {
        return mNome;
    }

    public void setmNome(String mNome) {
        this.mNome = mNome;
    }

    public String getmQrCode() {
        return mQrCode;
    }

    public void setmQrCode(String mQrCode) {
        this.mQrCode = mQrCode;
    }

    @Override
    public String toString() {
        return "Convidado{" +
                "mId='" + mId + '\'' +
                ", mNome='" + mNome + '\'' +
                ", mQrCode='" + mQrCode + '\'' +
                '}';
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(mId);
        dest.writeString(mNome);
        dest.writeString(mQrCode);
    }
}
