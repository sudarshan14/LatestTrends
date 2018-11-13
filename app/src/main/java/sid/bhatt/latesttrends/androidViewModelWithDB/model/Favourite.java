package sid.bhatt.latesttrends.androidViewModelWithDB.model;

public class Favourite {

    public long mId;
    public String mUrl;
    public long mDate;

    public Favourite(long id, String name, long date) {
        mId = id;
        mUrl = name;
        mDate = date;
    }

    public Favourite(Favourite favourites) {
        mId = favourites.mId;
        mUrl = favourites.mUrl;
        mDate = favourites.mDate;
    }

}