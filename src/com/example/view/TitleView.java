package com.example.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;

import com.example.pad.MainActivity;
import com.example.pad.R;
import com.example.pad.R.color;

public class TitleView extends View {

	private int backColor;
	private Context mContext;
	private Paint mPaint;
	private int screenWidth = 1000;
	
	public TitleView(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
		mPaint = new Paint();
	}
	
	public TitleView(Context context, AttributeSet attr) {
		super(context, attr);
		// TODO Auto-generated constructor stub
		this.mContext = context;
		
		mPaint = new Paint();
		
		TypedArray set = mContext.obtainStyledAttributes(attr, R.styleable.TitleView);
		backColor = set.getColor(R.styleable.TitleView_color, color.gray);
		
		RelativeLayout rlLayout = new RelativeLayout(mContext);
		
//		RelativeLayout.LayoutParams rParams1 = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT
//				, ViewGroup.LayoutParams.WRAP_CONTENT);
//		Button iB = new Button(mContext);
//		iB.setId(00001);
//		iB.setText("heheheheheheh");
//		rParams1.addRule(RelativeLayout.ALIGN_PARENT_TOP);//父布局的顶部
//		rParams1.addRule(RelativeLayout.CENTER_HORIZONTAL, RelativeLayout.TRUE);//在父布局最左边
//		rlLayout.addView(iB, rParams1);
		
		set.recycle();
		
	}
	
	@Override
	protected void onDraw(Canvas canvas){
		super.onDraw(canvas);
		mPaint = new Paint();
		
		//填充
		mPaint.setStyle(Style.FILL);
		mPaint.setColor(backColor);

		//画一个矩形
		this.screenWidth = MainActivity.screenWidth;
		canvas.drawRect(new Rect(0,0,this.screenWidth,100),mPaint);
		//System.out.println("this.screenWidth = "+this.screenWidth);
	}
}