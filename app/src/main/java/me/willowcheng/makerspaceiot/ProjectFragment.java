package me.willowcheng.makerspaceiot;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.github.ksoichiro.android.observablescrollview.ObservableScrollView;
import com.github.ksoichiro.android.observablescrollview.ObservableScrollViewCallbacks;
import com.github.ksoichiro.android.observablescrollview.ScrollState;
import com.nineoldandroids.view.ViewHelper;

import java.util.ArrayList;

import it.gmariotti.cardslib.library.cards.actions.BaseSupplementalAction;
import it.gmariotti.cardslib.library.cards.actions.TextSupplementalAction;
import it.gmariotti.cardslib.library.cards.material.MaterialLargeImageCard;
import it.gmariotti.cardslib.library.internal.Card;
import it.gmariotti.cardslib.library.view.CardViewNative;

/**
 * A simple {@link Fragment} subclass.
 */
public class ProjectFragment extends Fragment implements ObservableScrollViewCallbacks {

    private static final String TAG = "ProjectFragment";
    private View mTextView;
    private ObservableScrollView mScrollView;
    private int mParallaxImageHeight;

    public ProjectFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_project, container, false);
        mTextView = rootView.findViewById(R.id.logo);
        mScrollView = (ObservableScrollView) rootView.findViewById(R.id.scroll);
        mScrollView.setScrollViewCallbacks(this);
        mParallaxImageHeight = getResources().getDimensionPixelSize(R.dimen.parallax_image_height);

        setUpCard(rootView, "Internet of Things", R.id.card_iot, R.drawable.banner_iot);
        setUpCard(rootView, "Mobile", R.id.card_mobile, R.drawable.banner_mobile);
        setUpCard(rootView, "Biomedical", R.id.card_biomedical, R.drawable.banner_biomedical);
        setUpCard(rootView, "3D Modelling", R.id.card_3d_modelling, R.drawable.banner_3d_modelling);
        setUpCard(rootView, "Wearables", R.id.card_wearables, R.drawable.banner_wearables);
        setUpCard(rootView, "Virtual Reality", "This is my favorite local beach", "A wonderful place", R.id.card_virtual_reality, R.drawable.banner_virtual_reality);


        return rootView;
    }

    @Override
    public void onScrollChanged(int scrollY, boolean firstScroll, boolean dragging) {
        ViewHelper.setTranslationY(mTextView, scrollY / 2);
    }

    @Override
    public void onDownMotionEvent() {
    }

    @Override
    public void onUpOrCancelMotionEvent(ScrollState scrollState) {
    }

    public void setUpCard(View rootView, String overImageText, int cardViewNativeId, int imageDrawerId) {
        // Set supplemental actions as text
        ArrayList<BaseSupplementalAction> actions = new ArrayList<>();

        // Set supplemental actions
        TextSupplementalAction textLeft = new TextSupplementalAction(getActivity(), R.id.textLeft);
        textLeft.setOnActionClickListener(new BaseSupplementalAction.OnActionClickListener() {
            @Override
            public void onClick(Card card, View view) {
                Toast.makeText(getActivity(), " Click on Text SHARE ", Toast.LENGTH_SHORT).show();
            }
        });
        actions.add(textLeft);

        TextSupplementalAction textRight = new TextSupplementalAction(getActivity(), R.id.textRight);
        textRight.setOnActionClickListener(new BaseSupplementalAction.OnActionClickListener() {
            @Override
            public void onClick(Card card, View view) {
                Toast.makeText(getActivity(), " Click on Text LEARN ", Toast.LENGTH_SHORT).show();
            }
        });
        actions.add(textRight);

        //Create a Card, set the title over the image and set the thumbnail
        MaterialLargeImageCard card =
                MaterialLargeImageCard.with(getActivity())
                        .setTextOverImage(overImageText)
                        .useDrawableId(imageDrawerId)
                        .setupSupplementalActions(R.layout.card_native_material_supplement_text, actions)
                        .build();

        card.setOnClickListener(new Card.OnCardClickListener() {
            @Override
            public void onClick(Card card, View view) {
                Toast.makeText(getActivity(), " Click on ActionArea ", Toast.LENGTH_SHORT).show();
            }
        });

        CardViewNative cardView = (CardViewNative) rootView.findViewById(cardViewNativeId);
        cardView.setCard(card);
    }

    public void setUpCard(View rootView, String overImageText, String title, String subtitle, int cardViewNativeId, int imageDrawerId) {
        // Set supplemental actions as text
        ArrayList<BaseSupplementalAction> actions = new ArrayList<>();

        // Set supplemental actions
        TextSupplementalAction textLeft = new TextSupplementalAction(getActivity(), R.id.textLeft);
        textLeft.setOnActionClickListener(new BaseSupplementalAction.OnActionClickListener() {
            @Override
            public void onClick(Card card, View view) {
                Toast.makeText(getActivity(), " Click on Text SHARE ", Toast.LENGTH_SHORT).show();
            }
        });
        actions.add(textLeft);

        TextSupplementalAction textRight = new TextSupplementalAction(getActivity(), R.id.textRight);
        textRight.setOnActionClickListener(new BaseSupplementalAction.OnActionClickListener() {
            @Override
            public void onClick(Card card, View view) {
                Toast.makeText(getActivity(), " Click on Text LEARN ", Toast.LENGTH_SHORT).show();
            }
        });
        actions.add(textRight);

        //Create a Card, set the title over the image and set the thumbnail
        MaterialLargeImageCard card =
                MaterialLargeImageCard.with(getActivity())
                        .setTextOverImage(overImageText)
                        .setTitle(title)
                        .setSubTitle(subtitle)
                        .useDrawableId(imageDrawerId)
                        .setupSupplementalActions(R.layout.card_native_material_supplement_text, actions)
                        .build();

        card.setOnClickListener(new Card.OnCardClickListener() {
            @Override
            public void onClick(Card card, View view) {
                Toast.makeText(getActivity(), " Click on ActionArea ", Toast.LENGTH_SHORT).show();
            }
        });

        CardViewNative cardView = (CardViewNative) rootView.findViewById(cardViewNativeId);
        cardView.setCard(card);
    }

}
