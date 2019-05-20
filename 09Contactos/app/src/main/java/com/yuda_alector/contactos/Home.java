package com.yuda_alector.contactos;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.yuda_alector.contactos.adapter.ContactoHeaderAdapter;
import com.yuda_alector.contactos.dao.DaoContacto;
import com.yuda_alector.contactos.model.ContactoHeader;

import java.util.List;

public class Home extends AppCompatActivity {

    private RecyclerView recyclerViewContactos;
    private ContactoHeaderAdapter adapter;
    private List<ContactoHeader> contactos;
    private DaoContacto crud;

    static int CONTACT_ADD_REQUEST = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        this.crud = new DaoContacto(Home.this);

        this.recyclerViewContactos = this.findViewById(R.id.rv_contactos);
        this.contactos = this.crud.getAllInstances();
        this.adapter = new ContactoHeaderAdapter(this, this.contactos);


        this.recyclerViewContactos.setAdapter(adapter);
        this.recyclerViewContactos.setLayoutManager(new LinearLayoutManager(
                this, LinearLayoutManager.VERTICAL, false
        ));

    }

    @Override
    protected void onResume() {
        super.onResume();
        this.contactos = null;
        this.contactos = this.crud.getAllInstances();
        this.adapter.notifyDataSetChanged();
    }

    public void addContact(View view){
        this.startActivityForResult(new Intent(this, NewContact.class), Home.CONTACT_ADD_REQUEST);
    }



}
