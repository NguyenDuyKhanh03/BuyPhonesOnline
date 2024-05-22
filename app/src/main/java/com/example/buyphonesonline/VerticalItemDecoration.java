package com.example.buyphonesonline;

import android.graphics.Rect;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class VerticalItemDecoration extends RecyclerView.ItemDecoration {
    private final int offset;

    public VerticalItemDecoration(int offset) {
        this.offset = offset;
    }

    @Override
    public void getItemOffsets(@NonNull Rect outRect, @NonNull View view, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
        int position=parent.getChildAdapterPosition(view);
        int itemCount=state.getItemCount();
        outRect.top=offset;

        if(position==itemCount-1){
            outRect.bottom=offset;
        }
        else {
            outRect.bottom=0;
        }
    }
}
