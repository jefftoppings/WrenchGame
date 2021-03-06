package jeff.game.wrenchgame;

import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.graphics.Point;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Display;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    static boolean purpleCobra = false;
    static boolean avgJoe = false;
    static LinearLayout root;
    static int width, height;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setRequestedOrientation (ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        getSupportActionBar().hide();

        // get width and height
        Display display = getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        width = size.x;
        height = size.y;

        root = findViewById(R.id.root);

        root.addView(new HomeScreen(this));
    }
}
