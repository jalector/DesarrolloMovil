package com.yuda_alector.contactos;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;

import com.yuda_alector.contactos.model.ContactoHeader;

public class MainActivity extends AppCompatActivity {

    private TextView headerText;
    private Bundle extra;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.activity_main);
        this.headerText = findViewById(R.id.message);
        Intent intent = this.getIntent();
        ContactoHeader contact = (ContactoHeader) intent.getSerializableExtra("contacto");
        this.extra = new Bundle();
        this.extra.putString("id", contact.getId());
        BottomNavigationView navigation = findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                Fragment selected = null;
                switch(menuItem.getItemId()) {
                    case R.id.contact:
                        headerText.setText("Contacto");
                        selected = new ViewContact();
                        break;
                    case R.id.edit_contact:
                        headerText.setText("Editar contacto");
                        selected = new Edit();
                        break;
                }
                selected.setArguments(extra);
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.main_container, selected);
                transaction.commit();
                return true;
            }
        });

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        Fragment first = new ViewContact();
        first.setArguments(extra);
        transaction.replace(R.id.main_container, first);
        headerText.setText(R.string.contact_list);
        transaction.commit();



    }

}
