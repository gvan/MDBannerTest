package net.admixer.mdbannertest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;

import net.admixer.sdk.BannerAdView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.load_ad).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loadAd();
            }
        });

    }

    private void loadAd(){
        EditText zoneIdView = findViewById(R.id.zone_id);
        String zoneId = zoneIdView.getText().toString();
        if(zoneId == null || zoneId.isEmpty()) {
            return;
        }

        BannerAdView bannerAdView = new BannerAdView(this);
        bannerAdView.setPlacementID(zoneId);
        bannerAdView.setAdSize(300, 250);
        bannerAdView.setAutoRefresh(false);
        bannerAdView.loadAd();

        LinearLayout container = findViewById(R.id.container);
        container.removeAllViews();
        container.addView(bannerAdView);
    }
}