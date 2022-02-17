package com.example.lifeofgeoff;

import android.graphics.PointF;

public class FaceData {
    private int id;

    //Face Dimensions
    private PointF position;
    private float width;
    private float height;

    // Head orientation
    private float eulerY;
    private float eulerZ;

    private PointF mLeftEyePosition;
    private PointF mRightEyePosition;
    private PointF mLeftCheekPosition;
    private PointF mRightCheekPosition;
    private PointF mNoseBasePosition;

    public int getId() {
        return id;
    }

    public void setId(int newId) {
        id = newId;
    }

    public PointF getPosition() {
        return position;
    }

    public void setPosition(PointF newPosition) {
        position = newPosition;
    }

    public float getWidth() {
        return width;
    }

    public void setWidth(float newWidth) {
        width = newWidth;
    }

    public float getHeight() {
        return height;
    }

    public void setHeight(float newHeight) {
        height = newHeight;
    }

    public float getEulerY() {
        return eulerY;
    }

    public void setEulerY(float newEulerY) {
        eulerY = newEulerY;
    }

    public float getEulerZ() {
        return eulerZ;
    }

    public void setEulerZ(float newEulerZ) {
        eulerZ = newEulerZ;
    }

    public PointF getLeftEyePosition() {
        return mLeftEyePosition;
    }

    public void setLeftEyePosition(PointF leftEyePosition) {
        this.mLeftEyePosition = leftEyePosition;
    }

    public PointF getRightEyePosition() {
        return mRightEyePosition;
    }

    public void setRightEyePosition(PointF rightEyePosition) {
        this.mRightEyePosition = rightEyePosition;
    }
}
