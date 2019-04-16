package jeff.game.wrenchgame;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Space;
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

        setTitles();
        addSpace();
        setImages();
        addSpace();
        setButtons();
    }

    private void addSpace() {
        Space space = new Space(getContext());
        space.setMinimumHeight((int)(MainActivity.height*0.1));
        addView(space);
    }

    private void setTitles() {
        String gameOverText = "GAME OVER";
        title.setText(gameOverText);
        title.setTextSize(60);
        title.setTextAlignment(TEXT_ALIGNMENT_CENTER);
        title.setTypeface(null, Typeface.BOLD);
        title.setTextColor(Color.BLACK);

        String subtitleText = "You dodged " + score + " wrenches!";
        subtitle.setText(subtitleText);
        subtitle.setTextSize(20);
        subtitle.setTextAlignment(TEXT_ALIGNMENT_CENTER);
        subtitle.setTextColor(Color.BLACK);

        addView(title);
        addView(subtitle);
    }

    private void setImages() {
        int imgWidth = 78;
        int imgHeight = 156;

        if (score >= 10 && !MainActivity.purpleCobra) {
            // unlock the purple cobra for next game
            MainActivity.purpleCobra = true;

            LinearLayout container = new LinearLayout(getContext());
            container.setGravity(Gravity.CENTER);
            addView(container);

            ImageView imageView1 = new ImageView(getContext());
            imageView1.setImageResource(R.drawable.purple_stickman);
            imageView1.setLayoutParams(new LayoutParams(imgWidth, imgHeight));
            container.addView(imageView1);

            TextView caption = new TextView(getContext());
            caption.setText(getContext().getString(R.string.unlock_purple_cobra));
            caption.setTextSize(20);
            caption.setTextAlignment(TEXT_ALIGNMENT_CENTER);
            caption.setTextColor(Color.BLACK);
            container.addView(caption);
        }
    }

    private void setButtons() {
        LinearLayout buttonContainer = new LinearLayout(getContext());
        buttonContainer.setMinimumWidth(MainActivity.width);
        buttonContainer.setGravity(Gravity.CENTER);

        newGame.setText("New Game");
        newGame.setTextSize(20);
        newGame.setWidth(750);
        newGame.setOnClickListener(this::handleNew);

        Space space = new Space(getContext());
        space.setMinimumWidth(200);

        exit.setText("Exit");
        exit.setTextSize(20);
        exit.setWidth(750);
        exit.setOnClickListener(this::handleExit);

        buttonContainer.addView(newGame);
        buttonContainer.addView(space);
        buttonContainer.addView(exit);
        addView(buttonContainer);
    }

    private void handleExit(View view) {
        android.os.Process.killProcess(android.os.Process.myPid());
        System.exit(1);
    }

    private void handleNew(View view) {
        MainActivity.root.removeAllViews();
        MainActivity.root.addView(new HomeScreen(getContext()));
    }
}
