package maxim.grischenko.mathematic;

import android.graphics.Color;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

public class MainActivity extends AppCompatActivity {
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;
    private enum actionType {plus, minus};
    private TextView tvFirstNumber, tvSecondNumber, tvAction,tvAnswer1, tvAnswer2, tvAnswer3, tvAnswer4;
    private Integer maxVal = 20, correctAnswer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();

        tvFirstNumber = (TextView) findViewById(R.id.tvFirstNumber);
        tvSecondNumber = (TextView) findViewById(R.id.tvSecondNumber);
        tvAction = (TextView) findViewById(R.id.tvAction);
        tvAnswer1 = (TextView) findViewById(R.id.tvAnswer1);
        tvAnswer2 = (TextView) findViewById(R.id.tvAnswer2);
        tvAnswer3 = (TextView) findViewById(R.id.tvAnswer3);
        tvAnswer4 = (TextView) findViewById(R.id.tvAnswer4);
        
        generateExample();
        tvAnswer1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer((TextView) v);
            }
        });
        tvAnswer2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer((TextView)v);
            }
        });
        tvAnswer3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer((TextView)v);
            }
        });
        tvAnswer4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer((TextView)v);
            }
        });
    }

    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "Main Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app deep link URI is correct.
                Uri.parse("android-app://maxim.grischenko.mathematic/http/host/path")
        );
        AppIndex.AppIndexApi.start(client, viewAction);
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "Main Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app deep link URI is correct.
                Uri.parse("android-app://maxim.grischenko.mathematic/http/host/path")
        );
        AppIndex.AppIndexApi.end(client, viewAction);
        client.disconnect();
    }

    private void generateExample() {
        Integer first, second, answer1, answer2, answer3, answer4;
        Integer[] answers = new Integer[4];
        actionType action = actionType.plus;
        int actionNumber;
        first = (int) (Math.random() * maxVal);
        second = (int) (Math.random() * maxVal);
        actionNumber = (int) Math.round(Math.random());
        for (actionType act : actionType.values()) {
            if (act.ordinal() == actionNumber) {
                action = act;
            }
        }
        if (action == actionType.minus) {
            if (second > first) {
                Integer temp = first;
                first = second;
                second = temp;
            }
        }
        tvFirstNumber.setText(first.toString());
        tvSecondNumber.setText(second.toString());
        switch (action) {
            case plus:
                tvAction.setText("+");
                correctAnswer = first + second;
                break;
            case minus:
                tvAction.setText("-");
                correctAnswer = first - second;
                break;
        }
        //Generate answers
        int offset = (int) (Math.random() * 3);
        answers[0] = first + second;
        answers[1] = first - second;
        answers[2] = first + second + 1 + offset;
        answers[3] = first - second + 1 + offset;
        int i = 0;
        if ((i + offset) > 3) {
            answer1 = answers[i - offset];
        }else{
            answer1 = answers[i];
        }
        i++;
        if ((i + offset) > 3) {
            answer2 = answers[i - offset];
        }else{
            answer2 = answers[i];
        }
        i++;
        if ((i + offset) > 3) {
            answer3 = answers[i - offset];
        }else{
            answer3 = answers[i];
        }
        i++;
        if ((i + offset) > 3) {
            answer4 = answers[i - offset];
        }else{
            answer4 = answers[i];
        }
        tvAnswer1.setText(answer1.toString());
        tvAnswer2.setText(answer2.toString());
        tvAnswer3.setText(answer3.toString());
        tvAnswer4.setText(answer4.toString());

    }

    private void checkAnswer(TextView v){
        if (correctAnswer == Integer.parseInt(v.getText().toString())){
            v.setTextColor(Color.GREEN);
        } else{
            v.setTextColor(Color.RED);
        }
    }

}
