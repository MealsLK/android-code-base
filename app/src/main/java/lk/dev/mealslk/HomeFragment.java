package lk.dev.mealslk;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import lk.dev.mealslk.adapters.ItemSquareAdapter;

import static androidx.constraintlayout.widget.Constraints.TAG;

public class HomeFragment extends Fragment {
    private ArrayList<String> itemNames = new ArrayList<>();
    private ArrayList<String> itemImages = new ArrayList<>();
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public HomeFragment() {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters
    public static HomeFragment newInstance(String param1, String param2) {
        HomeFragment fragment = new HomeFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        getImages();
    }

    private void getImages(){
        Log.d(TAG, "initImageBitmaps: preparing bitmaps.");

        itemImages.add("https://i.imgur.com/ZcLLrkY.jpg");
        itemNames.add("Havasu Falls");

        itemImages.add("https://i.redd.it/tpsnoz5bzo501.jpg");
        itemNames.add("Trondheim");

        itemImages.add("https://i.redd.it/qn7f9oqu7o501.jpg");
        itemNames.add("Portugal");

        itemImages.add("https://i.redd.it/j6myfqglup501.jpg");
        itemNames.add("Rocky Mountain National Park");

        itemImages.add("https://i.redd.it/0h2gm1ix6p501.jpg");
        itemNames.add("Mahahual");

        itemImages.add("https://i.redd.it/k98uzl68eh501.jpg");
        itemNames.add("Frozen Lake");

        itemImages.add("https://i.redd.it/glin0nwndo501.jpg");
        itemNames.add("White Sands Desert");

        itemImages.add("https://i.redd.it/obx4zydshg601.jpg");
        itemNames.add("Austrailia");

        itemImages.add("https://i.imgur.com/ZcLLrkY.jpg");
        itemNames.add("Washington");

        initRecyclerView();

    }
    private void initRecyclerView(){
        Log.d(TAG, "initRecyclerView: init recyclerview");

        LinearLayoutManager layoutManager = new LinearLayoutManager(super.getContext(), LinearLayoutManager.HORIZONTAL, false);
        RecyclerView recyclerView = getView().findViewById(R.id.home_favourites);
        recyclerView.setLayoutManager(layoutManager);
        ItemSquareAdapter adapter = new ItemSquareAdapter(super.getContext(), itemNames, itemImages);
        recyclerView.setAdapter(adapter);

        LinearLayoutManager layoutManager1 = new LinearLayoutManager(super.getContext(), LinearLayoutManager.HORIZONTAL, false);
        RecyclerView recyclerView1 = getView().findViewById(R.id.home_nearby);
        recyclerView1.setLayoutManager(layoutManager1);
        ItemSquareAdapter adapter1 = new ItemSquareAdapter(super.getContext(), itemNames, itemImages);
        recyclerView1.setAdapter(adapter1);

        LinearLayoutManager layoutManager2 = new LinearLayoutManager(super.getContext(), LinearLayoutManager.HORIZONTAL, false);
        RecyclerView recyclerView2 = getView().findViewById(R.id.home_recommended);
        recyclerView2.setLayoutManager(layoutManager2);
        ItemSquareAdapter adapter2 = new ItemSquareAdapter(super.getContext(), itemNames, itemImages);
        recyclerView2.setAdapter(adapter2);
    }
}