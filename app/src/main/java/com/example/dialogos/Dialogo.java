package com.example.dialogos;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.widget.ListView;

public class Dialogo {

    public static Dialog alerta(Activity activity, final View view){
        AlertDialog.Builder builder = new AlertDialog.Builder(activity, R.style.estilo_dialogo);
        builder.setTitle("Alerta");
        builder.setMessage("dialogo de alerta");
        builder.setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Snackbar.make(view, "Mensaje aceptado", Snackbar.LENGTH_SHORT).show();
            }
        });

        return builder.create();
    }



    public static Dialog confirmacion(Activity activity, final View v){
        final AlertDialog.Builder builder = new AlertDialog.Builder(activity, R.style.estilo_dialogo);
        builder.setTitle("confirmacion");
        builder.setMessage("dialogo de confirmacion?");
        builder.setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
                Snackbar.make(v,"dialogo aceptado", Snackbar.LENGTH_SHORT ).show();
            }
        });
        builder.setNegativeButton("Rechazar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
                Snackbar.make(v, "dialogo rechazado", Snackbar.LENGTH_SHORT).show();
            }
        });

        builder.setNeutralButton("Cancelar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
                Snackbar.make(v, "dialogo cancelado", Snackbar.LENGTH_SHORT).show();
            }
        });
        return builder.create();
    }


    //dialogo de lista simples
    public static AlertDialog lista(Activity activity, final View view){
        final String[] items = {"Item1" , "Item2", "Item3", "Item4"};

        final AlertDialog.Builder builder = new AlertDialog.Builder(activity, R.style.estilo_lista);
        builder.setTitle("alerta de lista");
        builder.setItems(items, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Snackbar.make(view, items[which], Snackbar.LENGTH_SHORT).show();
            }
        });

        builder.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });

        return builder.create();

    }

    //dialogo de lista simples
    public static AlertDialog listaRadio(Activity activity, final View view){
        final String[] items = {"Item1" , "Item2", "Item3", "Item4"};

        final AlertDialog.Builder builder = new AlertDialog.Builder(activity, R.style.estilo_lista);
        builder.setTitle("alerta de lista");
        builder.setSingleChoiceItems(items, 0, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Snackbar.make(view, items[which], Snackbar.LENGTH_SHORT).show();
            }
        });

        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                ListView listView = ((AlertDialog) dialog).getListView();
                String seleccion = (String) listView.getAdapter().getItem(listView.getCheckedItemPosition());

                dialog.cancel();
                Snackbar.make(view, "Seleccion : " + seleccion, Snackbar.LENGTH_SHORT).show();
            }
        });
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });

        return builder.create();

    }

    //dialogo de lista simples
    public static AlertDialog listaCheck(Activity activity, final View view){
        final String[] items = {"Item1" , "Item2", "Item3", "Item4"};
        final boolean[] checkedItems = {false , false, false, false};

        final AlertDialog.Builder builder = new AlertDialog.Builder(activity, R.style.estilo_lista);
        builder.setTitle("alerta de lista");
        builder.setMultiChoiceItems(items, checkedItems, new DialogInterface.OnMultiChoiceClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                if (isChecked) Snackbar.make(view, items[which], Snackbar.LENGTH_SHORT).show();
            }
        });
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String seleccion = "";
                for (int i= 0; i< checkedItems.length; i++ ){
                    if (checkedItems[i]){
                        seleccion+=" "+items[i];
                    }
                }
                dialog.cancel();
                Snackbar.make(view, "Seleccion : "+seleccion, Snackbar.LENGTH_SHORT).show();
            }
        });

        builder.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });

        return builder.create();

    }
}
