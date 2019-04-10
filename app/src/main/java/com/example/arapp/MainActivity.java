package com.example.arapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.ar.core.Anchor;
import com.google.ar.core.HitResult;
import com.google.ar.core.Plane;
import com.google.ar.sceneform.AnchorNode;
import com.google.ar.sceneform.rendering.ModelRenderable;
import com.google.ar.sceneform.rendering.ViewRenderable;
import com.google.ar.sceneform.ux.ArFragment;
import com.google.ar.sceneform.ux.BaseArFragment;
import com.google.ar.sceneform.ux.TransformableNode;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    ArFragment arFragment;
    // build models
    private ModelRenderable bearRederable,
                            catRederable,
                            cowRederable,
                            dogRederable,
                            elephantRederable,
                            ferretRederable,
                            hippopotamusRederable,
                            horseRederable,
                            koalaRederable,
                            lionRederable,
                            reindeerRederable,
                            wolverineRederable;

    //take image view to render in layout
    ImageView bear, cat,cow,dog,elephant, ferret, hippo, horse,koala,lion,reindeer, wolverine;

    //create array of views
    View arrayView[];
    ViewRenderable name_animal;

    //set default
    int selected=1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // create goodle ar scene object
        arFragment=(ArFragment) getSupportFragmentManager().findFragmentById(R.id.sceneform_ux_fragment);

        // creat vivew for object in linear layout
        bear= (ImageView)findViewById(R.id.bear);
        cat= (ImageView)findViewById(R.id.cat);
        cow= (ImageView)findViewById(R.id.dog);
        dog= (ImageView)findViewById(R.id.cow);
        elephant= (ImageView)findViewById(R.id.elephant);
        ferret= (ImageView)findViewById(R.id.ferret);
        hippo= (ImageView)findViewById(R.id.hippopotamus);
        horse= (ImageView)findViewById(R.id.horse);
        koala= (ImageView)findViewById(R.id.koala_bear);
        lion= (ImageView)findViewById(R.id.lion);
        reindeer= (ImageView)findViewById(R.id.reindeer);
        wolverine= (ImageView)findViewById(R.id.wolverine);

        //call methods to view 3d models
        setArrayview();
        setClickListener();
        setupModel();

        //to add model when user tap on the screen
        arFragment.setOnTapArPlaneListener(new BaseArFragment.OnTapArPlaneListener() {
            @Override
            public void onTapPlane(HitResult hitResult, Plane plane, MotionEvent motionEvent) {
                if(selected==1){
                    Anchor anchor=hitResult.createAnchor();
                    AnchorNode anchorNode=new AnchorNode(anchor);
                    anchorNode.setParent(arFragment.getArSceneView().getScene());

                    createModel(anchorNode,selected);
                }
            }
        });
    }

    private void setupModel() {

        // render selected model
        ModelRenderable.builder()
                .setSource(this,R.raw.bear)
                .build().thenAccept(renderable->bearRederable=renderable)
                .exceptionally(
                        throwable-> {
                            Toast.makeText(this, "Unable to build the  model...", Toast.LENGTH_SHORT).show();
                            return null;
                        }
        );

        ModelRenderable.builder()
                .setSource(this,R.raw.cat)
                .build().thenAccept(renderable->catRederable=renderable)
                .exceptionally(
                        throwable-> {
                            Toast.makeText(this, "Unable to build the  model...", Toast.LENGTH_SHORT).show();
                            return null;
                        }
                );
        ModelRenderable.builder()
                .setSource(this,R.raw.reindeer)
                .build().thenAccept(renderable->reindeerRederable=renderable)
                .exceptionally(
                        throwable-> {
                            Toast.makeText(this, "Unable to build the  model...", Toast.LENGTH_SHORT).show();
                            return null;
                        }
                );
        ModelRenderable.builder()
                .setSource(this,R.raw.wolverine)
                .build().thenAccept(renderable->wolverineRederable=renderable)
                .exceptionally(
                        throwable-> {
                            Toast.makeText(this, "Unable to build the  model...", Toast.LENGTH_SHORT).show();
                            return null;
                        }
                );
        ModelRenderable.builder()
                .setSource(this,R.raw.cow)
                .build().thenAccept(renderable->cowRederable=renderable)
                .exceptionally(
                        throwable-> {
                            Toast.makeText(this, "Unable to build the  model...", Toast.LENGTH_SHORT).show();
                            return null;
                        }
                );

        ModelRenderable.builder()
                .setSource(this,R.raw.dog)
                .build().thenAccept(renderable->dogRederable=renderable)
                .exceptionally(
                        throwable-> {
                            Toast.makeText(this, "Unable to build the  model...", Toast.LENGTH_SHORT).show();
                            return null;
                        }
                );
        ModelRenderable.builder()
                .setSource(this,R.raw.elephant)
                .build().thenAccept(renderable->elephantRederable=renderable)
                .exceptionally(
                        throwable-> {
                            Toast.makeText(this, "Unable to build the  model...", Toast.LENGTH_SHORT).show();
                            return null;
                        }
                );
        ModelRenderable.builder()
                .setSource(this,R.raw.ferret)
                .build().thenAccept(renderable->ferretRederable=renderable)
                .exceptionally(
                        throwable-> {
                            Toast.makeText(this, "Unable to build the  model...", Toast.LENGTH_SHORT).show();
                            return null;
                        }
                );
        ModelRenderable.builder()
                .setSource(this,R.raw.hippopotamus)
                .build().thenAccept(renderable->hippopotamusRederable=renderable)
                .exceptionally(
                        throwable-> {
                            Toast.makeText(this, "Unable to build the  model...", Toast.LENGTH_SHORT).show();
                            return null;
                        }
                );

        ModelRenderable.builder()
                .setSource(this,R.raw.horse)
                .build().thenAccept(renderable->horseRederable=renderable)
                .exceptionally(
                        throwable-> {
                            Toast.makeText(this, "Unable to build the  model...", Toast.LENGTH_SHORT).show();
                            return null;
                        }
                );
        ModelRenderable.builder()
                .setSource(this,R.raw.koala_bear)
                .build().thenAccept(renderable->koalaRederable=renderable)
                .exceptionally(
                        throwable-> {
                            Toast.makeText(this, "Unable to build the  model...", Toast.LENGTH_SHORT).show();
                            return null;
                        }
                );
        ModelRenderable.builder()
                .setSource(this,R.raw.lion)
                .build().thenAccept(renderable->lionRederable=renderable)
                .exceptionally(
                        throwable-> {
                            Toast.makeText(this, "Unable to build the  model...", Toast.LENGTH_SHORT).show();
                            return null;
                        }
                );
    }

    private void createModel(AnchorNode anchorNode, int selected) {
        if(selected==1){
            TransformableNode bear=new TransformableNode(arFragment.getTransformationSystem());
            bear.setParent(anchorNode);
            bear.setRenderable(bearRederable);
            bear.select();
        }
    }

    private void setClickListener() {
        for(int i=0;i<arrayView.length;i++){
            arrayView[i].setOnClickListener(this);

        }
    }

    private void setArrayview() {
        arrayView=new View[]{
                bear,cat,cow,dog,elephant,ferret,hippo,horse,koala,lion,reindeer,wolverine
        };
    }

    @Override
    public void onClick(View v) {

    }
}
