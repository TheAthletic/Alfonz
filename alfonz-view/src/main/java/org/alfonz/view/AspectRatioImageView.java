package org.alfonz.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;

import androidx.annotation.NonNull;

public class AspectRatioImageView extends ImageView {
	public AspectRatioImageView(@NonNull Context context) {
		super(context);
	}

	public AspectRatioImageView(@NonNull Context context, AttributeSet attrs) {
		super(context, attrs);
	}

	public AspectRatioImageView(@NonNull Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
	}

	@Override
	protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
		int width = MeasureSpec.getSize(widthMeasureSpec);
		int height = 0;

		try {
			if (getDrawable() != null) {
				height = width * getDrawable().getIntrinsicHeight() / getDrawable().getIntrinsicWidth();
			}
		} catch (ArithmeticException e) {
			e.printStackTrace();
		}

		setMeasuredDimension(width, height);
	}
}
