package com.fima.cardsui.objects;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

import com.fima.cardsui.R;
import com.fima.cardsui.Utils;

public abstract class Card extends AbstractCard {

	public interface OnCardSwiped {
		public void onCardSwiped();
	}

	private OnCardSwiped onCardSwipedListener;
	private OnClickListener mListener;
	protected View mCardLayout;

	public Card() {

	}

	public Card(String title) {
		this.title = title;
	}
	
	@Override
	public View getView(Context context, boolean swipable) {
		return getView(context, false);
	}

	@Override
	public View getView(Context context) {

		View view = LayoutInflater.from(context).inflate(getCardLayout(), null);
		
		mCardLayout = view;

		try {
			((FrameLayout) view.findViewById(R.id.cardContent)).addView(getCardContent(context));
		} catch (NullPointerException e) {
			e.printStackTrace();
		}

		// ((TextView) view.findViewById(R.id.title)).setText(this.title);

		LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
		int bottom = Utils.convertDpToPixelInt(context, 12);
		lp.setMargins(0, 0, 0, bottom);

		view.setLayoutParams(lp);

		return view;
	}
	
	public View getViewLast(Context context) {

		View view = LayoutInflater.from(context).inflate(getLastCardLayout(), null);
		
		mCardLayout = view;

		try {
			((FrameLayout) view.findViewById(R.id.cardContent)).addView(getCardContent(context));
		} catch (NullPointerException e) {
			e.printStackTrace();
		}

		// ((TextView) view.findViewById(R.id.title)).setText(this.title);

		LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
		int bottom = Utils.convertDpToPixelInt(context, 12);
		lp.setMargins(0, 0, 0, bottom);

		view.setLayoutParams(lp);

		return view;
	}

	

	public View getViewFirst(Context context) {

		View view = LayoutInflater.from(context).inflate(getFirstCardLayout(), null);
		
		mCardLayout = view;

		try {
			((FrameLayout) view.findViewById(R.id.cardContent)).addView(getCardContent(context));
		} catch (NullPointerException e) {
			e.printStackTrace();
		}

		// ((TextView) view.findViewById(R.id.title)).setText(this.title);

		LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
		int bottom = Utils.convertDpToPixelInt(context, 12);
		lp.setMargins(0, 0, 0, bottom);

		view.setLayoutParams(lp);

		return view;
	}
	
	

	public abstract View getCardContent(Context context);

	public OnClickListener getClickListener() {
		return mListener;
	}

	public void setOnClickListener(OnClickListener listener) {
		mListener = listener;
	}

	public void OnSwipeCard() {
		if (onCardSwipedListener != null)
			onCardSwipedListener.onCardSwiped();

	}

	public OnCardSwiped getOnCardSwipedListener() {
		return onCardSwipedListener;
	}

	public void setOnCardSwipedListener(OnCardSwiped onEpisodeSwipedListener) {
		this.onCardSwipedListener = onEpisodeSwipedListener;
	}
	
	protected int getCardLayout() {
		return R.layout.item_card_empty;
	}
	
	protected int getLastCardLayout() {
		return R.layout.item_card_empty_last;
	}

	protected int getFirstCardLayout() {
		return R.layout.item_card_empty_first;
	}

}
