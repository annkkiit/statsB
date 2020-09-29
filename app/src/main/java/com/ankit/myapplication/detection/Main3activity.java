//package com.ankit.myapplication.detection;
//
//import android.net.Uri;
//import android.os.Build;
//import android.os.Bundle;
//import android.widget.Button;
//
//import androidx.annotation.RequiresApi;
//import androidx.appcompat.app.AppCompatActivity;
//import androidx.recyclerview.widget.LinearLayoutManager;
//import androidx.recyclerview.widget.RecyclerView;
//
//import com.google.ar.core.Anchor;
//import com.google.ar.sceneform.AnchorNode;
//import com.google.ar.sceneform.rendering.ModelRenderable;
//import com.google.ar.sceneform.ux.ArFragment;
//import com.google.ar.sceneform.ux.TransformableNode;
//
//import java.util.ArrayList;
//
//public class Main3activity extends AppCompatActivity {
//
//
//    private ArFragment arFragment;
//    private ArrayList<Integer> imagesPath = new ArrayList<Integer>();
//    private ArrayList<String> namesPath = new ArrayList<>();
//    private ArrayList<String> modelNames = new ArrayList<>();
//    AnchorNode anchorNode;
//    private Button btnRemove;
//
//    @RequiresApi(api = Build.VERSION_CODES.N)
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main3);
//
//        arFragment = (ArFragment)getSupportFragmentManager().findFragmentById(R.id.fragment);
//        btnRemove = (Button)findViewById(R.id.remove);
//        getImages();
//
//        arFragment.setOnTapArPlaneListener((hitResult, plane, motionEvent) -> {
//
//            Anchor anchor = hitResult.createAnchor();
//
//            ModelRenderable.builder()
//                    .setSource(this, Uri.parse(Common.model))
//                    .build()
//                    .thenAccept(modelRenderable -> addModelToScene(anchor,modelRenderable));
//
//        });
//
//
//        btnRemove.setOnClickListener(view -> removeAnchorNode(anchorNode));
//    }
//
//    private void getImages() {
//
//        //TODO: Upadate models with real monuments
//        imagesPath.add(R.drawable.administration);
//        imagesPath.add(R.drawable.islam);
//        imagesPath.add(R.drawable.fernsehturmberlin);
//        imagesPath.add(R.drawable.invercargill);
//        imagesPath.add(R.drawable.isla);
//        imagesPath.add(R.drawable.cultures);
//        imagesPath.add(R.drawable.osaka);
//        namesPath.add("Monument 2");
//        namesPath.add("Monument 3");
//        namesPath.add("Monument 4");
//        namesPath.add("Monument 5");
//        namesPath.add("Monument 6");
//        namesPath.add("Monument 7");
//        namesPath.add("Monument 8");
//        modelNames.add("model.sfb");
//        modelNames.add("lamp.sfb");
//        modelNames.add("tv.sfb");
//        modelNames.add("tv.sfb");
//        modelNames.add("taj.sfb");
//        modelNames.add("lamp.sfb");
//        modelNames.add("tv.sfb");
//        modelNames.add("tv.sfb");
//
//
//        initaiteRecyclerview();
//    }
//
//    private void initaiteRecyclerview() {
//
//        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL,false);
//        RecyclerView recyclerView = (RecyclerView)findViewById(R.id.recyclerview);
//        recyclerView.setLayoutManager(layoutManager);
//        RecyclerviewAdapter adapter = new RecyclerviewAdapter(this,namesPath,imagesPath,modelNames);
//        recyclerView.setAdapter(adapter);
//
//    }
//
//    private void addModelToScene(Anchor anchor, ModelRenderable modelRenderable) {
//
//        anchorNode = new AnchorNode(anchor);
//        TransformableNode node = new TransformableNode(arFragment.getTransformationSystem());
//        node.setParent(anchorNode);
//        node.setRenderable(modelRenderable);
//        arFragment.getArSceneView().getScene().addChild(anchorNode);
//        node.select();
//    }
//
//    public void removeAnchorNode(AnchorNode nodeToremove) {
//        if (nodeToremove != null) {
//            arFragment.getArSceneView().getScene().removeChild(nodeToremove);
//            nodeToremove.getAnchor().detach();
//            nodeToremove.setParent(null);
//            nodeToremove = null;
//        }
//    }
//}
//
