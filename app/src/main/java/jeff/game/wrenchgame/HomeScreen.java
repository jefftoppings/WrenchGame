package jeff.game.wrenchgame;

import android.content.Context;
import android.graphics.Color;
import android.widget.LinearLayout;

public class HomeScreen extends LinearLayout {

    public HomeScreen(Context context) {
        super(context);
        setBackgroundColor(Color.rgb(237, 247, 210));
        setMinimumWidth(MainActivity.width);
        setMinimumHeight(MainActivity.height);
    }

}
