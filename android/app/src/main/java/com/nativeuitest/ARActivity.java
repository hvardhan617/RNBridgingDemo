package com.nativeuitest;

import android.app.Activity;
import android.app.AlertDialog;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;

import com.google.ar.core.Anchor;
import com.google.ar.core.HitResult;
import com.google.ar.core.Plane;
import com.google.ar.sceneform.AnchorNode;
import com.google.ar.sceneform.rendering.ModelRenderable;
import com.google.ar.sceneform.ux.ArFragment;
import com.google.ar.sceneform.ux.BaseArFragment;
import com.google.ar.sceneform.ux.TransformableNode;

public class ARActivity extends AppCompatActivity {

    private ArFragment arFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_arcore);

        arFragment=(ArFragment) getSupportFragmentManager().findFragmentById(R.id.arFragment);
        arFragment.setOnTapArPlaneListener((hitResult,plane,motionEvent) ->{

            Anchor anchor = hitResult.createAnchor();

            ModelRenderable.builder().setSource(this, Uri.parse("Wolves.sfb")).build().thenAccept(modelRenderable -> addModelToScene(anchor,modelRenderable)).exceptionally(throwable -> {AlertDialog.Builder builder=new AlertDialog.Builder(this);
            builder.setMessage(throwable.getMessage()).show();return null;});
        });

    }

    private void addModelToScene(Anchor anchor,ModelRenderable modelRenderable){

        AnchorNode anchorNode = new AnchorNode(anchor);
        TransformableNode transformableNode = new TransformableNode(arFragment.getTransformationSystem());
        transformableNode.setParent(anchorNode);
        transformableNode.setRenderable(modelRenderable);

        arFragment.getArSceneView().getScene().addChild(anchorNode);
        transformableNode.select();

    }
}
