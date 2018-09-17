package com.example.varun.snackbardemo;

import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
Button showSnackbar;
RelativeLayout layout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        showSnackbar=findViewById(R.id.showSnackbarButton);
        layout=findViewById(R.id.layout);
        showSnackbar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Create the Snackbar
                final Snackbar snackbar = Snackbar.make(layout, "Sample Text", Snackbar.LENGTH_LONG);
                // Get the Snackbar's layout view
                Snackbar.SnackbarLayout layout = (Snackbar.SnackbarLayout) snackbar.getView();
                // Hide the text
                TextView textView = (TextView) layout.findViewById(android.support.design.R.id.snackbar_text);
                textView.setVisibility(View.INVISIBLE);

                // Inflate our custom view
                View snackView = getLayoutInflater().inflate(R.layout.snackbar_layout, null);
                // Configure the view
                ImageView cancelIcon = (ImageView) snackView.findViewById(R.id.cancelIcon);
                // Attach click listner on cancel icon
                cancelIcon.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Toast.makeText(MainActivity.this, "cancel clicked", Toast.LENGTH_SHORT).show();
                        snackbar.dismiss();
                    }
                });
                TextView tvText = (TextView) snackView.findViewById(R.id.tvText);
                tvText.setText("This is sample text");
                // Add the view to the Snackbar's layout
                //If the view is not covering the whole snackbar layout, add this line
                layout.setPadding(0,0,0,0);
                layout.addView(snackView, 0);
                // Show the Snackbar
                snackbar.show();

            }
        });
    }
}
