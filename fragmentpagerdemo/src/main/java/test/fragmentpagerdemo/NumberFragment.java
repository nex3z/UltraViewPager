package test.fragmentpagerdemo;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;

public class NumberFragment extends Fragment {
    private static final String ARG_NUMBER = "number";
    private static final String ARG_COLOR = "color";

    private FrameLayout mContainer;
    private TextView mTvNumber;

    private int mNumber;
    private int mColor;

    public NumberFragment() {}

    public static NumberFragment newInstance(int number, int color) {
        NumberFragment fragment = new NumberFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_NUMBER, number);
        args.putInt(ARG_COLOR, color);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mNumber = getArguments().getInt(ARG_NUMBER);
            mColor = getArguments().getInt(ARG_COLOR);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_number, container, false);
        mTvNumber = (TextView) rootView.findViewById(R.id.tv_number);
        mContainer = (FrameLayout) rootView.findViewById(R.id.container);
        return rootView;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        mTvNumber.setText(String.valueOf(mNumber));
        mContainer.setBackgroundColor(mColor);
    }
}
