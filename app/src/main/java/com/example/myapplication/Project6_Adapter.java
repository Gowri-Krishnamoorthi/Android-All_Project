package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import java.util.List;

public class Project6_Adapter extends RecyclerView.Adapter<Project6_Adapter.ViewHolder> {

    private List<Project6_MarvelCharacter> characters;
    private Context context;

    public Project6_Adapter(Context context, List<Project6_MarvelCharacter> characters) {
        this.context = context;
        this.characters = characters;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_project6_custom, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Project6_MarvelCharacter character = characters.get(position);
        String imageUrl = character.getImageurl();
        Glide.with(context)
                .load(imageUrl)
                .into(holder.imageView);

        holder.name.setText(character.getName());
        holder.realName.setText(character.getRealname());
        holder.team.setText(character.getTeam());
        holder.firstAppearance.setText(character.getFirstappearance());
        holder.createdBy.setText(character.getCreatedby());
        holder.publisher.setText(character.getPublisher());
        holder.bio.setText(character.getBio());
    }

    @Override
    public int getItemCount() {
        return characters.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView name, realName, team, firstAppearance, createdBy, publisher, bio;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageView);
            name = itemView.findViewById(R.id.name);
            realName = itemView.findViewById(R.id.realName);
            team = itemView.findViewById(R.id.team);
            firstAppearance = itemView.findViewById(R.id.firstAppearance);
            createdBy = itemView.findViewById(R.id.createdBy);
            publisher = itemView.findViewById(R.id.publisher);
            bio = itemView.findViewById(R.id.bio);
        }
    }
}