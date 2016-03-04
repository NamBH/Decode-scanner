package vn.apnic.decodepro;

public class Item {

    String Title;
    int Icon;

    public Item(String mTitle, int mIcon) {
        this.Title = mTitle;
        this.Icon = mIcon;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public int getIcon() {
        return Icon;
    }

    public void setIcon(int icon) {
        Icon = icon;
    }
}
