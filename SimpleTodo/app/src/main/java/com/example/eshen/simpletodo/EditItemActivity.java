package com.example.eshen.simpletodo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.content.Intent;

public class EditItemActivity extends AppCompatActivity {
    EditText etEditText2;
    int pos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_item2);
        etEditText2 = (EditText) findViewById(R.id.etEditText2);
        String text = getIntent().getStringExtra("text");
        pos = getIntent().getIntExtra("position", -1);
        etEditText2.setText(text);
    }

    public void onSubmit(View v) {
        Intent data = new Intent();
        data.putExtra("text", etEditText2.getText().toString());
        data.putExtra("pos", pos);
        setResult(RESULT_OK, data);
        this.finish();
    }
}
