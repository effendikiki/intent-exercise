package id.ac.polinema.intentexercise.model;

import android.os.Parcel;
import android.os.Parcelable;

public class user_data implements Parcelable {

    private String inputFullname, inputEmail, inputPassword, inputCfrmPassword, inputHomepage, inputAboutyou;

    public String getInputFullname() {
        return inputFullname;
    }

    public String getInputEmail() {
        return inputEmail;
    }

    public String getInputPassword() {
        return inputPassword;
    }

    public String getInputCfrmPassword() {
        return inputCfrmPassword;
    }

    public String getInputHomepage() {
        return inputHomepage;
    }

    public String getInputAboutyou() {
        return inputAboutyou;
    }

    public void setInputFullname(String inputFullname) {
        this.inputFullname = inputFullname;
    }

    public void setInputEmail(String inputEmail) {
        this.inputEmail = inputEmail;
    }

    public void setInputPassword(String inputPassword) {
        this.inputPassword = inputPassword;
    }

    public void setInputCfrmPassword(String inputCfrmPassword) {
        this.inputCfrmPassword = inputCfrmPassword;
    }

    public void setInputHomepage(String inputHomepage) {
        this.inputHomepage = inputHomepage;
    }

    public void setInputAboutyou(String inputAboutyou) {
        this.inputAboutyou = inputAboutyou;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.inputFullname);
        dest.writeString(this.inputEmail);
        dest.writeString(this.inputPassword);
        dest.writeString(this.inputCfrmPassword);
        dest.writeString(this.inputHomepage);
        dest.writeString(this.inputAboutyou);
    }

    public user_data(String inputFullname, String inputEmail, String inputPassword, String inputCfrmPassword, String inputHomepage, String inputAboutyou) {
        this.inputFullname = inputFullname;
        this.inputEmail = inputEmail;
        this.inputPassword = inputPassword;
        this.inputCfrmPassword = inputCfrmPassword;
        this.inputHomepage = inputHomepage;
        this.inputAboutyou = inputAboutyou;
    }



    protected user_data(Parcel in) {
        this.inputFullname = in.readString();
        this.inputEmail = in.readString();
        this.inputPassword = in.readString();
        this.inputCfrmPassword = in.readString();
        this.inputHomepage = in.readString();
        this.inputAboutyou = in.readString();
    }

    public static final Creator<user_data> CREATOR = new Creator<user_data>() {
        @Override
        public user_data createFromParcel(Parcel source) {
            return new user_data(source);
        }

        @Override
        public user_data[] newArray(int size) {
            return new user_data[size];
        }
    };
}
