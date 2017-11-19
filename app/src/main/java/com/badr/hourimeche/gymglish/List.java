package com.badr.hourimeche.gymglish;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class List extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        final String[] names = {
                getString(R.string.gymglish),
                getString(R.string.the_rich_morning_show),
                getString(R.string.the_word_of_the_month),
                getString(R.string.frantastique_orthographe),
                getString(R.string.cpf_anglais),
                getString(R.string.the_delavigne_corporation),
                getString(R.string.va_te_faire_conjuguer),
                getString(R.string.work_sweet_work)
        };

        final String[] urls = {
                "https://www.gymglish.com/fr",
                "https://www.richmorning.com/fr",
                "http://www.thewordofthemonth.com/",
                "https://www.frantastique.com/fr",
                "http://www.anglais-cpf.fr/",
                "http://www.delavignecorp.com/",
                "http://www.vatefaireconjuguer.com/",
                "https://worksweetwork.com/"
        };

        ListView listView = (ListView) findViewById(R.id.listV);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, R.layout.mytextview, R.id.txt, names);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(List.this, Webview.class);
                switch (i) {
                    case 0:
                        intent.putExtra("name", names[0]);
                        intent.putExtra("url", urls[0]);
                        break;
                    case 1:
                        intent.putExtra("name", names[1]);
                        intent.putExtra("url", urls[1]);
                        break;
                    case 2:
                        intent.putExtra("name", names[2]);
                        intent.putExtra("url", urls[2]);
                        break;
                    case 3:
                        intent.putExtra("name", names[3]);
                        intent.putExtra("url", urls[3]);
                        break;
                    case 4:
                        intent.putExtra("name", names[4]);
                        intent.putExtra("url", urls[4]);
                        break;
                    case 5:
                        intent.putExtra("name", names[5]);
                        intent.putExtra("url", urls[5]);
                        break;
                    case 6:
                        intent.putExtra("name", names[6]);
                        intent.putExtra("url", urls[6]);
                        break;
                    case 7:
                        intent.putExtra("name", names[7]);
                        intent.putExtra("url", urls[7]);
                        break;
                }
                startActivity(intent);
            }
        });

    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
    }
}
