package com.juanpabloprado.cardstacksample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import com.wenchao.cardstack.CardStack;

public class MainActivity extends AppCompatActivity {
  private CardStack mCardStack;
  private CardsDataAdapter mCardAdapter;

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
    setSupportActionBar(toolbar);

    mCardStack = (CardStack)findViewById(R.id.cardStackContainer);

    //
    mCardStack.setContentResource(R.layout.card_content);
    mCardStack.setStackMargin(20);

    //
    mCardAdapter = new CardsDataAdapter(getApplicationContext(),0);
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

    //noinspection SimplifiableIfStatement
    if (id == R.id.action_settings) {
      return true;
    }

    return super.onOptionsItemSelected(item);
  }
}
