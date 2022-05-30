package sg.edu.rp.c346.id21001078.mylocalbanks;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Switch;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView TV1;
    TextView TV2;
    TextView TV3;
    TextView TV4;
    int Language = 0;
    int T = 0;
    int M =0;
    Switch S1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TV1 = findViewById(R.id.textView);
        TV2 = findViewById(R.id.textView2);
        TV3 = findViewById(R.id.textView3);
        TV4 = findViewById(R.id.textView4);


        registerForContextMenu(TV2);
        registerForContextMenu(TV3);
        registerForContextMenu(TV4);


        TV2.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                T = 1;
                return false;
            }
        });

        TV3.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                T = 2;
                return false;
            }
        });

        TV4.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                T = 3;
                return false;
            }
        });

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.English) {
            TV1.setText(getString(R.string.AN1));
            TV2.setText(getString(R.string.B1a));
            TV3.setText(getString(R.string.B2a));
            TV4.setText(getString(R.string.B3a));
            Language = 0;

        } else if (id == R.id.Malay) {
            TV1.setText(getString(R.string.AN2));
            TV2.setText(getString(R.string.B1b));
            TV3.setText(getString(R.string.B2b));
            TV4.setText(getString(R.string.B3b));
            Language = 1;

        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        if (Language == 0) {
            menu.add(0, 0, 0, getString(R.string.PNOa));
            menu.add(0, 1, 0, getString(R.string.BLa));
            menu.add(0, 2, 2, getString(R.string.AFE));
        } else if (Language == 1) {
            menu.add(0, 0, 0, getString(R.string.PNOb));
            menu.add(0, 1, 1, getString(R.string.BLb));
            menu.add(0, 2, 2, getString(R.string.AFM));
        }
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        if (T == 1) {
            if (item.getItemId() == 0) {
                Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse("tel: " + getString(R.string.POSBDBSNO)));
                startActivity(intentCall);

            } else if (item.getItemId() == 1) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(getString(R.string.POSBDBSWL)));
                startActivity(intent);
            } else if (item.getItemId() == 2) {
                if (M == 0) {
                    TV2.setTextColor(Color.parseColor("#FF0000"));
                    M = 1;

                } else if (M == 1) {
                    TV2.setTextColor(Color.parseColor("#FF000000"));
                    M = 0;

                }

            }

        } else if (T == 2) {
            if (item.getItemId() == 0) {
                Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse("tel: " + getString(R.string.OCBCNO)));
                startActivity(intentCall);

            } else if (item.getItemId() == 1) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(getString(R.string.OCBCWL)));
                startActivity(intent);
            } else if (item.getItemId() == 2) {
                if (M == 0) {
                    TV3.setTextColor(Color.parseColor("#FF0000"));
                    M = 1;

                } else if (M == 1) {
                    TV3.setTextColor(Color.parseColor("#FF000000"));
                    M = 0;

                }

            }

        } else if (T == 3) {
            if (item.getItemId() == 0) {
                Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse("tel: " + getString(R.string.UOBNO)));
                startActivity(intentCall);

            } else if (item.getItemId() == 1) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(getString(R.string.UOBWL)));
                startActivity(intent);
            } else if (item.getItemId() == 2) {
                if (M == 0) {
                    TV4.setTextColor(Color.parseColor("#FF0000"));
                    M = 1;

                } else if (M == 1) {
                    TV4.setTextColor(Color.parseColor("#FF000000"));
                    M = 0;

                }

            }
        }
        return super.onContextItemSelected(item);
    }
}
