package com.example.orange;

import android.content.Context;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;


import org.json.JSONException;
import org.json.JSONObject;



import java.time.LocalDate;
import java.util.ArrayList;

public class ApiOrange {


    private static  String URL_API = "http://172.16.8.18:8080/api";


    public static void connectUser(Context context, User user, IConnexion observer )
    {


        RequestQueue queue = Volley.newRequestQueue(context);
        StringRequest request = new StringRequest(URL_API + "/user/" + user.getEmail(),
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                            JsonObject object = JsonParser.parseString(response).getAsJsonObject();
                            User user = new User();
                            user.setId(object.get("id").getAsInt());
                            user.setEmail(object.get("email").getAsString());
                            user.setRoles(object.get("roles").getAsString());
                            user.setPassword(object.get("password").getAsString());
                            user.setNom(object.get("nom").getAsString());
                            user.setPrenom(object.get("prenom").getAsString());
                            user.setAdresse(object.get("adresse").getAsString());
                            user.setTel(object.get("tel").getAsString());

                            Log.w("myApp", response);
                            observer.connect(user);

                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.w("myApp", error.toString());

                    }
                }
        );
        queue.add(request);
    }




    public static void createUser(Context context, User user, ISelectButtonHomePage listener)
    {
        RequestQueue queue = Volley.newRequestQueue(context);


        try
        {

            JSONObject jsonParams = new JSONObject();
            jsonParams.put("email", user.getEmail());
            jsonParams.put("roles", user.getRoles());
            jsonParams.put("password", user.getPassword());
            jsonParams.put("nom", user.getNom());
            jsonParams.put("prenom", user.getPrenom());
            jsonParams.put("adresse", user.getAdresse());
            jsonParams.put("tel", user.getTel());



            JsonObjectRequest request = new JsonObjectRequest(

                    Request.Method.POST, URL_API + "/user",
                    jsonParams,
                    new Response.Listener<JSONObject>() {
                        @Override
                        public void onResponse(JSONObject response) {

                            listener.onSelectAccueil();
                            Log.w("myApp", response.toString());

                        }
                    },

                    new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            Log.w("myApp", error.toString());
                        }
                    }
            );


            queue.add(request);
        }catch (JSONException ex){
            Log.w("myError", ex);
        }
    }




    public static void createMateriel(Context context, Materiel materiel, ISelectButtonHomePage listener)
    {
        RequestQueue queue = Volley.newRequestQueue(context);


        try
        {

            JSONObject jsonParams = new JSONObject();
            jsonParams.put("designation", materiel.getDesignation());
            jsonParams.put("modele", materiel.getModele());
            jsonParams.put("marque", materiel.getMarque());
            jsonParams.put("prix", materiel.getPrix());
            jsonParams.put("dateAchat", materiel.getDateAchat());
            jsonParams.put("idClient", materiel.getIdClient());



            JsonObjectRequest request = new JsonObjectRequest(

                    Request.Method.POST, URL_API + "/materiel",
                    jsonParams,
                    new Response.Listener<JSONObject>() {
                        @Override
                        public void onResponse(JSONObject response) {

                            listener.onSelectAccueil();
                            Log.w("myApp", response.toString());

                        }
                    },

                    new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            Log.w("myApp", error.toString());
                        }
                    }
            );


            queue.add(request);
        }catch (JSONException ex){
            Log.w("myError", ex);
        }
    }


    public static void getAllMateriels (Context context, Integer idUser, IMaterielObserver observer){
        RequestQueue queue = Volley.newRequestQueue(context);
        StringRequest request = new StringRequest(URL_API + "/materiel/" + idUser,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        ArrayList<Materiel> materiels = new ArrayList<Materiel>();
                        JsonArray jsonArray = (JsonArray) JsonParser.parseString(response);
                        for (int i = 0; i < jsonArray.size(); i++) {
                            JsonObject object = jsonArray.get(i).getAsJsonObject();
                            Materiel materiel = new Materiel();
                          //  materiel.setId(object.get("id").getAsInt());
                            materiel.setDesignation(object.get("designation").getAsString());
                            materiel.setModele(object.get("modele").getAsString());
                            materiel.setMarque(object.get("marque").getAsString());
                            materiel.setPrix(Integer.parseInt(object.get("prix").getAsString()));
                            materiel.setDateAchat(LocalDate.parse(object.get("dateAchat").getAsString()));
                            materiels.add(materiel);
                        }
                        observer.onReceiveMateriel(materiels);
                        }
                    },
                            new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {

                        }
                });
        queue.add(request);
    }




    public static void createIntervention(Context context, Intervention intervention, ISelectButtonHomePage listener)
    {
        RequestQueue queue = Volley.newRequestQueue(context);


        try
        {

            JSONObject jsonParams = new JSONObject();
            jsonParams.put("dateIntervention", intervention.getDateIntervention());
            jsonParams.put("description", intervention.getDescription());
            jsonParams.put("duree", intervention.getDuree());
            jsonParams.put("statut", intervention.getStatut());
            jsonParams.put("prix", intervention.getPrix());
            jsonParams.put("idClient", intervention.getIdClient());



            JsonObjectRequest request = new JsonObjectRequest(

                    Request.Method.POST, URL_API + "/intervention",
                    jsonParams,
                    new Response.Listener<JSONObject>() {
                        @Override
                        public void onResponse(JSONObject response) {

                            listener.onSelectAccueil();
                            Log.w("myApp", response.toString());

                        }
                    },

                    new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            Log.w("myApp", error.toString());
                        }
                    }
            );


            queue.add(request);
        }catch (JSONException ex){
            Log.w("myError", ex);
        }
    }


    public static void getAllInterventions (Context context, Integer idUser, IIterventionObserver observer){
        RequestQueue queue = Volley.newRequestQueue(context);
        StringRequest request = new StringRequest(URL_API + "/intervention/" + idUser,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        ArrayList<Intervention> interventions = new ArrayList<Intervention>();
                        JsonArray jsonArray = (JsonArray) JsonParser.parseString(response);
                        for (int i = 0; i < jsonArray.size(); i++) {
                            JsonObject object = jsonArray.get(i).getAsJsonObject();
                            Intervention intervention = new Intervention();
                            //  materiel.setId(object.get("id").getAsInt());
                            intervention.setDateIntervention(LocalDate.parse(object.get("date_inter").getAsString()));
                            intervention.setDescription(object.get("description").getAsString());
                            intervention.setDuree(object.get("duree").getAsInt());
                            intervention.setPrix(Integer.parseInt(object.get("prix").getAsString()));
                            intervention.setStatut(object.get("statut").getAsString());
                            interventions.add(intervention);
                        }
                        observer.onReceiveIntervention(interventions);
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                });
        queue.add(request);
    }


}
