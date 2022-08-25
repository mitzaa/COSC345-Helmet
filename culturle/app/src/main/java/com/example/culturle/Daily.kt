package com.example.culturle

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import java.util.*

/**
 * Group Members: George Stewart ID: , Hayden Knox ID: , Hami Daly ID: , Marion Millard ID: , Micheal Young ID: ,
 * This class Object is the instance of a Game played by the user. Once the user clicks the play game button
 * from the main screen an instance of this class is created and the program is executed.
 */
class Daily : AppCompatActivity() {
    /*
    * This first group of variable declarations creates all the needed UI
    * components to play the game we have created. The components created include the guess
    * submission button for a users country guess and an image view of the image which provides
    * a series of hits to the answer country. Lastly the variable flag is used to determine if the
    * user has guessed the correct answer country.
    */
    //private var b1: Button? = null
    private var iv: ImageView? = null
    private var flag = false
    /*
    * These intArrayOf instances contain collections of images bound to the drawables folder.
    * Each instance of an intArrayOf represents a single country out of the soon to be 195 countries
    * entered into thew game. As for the parameters of each game, each array folds five images
    * representing a feature associated with each answer country.
    */
    private val i001 = intArrayOf(R.drawable.i001_animal, R.drawable.i001_flag, R.drawable.i001_food, R.drawable.i001_lang,  R.drawable.i001_paint)
    private val i035 = intArrayOf(R.drawable.i035_animal, R.drawable.i035_flag, R.drawable.i035_food, R.drawable.i035_lang,  R.drawable.i035_paint)
    private val i040 = intArrayOf(R.drawable.i040_animal, R.drawable.i040_flag, R.drawable.i040_food, R.drawable.i040_lang,  R.drawable.i040_paint)
    private val i055 = intArrayOf(R.drawable.i055_animal, R.drawable.i055_flag, R.drawable.i055_food, R.drawable.i055_lang,  R.drawable.i055_paint)
    private val i061 = intArrayOf(R.drawable.i061_animal, R.drawable.i061_flag, R.drawable.i061_food, R.drawable.i061_lang,  R.drawable.i061_paint)
    private val i069 = intArrayOf(R.drawable.i069_animal, R.drawable.i069_flag, R.drawable.i069_food, R.drawable.i069_lang,  R.drawable.i069_paint)
    private val i111 = intArrayOf(R.drawable.i111_animal, R.drawable.i111_flag, R.drawable.i111_food, R.drawable.i111_lang,  R.drawable.i111_paint)
    private val i115 = intArrayOf(R.drawable.i115_animal, R.drawable.i115_flag, R.drawable.i115_food, R.drawable.i115_lang,  R.drawable.i115_paint)
    private val i124 = intArrayOf(R.drawable.i124_animal, R.drawable.i124_flag, R.drawable.i124_food, R.drawable.i124_lang,  R.drawable.i124_paint)
    private val i127 = intArrayOf(R.drawable.i127_animal, R.drawable.i127_flag, R.drawable.i127_food, R.drawable.i124_lang,  R.drawable.i124_paint)
    private val i170 = intArrayOf(R.drawable.i170_animal, R.drawable.i170_flag, R.drawable.i170_food, R.drawable.i170_lang,  R.drawable.i170_paint)
    private val i186 = intArrayOf(R.drawable.i186_animal, R.drawable.i186_flag, R.drawable.i186_food, R.drawable.i186_lang,  R.drawable.i186_paint)
    private val i187 = intArrayOf(R.drawable.i187_animal, R.drawable.i187_flag, R.drawable.i187_food, R.drawable.i187_lang,  R.drawable.i187_paint)

    // Order of the hints to be shown
    var order = intArrayOf(0, 4, 2, 3, 1)
    /*
    * For the simplicity of randomly selecting an answer country without a pattern. The country entries
    * are added as elements in a 2-Dimensional array. Each variable such as "i001" is a country within
    * the array, along with their associated images.
    */
    var arr = arrayOf(i001, i035, i040, i055, i061, i069, i111, i115, i124, i127, i170, i186, i187)
    /*
    * This array of Strings contains all of the corresponding text answers for each country.
    * Each answer is matched to the array of countries per index for chronological orders sake of organisation.
    * More String answer elements will be added in the future.
     */
    var answers = arrayOf<String>("Afghanistan", "Chad", "Congo", "Eritrea", "France", "Guatemala", "Mexico", "Mongolia", "New Zealand", "Nigeria", "Switzerland", "United Kingdom", "United States")

