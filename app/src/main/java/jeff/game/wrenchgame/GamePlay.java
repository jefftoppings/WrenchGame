package jeff.game.wrenchgame;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;

import java.util.Random;

public class GamePlay extends View {

    Canvas canvas;
    Paint paint;
    Random random;
    int score;

    public GamePlay(Context context) {
        super(context);
        random = new Random();
        paint = new Paint();
        score = 0;
        setBackgroundColor(Color.rgb(237, 247, 210));

        invalidate();
    }


    @Override
    protected void onDraw(Canvas canvas) {
        this.canvas = canvas;

        displayScore(canvas);
    }

    private void displayScore(Canvas canvas) {
        paint.setColor(Color.BLACK);
        paint.setTextSize(60);
        canvas.drawText("Score: " + score, 60, 100, paint);
    }

}
