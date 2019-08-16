package com.example.dialogos;


import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class DialogoFragment extends DialogFragment implements View.OnClickListener {

    Button login ;
    Button cancelar;
    EditText user;
    EditText pass;
    AlertDialog.Builder builder;

    public interface OnInicioSessionListener{
        void onIniciarListener();
    }

    OnInicioSessionListener listener;




    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        builder = new AlertDialog.Builder(getContext());
        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view  = inflater.inflate(R.layout.dialog_fragment, null);

        builder.setView(view);

        login = (Button) view.findViewById(R.id.btn_aceptar);
        cancelar = (Button) view.findViewById(R.id.btn_cancelar);
        user = (EditText) view.findViewById(R.id.user);
        pass = (EditText) view.findViewById(R.id.pass);

        login.setOnClickListener(this);
        cancelar.setOnClickListener(this);

        return builder.create();

    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_aceptar:
                listener.onIniciarListener();
                Toast.makeText(getContext(), "Bienvenido " + user.getText().toString(), Toast.LENGTH_SHORT).show();
                dismiss();
                break;
            case R.id.btn_cancelar:
                dismiss();
                break;
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try{
            listener = (OnInicioSessionListener) getActivity();

        }catch(ClassCastException e){
            throw new ClassCastException(context.toString()+" No se implemento la interfaz de login");

        }

    }
}
