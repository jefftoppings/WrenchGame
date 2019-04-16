package jeff.game.wrenchgame;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.view.Gravity;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.Space;
import android.widget.TextView;

public class Instructions extends ScrollView {

    LinearLayout root, contents;
    TextView title;
    Button back;

    public Instructions(Context context) {
        super(context);
        setBackgroundColor(Color.rgb(237, 247, 210));
        setMinimumWidth(MainActivity.width);
        setMinimumHeight(MainActivity.height);

        root = new LinearLayout(context);
        root.setGravity(Gravity.CENTER);
        root.setOrientation(LinearLayout.VERTICAL);
        addView(root);

        title = new TextView(context);
        title.setText("Instructions");
        title.setTextSize(60);
        title.setTextAlignment(TEXT_ALIGNMENT_CENTER);
        title.setTypeface(null, Typeface.BOLD);
        title.setTextColor(Color.BLACK);
        root.addView(title);

        // another linear layout to hold contents
        contents = new LinearLayout(context);
        contents.setOrientation(LinearLayout.VERTICAL);
        contents.setGravity(Gravity.CENTER);
        root.addView(contents);

        // instructions
        String[] instructions = new String[] {
                "Help the stickman train for his next dodgeball tournament!",
                "Touch the screen on the left to move left",
                "Touch the screen on the right to move right",
                "Hold down on the screen to move continuously in that direction",
                "If a wrench touches you, you will be knocked out!",
                "You score one point for every wrench dodged successfully"
        };

        for (String s : instructions) {
            TextView line = new TextView(context);
            line.setText("\t \u2022 " + s);
            line.setTextSize(18);
            line.setTextColor(Color.BLACK);
            contents.addView(line);
        }

        // Add space
        Space space = new Space(getContext());
        space.setMinimumHeight((int)(MainActivity.height*0.1));
        contents.addView(space);

        // Add back button
        back = new Button(context);
        back.setText("Back");
        back.setTextSize(20);
        back.setWidth(300);
        back.setOnClickListener(e -> {
            MainActivity.root.removeAllViews();
            MainActivity.root.addView(new HomeScreen(getContext()));
        });
        contents.addView(back);
    }
}
