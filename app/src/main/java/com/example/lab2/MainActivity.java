package com.example.lab2;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;


import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private Spinner spCounterOption;
    private EditText etEnteredText;
    private TextView tvResult;
    private String charString;
    private String wordString;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.spCounterOption = findViewById(R.id.spCounterOption);
        this.etEnteredText = findViewById(R.id.etEnteredText);
        this.tvResult = findViewById(R.id.tvResult);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.selection_options, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);


        this.spCounterOption.setAdapter(adapter);
    }

    @Override
    protected void onRestart() {
        super.onRestart();

        Toast.makeText(this, "onRestart", Toast.LENGTH_SHORT).show();
        Log.i("Routine", "onRestart =>");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Toast.makeText(this, "onStart", Toast.LENGTH_SHORT).show();
        Log.i("Routine", "onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Toast.makeText(this, "onResume", Toast.LENGTH_SHORT).show();
        Log.d("RoutineDealingWithFocus", "onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Toast.makeText(this, "onPause", Toast.LENGTH_SHORT).show();
        Log.i("Routine", "onPause =>");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Toast.makeText(this, "onStop", Toast.LENGTH_SHORT).show();
        Log.i("Routine", "onStop =>");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Toast.makeText(this, "onDestroy", Toast.LENGTH_SHORT).show();
        Log.i("Routine", "onDestroy =>");
    }





    public void onBtnOpenUrlClick(View view) {
        Toast.makeText(this, this.spCounterOption.getSelectedItem().toString(), Toast.LENGTH_SHORT).show();

        String spSelectedOption = this.spCounterOption.getSelectedItem().toString();
        String charString= getString(R.string.selection_chars);
        
        if(spSelectedOption.equalsIgnoreCase(charString)){
            String enteredUserText = this.etEnteredText.getText().toString();
            int charsCount = TextCounter.getCharsCount(enteredUserText);

                this.tvResult.setText(String.valueOf(charsCount));
        }
        else {
               Toast.makeText(this, "Not implemented", Toast.LENGTH_SHORT);
        }
        Toast.makeText(this, this.spCounterOption.getSelectedItem().toString(), Toast.LENGTH_SHORT).show();

        String wordString= getString(R.string.selection_words);

        if(spSelectedOption.equalsIgnoreCase(wordString)){
            String enteredUserText = this.etEnteredText.getText().toString();
            int wordsCount = WordCounter.getWordsCount(enteredUserText);
                this.tvResult.setText(String.valueOf(wordsCount));

        }
        else{
                Toast.makeText(this, "Not implemented", Toast.LENGTH_SHORT);
        }


    }
}




