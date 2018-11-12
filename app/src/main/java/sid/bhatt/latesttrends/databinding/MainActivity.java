package sid.bhatt.latesttrends.databinding;

import android.databinding.DataBindingUtil;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import sid.bhatt.latesttrends.R;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding activityMainBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        activityMainBinding.tvHeading.setText("Hello Sudarshan...");
        activityMainBinding.tvHeading.setTextColor(R.color.colorAccent);
        activityMainBinding.tvSubHeading.setText("Welcome TO the world of reactive programming. Have Lots of fun");
    }
}
