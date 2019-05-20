package com.yuda_alector.contactos.adapter;


import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.yuda_alector.contactos.MainActivity;
import com.yuda_alector.contactos.R;
import com.yuda_alector.contactos.model.ContactoHeader;
import java.util.List;

public class ContactoHeaderAdapter extends RecyclerView.Adapter<ContactoHeaderAdapter.ContactoHeaderAdapaterViewHolder>  {

    private Context context;
    private List<ContactoHeader> contactos;

    public ContactoHeaderAdapter (Context context, List<ContactoHeader> contactos){
        this.context = context;
        this.contactos = contactos;
    }

    @NonNull
    @Override
    public ContactoHeaderAdapaterViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(
                R.layout.item_rv_contacto,
                viewGroup,
                false
        );

        return new ContactoHeaderAdapaterViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ContactoHeaderAdapaterViewHolder contactoAdapaterViewHolder, int i) {
        final ContactoHeader contacto = this.contactos.get(i);

        contactoAdapaterViewHolder.nombre.setText(contacto.getNombre() +" "+contacto.getApellidoPaterno());
        contactoAdapaterViewHolder.email.setText(contacto.getPuesto() +" | " + contacto.getEmail());

        contactoAdapaterViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), MainActivity.class);
                intent.putExtra("contacto", contacto);
                context.startActivity(intent);
            }
        });
    }



    @Override
    public int getItemCount() {
        return this.contactos.size();
    }

    public class ContactoHeaderAdapaterViewHolder extends RecyclerView.ViewHolder {

        TextView nombre;
        TextView email;

        public ContactoHeaderAdapaterViewHolder(View view){
            super(view);
            this.nombre = view.findViewById(R.id.rv_nombre);
            this.email = view.findViewById(R.id.rv_email);
        }
    }
}

