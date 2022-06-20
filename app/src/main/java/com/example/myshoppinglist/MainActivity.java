package com.example.myshoppinglist;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Button;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {


    private EditText TextEdit;
    private Button AddButton;
    private ArrayAdapter<String> mAdapter;
    private ListView MarketList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MarketList = (ListView) findViewById(R.id.shopping_listView);
        TextEdit = (EditText) findViewById(R.id.item_editText);
        AddButton = (Button) findViewById(R.id.add_button);
        mAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1);
        MarketList.setAdapter(mAdapter);


        AddButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String item = TextEdit.getText().toString();
                if(item.equals("limpar")){
                    mAdapter.clear();
                    Toast.makeText(getApplicationContext(), "Lista limpa", Toast.LENGTH_SHORT).show();
                }
                else{
                mAdapter.add(item);}
                mAdapter.notifyDataSetChanged();
                TextEdit.setText("");
            }

        });
    }
}