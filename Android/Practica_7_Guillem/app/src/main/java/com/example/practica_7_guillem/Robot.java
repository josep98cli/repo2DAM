package com.example.practica_7_guillem;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

public class Robot implements Parcelable {

    public String nombre;
    public String material;
    public int anyo;
    public Tipo tipo;


    public Robot() {
    }

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Robot(String nombre, String material, int anyo, Tipo tipo) {
        this.nombre = nombre;
        this.material = material;
        this.anyo = anyo;
        this.tipo = tipo;
    }

    protected Robot(Parcel in) {
        nombre = in.readString();
        material = in.readString();
        anyo = in.readInt();
    }

    public static final Creator<Robot> CREATOR = new Creator<Robot>() {
        @Override
        public Robot createFromParcel(Parcel in) {
            return new Robot(in);
        }

        @Override
        public Robot[] newArray(int size) {
            return new Robot[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(nombre);
        parcel.writeString(material);
        parcel.writeInt(anyo);
    }
}
