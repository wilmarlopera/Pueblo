package com.example.pueblo;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ListaAdaptador extends RecyclerView.Adapter<ListaAdaptador.viewHolder> {

    ArrayList<Titiribi> listAtributos;

    public ListaAdaptador(ArrayList<Titiribi> listAtributos) {
        this.listAtributos = listAtributos;
    }


    @NonNull
    @Override
    public ListaAdaptador.viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View listView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list, parent, false);
        return new viewHolder(listView);
    }

    @Override
    public void onBindViewHolder(@NonNull ListaAdaptador.viewHolder holder, int position) {
        holder.actualizarDatos(listAtributos.get(position));
    }

    @Override
    public int getItemCount() {
        return listAtributos.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder {

        ImageView img;
        TextView tit;

        public viewHolder(@NonNull View itemView) {
            super(itemView);

            img = itemView.findViewById(R.id.listImg);
            tit = itemView.findViewById(R.id.listTit);
        }

        public void actualizarDatos(final Titiribi titiribi){
            img.setImageResource(titiribi.getFoto());
            tit.setText(titiribi.getTitulo());

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(itemView.getContext(), MainActivity.class);
                    intent.putExtra("datos", titiribi);
                    itemView.getContext().startActivity(intent);
                }
            });
        }
    }
}
