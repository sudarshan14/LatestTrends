package sid.bhatt.latesttrends.twowaydatabinding.model;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.Patterns;

public class User {
    @NonNull
    private String userName;

    @NonNull
    private String password;

    @NonNull
    public String getUserName() {
        return userName;
    }

    public void setUserName(@NonNull String userName) {
        this.userName = userName;
    }

    @NonNull
    public String getPassword() {
        return password;
    }

    public void setPassword(@NonNull String password) {
        this.password = password;
    }

    public User(@NonNull String userName, @NonNull String password) {

        this.userName = userName;
        this.password = password;
    }

    public boolean isInputDataValid() {
        return !TextUtils.isEmpty(getUserName()) && Patterns.EMAIL_ADDRESS.matcher(getUserName()).matches() && getPassword().length() > 5;
    }


}
