package com.example.brailledigital;

import android.os.Bundle;
import android.util.SparseArray;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import com.google.android.material.textfield.TextInputEditText;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private SparseArray<String> brailleMap;
    private StringBuilder stringBuilder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button1 = findViewById(R.id.button1);
        Button button2 = findViewById(R.id.button2);
        Button button3 = findViewById(R.id.button3);
        Button button4 = findViewById(R.id.button4);
        Button button5 = findViewById(R.id.button5);
        Button button6 = findViewById(R.id.button6);

        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
        button4.setOnClickListener(this);
        button5.setOnClickListener(this);
        button6.setOnClickListener(this);

        initBrailleMap();
        stringBuilder = new StringBuilder();
    }

    private void initBrailleMap() {
        brailleMap = new SparseArray<>();
        brailleMap.put(R.id.button1, "1");
        brailleMap.put(R.id.button2, "2");
        brailleMap.put(R.id.button3, "3");
        brailleMap.put(R.id.button4, "4");
        brailleMap.put(R.id.button5, "5");
        brailleMap.put(R.id.button6, "6");
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.button1 || v.getId() == R.id.button2 || v.getId() == R.id.button3
                || v.getId() == R.id.button4 || v.getId() == R.id.button5 || v.getId() == R.id.button6) {
            String braille = brailleMap.get(v.getId());
            stringBuilder.append(braille);
            if (stringBuilder.length() == 6) {
                String character = getCharacter(stringBuilder.toString());
                Toast.makeText(this, character, Toast.LENGTH_SHORT).show();
                stringBuilder = new StringBuilder();
            }
        }
    }

    private String getCharacter(String braille) {
        switch (braille) {
            case "123456":
                return "a";
            case "12346":
                return "b";
            case "12356":
                return "c";
            case "1235":
                return "d";
            case "12456":
                return "e";
            case "1246":
                return "f";
            case "1256":
                return "g";
            case "125":
                return "h";
            case "24":
                return "i";
            case "2456":
                return "j";
            case "13":
                return "k";
            case "123":
                return "l";
            case "134":
                return "m";
            case "1345":
                return "n";
            case "1356":
                return "o";
            case "135":
                return "p";
            case "1234":
                return "q";
            case "12345":
                return "r";
            case "124":
                return "s";
            case "234":
                return "t";
            case "1346":
                return "u";
            case "1236":
                return "v";
            case "245":
                return "w";
            case "13456":
                return "x";
            case "12":
                return "y";
            case "1355":
                return "z";
            default:
                return "";
        }
    }
}
