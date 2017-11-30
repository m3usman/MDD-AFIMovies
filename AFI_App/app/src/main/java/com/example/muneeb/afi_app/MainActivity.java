package com.example.muneeb.afi_app;
import android.app.SearchManager;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
public class MainActivity extends AppCompatActivity {
    //variables

    //TextView boxes in app to show chosen movie titles
    private TextView filmOne;
    private TextView filmTwo;
    private TextView filmThree;
    private TextView filmFour;
    private TextView filmFive;

    //Movie Titles are stored as strings
    private String movieTitle1;
    private String movieTitle2;
    private String movieTitle3;
    private String movieTitle4;
    private String movieTitle5;

    //integer variable to store the array position element, position of chosen movie
    int filmChosen1 = 0;
    int filmChosen2 = 0;
    int filmChosen3 = 0;
    int filmChosen4 = 0;
    int filmChosen5 = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.AppTheme);
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_splash);

        //start activity main
        setContentView(R.layout.activity_main);


        //assign the textview variable to UI object
        filmOne = (TextView)findViewById(R.id.filmOne);
        filmTwo = (TextView)findViewById(R.id.filmTwo);
        filmThree = (TextView)findViewById(R.id.filmThree);
        filmFour = (TextView)findViewById(R.id.filmFour);
        filmFive = (TextView)findViewById(R.id.filmFive);

        //button variable, assign to the UI object
        Button button = (Button) findViewById(R.id.button1);
        button.setOnClickListener(new ButtonHandler());//assign a button listener to an event handler

    }//end onCreate

    class ButtonHandler implements View.OnClickListener {

        //this method handles the event
        public void onClick(View view){

            int[] filmNumberList = new int[6];

            AFIMovies afiMovies = new AFIMovies();
            afiMovies.chooseFilmList();


            for (int i = 0; i <= 5; i++) {
                filmNumberList[i] = afiMovies.getFilmNumber(i);
            }

            for (int i = 0; i <= 5; i++) {
                //get random film number
                filmChosen1 = filmNumberList[0];
                filmChosen2 = filmNumberList[1];
                filmChosen3 = filmNumberList[2];
                filmChosen4 = filmNumberList[3];
                filmChosen5 = filmNumberList[4];

                //use the number to locate the movie
                movieTitle1 = afiMovies.getFilm(filmChosen1);
                movieTitle2 = afiMovies.getFilm(filmChosen2);
                movieTitle3 = afiMovies.getFilm(filmChosen3);
                movieTitle4 = afiMovies.getFilm(filmChosen4);
                movieTitle5 = afiMovies.getFilm(filmChosen5);

                //set the text of viewText to chosen movie
                filmOne.setText(movieTitle1);
                filmTwo.setText(movieTitle2);
                filmThree.setText(movieTitle3);
                filmFour.setText(movieTitle4);
                filmFive.setText(movieTitle5);

            }

        }//end onClick

    }//end ButtonHandler

    //method called when user selects/taps on chosen movie in the UI
    public void onClickmyTextView1 (View v1){

        //calls the searchWeb method, searches using item(IMDB) + movie title chosen
        searchWeb("IMDB " + movieTitle1);

    }// end onClickmyTextView

    public void onClickmyTextView2 (View v2){

        //calls the searchWeb method, searches using item(IMDB) + movie title chosen
        searchWeb("IMDB " + movieTitle2);

    }// end onClickmyTextView

    public void onClickmyTextView3 (View v3){

        //calls the searchWeb method, searches using item(IMDB) + movie title chosen
        searchWeb("IMDB " + movieTitle3);

    }// end onClickmyTextView

    public void onClickmyTextView4 (View v4){

        //calls the searchWeb method, searches using item(IMDB) + movie title chosen
        searchWeb("IMDB " + movieTitle4);

    }// end onClickmyTextView

    public void onClickmyTextView5 (View v5){

        //calls the searchWeb method, searches using item(IMDB) + movie title chosen
        searchWeb("IMDB " + movieTitle5);

    }// end onClickmyTextView

    /*
    public void searchWeb (String query){
        //sets up intent with search query
        Intent intent = new Intent(Intent.ACTION_SEARCH);
        intent.putExtra(SearchManager.QUERY, query);

        if (intent.resolveActivity(getPackageManager()) != null)
        {
            startActivity(intent);
        }

    }//end searchWeb
    */

    public void searchWeb (String query){
        try {

            Intent intent = new Intent(Intent.ACTION_SEARCH, Uri.parse("vnd.youtube://"));
            intent.putExtra(SearchManager.QUERY, query);
            //intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);

        } catch (ActivityNotFoundException e) {

            // youtube is not installed.Will be opened in other available apps

            Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtube.com/results?search_query=" + query));
            startActivity(i);
        }

    }//end searchWeb

}//end MainActivity


