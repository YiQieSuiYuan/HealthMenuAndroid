package com.example.admin.healthmenu.activity;

import android.os.Bundle;

import com.example.admin.healthmenu.R;
import com.example.admin.healthmenu.base.BaseActivity;
import com.example.admin.healthmenu.http.ApiHttpClient;
import com.example.admin.healthmenu.util.DialogHelp;
import com.example.admin.healthmenu.util.TLog;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;

import org.apache.http.Header;

public class HomeActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        ApiHttpClient.setHttpClient(new AsyncHttpClient());
        ApiHttpClient.get("api/openapi/BaikeLemmaCardApi?scope=103&format=json&appid=379020&bk_key=%E9%93%B6%E9%AD%82&bk_length=600", new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                String str=new String(responseBody);
                TLog.log(str);

                DialogHelp.getMessageDialog(HomeActivity.this, "知道").show();
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {

            }
        });


    }
}
