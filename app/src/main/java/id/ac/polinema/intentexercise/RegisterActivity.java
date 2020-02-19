package id.ac.polinema.intentexercise;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.IOException;

public class RegisterActivity extends AppCompatActivity {

    private static final String TAG = RegisterActivity.class.getCanonicalName();
    private static final int GALLERY_REQUEST_CODE = 1;

    private ImageView inputImage;
    private EditText inputFullname, inputEmail, inputPassword, inputCfrmPassword, inputHomepage, inputAboutyou;

    public static final String FULLNAME_KEY="fullname";
    public static final String  EMAIL_KEY="email";
    public static final String PASSWORD_KEY="password";
    public static final String  CFRMPASSWORD_KEY="cfrmpassword";
    public static final String HOMEPAGE_KEY="homepage";
    public static final String ABOUTYOU_KEY="aboutyou";
    public static final String IMAGE_KEY="image";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        inputImage = findViewById(R.id.image_profile);
        inputFullname = findViewById(R.id.text_fullname);
        inputEmail = findViewById(R.id.text_email);
        inputPassword = findViewById(R.id.text_password);
        inputCfrmPassword = findViewById(R.id.text_confirm_password);
        inputHomepage = findViewById(R.id.text_homepage);
        inputAboutyou = findViewById(R.id.text_about);

    }

    public void handleSubmit(View view) {
        String output_Fullname = inputFullname.getText().toString();
        String output_Email = inputEmail.getText().toString();
        String output_Password = inputPassword.getText().toString();
        String output_CfrmPassword = inputCfrmPassword.getText().toString();
        String output_Homepage = inputHomepage.getText().toString();
        String output_Aboutyou = inputAboutyou.getText().toString();
//        Uri output_uri = inputImage.getIma

        Intent intent = new Intent(this, ProfileActivity.class);


        if (!(output_Fullname).equals("") && !(output_Email).equals("") && !(output_Password).equals("") && !(output_CfrmPassword).equals("") && !(output_Homepage).equals("") && !(output_Aboutyou).equals("")){

            if ((output_Password).equals(output_CfrmPassword) ){
                intent.putExtra(FULLNAME_KEY, output_Fullname);
                intent.putExtra(EMAIL_KEY, output_Email);
                intent.putExtra(PASSWORD_KEY, output_Password);
                intent.putExtra(CFRMPASSWORD_KEY, output_CfrmPassword);
                intent.putExtra(HOMEPAGE_KEY, output_Homepage);
                intent.putExtra(ABOUTYOU_KEY, output_Aboutyou);

                startActivity(intent);
            }
            else {

                Toast.makeText(this, "Password Harus Sama!", Toast.LENGTH_SHORT).show();
            }

        }
        else {
            Toast.makeText(this, "Semua Form Harus Diisi!", Toast.LENGTH_SHORT).show();
        }


    }

    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_CANCELED) {
            return;
        }

        if (requestCode == GALLERY_REQUEST_CODE) {
            if (data != null) {
                try {
                    Uri imageUri = data.getData();
                    Bitmap bitmap = MediaStore.Images.Media.getBitmap(this.getContentResolver(), imageUri);
                    inputImage.setImageBitmap(bitmap);
                } catch (IOException e) {
                    Toast.makeText(this, "Tidak bisa memuat gambar", Toast.LENGTH_SHORT).show();
                    Log.e(TAG, e.getMessage());
                }
            }
        }
    }

    public void handleChangeAvatar(View view) {
        Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        startActivityForResult(intent, GALLERY_REQUEST_CODE);
    }

//    TODO : parse image ke halaman profil

}
