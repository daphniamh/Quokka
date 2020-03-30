package com.example.quokka;

import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import java.util.Locale;

public class FirstFragment extends Fragment  {
    //finde items and caching them
    TextView showCountTextView;
    EditText text_name_field;
    //public TextToSpeech tts;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        // Inflate the layout for this fragment
        View fragmentFirstLayout = inflater.inflate(R.layout.fragment_first, container, false);
        //Suchen der Items per View hier einmalig für ganze Klasse
        showCountTextView = fragmentFirstLayout.findViewById(R.id.text_number);
        text_name_field = fragmentFirstLayout.findViewById(R.id.text_name);

        return fragmentFirstLayout;
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        //voreingestellt durch IDE -> bei Klick on next öffnet sich anderes fragment
        view.findViewById(R.id.button_first).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(FirstFragment.this)
                        .navigate(R.id.action_FirstFragment_to_SecondFragment);
            }
        });

        // Methode um Namen als Toast-Message auszugeben
        view.findViewById(R.id.toast_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String name = text_name_field.getText().toString();
                Toast myToast = Toast.makeText(getActivity(), "Hello "+name+"!", Toast.LENGTH_SHORT);
                myToast.show();
            }
        });

        //view.findViewById(R.id.random_button).setOnClickListener(new View.OnClickListener(){
        //        talkSalut(view);
        //});

        //Funktion des Zählens durch den Count-Button
        view.findViewById(R.id.button_count).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                countMe(view); //neue Funktion deklariert, weil die Inhalte komplexer sind
            }
        });


    }

    //innerhalb der Firstfragment-Class die countMe Methode-beschreiben
    private void countMe(View view) {
        String countString = showCountTextView.getText().toString();
        Integer count = Integer.parseInt(countString); //convert to integer
        count++; //increment the existing number
        showCountTextView.setText(count.toString()); //display value in textview
    }

   //public void talkSalut(View view){
   //    view.findViewById(R.id.random_button).setOnClickListener(new View.OnClickListener() {
   //        @Override
   //        public void onClick(View view) {
   //            tts = new TextToSpeech(this, this);
   //        }

   //        public void onInit(int arg0) {
   //            tts.setLanguage(Locale.FRENCH);
   //            tts.speak("Salut", TextToSpeech.QUEUE_FLUSH, null);
   //        }
   //    });
   // }


}
