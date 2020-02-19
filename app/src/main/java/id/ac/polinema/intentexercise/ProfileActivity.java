package id.ac.polinema.intentexercise;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import static id.ac.polinema.intentexercise.RegisterActivity.*;

public class ProfileActivity extends AppCompatActivity {

    private TextView fullnameText,emailText, passwordText, cfrmpasswordText, homepageText, aboutyouText;
    private ImageView image_profile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        image_profile = findViewById(R.id.image_profile);
        fullnameText = findViewById(R.id.label_fullname);
        emailText = findViewById(R.id.label_email);
        homepageText = findViewById(R.id.label_homepage);
        aboutyouText = findViewById(R.id.label_about);

        Bundle extras= getIntent().getExtras();

        if (extras != null){
            fullnameText.setText(getIntent().getStringExtra(FULLNAME_KEY));
            emailText.setText(getIntent().getStringExtra(EMAIL_KEY));
            homepageText.setText(getIntent().getStringExtra(HOMEPAGE_KEY));
            aboutyouText.setText(getIntent().getStringExtra(ABOUTYOU_KEY));
        }

    }

    public void visitHomepage(View view) {
        Intent implicit = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.github.com/effendikiki"));
        startActivity(implicit);
    }
}
