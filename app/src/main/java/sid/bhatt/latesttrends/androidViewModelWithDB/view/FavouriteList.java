package sid.bhatt.latesttrends.androidViewModelWithDB.view;

import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.List;

import sid.bhatt.latesttrends.R;
import sid.bhatt.latesttrends.androidViewModelWithDB.model.Favourite;
import sid.bhatt.latesttrends.androidViewModelWithDB.viewModel.FavouritesViewModel;

public class FavouriteList extends AppCompatActivity {
    FavouritesViewModel favouritesViewModel;
    FavouriteAdapter favouriteAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favourite_list);

        ListView listView = findViewById(R.id.listView);
//        FloatingActionButton fab = findViewById(R.id.fab);
        favouritesViewModel = ViewModelProviders.of(this).get(FavouritesViewModel.class);
        List<Favourite> favourites = favouritesViewModel.getFavourites();
        favouriteAdapter = new FavouriteAdapter(this, R.layout.list_item_row, favourites);
        listView.setAdapter(favouriteAdapter);

    }
}
