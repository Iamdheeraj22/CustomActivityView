package com.sef.customactivityview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatSpinner;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    LinearLayout list;
    Button addButton,submitList;
    List <String> teams=new ArrayList<String>();
    ArrayList<Cricketer> arrayList=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        list=findViewById(R.id.layoutList);
        addButton=findViewById(R.id.addButton);
        submitList=findViewById(R.id.submitListButton);
        teams.add("Select Team");
        teams.add("India");
        teams.add("England");
        teams.add("Australia");
        teams.add("SriLanka");
        teams.add("South Africa");
        addButton.setOnClickListener(v->{
            addView();
        });
        submitList.setOnClickListener(v->{
            if(checkIfValidAndRead()){
                Intent intent=new Intent(MainActivity.this,CricketersActivity.class);
                Bundle bundle=new Bundle();
                bundle.putSerializable("list",arrayList);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
    }

    private boolean checkIfValidAndRead()
    {
        boolean result=true;
        arrayList.clear();

        for (int i=0;i<list.getChildCount();i++)
        {
            View cricketerView=list.getChildAt(i);
            EditText name=cricketerView.findViewById(R.id.cricketerName);
            AppCompatSpinner compatSpinner=cricketerView.findViewById(R.id.spinner);
            Cricketer cricketer= new Cricketer();

            if(!name.getText().toString().equals("")){
                cricketer.setCricketerName(name.getText().toString());
            }else{
                result=false;
            }

            if(compatSpinner.getSelectedItemPosition()!=-1){
                cricketer.setTeamName(teams.get(compatSpinner.getSelectedItemPosition()));
            }else{
                result=false;
            }
            arrayList.add(cricketer);
        }

        if(arrayList.size()==0){
            result=false;
            Toast.makeText(this, "Add Cricketer's first...", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(this, "Enter all details correctly...", Toast.LENGTH_SHORT).show();
        }
        return result;
    }

    private void addView() {
        View cricketerView=getLayoutInflater().inflate(R.layout.row_add_cricketer,null,false);

        EditText name=cricketerView.findViewById(R.id.cricketerName);
        AppCompatSpinner compatSpinner=cricketerView.findViewById(R.id.spinner);
        ImageView removeImage=cricketerView.findViewById(R.id.closeButton);

        ArrayAdapter arrayAdapter=new ArrayAdapter(this,android.R.layout.simple_spinner_item,teams);
        compatSpinner.setAdapter(arrayAdapter);
        removeImage.setOnClickListener(v->{
            removeView(cricketerView);
        });

        list.addView(cricketerView);
    }

    private void removeView(View view){
        list.removeView(view);
    }
}