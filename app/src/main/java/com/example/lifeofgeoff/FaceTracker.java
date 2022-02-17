package com.example.lifeofgeoff;

import android.content.Context;

import com.google.android.gms.vision.Tracker;
import com.google.android.gms.vision.face.Face;

public class FaceTracker extends Tracker<Face> {
    private Context context;
    private FaceData faceData;


    FaceTracker(Context newContext) {
        context = newContext;
        faceData = new FaceData();
    }
}
