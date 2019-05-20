package com.yuda_alector.contactos;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.yuda_alector.contactos.dao.DaoContacto;
import com.yuda_alector.contactos.model.Contacto;


public class Edit extends Fragment {
    private DaoContacto crud;
    private String id;
    private Contacto contact;
    private TextView nombre,
            apellidoPaterno,
            apellidoMaterno,
            telefono,
            email,
            calle,
            colonia,
            numero,
            ciudad,
            estado,
            estadoCivil,
            enfermedades,
            nacionalidad,
            numeroNomina,
            curp,
            puesto;


    public Edit() {}

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.crud = new DaoContacto(getActivity().getApplicationContext());
        this.id = this.getArguments().getString("id");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view  = inflater.inflate(R.layout.fragment_edit, container, false);
        Button edit = view.findViewById(R.id.fec_save);

        edit.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                save(v);
            }
        });
        this.contact = this.crud.getContact(this.id);

        this.nombre = view.findViewById(R.id.fec_tv_nombre);
        this.apellidoPaterno = view.findViewById(R.id.fec_tv_apellido_paterno);
        this.apellidoMaterno = view.findViewById(R.id.fec_tv_apellido_paterno);
        this.telefono = view.findViewById(R.id.fec_tv_telefono);
        this.email = view.findViewById(R.id.fec_tv_email);
        this.calle = view.findViewById(R.id.fec_tv_calle);
        this.colonia = view.findViewById(R.id.fec_tv_colonia);
        this.numero = view.findViewById(R.id.fec_tv_numero);
        this.ciudad = view.findViewById(R.id.fec_tv_ciudad);
        this.estado = view.findViewById(R.id.fec_tv_estado);
        this.estadoCivil = view.findViewById(R.id.fec_tv_estado_civil);
        this.enfermedades = view.findViewById(R.id.fec_tv_enfermedades);
        this.nacionalidad = view.findViewById(R.id.fec_tv_nacionalidad);
        this.numeroNomina = view.findViewById(R.id.fec_tv_numero_nomina);
        this.curp = view.findViewById(R.id.fec_tv_cupr);
        this.puesto = view.findViewById(R.id.fec_tv_puesto);


        this.nombre.setText(contact.getNombre());
        this.apellidoPaterno.setText(contact.getApellidoPaterno());
        this.apellidoMaterno.setText(contact.getApellidoMaterno());
        this.telefono.setText(contact.getTelefono());
        this.email.setText(contact.getEmail());
        this.calle.setText(contact.getCalle());
        this.colonia.setText(contact.getColonia());
        this.numero.setText(contact.getNumero());
        this.ciudad.setText(contact.getCiudad());
        this.estado.setText(contact.getEstado());
        this.estadoCivil.setText(contact.getEstadoCivil());
        this.enfermedades.setText(contact.getEnfermedades());
        this.nacionalidad.setText(contact.getNacionalidad());
        this.numeroNomina.setText(contact.getNumeroNomina());
        this.curp.setText(contact.getCurp());
        this.puesto.setText(contact.getPuesto());


        Toast.makeText(view.getContext(), "Contacto[f]: " + id, Toast.LENGTH_LONG).show();
        return view;
    }

    public void save(View view) {
        if(this.crud.edit(contact)){
            Toast.makeText(view.getContext(), "Contacto "+ contact.getNombre()+" actualizado con éxito", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(view.getContext(), "Tenemos problemas para actualizar a "+ contact.getNombre() , Toast.LENGTH_SHORT).show();
        }

    }

    public Contacto getContact(){
        return new Contacto(
                null,
                nombre.getText().toString(),
                apellidoPaterno.getText().toString(),
                apellidoMaterno.getText().toString(),
                telefono.getText().toString(),
                email.getText().toString(),
                calle.getText().toString(),
                colonia.getText().toString(),
                numero.getText().toString(),
                ciudad.getText().toString(),
                estado.getText().toString(),
                estadoCivil.getText().toString(),
                enfermedades.getText().toString(),
                nacionalidad.getText().toString(),
                numeroNomina.getText().toString(),
                curp.getText().toString(),
                puesto.getText().toString()
        );
    }

}
