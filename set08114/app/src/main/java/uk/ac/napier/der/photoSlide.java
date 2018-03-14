package uk.ac.napier.der;

import java.io.InputStream;




import android.content.Intent;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.ViewSwitcher.ViewFactory;

public class photoSlide extends AppCompatActivity {

    private Integer images[] = {R.drawable.img_3053, R.drawable.img_0221, R.drawable.img_2077};
    private int currImage = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery);

        /*button code to link main page and video gallery */
        Button Backbtn = (Button) findViewById(R.id.Backbtn);
        Backbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent About = new Intent(photoSlide.this, MainActivity.class);
                startActivity(About);
            }
        });

        Button nextbtn = (Button) findViewById(R.id.nextbtn);
        nextbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent About = new Intent(photoSlide.this, AboutPage.class);
                startActivity(About);
            }
        });

        initializeImageSwitcher();
        setInitialImage();
        setImageRotateListener();
    }
/*the code below gives a smooth animation while pressing the next page button*/
    private void initializeImageSwitcher() {
        final ImageSwitcher imageSwitcher = (ImageSwitcher) findViewById(R.id.imageSwitcher);
        imageSwitcher.setFactory(new ViewFactory() {
            @Override
            public View makeView() {
                ImageView imageView = new ImageView(photoSlide.this);
                return imageView;
            }
        });

        imageSwitcher.setInAnimation(AnimationUtils.loadAnimation(this, android.R.anim.slide_in_left));
        imageSwitcher.setOutAnimation(AnimationUtils.loadAnimation(this, android.R.anim.slide_out_right));
    }

    private void setImageRotateListener() {
        final Button rotatebutton = (Button) findViewById(R.id.btnRotateImage);
        rotatebutton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View arg0) {
                currImage++;
                if (currImage == 3) {
                    currImage = 0;
                }
                setCurrentImage();
            }
        });
    }

    private void setInitialImage() {
        setCurrentImage();
    }

    private void setCurrentImage() {
        final ImageSwitcher imageSwitcher = (ImageSwitcher) findViewById(R.id.imageSwitcher);
        imageSwitcher.setImageResource(images[currImage]);
    }
}
