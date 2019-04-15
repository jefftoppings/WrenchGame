package jeff.game.wrenchgame;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.view.Gravity;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Space;
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

    private void setImages() {

        int imgWidth = 724;
        int imgHeight = 210;

        LinearLayout imageContainer = new LinearLayout(getContext());
        imageContainer.setMinimumWidth(MainActivity.width);
        imageContainer.setGravity(Gravity.CENTER);

        ImageView imageView1 = new ImageView(getContext());
        imageView1.setImageResource(R.drawable.wrench1);
        imageView1.setLayoutParams(new LayoutParams((int)(imgWidth*0.7), (int)(imgHeight*0.7)));

        Space space = new Space(getContext());
        space.setMinimumWidth(300);

        ImageView imageView2 = new ImageView(getContext());
        imageView2.setImageResource(R.drawable.wrench2);
        imageView2.setLayoutParams(new LayoutParams((int)(imgWidth*0.7), (int)(imgHeight*0.7)));

        imageContainer.addView(imageView1);
        imageContainer.addView(space);
        imageContainer.addView(imageView2);
        addView(imageContainer);
    }

    private void setButtons() {
        LinearLayout buttonContainer = new LinearLayout(getContext());
        buttonContainer.setMinimumWidth(MainActivity.width);
        buttonContainer.setGravity(Gravity.CENTER);

        startGame.setText("Start Game");
        startGame.setTextSize(20);
        startGame.setWidth(750);

        Space space = new Space(getContext());
        space.setMinimumWidth(200);

        instructions.setText("Instructions");
        instructions.setTextSize(20);
        instructions.setWidth(750);

        buttonContainer.addView(startGame);
        buttonContainer.addView(space);
        buttonContainer.addView(instructions);
        addView(buttonContainer);
    }
}
