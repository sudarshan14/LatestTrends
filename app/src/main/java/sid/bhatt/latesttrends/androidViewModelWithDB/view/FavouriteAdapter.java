package sid.bhatt.latesttrends.androidViewModelWithDB.view;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.Date;
import java.util.List;

import sid.bhatt.latesttrends.R;
import sid.bhatt.latesttrends.androidViewModelWithDB.model.Favourite;

class FavouriteAdapter extends ArrayAdapter<Favourite> {
    Context context;

    public FavouriteAdapter(Context context, int layoutResourceId, List<Favourite> todos) {
        super(context, layoutResourceId, todos);

        this.context = context;
    }

    private class ViewHolder {
        TextView tvUrl;
        TextView tvDate;
    }

    @Override
    @NonNull
    public View getView(int position, View convertView, ViewGroup parent) {
        Favourite favourites = getItem(position);
        ViewHolder viewHolder;
        if (convertView == null) {
            viewHolder = new ViewHolder();
            LayoutInflater vi = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = vi.inflate(R.layout.list_item_row, parent, false);
            viewHolder.tvUrl = convertView.findViewById(R.id.tvUrl);
            viewHolder.tvDate = convertView.findViewById(R.id.tvDate);
            convertView.setTag(R.id.VH, viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag(R.id.VH);

        }

        viewHolder.tvUrl.setText(favourites.mUrl);
        viewHolder.tvDate.setText((new Date(favourites.mDate).toString()));
        convertView.setTag(R.id.POS, position);
        return convertView;
    }

}
