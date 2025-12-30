package com.example.lifecycle;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;


public class FirstFragment extends Fragment {

    private static final String TAG="FragmentLifecycle";
@Override
public void onAttach(@NonNull Context context){
    super.onAttach(context);
    Log.d(TAG,"FirstFragment: onAttach() called");
    Toast.makeText(getActivity(),"FirstFragment: onAttach", Toast.LENGTH_SHORT).show();
}

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG,"FirstFragment: onCreate() called");
        Toast.makeText(getActivity(),"FirstFragment: onCreate", Toast.LENGTH_SHORT).show();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Log.d(TAG,"FirstFragment: onCreateView() called");
        Toast.makeText(getActivity(),"FirstFragment: onCreateView", Toast.LENGTH_SHORT).show();
        return inflater.inflate(R.layout.fragment_first, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);
        Log.d(TAG,"FirstFragment: onViewCreated() called");
        Toast.makeText(getActivity(),"FirstFragment: onViewCreated", Toast.LENGTH_SHORT).show();

        TextView LTPTextView=view.findViewById(R.id.LPTextView);
        registerForContextMenu(LTPTextView);
    }

    @Override
    public void onCreateContextMenu(
            @NonNull ContextMenu menu, @NonNull View v,
            @Nullable ContextMenu.ContextMenuInfo menuInfo
    ){
        super.onCreateContextMenu(menu,v,menuInfo);
        getActivity().getMenuInflater().inflate(R.menu.context_menu,menu);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.d(TAG,"FirstFragment: onActivityCreated() called");
        Toast.makeText(getActivity(),"FirstFragment: onActivityCreated", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onStart(){
    super.onStart();
        Log.d(TAG,"FirstFragment: onStart() called");
        Toast.makeText(getActivity(),"FirstFragment: onStart", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onResume(){
        super.onResume();
        Log.d(TAG,"FirstFragment: onResume() called");
        Toast.makeText(getActivity(),"FirstFragment: onResume", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onPause(){
        super.onPause();
        Log.d(TAG,"FirstFragment: onPause() called");
        Toast.makeText(getActivity(),"FirstFragment: onPause", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onStop(){
        super.onStop();
        Log.d(TAG,"FirstFragment: onStop() called");
        Toast.makeText(getActivity(),"FirstFragment: onStop", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onDestroyView(){
        super.onDestroyView();
        Log.d(TAG,"FirstFragment: onDestroyView() called");
        Toast.makeText(getActivity(),"FirstFragment: onDestroyView", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onDestroy(){
        super.onDestroy();
        Log.d(TAG,"FirstFragment: onDestroy() called");
        Toast.makeText(getActivity(),"FirstFragment: onDestroy", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onDetach(){
        super.onDetach();
        Log.d(TAG,"FirstFragment: onDetach() called");
        Toast.makeText(getActivity(),"FirstFragment: onDetach", Toast.LENGTH_SHORT).show();
    }

}