package jeff.game.wrenchgame;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.view.Gravity;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class HomeScreen extends LinearLayout {

    TextView title, subtitle;
    Button startGame, instructions;

    public HomeScreen(Context context) {
        super(context);
        setOrientation(VERTICAL);
        setMinimumWidth(MainActivity.width);
        setMinimumHeight(MainActivity.height);
        setBackgroundColor(Color.rgb(237, 247, 210));
        setGravity(Gravity.CENTER);

        title = new TextView(context);
        subtitle = new TextView(context);
        startGame = new Button(context);
        instructions = new Button(context);

        setTitles();
        setButtons();
    }

    private void setTitles() {
        title.setText("Dodgeball Training");
        title.setTextSize(60);
        title.setTextAlignment(TEXT_ALIGNMENT_CENTER);
        title.setTypeface(null, Typeface.BOLD);
        title.setTextColor(Color.BLACK);

        subtitle.setText("If you can dodge a wrench, you can dodge a ball");
        subtitle.setTextSize(20);
        subtitle.setTextAlignment(TEXT_ALIGNMENT_CENTER);
        subtitle.setTypeface(null, Typeface.ITALIC);
        subtitle.setTextColor(Color.BLACK);

        addView(title);
        addView(subtitle);
    }

    private void setButtons() {
        LinearLayout buttonContainer = new LinearLayout(getContext());
        buttonContainer.setMinimumWidth(MainActivity.width);
        buttonContainer.setGravity(Gravity.CENTER);

        startGame.setText("Start Game");
        startGame.setTextSize(20);
        startGame.setWidth(750);

        instructions.setText("Instructions");
        instructions.setTextSize(20);
        instructions.setWidth(750);

        buttonContainer.addView(startGame);
        buttonContainer.addView(instructions);
        addView(buttonContainer);
    }
}