    /*
    * Variables:
    * i: is the count index which iterates through the images indexes in each country array.
    * enteredText: This variable is initialised to none for the default text when the game first begins
    * guesses: This is the number of attempts at guessing the user has attempted over the course of a game.
    * todaysCountry: This is the variable to hold the answer country which is allocated for the
    * game user to play the game. Later it will be renewed daily to contain a single country as to limit game play.
    * binding: In further versions of the game this variable will limit official gameplay to one round per day.
    * At the present time it is not used.
    */
    private var i = 0
    private var numGuesses = 1
    private var enteredText = "NONE"
    var todaysCountry = "NONE"
    //private lateinit var binding: Daily

    /**
     * @param: Bundle
     * This class instance is used to collect and tally user scores in a separate file which will
     * record statistical information related to the game users skills and progress.
     * Including: Games played Total, Games Won Total, Games Lost Total and User points score
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        // creates a random index column number for the 2-dimensional array so a country entry containing
        // images is chosen at random.
        val rnd = Random()

        val dailyMode = intent.getBooleanExtra("dailyMode", false)
        if(dailyMode) {
            val preferenceManager = PreferenceManager()
            val gamesPlayed = preferenceManager.getIntValue("gamesPlayed",this)
            preferenceManager.setIntPreference("gamesPlayed", gamesPlayed + 1,this)
            preferenceManager.setIntPreference("attemptedDaily", 1, this)
        }

        //if(dailyMode && dateManager.isNewDay())

        // This variable is dynamically used to produce a random int number for the 2-dimensional array based on the
        // number of elements it contains. This variable number range will be updated when the completion of more countries can be
        // entered.
        val myRandomValues = rnd.nextInt(arr.size)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_daily)
        val autotextView = findViewById<AutoCompleteTextView>(R.id.autoTextView)
        // This variable is used to retrieve the array of countries created.
        val countries = resources.getStringArray(R.array.Countries)
        // Create adapter and add in AutoCompleteTextView
        val adapter = ArrayAdapter(
            this,
            android.R.layout.simple_list_item_1, countries
        )
        autotextView.setAdapter(adapter)

        val guessBtn = findViewById<Button>(R.id.guessButton)
        // This if statement block is used to compare the guess country entered by the user
        // to the country held as an answer by the game
        if (guessBtn != null) {
            guessBtn.setOnClickListener(View.OnClickListener {
                enteredText = autotextView.getText().toString()
                //val enteredText = getString(R.string.submitted_country) + " " + autotextView.getText()
            })
            val autotextView = findViewById<AutoCompleteTextView>(R.id.autoTextView)
            val countries = resources.getStringArray(R.array.Countries)
            val adapter = ArrayAdapter(
                this,
                android.R.layout.simple_list_item_1, countries
            )
            autotextView.setAdapter(adapter)
            flag = true
            //b1 = findViewById<View>(R.id.guessButton) as Button
            iv = findViewById<View>(R.id.hintImage) as ImageView?
            iv!!.setImageResource(arr[myRandomValues][0])
            guessBtn!!.setOnClickListener {
                enteredText = autotextView.getText().toString()

                todaysCountry = answers[myRandomValues]

                // These blocks of if and else statements are used to determine if the used has entered
                // a guess which results in a win or a loss that the user is directed to either the loss
                // page of the game or then win page which displays the points and gains of their attempts.
                if(enteredText == answers[myRandomValues]) {
                    val intent = Intent(this, WinScreen::class.java)
                    intent.putExtra("todaysCountry", todaysCountry)
                    intent.putExtra("todaysFlag", arr[myRandomValues])
                    intent.putExtra("dailyMode", dailyMode)
                    intent.putExtra("numGuesses", numGuesses)
                    startActivity(intent)
                    // if this if statement condition results as true. This win page is displayed
                    // if the enteredText variable by the user matches the random text value selected
                    // from the answers array. The answer is picked by the random number generator value.
                }
                else{
                    // if this if statement condition results as a False Boolean value, the incorrect
                    // answer is removed from the text box component.
                    autotextView.getText().clear()
                }
                // This if statement executes if the maximum number of guesses has been attempted per
                // daily game. if the iterator variable for the number of games is equal to 5 the game
                // displays its end screen.
                if (i == 4) {
                    val intent = Intent(this, EndScreen::class.java)
                    intent.putExtra("todaysCountry", todaysCountry)
                    intent.putExtra("todaysFlag", arr[myRandomValues])
                    intent.putExtra("dailyMode", dailyMode)
                    startActivity(intent)
                }
                // This if statement executes if the  number of guesses attempted per
                // daily game is less than the limit. This variable increases for the number guess attempts
                // entered by the user. When this variable increments higher a new image is displayed in
                // the setImageResource variable from the array of country images.
                if (i < 4) {
                    i++
                    numGuesses++
                }
                    iv!!.setImageResource(arr[myRandomValues][order[i]])
            }
        }
    }
}
