package com.example.lifeofgeoff;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PointF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RotateDrawable;
import android.util.AttributeSet;
import android.widget.ImageView;

import androidx.core.content.res.ResourcesCompat;

import com.google.android.gms.vision.face.Face;
import com.example.lifeofgeoff.ui.camera.GraphicOverlay;
import com.google.android.gms.vision.face.FaceDetector;

/**
 * Graphic instance for rendering face position, orientation, and landmarks within an associated
 * graphic overlay view.
 */
class DrawPicture extends GraphicOverlay.Graphic {
    private static final float FACE_POSITION_RADIUS = 10.0f;
    private static final float ID_TEXT_SIZE = 40.0f;
    private static final float ID_Y_OFFSET = 50.0f;
    private static final float ID_X_OFFSET = -50.0f;
    private static final float BOX_STROKE_WIDTH = 5.0f;

    private static final int COLOR_CHOICES[] = {
            Color.BLUE,
            Color.CYAN,
            Color.GREEN,
            Color.MAGENTA,
            Color.RED,
            Color.WHITE,
            Color.YELLOW
    };
    private static int mCurrentColorIndex = 0;
    private Paint mFacePositionPaint;
    private Paint mIdPaint;
    private Paint mBoxPaint;
    private volatile Face mFace;
    private int mFaceId;
    private float mFaceHappiness;

    private Drawable geoff;

    DrawPicture(GraphicOverlay overlay, Context context) {
        super(overlay);
        geoff = ResourcesCompat.getDrawable(context.getResources(), R.drawable.geoff, null);
    }


    void setId(int id) {
        mFaceId = id;
    }


    /**
     * Updates the face instance from the detection of the most recent frame.  Invalidates the
     * relevant portions of the overlay to trigger a redraw.
     */
    void updateFace(Face face) {
        mFace = face;
        postInvalidate();
    }

    /**
     * Draws the face annotations for position on the supplied canvas.
     */
    @Override
    public void draw(Canvas canvas) {
        Face face = mFace;
        if (face == null) {
            return;
        }

         //Face position and dimensions
//        PointF position = new PointF(translateX(face.getPosition().x),
//                translateY(face.getPosition().y));
//        float width = scaleX(face.getWidth());
//        float height = scaleY(face.getHeight());
        ///IF WANT TO ROTATE FIGURE OUT THIS vvv
//        RotateDrawable g = (RotateDrawable) geoff;
//        g.setToDegrees(face.getEulerZ());
        // Draws a circle at the position of the detected face, with the face's track id below.
        float x = translateX(face.getPosition().x + face.getWidth() / 2);
        float y = translateY(face.getPosition().y + face.getHeight() / 2);

        // Draws a Geoff.
        float xOffset = scaleX(face.getWidth() / 1.6f);
        float yOffset = scaleY(face.getHeight() / 1.6f);
        float left = x - xOffset;
        float top = y - yOffset;
        float right = x + xOffset;
        float bottom = y + yOffset;
        geoff.setBounds((int) left, (int) top, (int) right, (int) bottom);
        geoff.draw(canvas);

    }
}

