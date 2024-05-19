package com.example.buyphonesonline;

import android.graphics.Rect;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class HorizontalItemDecoration extends RecyclerView.ItemDecoration {
    private final int offset;

    public HorizontalItemDecoration(int offset) {
        this.offset = offset;
    }

    @Override
    public void getItemOffsets(@NonNull Rect outRect, @NonNull View view, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
        int position = parent.getChildAdapterPosition(view);
        int itemCount = state.getItemCount();

        outRect.left = offset;

        if(position==0){
            outRect.left=0;
        }
        else if(position == itemCount - 1) {
            outRect.right = offset;
        } else {
            outRect.right = 0;
        }

        outRect.top = offset;
        outRect.bottom = offset;
    }
}
