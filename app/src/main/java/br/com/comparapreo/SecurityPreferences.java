package br.com.comparapreo;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

public class SecurityPreferences {

    SharedPreferences preferences;
    SharedPreferences.Editor editor;

    //CONSTRUTOR
    public SecurityPreferences(Context context) {
        this.preferences = PreferenceManager.getDefaultSharedPreferences(context);
        this.editor = preferences.edit();
    }
    //GUARDA VALORER
    public void guardaString(String key, String value){
        editor.putString(key, value).commit();
    }

    //RECUPERA VALOR
    public String recuperaString(String key){
        return preferences.getString(key, "Nulo");
    }


}
