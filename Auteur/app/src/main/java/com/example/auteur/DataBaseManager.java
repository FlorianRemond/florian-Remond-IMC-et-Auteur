package com.example.auteur;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;


public class DataBaseManager extends SQLiteOpenHelper {
    /*  Création de la base de données qui aura le nom de Axobdd*/
    private static final String DATABASE_NAME = "Auteur";
    private static final int DATABASE_VERSION = 1;

    String nomAuteur,prenomAuteur,dateNaissance;

    public DataBaseManager(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION );

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String requeteAuteur = "create table auteur (idAuteur integer primary key autoincrement, nomAuteur text not null, prenomAuteur text not null, dateNaissance text not null)";
        db.execSQL(requeteAuteur);
        Log.i("DB", "Création Ok");
    }

    //mise  a jour du schema de la BDD
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        this.onCreate(db);
        Log.i("DB", "OnUpgrade");
    }

    //ajout d'un auteur
    public void insertAuteur(String nomAuteur, String prenomAuteur, String dateNaissance) {
        String req = "INSERT INTO auteur (nomAuteur,prenomAuteur,dateNaissance) values('" + nomAuteur + "','" + prenomAuteur + "','" + dateNaissance +"')";
        this.getReadableDatabase().execSQL(req);
        Log.i("DB", "Insert auteur Ok");
    }
       //suppression d'une auteur
    public void deleteAuteur(int idAuteur) {
        String req = "DELETE FROM auteur  WHERE idAuteur= '" + idAuteur + "'";
        this.getReadableDatabase().execSQL(req);
         Log.i("DB", "Delete auteur  Ok");
    }

    //récupérer un auteur
    public Auteur  getOneAuteur (int idAuteur){
        SQLiteDatabase db = this.getReadableDatabase();
        Auteur auteur = null;
        Cursor c = db.rawQuery("SELECT * FROM user WHERE idAuteur = '"+idAuteur+"'", null);
        if (c.moveToFirst()){
            do {
                // Passing values
               // int idAuteur = c.getInt(0);
                nomAuteur = c.getString(1);
                prenomAuteur = c.getString(2);
                dateNaissance = c.getString(3);
                auteur = new Auteur(c.getInt(0),nomAuteur,prenomAuteur,dateNaissance);
                // Do something Here with values
            } while(c.moveToNext());
            Log.i("DB", "GetOne auteur Ok" );
        }
        c.close();
        db.close();
        Log.i("DB", "GetOne auteur Ok"+auteur );
        return auteur;

    }


    // récupérer toutes les auteurs dans la base
    public List<Auteur> getAllAuteur() {
        List<Auteur> listeAut = new ArrayList<>();
        String req = "SELECT * FROM auteur";
        Cursor cursor = this.getReadableDatabase().rawQuery(req, null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            Auteur aut = new Auteur(cursor.getInt(0), cursor.getString(1), cursor.getString(2), cursor.getString(3));
            listeAut.add(aut);
            cursor.moveToNext();
            Log.i("DB", "Getall auteur Ok" );
        }
        cursor.close();
        return listeAut;
    }

    public void updateAuteur(int idAuteur, String nomAuteur, String prenomAuteur, String dateNaissance) {
        String req = " UPDATE auteur SET nomAuteur='" + nomAuteur + "', prenomAuteur='" + prenomAuteur + "', dateNaissance='" + dateNaissance + "' WHERE idAuteur='" + idAuteur + "'";
        this.getReadableDatabase().execSQL(req);
        Log.i("DB", "Update Auteur Ok");
    }



}
