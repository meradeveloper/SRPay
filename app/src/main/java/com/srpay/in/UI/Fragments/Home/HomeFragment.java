package com.srpay.in.UI.Fragments.Home;

import android.annotation.TargetApi;
import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;


import com.fujiyuu75.sequent.Direction;
import com.fujiyuu75.sequent.Sequent;
import com.srpay.in.Adapters.CustomRecycleAdapter;
import com.srpay.in.Adapters.MainSliderAdapter;
import com.srpay.in.BR;
import com.srpay.in.Base.BaseFragment;
import com.srpay.in.Base.BaseRecycleViewFragment;
import com.srpay.in.Base.BaseViewModel;
import com.srpay.in.R;
import com.srpay.in.UI.DTH.DTHActivity;
import com.srpay.in.UI.Fragments.FragmentHandler;
import com.srpay.in.UI.Recharge.RechargeActivity;
import com.srpay.in.UI.Recharge.RechargeConfig;
import com.srpay.in.UI.RecycleView.ItemOffsetDecoration;
import com.srpay.in.databinding.FragmentHomeBinding;

import java.util.ArrayList;

import javax.inject.Inject;

import ss.com.bannerslider.Slider;
import ss.com.bannerslider.event.OnSlideClickListener;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link HomeFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link HomeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HomeFragment extends BaseFragment<FragmentHomeBinding,HomeViewModel> implements View.OnScrollChangeListener,OnSlideClickListener,CustomRecycleAdapter.RecyleAdapterListener,HomeNavigator {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    CardView cardView;
    LinearLayout linearLayout;
    private Slider slider;
    private ImageView imageView;
    //private ObservableScrollView observableScrollView;

    private OnFragmentInteractionListener mListener;
    private FragmentHandler fragmentHandler;
    private ArrayList<HomeOptionModel> homeOptionArrayList=new ArrayList<>();

    public HomeFragment() {
        // Required empty public constructor
    }

    @Inject
    HomeViewModel mViewModel;
    @Inject
    ViewModelProvider.Factory mViewModelFactory;
    @Inject
    CustomRecycleAdapter QuickOptionAdapter;

    @Inject
    CustomRecycleAdapter OtherOptionAdapter;
    private FragmentHomeBinding mViewBinding;

    // TODO: Rename and change types and number of parameters
    public static HomeFragment newInstance(FragmentHandler fragmentHandler) {
        HomeFragment fragment = new HomeFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public int getBindingVariable() {
        return BR.viewModel;
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_home;
    }

    @Override
    public HomeViewModel getViewModel() {
        mViewModel = ViewModelProviders.of(this, mViewModelFactory).get(HomeViewModel.class);
        return mViewModel;
    }


    @TargetApi(Build.VERSION_CODES.M)
    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mViewBinding = getViewDataBinding();
        getViewModel().setNavigator(this);
        mViewBinding.scrollView.setSmoothScrollingEnabled(true);
        mViewBinding.scrollView.setOnScrollChangeListener(this);
        mViewBinding.slider.setOnSlideClickListener(this);
        mViewBinding.slider.setAdapter(new MainSliderAdapter(getActivity()));
        setQuickOptionAdapter();
        setOtherOptionAdapter();
        addSequent(mViewBinding.LL);
    }

    private void setQuickOptionAdapter() {

        QuickOptionAdapter.setLayoutID(R.layout.home_recyle_layout);
        QuickOptionAdapter.setDataList(homeOptionArrayList);
        final int spacing = getResources().getDimensionPixelOffset(R.dimen.default_spacing_verysmall);
        mViewBinding.recyclerView.setLayoutManager(getGridLayoutManager(3));
        mViewBinding.recyclerView.setAdapter(QuickOptionAdapter);
        mViewBinding.recyclerView.addItemDecoration(new ItemOffsetDecoration(spacing));
        mViewBinding.recyclerView.setNestedScrollingEnabled(false);

    }

    private void setOtherOptionAdapter() {
        addSequent(mViewBinding.cv2);
        OtherOptionAdapter.setLayoutID(R.layout.home_recyle_layout);
        OtherOptionAdapter.setDataList(homeOptionArrayList);
        final int spacing = getResources().getDimensionPixelOffset(R.dimen.default_spacing_verysmall);
        mViewBinding.otherRecycle.setLayoutManager(getGridLayoutManager(3));
        mViewBinding.otherRecycle.setAdapter(OtherOptionAdapter);
        mViewBinding.otherRecycle.addItemDecoration(new ItemOffsetDecoration(spacing));
        mViewBinding.otherRecycle.setNestedScrollingEnabled(false);
    }

    private GridLayoutManager getGridLayoutManager(int count){return new GridLayoutManager(getActivity(),count);}

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            //mParam1 = getArguments().getString(ARG_PARAM1);
            //fragmentHandler = (FragmentHandler) getArguments().getSerializable(ARG_PARAM1);
        }

        HomeOptionModel homeOptionModel = new HomeOptionModel();
        homeOptionModel.setOptionName("Prepaid");
        homeOptionModel.setOptionIcon(R.drawable.mobile_recharge);
        homeOptionArrayList.add(homeOptionModel);

        homeOptionModel = new HomeOptionModel();
        homeOptionModel.setOptionName("Postpaid");
        homeOptionModel.setOptionIcon(R.drawable.option_postpaid);
        homeOptionArrayList.add(homeOptionModel);

        homeOptionModel = new HomeOptionModel();
        homeOptionModel.setOptionName("DTH");
        homeOptionModel.setOptionIcon(R.drawable.option_dth);
        homeOptionArrayList.add(homeOptionModel);

        homeOptionModel = new HomeOptionModel();
        homeOptionModel.setOptionName("Bill Pay");
        homeOptionModel.setOptionIcon(R.drawable.option_billpay);
        homeOptionArrayList.add(homeOptionModel);

        homeOptionModel = new HomeOptionModel();
        homeOptionModel.setOptionName("Fund Transfer");
        homeOptionModel.setOptionIcon(R.drawable.optio_fund_transfer);
        homeOptionArrayList.add(homeOptionModel);
    }

    private void addSequent(ViewGroup container) {

        Sequent
        .origin(container)
        .duration(700) // option.
        .delay(500) // option. StartOffSet time.
        .offset(500) // option. Interval time.
        .flow(Direction.BACKWARD) // option. Flow of animations in (FORWARD/BACKWARD/RANDOM).
        //.anim(Context, Animation) or .anim(Context, int) // option. implemented Animation or ObjectAnimator xml resource.
        .start();
    }


    /*@Override
    protected int getAnimationItems() {
        return AnimationItems.SLIDE_FROM_BOTTOM;
    }*/


    // TODO: Rename method, update argument and hook method into UI event


    @Override
    public void onSlideClick(int position) {
        Toast.makeText(getActivity(), "position: "+position, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onScrollChange(View view, int i, int i1, int i2, int i3) {
        mViewBinding.slider.setTranslationY(i3/2);
    }

    @Override
    public void onItemClick(CustomRecycleAdapter CRA,HomeOptionModel HOM) {
        Log.e("HomeFragment","OnSelect");
        if(mViewBinding.recyclerView.getAdapter() == CRA)
        {
            if(HOM.getOptionName().equalsIgnoreCase("Prepaid"))
                mViewModel.goToPrepaid();

            else if(HOM.getOptionName().equalsIgnoreCase("Postpaid"))
                mViewModel.goToPostpaid();

            else if(HOM.getOptionName().equalsIgnoreCase("DTH"))
                mViewModel.goToDTH();
               // startActivity(new Intent(getActivity(), RechargeActivity.class).putExtra(RechargeConfig.TYPE,RechargeConfig.Type.POSTPAID.toString()));

            Log.e("HomeFragment","OnSelect: recycle "+HOM.getOptionName()) ;
        }

        else if (mViewBinding.otherRecycle.getAdapter() == CRA)
            Log.e("HomeFragment","OnSelect: otherRecycle");
    }

    @Override
    public void handleError(Throwable throwable) {

    }

    @Override
    public void login() {

    }

    @Override
    public void openMainActivity() {

    }

    @Override
    public void goToRecharge(Intent bundle) {
        startActivity(bundle.setClass(getActivity(),RechargeActivity.class));
        getActivity().overridePendingTransition(R.anim.pull_in_right, R.anim.push_out_left);
    }

    @Override
    public void goToBillPay(Intent bundle) {
        startActivity(bundle.setClass(getActivity(),RechargeActivity.class));
        getActivity().overridePendingTransition(R.anim.pull_in_right, R.anim.push_out_left);
    }

    @Override
    public void goToDTH(Intent bundle) {
        startActivity(bundle.setClass(getActivity(),DTHActivity.class));
        getActivity().overridePendingTransition(R.anim.pull_in_right, R.anim.push_out_left);
    }

    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
         void onHomeFragmentInteraction();
    }
}
