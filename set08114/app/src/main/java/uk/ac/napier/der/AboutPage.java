package uk.ac.napier.der;


import android.content.Intent;
import android.os.Bundle;

import android.support.v7.app.AppCompatActivity;


import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import uk.ac.napier.der.model.Video;
import uk.ac.napier.der.util.VideoAdapter;







public class AboutPage extends AppCompatActivity {


/*calls the array created on the video adapter file*/

        private ListView mVideosListView;
        private List<Video> mVideosList = new ArrayList<>();
        private VideoAdapter mVideoAdapter;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_about_page);

            /*2 buttons added to link to the main page and the image gallery */
            Button Backbtn = (Button) findViewById(R.id.Backbtn);
            Backbtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent About = new Intent(AboutPage.this, MainActivity.class);
                    startActivity(About);
                }
            });

            Button nextbtn = (Button) findViewById(R.id.nextbtn);
            nextbtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent About = new Intent(AboutPage.this, photoSlide.class);
                    startActivity(About);
                }
            });



            //assignig the  videos
            mVideosListView = (ListView) findViewById(R.id.videoListView);

            //name given to the videos and respective dropbox url
            Video gallerieVideo = new Video("https://www.dropbox.com/s/5qxenkksx9o6aji/Strada%20delle%2052%20Gallerie%20Pasubio%20UHD%204K.mp4?dl=1");
            Video campoVideo = new Video("https://www.dropbox.com/s/wde5upiqf9w0v4v/Spigolo%20Faccio%2C%20Primo%20Apostolo%2CCampogrosso%20Italy.mp4?dl=1");
            Video piazVideo = new Video("https://www.dropbox.com/s/e1gpsee0ctuypk0/Piz%20Boe%27%20Ferrata%20Piazzetta.mp4?dl=1");
            Video bridgeVideo = new Video("https://www.dropbox.com/s/vrqowhvfzx2pq6f/Ossario%20del%20Pasubio%2C%20Tibetan%20bridge%20Beinhaus%20des%20Pasubio%20UHD%204K.mp4?dl=1");


            mVideosList.add(gallerieVideo);
            mVideosList.add(campoVideo);
            mVideosList.add(piazVideo);
            mVideosList.add(bridgeVideo);


            /*the code below generate the video list to the adapter file */
            mVideoAdapter = new VideoAdapter(this, mVideosList);
            mVideosListView.setAdapter(mVideoAdapter);


        }
    }

















