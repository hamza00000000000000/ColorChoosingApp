package com.example.colorapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class MainActivity extends AppCompatActivity {

    ImageView color1 , color2 , color3 , color4;
    TextView color_name , color_ressult;
    ArrayList<Integer> colors;
    ArrayList<String> choosen_clr;
    String hex_color , hex_to_color_name;
    Button getStartedBtn ;
    int Count = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        color1 = findViewById(R.id.color1);
        color2 = findViewById(R.id.color2);
        color3 = findViewById(R.id.color3);
        color4 = findViewById(R.id.color4);
        color_name = findViewById(R.id.color_name);
        getStartedBtn = findViewById(R.id.started);
        color_ressult = findViewById(R.id.color_result);

        //choosen_clr = new String[]{"Green" , "Red" , "Blue" , "Yellow" , "Purple" , "Pink"};
        choosen_clr = new ArrayList<>();
        choosen_clr.add("Green");
        choosen_clr.add("Red");
        choosen_clr.add("Blue");
        choosen_clr.add("Yellow");
        choosen_clr.add("Purple");
        choosen_clr.add("Pink");

        colors = new ArrayList<>();
        colors.add(getResources().getColor(R.color.green));
        colors.add(getResources().getColor(R.color.red));
        colors.add(getResources().getColor(R.color.blue));
        colors.add(getResources().getColor(R.color.yellow));
        colors.add(getResources().getColor(R.color.purple));
        colors.add(getResources().getColor(R.color.pink));

        getStartedBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                color1.setBackgroundColor(colors.get(0));
                color2.setBackgroundColor(colors.get(1));
                color3.setBackgroundColor(colors.get(2));
                color4.setBackgroundColor(colors.get(3));
                color_name.setText(choosen_clr.get(0));
                getStartedBtn.setVisibility(View.GONE);
            }
        });


        color1.setOnClickListener(view -> {
            getColor(color1);
            shuffle_colors();
        });

        color2.setOnClickListener(view -> {
           getColor(color2);
           shuffle_colors();
        });

        color3.setOnClickListener(view -> {
            getColor(color3);
            shuffle_colors();
        });
        color4.setOnClickListener(view -> {
            getColor(color4);
            shuffle_colors();
        });

    }
    //to get the color hex_color decimal code
    @SuppressLint("SetTextI18n")
    public void getColor(ImageView imageView)
    {
        String chooseName = color_name.getText().toString();
        ColorDrawable colorDrawable = (ColorDrawable) imageView.getBackground();
        int colorid = colorDrawable.getColor();
        hex_color = String.format("#%06X", (0xFFFFFF & colorid));
        String clr_name = getColorName(hex_color);
        //Toast.makeText(this, "Color: " + clr_name , Toast.LENGTH_SHORT).show();
        Collections.shuffle(choosen_clr);
        color_name.setText(choosen_clr.get(Count));

        if (clr_name.equals(chooseName))
        {
            color_ressult.setText("Congratulations!!!!");

        }
        else
        {
            color_ressult.setText("Wrong answer please try again");
        }

    }
    
    public String getColorName (String hexColor)
    {
        switch (hexColor)
        {
            case "#05E80F":
                hex_to_color_name = "Green";
                break;
            case "#FF0000":
                hex_to_color_name = "Red";
                break;
            case "#0159F3":
                hex_to_color_name = "Blue";
                break;
            case "#FBD200":
                hex_to_color_name = "Yellow";
                break;
            case "#D902FF":
                hex_to_color_name = "Purple";
                break;
            case "#E31E84":
                hex_to_color_name = "Pink";
                break;
            default:
        }
        return hex_to_color_name;
    }
    public void shuffle_colors ()
    {
        Collections.shuffle(colors);

        color1.setBackgroundColor(colors.get(0));
        color2.setBackgroundColor(colors.get(1));
        color3.setBackgroundColor(colors.get(2));
        color4.setBackgroundColor(colors.get(3));
    }
}