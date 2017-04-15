package com.example.gs.firebaserecycler;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.flavienlaurent.discrollview.lib.DiscrollView;
import com.flavienlaurent.discrollview.lib.DiscrollViewContent;
/**
 * Created by GS on 08-04-2017.
 */

public class Splash extends AppCompatActivity {
    private ImageView im;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash);
        getSupportActionBar().hide();
        final Animation fade = AnimationUtils.loadAnimation(this, R.anim.fadein);
        final Animation fade1 = AnimationUtils.loadAnimation(this, R.anim.fadeout);

        final Animation zoomt = AnimationUtils.loadAnimation(this, R.anim.zoom);
        final Animation trans = AnimationUtils.loadAnimation(this, R.anim.translate);
        im = (ImageView) findViewById(R.id.imageView123);
        textView = (TextView) findViewById(R.id.textView123);

        final DiscrollView scroller= (DiscrollView) findViewById(R.id.android_animated_discroll_view_layout);
        final LinearLayout logo = (LinearLayout) findViewById(R.id.logo);
        final DiscrollViewContent scroller1= (DiscrollViewContent) findViewById(R.id.discroll_view_content_layout);

        im.startAnimation(zoomt);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                textView.startAnimation(fade);
            }
        }, 700);

        logo.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                logo.animate().translationY(-1250).setDuration(750);
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        logo.setVisibility(View.GONE);
                        scroller1.startAnimation(fade);
                    }
                },1000);
                return true;
            }
        });
    }

    public void musicon(View a) {
        if (a.getId() == R.id.musicbutton) {
            new Handler().postDelayed(new Runnable() {
                public void run() {
                    Intent login = new Intent(Splash.this, Music.class);
                    startActivity(login);
                    overridePendingTransition(R.anim.fadein,R.anim.fadeout);
                }
            }, 100);
        }
    }

    public void dramson(View a) {
        if (a.getId() == R.id.dramsbutton) {
            new Handler().postDelayed(new Runnable() {
                public void run() {
                    Intent login = new Intent(Splash.this, Drams.class);
                    startActivity(login);
                    overridePendingTransition(R.anim.fadein,R.anim.fadeout);
                }
            }, 100);
        }
    }

    public void sportson(View a) {
        if (a.getId() == R.id.sportsbutton) {
            new Handler().postDelayed(new Runnable() {
                public void run() {
                    Intent login = new Intent(Splash.this, Sports.class);
                    startActivity(login);
                    overridePendingTransition(R.anim.fadein,R.anim.fadeout);
                }
            }, 100);
        }
    }

    public void speakon(View a) {
        if (a.getId() == R.id.debatebutton) {
            new Handler().postDelayed(new Runnable() {
                public void run() {
                    Intent login = new Intent(Splash.this, Speakers.class);
                    startActivity(login);
                    overridePendingTransition(R.anim.fadein,R.anim.fadeout);
                }
            }, 100);
        }
    }

    public void artson(View a) {
        if (a.getId() == R.id.pdcbutton) {
            new Handler().postDelayed(new Runnable() {
                public void run() {
                    Intent login = new Intent(Splash.this, PDC.class);
                    startActivity(login);
                    overridePendingTransition(R.anim.fadein,R.anim.fadeout);
                }
            }, 100);
        }
    }

    public void techon(View a) {
        if (a.getId() == R.id.techbutton) {
            new Handler().postDelayed(new Runnable() {
                public void run() {
                    Intent login = new Intent(Splash.this, Technical.class);
                    startActivity(login);
                    overridePendingTransition(R.anim.fadein,R.anim.fadeout);
                }
            }, 100);
        }
    }

    public void apcon(View a) {
        if (a.getId() == R.id.apcbutton) {
            new Handler().postDelayed(new Runnable() {
                public void run() {
                    Intent login = new Intent(Splash.this, APC.class);
                    startActivity(login);
                    overridePendingTransition(R.anim.fadein,R.anim.fadeout);
                }
            }, 100);
        }
    }
        /*layout.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                final Intent intent = new Intent(Splash.this, MenuActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NO_ANIMATION);
                Splash.this.startActivity(intent);
                finish();
                return false;
            }
        });
        im.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                final Intent intent = new Intent(Splash.this, MenuActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NO_ANIMATION);
                Splash.this.startActivity(intent);
                finish();
                return false;
            }
        });*/
}