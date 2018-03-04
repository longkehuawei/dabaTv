package com.longke.shot;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

import static com.longke.shot.SharedPreferencesUtil.IS_RADIO;
import static com.longke.shot.SharedPreferencesUtil.IS_VISITOR;

public class ConfigureActivity extends AppCompatActivity {

    @InjectView(R.id.addrss_name_tv)
    TextView addrssNameTv;
    @InjectView(R.id.url_name)
    EditText urlName;
    @InjectView(R.id.isRed)
    CheckBox isRed;
    @InjectView(R.id.bt_queding)
    Button btQueding;
    @InjectView(R.id.isRadio)
    CheckBox isRadio;

    private boolean isFromMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_configure);
        ButterKnife.inject(this);
        isFromMain = getIntent().getBooleanExtra("isFromMain", false);


        String baseUrl = (String)  SharedPreferencesUtil.get(ConfigureActivity.this, SharedPreferencesUtil.BASE_URL, "");
        urlName.setText(baseUrl);
        boolean IS_RADIO = (boolean) SharedPreferencesUtil.get(ConfigureActivity.this, SharedPreferencesUtil.IS_RADIO, false);
        boolean isShowRedOpen = (boolean) SharedPreferencesUtil.get(ConfigureActivity.this, SharedPreferencesUtil.IS_RED, true);
        isRadio.setChecked(IS_RADIO);
        isRed.setChecked(isShowRedOpen);

    }

    @OnClick(R.id.bt_queding)
    public void onViewClicked() {
        SharedPreferencesUtil.put(ConfigureActivity.this, SharedPreferencesUtil.BASE_URL, urlName.getText().toString());
        SharedPreferencesUtil.put(ConfigureActivity.this, SharedPreferencesUtil.IS_RED, isRed.isChecked());
        SharedPreferencesUtil.put(ConfigureActivity.this, IS_RADIO, isRadio.isChecked());


        if (isFromMain) {
            startActivity(new Intent(ConfigureActivity.this, MainActivity.class));
        }else{
            setResult(RESULT_OK);
        }

        finish();

    }
}
