package com.example.auteur;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private EditText txtIdAuteur,txtNomAuteur,txtPrenomAuteur,txtDateNaissance;
    private Button idBtnAjout,idBtnModifier,idBtnSupprimer;
    private DataBaseManager dbm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dbm= new DataBaseManager(this);
        initButton();
        listenerButton();

      //  dbm.insertAuteur ("King","Stephen", "10091981");
     //   dbm.insertAuteur ("john","Café", "10091981");
      //  dbm.insertAuteur ("musso ","guigui", "10091981");
      //  dbm.deleteAuteur(1);
       // dbm.getOneAuteur(5);
       // dbm.getAllAuteur();
    }

    public void initButton(){
        idBtnAjout = findViewById(R.id.idBtnAjout);
        idBtnModifier = findViewById(R.id.idBtnModifier);
        idBtnSupprimer = findViewById(R.id.idBtnSupprimer);
        txtIdAuteur=findViewById(R.id.txtIdAuteur);
        txtNomAuteur=findViewById(R.id.txtNomAuteur);
        txtPrenomAuteur=findViewById(R.id.txtPrenomAuteur);
        txtDateNaissance=findViewById(R.id.txtDateNaissance);
    }
    public void listenerButton(){
        idBtnAjout.setOnClickListener(this);
        idBtnModifier.setOnClickListener(this);
        idBtnSupprimer.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view.equals(idBtnAjout)){
          String nom = txtNomAuteur.getText().toString();
          String prenom = txtPrenomAuteur.getText().toString();
          String date = txtDateNaissance.getText().toString();
          dbm.insertAuteur(nom,prenom,date);
            Toast.makeText(this, "btn ajout", Toast.LENGTH_SHORT).show();
        }
        if(view.equals(idBtnModifier)){
            int idA = Integer.parseInt(txtIdAuteur.getText().toString());
            String nom = txtNomAuteur.getText().toString();
            String prenom = txtPrenomAuteur.getText().toString();
            String date = txtDateNaissance.getText().toString();
            dbm.updateAuteur(idA,nom,prenom,date);
            Toast.makeText(this, "btn modif", Toast.LENGTH_SHORT).show();
        }
        if(view.equals(idBtnSupprimer)){
           String idA = txtIdAuteur.getText().toString();
            dbm.deleteAuteur(Integer.parseInt(idA));
            Toast.makeText(this, "btn supprimer", Toast.LENGTH_SHORT).show();
        }
    }

}
