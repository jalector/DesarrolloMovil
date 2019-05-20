package com.yuda_alector.contactos;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.yuda_alector.contactos.dao.DaoContacto;
import com.yuda_alector.contactos.model.Contacto;

public class ViewContact extends Fragment {
    private DaoContacto crud;
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

    public ViewContact() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_view_contact, container, false);
        String id = this.getArguments().getString("id");
        this.crud = new DaoContacto(view.getContext());
        this.contact = this.crud.getContact(id);

        this.nombre = view.findViewById(R.id.fc_tv_nombre);
        this.apellidoPaterno = view.findViewById(R.id.fc_tv_apellido_paterno);
        this.apellidoMaterno = view.findViewById(R.id.fc_tv_apellido_paterno);
        this.telefono = view.findViewById(R.id.fc_tv_telefono);
        this.email = view.findViewById(R.id.fc_tv_email);
        this.calle = view.findViewById(R.id.fc_tv_calle);
        this.colonia = view.findViewById(R.id.fc_tv_colonia);
        this.numero = view.findViewById(R.id.fc_tv_numero);
        this.ciudad = view.findViewById(R.id.fc_tv_ciudad);
        this.estado = view.findViewById(R.id.fc_tv_estado);
        this.estadoCivil = view.findViewById(R.id.fc_tv_estado_civil);
        this.enfermedades = view.findViewById(R.id.fc_tv_enfermedades);
        this.nacionalidad = view.findViewById(R.id.fc_tv_nacionalidad);
        this.numeroNomina = view.findViewById(R.id.fc_tv_numero_nomina);
        this.curp = view.findViewById(R.id.fc_tv_cupr);
        this.puesto = view.findViewById(R.id.fc_tv_puesto);

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

        Toast.makeText(view.getContext(), "Contacto[F_Contact]: " + id, Toast.LENGTH_LONG).show();
        return view;
    }




}
