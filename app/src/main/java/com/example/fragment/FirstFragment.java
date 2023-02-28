package com.example.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.fragment.adapter.MovieAdopter;
import com.example.fragment.model.DataModel;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FirstFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FirstFragment extends Fragment implements MovieAdopter.ItemClickListener {

    private ArrayList<DataModel> list=new ArrayList<>();
    private RecyclerView recyclerView;
    private MovieAdopter adopter;

  //  private int [] imageBack={R.drawable.joker,R.drawable.leo,R.drawable.the,R.drawable.emilie,R.drawable.mouse,R.drawable.bla};
    private RecyclerView.LayoutManager layoutManager;



    public FirstFragment() {

        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     * @return A new instance of fragment FirstFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static FirstFragment newInstance() {
        FirstFragment fragment = new FirstFragment();
        return fragment;
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null)
          {

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_first, container, false);
        buildListData();
        initRecyclerView(view);
        return view;
    }

    private void initRecyclerView(View view){

        recyclerView=view.findViewById(R.id.recyclerViewEve);
        layoutManager=new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        adopter=new MovieAdopter(list,this);
        recyclerView.setAdapter(adopter);
        //adopter=new MovieAdopter(imageBack);

    }

    private void buildListData (){

        list.add(new DataModel("Joker"));
        list.add(new DataModel("Leon"));
        list.add(new DataModel("Avengers"));
        list.add(new DataModel("Emilie"));
        list.add(new DataModel("Ratatouille"));
        list.add(new DataModel("Black Swan"));


    }




    @Override
    public void onItemClick(DataModel dataModel) {

            Fragment fragment = DetailsFragment.newInstance(dataModel.getTitle());



        FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frame_container,fragment,"details_fragment");
        //transaction.hide(getActivity().getSupportFragmentManager().findFragmentByTag("fragment_first"));
       // transaction.add(R.id.frame_container,fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }

}