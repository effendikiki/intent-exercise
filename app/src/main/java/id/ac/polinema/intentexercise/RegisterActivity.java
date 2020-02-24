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
import id.ac.polinema.intentexercise.model.*;

import java.io.IOException;

public class RegisterActivity extends AppCompatActivity {

    private static final String TAG = RegisterActivity.class.getCanonicalName();
    private static final int GALLERY_REQUEST_CODE = 1;

    private ImageView inputImage;
    private EditText inputFullname, inputEmail, inputPassword, inputCfrmPassword, inputHomepage, inputAboutyou;

    public static final String key="key";



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





        if (!(output_Fullname).equals("") && !(output_Email).equals("") && !(output_Password).equals("") && !(output_CfrmPassword).equals("") && !(output_Homepage).equals("") && !(output_Aboutyou).equals("")){

            if ((output_Password).equals(output_CfrmPassword) ){
                Intent intent = new Intent(this, ProfileActivity.class);

                user_data user = new user_data(output_Fullname, output_Email, output_Password, output_CfrmPassword, output_Homepage, output_Aboutyou);
                intent.putExtra(key, user);

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
