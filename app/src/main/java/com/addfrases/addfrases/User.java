package com.addfrases.addfrases;

import com.google.gson.annotations.SerializedName;

public class User {

        @SerializedName("id")
        public int id_user;

        @SerializedName("nome")
        public String name_user;

        @SerializedName("usuario")
        public String username_user;

        @SerializedName("senha")
        public String password_user;

        @SerializedName("foto")
        public String foto_user;

        @SerializedName("email")
        public String email_user ;

        @SerializedName("sexo")
        public String sexo_user;

        @SerializedName("estado")
        public String estado_user;

        @SerializedName("background")
        public String background_user;

        @SerializedName("sobre")
        public String sobre_user;

}
