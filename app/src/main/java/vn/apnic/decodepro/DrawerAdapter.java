package vn.apnic.decodepro;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class DrawerAdapter extends BaseAdapter {

    private Context mContext;
    private ArrayList<Item> mDrawers;

    public DrawerAdapter(Context context, ArrayList<Item> drawers) {
        this.mContext = context;
        this.mDrawers = drawers;
    }

    public int getCount()
    {
        return mDrawers.size();
    }

    public Item getItem(int position)
    {
        return mDrawers.get(position);
    }

    public long getItemId(int position)
    {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        View mView = convertView;

        if (mView == null) {
            LayoutInflater mInflater = (LayoutInflater)
                    mContext.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
            mView = mInflater.inflate(R.layout.listview_row, null);
        }

        ImageView mImageViewIcon = (ImageView) mView.findViewById(R.id.imageViewIcon);
        TextView mTextViewTitle = (TextView) mView.findViewById(R.id.imageViewTitle);

        mImageViewIcon.setImageResource(mDrawers.get(position).getIcon());
        mTextViewTitle.setText(mDrawers.get(position).getTitle());

        return mView;
    }
}
