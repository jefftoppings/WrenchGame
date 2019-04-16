package jeff.game.wrenchgame;

import android.content.Context;
import android.graphics.Color;
import android.view.Gravity;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class GameOver extends LinearLayout {

    int score;
    TextView title, subtitle;
    Button newGame, exit;

    public GameOver(Context context, int score) {
        super(context);
        this.score = score;
        setOrientation(VERTICAL);
        setMinimumWidth(MainActivity.width);
        setMinimumHeight(MainActivity.height);
        setBackgroundColor(Color.rgb(237, 247, 210));
        setGravity(Gravity.CENTER);

        title = new TextView(context);
        subtitle = new TextView(context);
        newGame = new Button(context);
        exit = new Button(context);

        
    }
}
