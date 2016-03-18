package healthsignz.com.recyclerview;

import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by devuser on 17-03-2016.
 */
public class SimpleItemDecoration extends RecyclerView.ItemDecoration {
    private int space;
    public SimpleItemDecoration(int space) {
        this.space = space;
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        outRect.left = space;
        outRect.right = space;
        outRect.bottom = space;

        // Add top margin only for the first item to avoid double space between items
        if(parent.getChildAdapterPosition (view) == 0)
            outRect.top = space;
    }
}
