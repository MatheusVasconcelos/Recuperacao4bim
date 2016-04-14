package recuperacao.app.matheus.controledeeventos.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.journeyapps.barcodescanner.CaptureActivity;

import butterknife.Bind;
import butterknife.ButterKnife;
import recuperacao.app.matheus.controledeeventos.R;

public class QrCodeActivity extends AppCompatActivity {

    @Bind(R.id.tv_zxing)
    TextView mTvCode;

    public static final int REQUEST_CODE = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qr_code);
        ButterKnife.bind(this);


    }

    public void chamarLeitor(View view) {

        Intent intent = new Intent(QrCodeActivity.this, CaptureActivity.class);
        startActivityForResult(intent, REQUEST_CODE);
    }

    @Override
    public void onActivityResult(int resquestCode, int resultCode, Intent data) {

        if (REQUEST_CODE == resquestCode && RESULT_OK == resultCode) {

            mTvCode.setText(data.getStringExtra("SCAN_RESULT") + " (" + data.getStringExtra("SCAN_FORMAT") + ")");
        }
    }
}
