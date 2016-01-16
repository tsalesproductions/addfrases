package com.addfrases.addfrases;

import com.google.gson.annotations.SerializedName;

public class Post {
    @SerializedName("id")
    public int id_post;

    @SerializedName("legenda")
    public String post_legenda;

    @SerializedName("data")
    public String post_data;

    @SerializedName("postador")
    public String id_postador;

    @SerializedName("curtidas")
    public String curtidas;

    @SerializedName("foto")
    public String post_foto;

}
