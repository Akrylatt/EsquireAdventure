package com.example.esquireadventure;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.snackbar.Snackbar;

import java.io.File;

public class FirstFragment extends Fragment {

    private void changeTextSize(float f, Button b, Button b2){
        b.setTextSize(f);
        b2.setTextSize(f);
    }

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_first, container, false);
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Button button_newGame = view.findViewById(R.id.button_newGame);
        Button button_loadGame = view.findViewById(R.id.button_LoadGame);

        if (PreferenceManager.getDefaultSharedPreferences(this.getContext()).getString("pref_text_size", "Medium").equals("Large")) {
            changeTextSize(26, button_loadGame, button_newGame);

        } else if(PreferenceManager.getDefaultSharedPreferences(this.getContext()).getString("pref_text_size", "Medium").equals("Small")){
            changeTextSize(15, button_loadGame, button_newGame);
        }
        else {
            changeTextSize(19, button_loadGame, button_newGame);
        }

        view.findViewById(R.id.button_newGame).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*NavHostFragment.findNavController(FirstFragment.this)
                        .navigate(R.id.action_FirstFragment_to_SecondFragment);*/
               /* startActivity(new Intent(this, GameActivity.class));*/

                //Delete history file
               File outputFile = new File(getActivity().getFilesDir(), "savedStory");
               if(outputFile.exists()){

                   outputFile.delete();
                   Intent intent = new Intent(getActivity(), GameActivity.class);
                   startActivity(intent);
               }
               else{

                   Snackbar snackbar = Snackbar
                           .make(view, getActivity().getString(R.string.nothing_to_delete), Snackbar.LENGTH_LONG);
                   snackbar.show();
                }
                //


            }


        });

        view.findViewById(R.id.button_LoadGame).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), GameActivity.class);
                startActivity(intent);
            }
        });
    }
}