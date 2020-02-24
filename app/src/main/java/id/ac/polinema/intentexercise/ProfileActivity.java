package id.ac.polinema.intentexercise;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import id.ac.polinema.intentexercise.model.*;

import static id.ac.polinema.intentexercise.RegisterActivity.*;

public class ProfileActivity extends AppCompatActivity {

    private TextView fullnameText,emailText,  homepageText, aboutyouText;
//    private ImageView image_profile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

//        image_profile = findViewById(R.id.image_profile);
        fullnameText = findViewById(R.id.label_fullname);
        emailText = findViewById(R.id.label_email);
        homepageText = findViewById(R.id.label_homepage);
        aboutyouText = findViewById(R.id.label_about);

        Bundle extras= getIntent().getExtras();
        user_data user = extras.getParcelable(key);


        if (extras != null){
            fullnameText.setText(user.getInputFullname());
            emailText.setText(user.getInputEmail());
            homepageText.setText(user.getInputHomepage());
            aboutyouText.setText(user.getInputAboutyou());
        }

    }

    public void visitHomepage(View view) {
        Bundle extras= getIntent().getExtras();
        user_data user = extras.getParcelable(key);
        Intent implicit = new Intent(Intent.ACTION_VIEW, Uri.parse("http://" + user.getInputHomepage()));
        startActivity(implicit);
    }
}
