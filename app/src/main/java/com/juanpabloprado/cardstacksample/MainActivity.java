package com.juanpabloprado.cardstacksample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;
import com.wenchao.cardstack.CardStack;

public class MainActivity extends AppCompatActivity {
  private static final String TAG = "MainActivity";
  private static final int DIRECTION_ZERO = 0;
  private static final int DIRECTION_ONE = 1;
  private static final int DIRECTION_TWO = 2;
  private static final int DIRECTION_THREE = 3;

  private CardStack.CardEventListener cardEventListener = new CardStack.CardEventListener() {
    // implement card event interface
    @Override public boolean swipeEnd(int direction, float distance) {
      // if "return true" the dismiss animation will be triggered
      // if false, the card will move back to stack
      // distance is finger swipe distance in dp

      // the direction indicate swipe direction
      // there are four directions
      //  0  |  1
      // ----------
      //  2  |  3

      Log.i(TAG,
          "CardStack swipeEnd triggered with direction: " + direction + ", distance: " + distance);
      return distance > 300;
    }

    @Override public boolean swipeStart(int direction, float distance) {

      Log.i(TAG, "CardStack swipeStart triggered with direction: "
          + direction
          + ", distance: "
          + distance);
      return true;
    }

    @Override public boolean swipeContinue(int direction, float distanceX, float distanceY) {
      Log.i(TAG, "CardStack swipeContinue triggered with direction: "
          + direction
          + ", distanceX: "
          + distanceX
          + ", distanceY: "
          + distanceY);
      return true;
    }

    @Override public void discarded(int id, int direction) {
      //this callback invoked when dismiss animation is finished.
      Log.i(TAG, "CardStack discarded triggered with id: " + id + ", direction: " + direction);
      switch (direction) {
        case DIRECTION_ZERO:
          Toast.makeText(MainActivity.this, "Direction: " + direction, Toast.LENGTH_SHORT).show();
          break;
        case DIRECTION_ONE:
          Toast.makeText(MainActivity.this, "Direction: " + direction, Toast.LENGTH_SHORT).show();
          break;
        case DIRECTION_TWO:
          Toast.makeText(MainActivity.this, "Direction: " + direction, Toast.LENGTH_SHORT).show();
          break;
        case DIRECTION_THREE:
          Toast.makeText(MainActivity.this, "Direction: " + direction, Toast.LENGTH_SHORT).show();
          break;
      }
    }

    @Override public void topCardTapped() {
      //this callback invoked when a top card is tapped by user.
      Log.i(TAG, "CardStack topCardTapped triggered");
    }
  };

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
    setSupportActionBar(toolbar);

    CardStack mCardStack = (CardStack) findViewById(R.id.cardStackContainer);

    mCardStack.setContentResource(R.layout.card_content);
    mCardStack.setStackMargin(20);
    mCardStack.setListener(cardEventListener);

    CardsDataAdapter mCardAdapter = new CardsDataAdapter(getApplicationContext(), 0);
    mCardAdapter.add("test1");
    mCardAdapter.add("test2");
    mCardAdapter.add("test3");
    mCardAdapter.add("test4");
    mCardAdapter.add("test5");

    mCardStack.setAdapter(mCardAdapter);
  }

  @Override public boolean onCreateOptionsMenu(Menu menu) {
    // Inflate the menu; this adds items to the action bar if it is present.
    getMenuInflater().inflate(R.menu.menu_main, menu);
    return true;
  }

  @Override public boolean onOptionsItemSelected(MenuItem item) {
    // Handle action bar item clicks here. The action bar will
    // automatically handle clicks on the Home/Up button, so long
    // as you specify a parent activity in AndroidManifest.xml.
    int id = item.getItemId();

    // noinspection SimplifiableIfStatement
    if (id == R.id.action_settings) {
      return true;
    }

    return super.onOptionsItemSelected(item);
  }
}
