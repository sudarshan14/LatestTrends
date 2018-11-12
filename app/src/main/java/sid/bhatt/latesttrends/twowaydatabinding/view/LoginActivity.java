package sid.bhatt.latesttrends.twowaydatabinding.view;

import android.databinding.BindingAdapter;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import sid.bhatt.latesttrends.R;
import sid.bhatt.latesttrends.databinding.ActivityLoginBinding;
import sid.bhatt.latesttrends.databinding.ActivityMainBinding;
import sid.bhatt.latesttrends.twowaydatabinding.viewModel.LoginViewModel;

public class LoginActivity extends AppCompatActivity {

    ActivityLoginBinding activityLoginBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityLoginBinding = DataBindingUtil.setContentView(this, R.layout.activity_login);
        activityLoginBinding.setViewModel(new LoginViewModel());
        activityLoginBinding.executePendingBindings();
    }

    //The @BindingAdapter method gets triggered whenever
    // toastMessage attribute defined on the Button is changed.
    @BindingAdapter({"toastMessage"})
    public static void runMe(View view, String message) {
        if (message != null)
            Toast.makeText(view.getContext(), message, Toast.LENGTH_SHORT).show();
    }

}
