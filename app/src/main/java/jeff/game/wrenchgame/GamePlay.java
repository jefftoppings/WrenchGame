package jeff.game.wrenchgame;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.View;

import java.util.Random;

public class GamePlay extends View {

    Canvas canvas;
    Paint paint;
    Random random;

    public GamePlay(Context context) {
        super(context);
        random = new Random();
        
    }

}
