package com.example.culturle

import android.annotation.SuppressLint
import android.content.Intent
import android.media.MediaPlayer
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import java.text.SimpleDateFormat
import java.util.*
import kotlin.math.PI

/**
 * This class Object is the instance of a Game played by the user. Once the user clicks the play game button
 * from the main screen an instance of this class is created and the program is executed. The boolean
 * variable dailyMode determines if this game is counts as Daily or Practice.
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
    * entered into the game. As for the parameters of each game, each array holds five images
    * representing a feature associated with each answer country.
    */


    //<item>Afghanistan<item>
    private val i001 = intArrayOf(R.drawable.i001_animal, R.drawable.i001_flag, R.drawable.i001_food, R.drawable.i001_lang,  R.drawable.i001_paint)
    //<item>Albania<item>
    private val i002 = intArrayOf(R.drawable.i002_animal, R.drawable.i002_flag, R.drawable.i002_food, R.drawable.i002_lang,  R.drawable.i002_paint)
    //<item>Algeria<item>
    private val i003 = intArrayOf(R.drawable.i003_animal, R.drawable.i003_flag, R.drawable.i003_food, R.drawable.i003_lang,  R.drawable.i003_paint)
    //<item>Andorra<item>
    private val i004 = intArrayOf(R.drawable.i004_animal, R.drawable.i004_flag, R.drawable.i004_food, R.drawable.i004_lang,  R.drawable.i004_paint)
    //<item>Angola<item>
    private val i005 = intArrayOf(R.drawable.i005_animal, R.drawable.i005_flag, R.drawable.i005_food, R.drawable.i005_lang,  R.drawable.i005_paint)
    //<item>Antigua and Barbuda<item>
    private val i006 = intArrayOf(R.drawable.i006_animal, R.drawable.i006_flag, R.drawable.i006_food, R.drawable.i006_lang,  R.drawable.i006_paint)
    //<item>Argentina<item>
    private val i007 = intArrayOf(R.drawable.i007_animal, R.drawable.i007_flag, R.drawable.i007_food, R.drawable.i007_lang,  R.drawable.i007_paint)
    //<item>Armenia<item>
    private val i008 = intArrayOf(R.drawable.i008_animal, R.drawable.i008_flag, R.drawable.i008_food, R.drawable.i008_lang,  R.drawable.i008_paint)
    //<item>Australia<item>
    private val i009 = intArrayOf(R.drawable.i009_animal, R.drawable.i009_flag, R.drawable.i009_food, R.drawable.i009_lang,  R.drawable.i009_paint)
    //<item>Austria<item>
    private val i010 = intArrayOf(R.drawable.i010_animal, R.drawable.i010_flag, R.drawable.i010_food, R.drawable.i010_lang,  R.drawable.i010_paint)
    //<item>Azerbaijan<item>
    private val i011 = intArrayOf(R.drawable.i011_animal, R.drawable.i011_flag, R.drawable.i011_food, R.drawable.i011_lang,  R.drawable.i011_paint)
    //<item>Bahamas<item>
    private val i012 = intArrayOf(R.drawable.i012_animal, R.drawable.i012_flag, R.drawable.i012_food, R.drawable.i012_lang,  R.drawable.i012_paint)
    //<item>Bahrain<item>
    private val i013 = intArrayOf(R.drawable.i013_animal, R.drawable.i013_flag, R.drawable.i013_food, R.drawable.i013_lang,  R.drawable.i013_paint)
    //<item>Bangladesh<item>
    private val i014 = intArrayOf(R.drawable.i014_animal, R.drawable.i014_flag, R.drawable.i014_food, R.drawable.i014_lang,  R.drawable.i014_paint)
    //<item>Barbados<item>
    private val i015 = intArrayOf(R.drawable.i015_animal, R.drawable.i015_flag, R.drawable.i015_food, R.drawable.i015_lang,  R.drawable.i015_paint)
    //<item>Belarus<item>
    private val i016 = intArrayOf(R.drawable.i016_animal, R.drawable.i016_flag, R.drawable.i016_food, R.drawable.i016_lang,  R.drawable.i016_paint)
    //<item>Belgium<item>
    private val i017 = intArrayOf(R.drawable.i017_animal,
        R.drawable.i017_flag, R.drawable.i017_food, R.drawable.i017_lang, R.drawable.i017_animal
    )
    //<item>Belize<item>
    private val i018 = intArrayOf(R.drawable.i018_animal, R.drawable.i018_flag, R.drawable.i018_food, R.drawable.i018_lang,  R.drawable.i018_paint)
    //<item>Benin<item>
    private val i019 = intArrayOf(R.drawable.i019_animal, R.drawable.i019_flag, R.drawable.i019_food, R.drawable.i019_lang,  R.drawable.i019_paint)
    //<item>Bhutan<item>
    private val i020 = intArrayOf(R.drawable.i020_animal, R.drawable.i020_flag, R.drawable.i020_food, R.drawable.i020_lang,  R.drawable.i020_paint)
    //<item>Bolivia<item>
    private val i021 = intArrayOf(R.drawable.i021_animal, R.drawable.i021_flag, R.drawable.i021_food, R.drawable.i021_lang,  R.drawable.i021_paint)
    //<item>Bosnia and Herzegovina<item>
    private val i022 = intArrayOf(R.drawable.i022_animal, R.drawable.i022_flag, R.drawable.i022_food, R.drawable.i022_lang,  R.drawable.i022_paint)
    //<item>Botswana<item>
    private val i023 = intArrayOf(R.drawable.i023_animal, R.drawable.i023_flag, R.drawable.i023_food, R.drawable.i023_lang,  R.drawable.i023_paint)
    //<item>Brazil<item>
    private val i024 = intArrayOf(R.drawable.i024_animal, R.drawable.i024_flag, R.drawable.i024_food, R.drawable.i024_lang,  R.drawable.i024_paint)
    //<item>Brunei<item>
    private val i025 = intArrayOf(R.drawable.i025_animal, R.drawable.i025_flag, R.drawable.i025_food, R.drawable.i025_lang,  R.drawable.i025_paint)
    //<item>Bulgaria<item>
    private val i026 = intArrayOf(R.drawable.i026_animal, R.drawable.i026_flag, R.drawable.i026_food, R.drawable.i026_lang,  R.drawable.i026_paint)
    //<item>Burkina Faso<item>
    private val i027 = intArrayOf(R.drawable.i027_animal, R.drawable.i027_flag, R.drawable.i027_food, R.drawable.i027_lang,  R.drawable.i027_paint)
    //<item>Burundi<item>
    private val i028 = intArrayOf(R.drawable.i028_animal, R.drawable.i028_flag, R.drawable.i028_food, R.drawable.i028_lang,  R.drawable.i028_paint)
    //<item>Côte d'Ivoire<item>
    private val i029 = intArrayOf(R.drawable.i029_animal, R.drawable.i029_flag, R.drawable.i029_food, R.drawable.i029_lang,  R.drawable.i029_paint)
    //<item>Cabo Verde<item>
    private val i030 = intArrayOf(R.drawable.i030_animal, R.drawable.i030_flag, R.drawable.i030_food, R.drawable.i030_lang,  R.drawable.i030_paint)
    //<item>Cambodia<item>
    private val i031 = intArrayOf(R.drawable.i031_animal, R.drawable.i031_flag, R.drawable.i031_food, R.drawable.i031_lang,  R.drawable.i031_paint)
    //<item>Cameroon<item>
    private val i032 = intArrayOf(R.drawable.i032_animal, R.drawable.i032_flag, R.drawable.i032_food, R.drawable.i032_lang,  R.drawable.i032_paint)
    //<item>Canada<item>
    private val i033 = intArrayOf(R.drawable.i033_animal, R.drawable.i033_flag, R.drawable.i033_food, R.drawable.i033_lang,  R.drawable.i033_paint)
    //<item>Central African Republic<item>
    private val i034 = intArrayOf(R.drawable.i034_animal, R.drawable.i034_flag, R.drawable.i034_food, R.drawable.i034_lang,  R.drawable.i034_paint)
    //<item>Chad<item>
    private val i035 = intArrayOf(R.drawable.i035_animal, R.drawable.i035_flag, R.drawable.i035_food, R.drawable.i035_lang,  R.drawable.i035_paint)
    //<item>Chile<item>
    private val i036 = intArrayOf(R.drawable.i036_animal, R.drawable.i036_flag, R.drawable.i036_food, R.drawable.i036_lang,  R.drawable.i036_paint)
    //<item>China<item>
    private val i037 = intArrayOf(R.drawable.i037_animal, R.drawable.i037_flag, R.drawable.i037_food, R.drawable.i037_lang,  R.drawable.i037_paint)
    //<item>Colombia<item>
    private val i038 = intArrayOf(R.drawable.i038_animal, R.drawable.i038_flag, R.drawable.i038_food, R.drawable.i038_lang,  R.drawable.i038_paint)
    //<item>Comoros<item>
    private val i039 = intArrayOf(R.drawable.i039_animal, R.drawable.i039_flag, R.drawable.i039_food, R.drawable.i039_lang,  R.drawable.i039_paint)
    //<item>Republic of the Congo<item>
    private val i040 = intArrayOf(R.drawable.i040_animal, R.drawable.i040_flag, R.drawable.i040_food, R.drawable.i040_lang,  R.drawable.i040_paint)
    //<item>Costa Rica<item>
    private val i041 = intArrayOf(R.drawable.i041_animal, R.drawable.i041_flag, R.drawable.i041_food, R.drawable.i041_lang,  R.drawable.i041_paint)
    //<item>Croatia<item>
    private val i042 = intArrayOf(R.drawable.i042_animal, R.drawable.i042_flag, R.drawable.i042_food, R.drawable.i042_lang,  R.drawable.i042_paint)
    //<item>Cuba<item>
    private val i043 = intArrayOf(R.drawable.i043_animal, R.drawable.i043_flag, R.drawable.i043_food, R.drawable.i043_lang,  R.drawable.i043_paint)
    //<item>Cyprus<item>
    private val i044 = intArrayOf(R.drawable.i044_animal, R.drawable.i044_flag, R.drawable.i044_food, R.drawable.i044_lang,  R.drawable.i044_paint)
    //<item>Czechia (Czech Republic)<item>
    private val i045 = intArrayOf(R.drawable.i045_animal, R.drawable.i045_flag, R.drawable.i045_food, R.drawable.i045_lang,  R.drawable.i045_paint)
    //<item>Democratic Republic of the Congo<item>
    private val i046 = intArrayOf(R.drawable.i046_animal, R.drawable.i046_flag, R.drawable.i046_food, R.drawable.i046_lang,  R.drawable.i046_paint)
    //<item>Denmark<item>
    private val i047 = intArrayOf(R.drawable.i047_animal, R.drawable.i047_flag, R.drawable.i047_food, R.drawable.i047_lang,  R.drawable.i047_paint)
    //<item>Djibouti<item>
    private val i048 = intArrayOf(R.drawable.i048_animal, R.drawable.i048_flag, R.drawable.i048_food, R.drawable.i048_lang,  R.drawable.i048_paint)
    //<item>Dominica<item>
    private val i049 = intArrayOf(R.drawable.i049_animal, R.drawable.i049_flag, R.drawable.i049_food, R.drawable.i049_lang,  R.drawable.i049_paint)
    //<item>Dominican Republic<item>
    private val i050 = intArrayOf(R.drawable.i050_animal, R.drawable.i050_flag, R.drawable.i050_food, R.drawable.i050_lang,  R.drawable.i050_paint)
    //<item>Ecuador<item>
    private val i051 = intArrayOf(R.drawable.i051_animal, R.drawable.i051_flag, R.drawable.i051_food, R.drawable.i051_lang,  R.drawable.i051_paint)
    //<item>Egypt<item>
    private val i052 = intArrayOf(R.drawable.i052_animal, R.drawable.i052_flag, R.drawable.i052_food, R.drawable.i052_lang,  R.drawable.i052_paint)
    //<item>El Salvador<item>
    private val i053 = intArrayOf(R.drawable.i053_animal, R.drawable.i053_flag, R.drawable.i053_food, R.drawable.i053_lang,  R.drawable.i053_paint)
    //<item>Equatorial Guinea<item>
    private val i054 = intArrayOf(R.drawable.i054_animal, R.drawable.i054_flag, R.drawable.i054_food, R.drawable.i054_lang,  R.drawable.i054_paint)
    //<item>Eritrea<item>
    private val i055 = intArrayOf(R.drawable.i055_animal, R.drawable.i055_flag, R.drawable.i055_food, R.drawable.i055_lang,  R.drawable.i055_paint)
    //<item>Estonia<item>
    private val i056 = intArrayOf(R.drawable.i056_animal, R.drawable.i056_flag, R.drawable.i056_food, R.drawable.i056_lang,  R.drawable.i056_paint)
    //<item>Eswatini (fmr. "Swaziland")<item>
    private val i057 = intArrayOf(R.drawable.i057_animal, R.drawable.i057_flag, R.drawable.i057_food, R.drawable.i057_lang,  R.drawable.i057_paint)
    //<item>Ethiopia<item>
    private val i058 = intArrayOf(R.drawable.i058_animal, R.drawable.i058_flag, R.drawable.i058_food, R.drawable.i058_lang,  R.drawable.i058_paint)
    //<item>Fiji<item>
    private val i059 = intArrayOf(R.drawable.i059_animal, R.drawable.i059_flag, R.drawable.i059_food, R.drawable.i059_lang,  R.drawable.i059_paint)
    //<item>Finland<item>
    private val i060 = intArrayOf(R.drawable.i060_animal, R.drawable.i060_flag, R.drawable.i060_food, R.drawable.i060_lang,  R.drawable.i060_paint)
    //<item>France<item>
    private val i061 = intArrayOf(R.drawable.i061_animal, R.drawable.i061_flag, R.drawable.i061_food, R.drawable.i061_lang,  R.drawable.i061_paint)
    //<item>Gabon<item>
    private val i062 = intArrayOf(R.drawable.i062_animal, R.drawable.i062_flag, R.drawable.i062_food, R.drawable.i062_lang,  R.drawable.i062_paint)
    //<item>Gambia<item>
    private val i063 = intArrayOf(R.drawable.i063_animal, R.drawable.i063_flag, R.drawable.i063_food, R.drawable.i063_lang,  R.drawable.i063_paint)
    //<item>Georgia<item>
    private val i064 = intArrayOf(R.drawable.i064_animal, R.drawable.i064_flag, R.drawable.i064_food, R.drawable.i064_lang,  R.drawable.i064_paint)
    //<item>Germany<item>
    private val i065 = intArrayOf(R.drawable.i065_animal, R.drawable.i065_flag, R.drawable.i065_food, R.drawable.i065_lang,  R.drawable.i065_paint)
    //<item>Ghana<item>
    private val i066 = intArrayOf(R.drawable.i066_animal, R.drawable.i066_flag, R.drawable.i066_food, R.drawable.i066_lang,  R.drawable.i066_paint)
    //<item>Greece<item>
    private val i067 = intArrayOf(R.drawable.i067_animal, R.drawable.i067_flag, R.drawable.i067_food, R.drawable.i067_lang,  R.drawable.i067_paint)
    //<item>Grenada<item>
    private val i068 = intArrayOf(R.drawable.i068_animal, R.drawable.i068_flag, R.drawable.i068_food, R.drawable.i068_lang,  R.drawable.i068_paint)
    //<item>Guatemala<item>
    private val i069 = intArrayOf(R.drawable.i069_animal, R.drawable.i069_flag, R.drawable.i069_food, R.drawable.i069_lang,  R.drawable.i069_paint)
    //<item>Guinea<item>
    private val i070 = intArrayOf(R.drawable.i070_animal, R.drawable.i070_flag, R.drawable.i070_food, R.drawable.i070_lang,  R.drawable.i070_paint)
    //<item>Guinea-Bissau<item>
    private val i071 = intArrayOf(R.drawable.i071_animal, R.drawable.i071_flag, R.drawable.i071_food, R.drawable.i071_lang,  R.drawable.i071_paint)
    //<item>Guyana<item>
    private val i072 = intArrayOf(R.drawable.i072_animal, R.drawable.i072_flag, R.drawable.i072_food, R.drawable.i072_lang,  R.drawable.i072_paint)
    //<item>Haiti<item>
    private val i073 = intArrayOf(R.drawable.i073_animal, R.drawable.i073_flag, R.drawable.i073_food, R.drawable.i073_lang,  R.drawable.i073_paint)
    //<item>Holy See<item>
    private val i074 = intArrayOf(R.drawable.i074_animal, R.drawable.i074_flag, R.drawable.i074_food, R.drawable.i074_lang,  R.drawable.i074_paint)
    //<item>Honduras<item>
    private val i075 = intArrayOf(R.drawable.i075_animal, R.drawable.i075_flag, R.drawable.i075_food, R.drawable.i075_lang,  R.drawable.i075_paint)
    //<item>Hungary<item>
    private val i076 = intArrayOf(R.drawable.i076_animal, R.drawable.i076_flag, R.drawable.i076_food, R.drawable.i076_lang,  R.drawable.i076_paint)
    //<item>Iceland<item>
    private val i077 = intArrayOf(R.drawable.i077_animal, R.drawable.i077_flag, R.drawable.i077_food, R.drawable.i077_lang,  R.drawable.i077_paint)
    //<item>India<item>
    private val i078 = intArrayOf(R.drawable.i078_animal, R.drawable.i078_flag, R.drawable.i078_food, R.drawable.i078_lang,  R.drawable.i078_paint)
    //<item>Indonesia<item>
    private val i079 = intArrayOf(R.drawable.i079_animal, R.drawable.i079_flag, R.drawable.i079_food, R.drawable.i079_lang,  R.drawable.i079_paint)
    //<item>Iran<item>
    private val i080 = intArrayOf(R.drawable.i080_animal, R.drawable.i080_flag, R.drawable.i080_food, R.drawable.i080_lang,  R.drawable.i080_paint)
    //<item>Iraq<item>
    private val i081 = intArrayOf(R.drawable.i081_animal, R.drawable.i081_flag, R.drawable.i081_food, R.drawable.i081_lang,  R.drawable.i081_paint)
    //<item>Ireland<item>
    private val i082 = intArrayOf(R.drawable.i082_animal, R.drawable.i082_flag, R.drawable.i082_food, R.drawable.i082_lang,  R.drawable.i082_paint)
    //<item>Israel<item>
    private val i083 = intArrayOf(R.drawable.i083_animal, R.drawable.i083_flag, R.drawable.i083_food, R.drawable.i083_lang,  R.drawable.i083_paint)
    //<item>Italy<item>
    private val i084 = intArrayOf(R.drawable.i084_animal, R.drawable.i084_flag, R.drawable.i084_food, R.drawable.i084_lang,  R.drawable.i084_paint)
    //<item>Jamaica<item>
    private val i085 = intArrayOf(R.drawable.i085_animal, R.drawable.i085_flag, R.drawable.i085_food, R.drawable.i085_lang,  R.drawable.i085_paint)
    //<item>Japan<item>
    private val i086 = intArrayOf(R.drawable.i086_animal, R.drawable.i086_flag, R.drawable.i086_food, R.drawable.i086_lang,  R.drawable.i086_paint)
    //<item>Jordan<item>
    private val i087 = intArrayOf(R.drawable.i087_animal, R.drawable.i087_flag, R.drawable.i087_food, R.drawable.i087_lang,  R.drawable.i087_paint)
    //<item>Kazakhstan<item>
    private val i088 = intArrayOf(R.drawable.i088_animal, R.drawable.i088_flag, R.drawable.i088_food, R.drawable.i088_lang,  R.drawable.i088_paint)
    //<item>Kenya<item>
    private val i089 = intArrayOf(R.drawable.i089_animal, R.drawable.i089_flag, R.drawable.i089_food, R.drawable.i089_lang,  R.drawable.i089_paint)
    //<item>Kiribati<item>
    private val i090 = intArrayOf(R.drawable.i090_animal, R.drawable.i090_flag, R.drawable.i090_food, R.drawable.i090_lang,  R.drawable.i090_paint)
    //<item>Kuwait<item>
    //private val i091 = intArrayOf(R.drawable.i091_animal, R.drawable.i091_flag, R.drawable.i091_food, R.drawable.i091_lang,  R.drawable.i091_paint)
    //<item>Kyrgyzstan<item>
    //private val i092 = intArrayOf(R.drawable.i092_animal, R.drawable.i092_flag, R.drawable.i092_food, R.drawable.i092_lang,  R.drawable.i092_paint)
    //<item>Laos<item>
    //private val i093 = intArrayOf(R.drawable.i093_animal, R.drawable.i093_flag, R.drawable.i093_food, R.drawable.i093_lang,  R.drawable.i093_paint)
    //<item>Latvia<item>
    //private val i094 = intArrayOf(R.drawable.i094_animal, R.drawable.i094_flag, R.drawable.i094_food, R.drawable.i094_lang,  R.drawable.i094_paint)
    //<item>Lebanon<item>
    //private val i095 = intArrayOf(R.drawable.i095_animal, R.drawable.i095_flag, R.drawable.i095_food, R.drawable.i095_lang,  R.drawable.i095_paint)
    //<item>Lesotho<item>
    //private val i096 = intArrayOf(R.drawable.i096_animal, R.drawable.i096_flag, R.drawable.i096_food, R.drawable.i096_lang,  R.drawable.i096_paint)
    //<item>Liberia<item>
    //private val i097 = intArrayOf(R.drawable.i097_animal, R.drawable.i097_flag, R.drawable.i097_food, R.drawable.i097_lang,  R.drawable.i097_paint)
    //<item>Libya<item>
    //private val i098 = intArrayOf(R.drawable.i098_animal, R.drawable.i098_flag, R.drawable.i098_food, R.drawable.i098_lang,  R.drawable.i098_paint)
    //<item>Liechtenstein<item>
    //private val i099 = intArrayOf(R.drawable.i099_animal, R.drawable.i099_flag, R.drawable.i099_food, R.drawable.i099_lang,  R.drawable.i099_paint)
    //<item>Lithuania<item>
    //private val i100 = intArrayOf(R.drawable.i100_animal, R.drawable.i100_flag, R.drawable.i100_food, R.drawable.i100_lang,  R.drawable.i100_paint)
    //<item>Luxembourg<item>
    //private val i101 = intArrayOf(R.drawable.i101_animal, R.drawable.i101_flag, R.drawable.i101_food, R.drawable.i101_lang,  R.drawable.i101_paint)
    //<item>Madagascar<item>
    //private val i102 = intArrayOf(R.drawable.i102_animal, R.drawable.i102_flag, R.drawable.i102_food, R.drawable.i102_lang,  R.drawable.i102_paint)
    //<item>Malawi<item>
    //private val i103 = intArrayOf(R.drawable.i103_animal, R.drawable.i103_flag, R.drawable.i103_food, R.drawable.i103_lang,  R.drawable.i103_paint)
    //<item>Malaysia<item>
    //private val i104 = intArrayOf(R.drawable.i104_animal, R.drawable.i104_flag, R.drawable.i104_food, R.drawable.i104_lang,  R.drawable.i104_paint)
    //<item>Maldives<item>
    //private val i105 = intArrayOf(R.drawable.i105_animal, R.drawable.i105_flag, R.drawable.i105_food, R.drawable.i105_lang,  R.drawable.i105_paint)
    //<item>Mali<item>
    //private val i106 = intArrayOf(R.drawable.i106_animal, R.drawable.i106_flag, R.drawable.i106_food, R.drawable.i106_lang,  R.drawable.i106_paint)
    //<item>Malta<item>
    //private val i107 = intArrayOf(R.drawable.i107_animal, R.drawable.i107_flag, R.drawable.i107_food, R.drawable.i107_lang,  R.drawable.i107_paint)
    //<item>Marshall Islands<item>
    //private val i108 = intArrayOf(R.drawable.i108_animal, R.drawable.i108_flag, R.drawable.i108_food, R.drawable.i108_lang,  R.drawable.i108_paint)
    //<item>Mauritania<item>
    //private val i109 = intArrayOf(R.drawable.i109_animal, R.drawable.i109_flag, R.drawable.i109_food, R.drawable.i109_lang,  R.drawable.i109_paint)
    //<item>Mauritius<item>
    //private val i110 = intArrayOf(R.drawable.i110_animal, R.drawable.i110_flag, R.drawable.i110_food, R.drawable.i110_lang,  R.drawable.i110_paint)
    //<item>Mexico<item>
    //private val i111 = intArrayOf(R.drawable.i111_animal, R.drawable.i111_flag, R.drawable.i111_food, R.drawable.i111_lang,  R.drawable.i111_paint)
    //<item>Micronesia<item>
    //private val i112 = intArrayOf(R.drawable.i112_animal, R.drawable.i112_flag, R.drawable.i112_food, R.drawable.i112_lang,  R.drawable.i112_paint)
    //<item>Moldova<item>
    //private val i113 = intArrayOf(R.drawable.i113_animal, R.drawable.i113_flag, R.drawable.i113_food, R.drawable.i113_lang,  R.drawable.i113_paint)
    //<item>Monaco<item>
    //private val i114 = intArrayOf(R.drawable.i114_animal, R.drawable.i114_flag, R.drawable.i114_food, R.drawable.i114_lang,  R.drawable.i114_paint)
    //<item>Mongolia<item>
    //private val i115 = intArrayOf(R.drawable.i115_animal, R.drawable.i115_flag, R.drawable.i115_food, R.drawable.i115_lang,  R.drawable.i115_paint)
    //<item>Montenegro<item>
    //private val i116 = intArrayOf(R.drawable.i116_animal, R.drawable.i116_flag, R.drawable.i116_food, R.drawable.i116_lang,  R.drawable.i116_paint)
    //<item>Morocco<item>
    //private val i117 = intArrayOf(R.drawable.i117_animal, R.drawable.i117_flag, R.drawable.i117_food, R.drawable.i117_lang,  R.drawable.i117_paint)
    //<item>Mozambique<item>
    //private val i118 = intArrayOf(R.drawable.i118_animal, R.drawable.i118_flag, R.drawable.i118_food, R.drawable.i118_lang,  R.drawable.i118_paint)
    //<item>Myanmar (formerly Burma)<item>
    //private val i119 = intArrayOf(R.drawable.i119_animal, R.drawable.i119_flag, R.drawable.i119_food, R.drawable.i119_lang,  R.drawable.i119_paint)
    //<item>Namibia<item>
    //private val i120 = intArrayOf(R.drawable.i120_animal, R.drawable.i120_flag, R.drawable.i120_food, R.drawable.i120_lang,  R.drawable.i120_paint)
    //<item>Nauru<item>
    //private val i121 = intArrayOf(R.drawable.i121_animal, R.drawable.i121_flag, R.drawable.i121_food, R.drawable.i121_lang,  R.drawable.i121_paint)
    //<item>Nepal<item>
    //private val i122 = intArrayOf(R.drawable.i122_animal, R.drawable.i122_flag, R.drawable.i122_food, R.drawable.i122_lang,  R.drawable.i122_paint)
    //<item>Netherlands<item>
    //private val i123 = intArrayOf(R.drawable.i123_animal, R.drawable.i123_flag, R.drawable.i123_food, R.drawable.i123_lang,  R.drawable.i123_paint)
    //<item>New Zealand<item>
    //private val i124 = intArrayOf(R.drawable.i124_animal, R.drawable.i124_flag, R.drawable.i124_food, R.drawable.i124_lang,  R.drawable.i124_paint)
    //<item>Nicaragua<item>
    //private val i125 = intArrayOf(R.drawable.i125_animal, R.drawable.i125_flag, R.drawable.i125_food, R.drawable.i125_lang,  R.drawable.i125_paint)
    //<item>Niger<item>
    //private val i126 = intArrayOf(R.drawable.i126_animal, R.drawable.i126_flag, R.drawable.i126_food, R.drawable.i126_lang,  R.drawable.i126_paint)
    //<item>Nigeria<item>
    //private val i127 = intArrayOf(R.drawable.i127_animal, R.drawable.i127_flag, R.drawable.i127_food, R.drawable.i127_lang,  R.drawable.i127_paint)
    //<item>North Korea<item>
    //private val i128 = intArrayOf(R.drawable.i128_animal, R.drawable.i128_flag, R.drawable.i128_food, R.drawable.i128_lang,  R.drawable.i128_paint)
    //<item>North Macedonia<item>
    //private val i129 = intArrayOf(R.drawable.i129_animal, R.drawable.i129_flag, R.drawable.i129_food, R.drawable.i129_lang,  R.drawable.i129_paint)
    //<item>Norway<item>
    //private val i130 = intArrayOf(R.drawable.i130_animal, R.drawable.i130_flag, R.drawable.i130_food, R.drawable.i130_lang,  R.drawable.i130_paint)
    //<item>Oman<item>
    //private val i131 = intArrayOf(R.drawable.i131_animal, R.drawable.i131_flag, R.drawable.i131_food, R.drawable.i131_lang,  R.drawable.i131_paint)
    //<item>Pakistan<item>
    //private val i132 = intArrayOf(R.drawable.i132_animal, R.drawable.i132_flag, R.drawable.i132_food, R.drawable.i132_lang,  R.drawable.i132_paint)
    //<item>Palau<item>
    //private val i133 = intArrayOf(R.drawable.i133_animal, R.drawable.i133_flag, R.drawable.i133_food, R.drawable.i133_lang,  R.drawable.i133_paint)
    //<item>Palestine State<item>
    //private val i134 = intArrayOf(R.drawable.i134_animal, R.drawable.i134_flag, R.drawable.i134_food, R.drawable.i134_lang,  R.drawable.i134_paint)
    //<item>Panama<item>
    //private val i135 = intArrayOf(R.drawable.i135_animal, R.drawable.i135_flag, R.drawable.i135_food, R.drawable.i135_lang,  R.drawable.i135_paint)
    //<item>Papua New Guinea<item>
    //private val i136 = intArrayOf(R.drawable.i136_animal, R.drawable.i136_flag, R.drawable.i136_food, R.drawable.i136_lang,  R.drawable.i136_paint)
    //<item>Paraguay<item>
    //private val i137 = intArrayOf(R.drawable.i137_animal, R.drawable.i137_flag, R.drawable.i137_food, R.drawable.i137_lang,  R.drawable.i137_paint)
    //<item>Peru<item>
    //private val i138 = intArrayOf(R.drawable.i138_animal, R.drawable.i138_flag, R.drawable.i138_food, R.drawable.i138_lang,  R.drawable.i138_paint)
    //<item>Philippines<item>
    //private val i139 = intArrayOf(R.drawable.i139_animal, R.drawable.i139_flag, R.drawable.i139_food, R.drawable.i139_lang,  R.drawable.i139_paint)
    //<item>Poland<item>
    //private val i140 = intArrayOf(R.drawable.i140_animal, R.drawable.i140_flag, R.drawable.i140_food, R.drawable.i140_lang,  R.drawable.i140_paint)
    //<item>Portugal<item>
    //private val i141 = intArrayOf(R.drawable.i141_animal, R.drawable.i141_flag, R.drawable.i141_food, R.drawable.i141_lang,  R.drawable.i141_paint)
    //<item>Qatar<item>
    //private val i142 = intArrayOf(R.drawable.i142_animal, R.drawable.i142_flag, R.drawable.i142_food, R.drawable.i142_lang,  R.drawable.i142_paint)
    //<item>Romania<item>
    //private val i143 = intArrayOf(R.drawable.i143_animal, R.drawable.i143_flag, R.drawable.i143_food, R.drawable.i143_lang,  R.drawable.i143_paint)
    //<item>Russia<item>
    //private val i144 = intArrayOf(R.drawable.i144_animal, R.drawable.i144_flag, R.drawable.i144_food, R.drawable.i144_lang,  R.drawable.i144_paint)
    //<item>Rwanda<item>
    //private val i145 = intArrayOf(R.drawable.i145_animal, R.drawable.i145_flag, R.drawable.i145_food, R.drawable.i145_lang,  R.drawable.i145_paint)
    //<item>Saint Kitts and Nevis<item>
    //private val i146 = intArrayOf(R.drawable.i146_animal, R.drawable.i146_flag, R.drawable.i146_food, R.drawable.i146_lang,  R.drawable.i146_paint)
    //<item>Saint Lucia<item>
    //private val i147 = intArrayOf(R.drawable.i147_animal, R.drawable.i147_flag, R.drawable.i147_food, R.drawable.i147_lang,  R.drawable.i147_paint)
    //<item>Saint Vincent and the Grenadines<item>
    //private val i148 = intArrayOf(R.drawable.i148_animal, R.drawable.i148_flag, R.drawable.i148_food, R.drawable.i148_lang,  R.drawable.i148_paint)
    //<item>Samoa<item>
    //private val i149 = intArrayOf(R.drawable.i149_animal, R.drawable.i149_flag, R.drawable.i149_food, R.drawable.i149_lang,  R.drawable.i149_paint)
    //<item>San Marino<item>
    //private val i150 = intArrayOf(R.drawable.i150_animal, R.drawable.i150_flag, R.drawable.i150_food, R.drawable.i150_lang,  R.drawable.i150_paint)
    //<item>Sao Tome and Principe<item>
    //private val i151 = intArrayOf(R.drawable.i151_animal, R.drawable.i151_flag, R.drawable.i151_food, R.drawable.i151_lang,  R.drawable.i151_paint)
    //<item>Saudi Arabia<item>
    //private val i152 = intArrayOf(R.drawable.i152_animal, R.drawable.i152_flag, R.drawable.i152_food, R.drawable.i152_lang,  R.drawable.i152_paint)
    //<item>Senegal<item>
    //private val i153 = intArrayOf(R.drawable.i153_animal, R.drawable.i153_flag, R.drawable.i153_food, R.drawable.i153_lang,  R.drawable.i153_paint)
    //<item>Serbia<item>
    //private val i154 = intArrayOf(R.drawable.i154_animal, R.drawable.i154_flag, R.drawable.i154_food, R.drawable.i154_lang,  R.drawable.i154_paint)
    //<item>Seychelles<item>
    //private val i155 = intArrayOf(R.drawable.i155_animal, R.drawable.i155_flag, R.drawable.i155_food, R.drawable.i155_lang,  R.drawable.i155_paint)
    //<item>Sierra Leone<item>
    //private val i156 = intArrayOf(R.drawable.i156_animal, R.drawable.i156_flag, R.drawable.i156_food, R.drawable.i156_lang,  R.drawable.i156_paint)
    //<item>Singapore<item>
    //private val i157 = intArrayOf(R.drawable.i157_animal, R.drawable.i157_flag, R.drawable.i157_food, R.drawable.i157_lang,  R.drawable.i157_paint)
    //<item>Slovakia<item>
    //private val i158 = intArrayOf(R.drawable.i158_animal, R.drawable.i158_flag, R.drawable.i158_food, R.drawable.i158_lang,  R.drawable.i158_paint)
    //<item>Slovenia<item>
    //private val i159 = intArrayOf(R.drawable.i159_animal, R.drawable.i159_flag, R.drawable.i159_food, R.drawable.i159_lang,  R.drawable.i159_paint)
    //<item>Solomon Islands<item>
    //private val i160 = intArrayOf(R.drawable.i160_animal, R.drawable.i160_flag, R.drawable.i160_food, R.drawable.i160_lang,  R.drawable.i160_paint)
    //<item>Somalia<item>
    //private val i161 = intArrayOf(R.drawable.i161_animal, R.drawable.i161_flag, R.drawable.i161_food, R.drawable.i161_lang,  R.drawable.i161_paint)
    //<item>South Africa<item>
    //private val i162 = intArrayOf(R.drawable.i162_animal, R.drawable.i162_flag, R.drawable.i162_food, R.drawable.i162_lang,  R.drawable.i162_paint)
    //<item>South Korea<item>
    //private val i163 = intArrayOf(R.drawable.i163_animal, R.drawable.i163_flag, R.drawable.i163_food, R.drawable.i163_lang,  R.drawable.i163_paint)
    //<item>South Sudan<item>
    //private val i164 = intArrayOf(R.drawable.i164_animal, R.drawable.i164_flag, R.drawable.i164_food, R.drawable.i164_lang,  R.drawable.i164_paint)
    //<item>Spain<item>
    //private val i165 = intArrayOf(R.drawable.i165_animal, R.drawable.i165_flag, R.drawable.i165_food, R.drawable.i165_lang,  R.drawable.i165_paint)
    //<item>Sri Lanka<item>
    //private val i166 = intArrayOf(R.drawable.i166_animal, R.drawable.i166_flag, R.drawable.i166_food, R.drawable.i166_lang,  R.drawable.i166_paint)
    //<item>Sudan<item>
    //private val i167 = intArrayOf(R.drawable.i167_animal, R.drawable.i167_flag, R.drawable.i167_food, R.drawable.i167_lang,  R.drawable.i167_paint)
    //<item>Suriname<item>
    //private val i168 = intArrayOf(R.drawable.i168_animal, R.drawable.i168_flag, R.drawable.i168_food, R.drawable.i168_lang,  R.drawable.i168_paint)
    //<item>Sweden<item>
    //private val i169 = intArrayOf(R.drawable.i169_animal, R.drawable.i169_flag, R.drawable.i169_food, R.drawable.i169_lang,  R.drawable.i169_paint)
    //<item>Switzerland<item>
    //private val i170 = intArrayOf(R.drawable.i170_animal, R.drawable.i170_flag, R.drawable.i170_food, R.drawable.i170_lang,  R.drawable.i170_paint)
    //<item>Syria<item>
    //private val i171 = intArrayOf(R.drawable.i171_animal, R.drawable.i171_flag, R.drawable.i171_food, R.drawable.i171_lang,  R.drawable.i171_paint)
    //<item>Tajikistan<item>
    //private val i172 = intArrayOf(R.drawable.i172_animal, R.drawable.i172_flag, R.drawable.i172_food, R.drawable.i172_lang,  R.drawable.i172_paint)
    //<item>Tanzania<item>
    //private val i173 = intArrayOf(R.drawable.i173_animal, R.drawable.i173_flag, R.drawable.i173_food, R.drawable.i173_lang,  R.drawable.i173_paint)
    //<item>Thailand<item>
    //private val i174 = intArrayOf(R.drawable.i174_animal, R.drawable.i174_flag, R.drawable.i174_food, R.drawable.i174_lang,  R.drawable.i174_paint)
    //<item>Timor-Leste<item>
    //private val i175 = intArrayOf(R.drawable.i175_animal, R.drawable.i175_flag, R.drawable.i175_food, R.drawable.i175_lang,  R.drawable.i175_paint)
    //<item>Togo<item>
    //private val i176 = intArrayOf(R.drawable.i176_animal, R.drawable.i176_flag, R.drawable.i176_food, R.drawable.i176_lang,  R.drawable.i176_paint)
    //<item>Tonga<item>
    //private val i177 = intArrayOf(R.drawable.i177_animal, R.drawable.i177_flag, R.drawable.i177_food, R.drawable.i177_lang,  R.drawable.i177_paint)
    //<item>Trinidad and Tobago<item>
    //private val i178 = intArrayOf(R.drawable.i178_animal, R.drawable.i178_flag, R.drawable.i178_food, R.drawable.i178_lang,  R.drawable.i178_paint)
    //<item>Tunisia<item>
    //private val i179 = intArrayOf(R.drawable.i179_animal, R.drawable.i179_flag, R.drawable.i179_food, R.drawable.i179_lang,  R.drawable.i179_paint)
    //<item>Turkey<item>
    //private val i180 = intArrayOf(R.drawable.i180_animal, R.drawable.i180_flag, R.drawable.i180_food, R.drawable.i180_lang,  R.drawable.i180_paint)
    //<item>Turkmenistan<item>
    //private val i181 = intArrayOf(R.drawable.i181_animal, R.drawable.i181_flag, R.drawable.i181_food, R.drawable.i181_lang,  R.drawable.i181_paint)
    //<item>Tuvalu<item>
    //private val i182 = intArrayOf(R.drawable.i182_animal, R.drawable.i182_flag, R.drawable.i182_food, R.drawable.i182_lang,  R.drawable.i182_paint)
    //<item>Uganda<item>
    //private val i183 = intArrayOf(R.drawable.i183_animal, R.drawable.i183_flag, R.drawable.i183_food, R.drawable.i183_lang,  R.drawable.i183_paint)
    //<item>Ukraine<item>
    //private val i184 = intArrayOf(R.drawable.i184_animal, R.drawable.i184_flag, R.drawable.i184_food, R.drawable.i184_lang,  R.drawable.i184_paint)
    //<item>United Arab Emirates<item>
    //private val i185 = intArrayOf(R.drawable.i185_animal, R.drawable.i185_flag, R.drawable.i185_food, R.drawable.i185_lang,  R.drawable.i185_paint)
    //<item>United Kingdom<item>
    //private val i186 = intArrayOf(R.drawable.i186_animal, R.drawable.i186_flag, R.drawable.i186_food, R.drawable.i186_lang,  R.drawable.i186_paint)
    //<item>United States of America<item>
    //private val i187 = intArrayOf(R.drawable.i187_animal, R.drawable.i187_flag, R.drawable.i187_food, R.drawable.i187_lang,  R.drawable.i187_paint)
    //<item>Uruguay<item>
    //private val i188 = intArrayOf(R.drawable.i188_animal, R.drawable.i188_flag, R.drawable.i188_food, R.drawable.i188_lang,  R.drawable.i188_paint)
    //<item>Uzbekistan<item>
    //private val i189 = intArrayOf(R.drawable.i189_animal, R.drawable.i189_flag, R.drawable.i189_food, R.drawable.i189_lang,  R.drawable.i189_paint)
    //<item>Vanuatu<item>
    //private val i190 = intArrayOf(R.drawable.i190_animal, R.drawable.i190_flag, R.drawable.i190_food, R.drawable.i190_lang,  R.drawable.i190_paint)
    //<item>Venezuela<item>
    //private val i191 = intArrayOf(R.drawable.i191_animal, R.drawable.i191_flag, R.drawable.i191_food, R.drawable.i191_lang,  R.drawable.i191_paint)
    //<item>Vietnam<item>
    //private val i192 = intArrayOf(R.drawable.i192_animal, R.drawable.i192_flag, R.drawable.i192_food, R.drawable.i192_lang,  R.drawable.i192_paint)
    //<item>Yemen<item>
    //private val i193 = intArrayOf(R.drawable.i193_animal, R.drawable.i193_flag, R.drawable.i193_food, R.drawable.i193_lang,  R.drawable.i193_paint)
    //<item>Zambia<item>
    //private val i194 = intArrayOf(R.drawable.i194_animal, R.drawable.i194_flag, R.drawable.i194_food, R.drawable.i194_lang,  R.drawable.i194_paint)
    //<item>Zimbabwe<item>
    //private val i195 = intArrayOf(R.drawable.i195_animal, R.drawable.i195_flag, R.drawable.i195_food, R.drawable.i195_lang,  R.drawable.i195_paint)


    private val countryCoordArr = arrayOf(
        arrayOf(33.9391, 67.709953),
        arrayOf(41.15333, 20.168331),
        arrayOf(28.03388, 1.659626),
        arrayOf(42.54624, 1.601554),
        arrayOf(-11.20269, 17.873887),
        arrayOf(17.06081, -61.796428),
        arrayOf(-38.41609, -63.616672),
        arrayOf(40.06909, 45.038189),
        arrayOf(-25.27439, 133.775136),
        arrayOf(47.51623, 14.550072),
        arrayOf(40.14310, 47.576927),
        arrayOf(25.0342, -77.39628),
        arrayOf(25.93041, 50.637772),
        arrayOf(23.68499, 90.356331),
        arrayOf(13.19388, -59.543198),
        arrayOf(53.70980, 27.953389),
        arrayOf(50.50388, 4.469936),
        arrayOf(17.18987, -88.49765),
        arrayOf(9.3076, 2.315834),
        arrayOf(27.51416, 90.433601),
        arrayOf(-16.29015, -63.588653),
        arrayOf(43.91588, 17.679076),
        arrayOf(-22.32847, 24.684866),
        arrayOf(-14.23500, -51.92528),
        arrayOf(4.53527, 114.727669),
        arrayOf(42.73388, 25.48583),
        arrayOf(12.23833, -1.561593),
        arrayOf(-3.37305, 29.918886),
        arrayOf(7.53998, -5.54708),
        arrayOf(16.00208, -24.013197),
        arrayOf(12.56567, 104.990963),
        arrayOf(7.36972, 12.354722),
        arrayOf(56.13036, -106.346771),
        arrayOf(6.61111, 20.939444),
        arrayOf(15.45416, 18.732207),
        arrayOf(-35.67514, -71.542969),
        arrayOf(35.8616, 104.195397),
        arrayOf(4.57086, -74.297333),
        arrayOf(-11.87500, 43.872219),
        arrayOf(-4.03833, 21.758664),
        arrayOf(9.74891, -83.753428),
        arrayOf(45.1, 15.2),
        arrayOf(21.52175, -77.781167),
        arrayOf(35.12641, 33.429859),
        arrayOf(49.81749, 15.472962),
        arrayOf(-0.22802, 15.827659),
        arrayOf(56.2639, 9.501785),
        arrayOf(11.82513, 42.590275),
        arrayOf(15.41499, -61.370976),
        arrayOf(18.73569, -70.162651),
        arrayOf(-1.83123, -78.183406),
        arrayOf(26.82055, 30.802498),
        arrayOf(13.79418, -88.89653),
        arrayOf(1.65080, 10.267895),
        arrayOf(15.17938, 39.782334),
        arrayOf(58.59527, 25.013607),
        arrayOf(-26.52250, 31.465866),
        arrayOf(9.14, 40.489673),
        arrayOf(-16.57819, 179.414413),
        arrayOf(61.9241, 25.748151),
        arrayOf(46.22763, 2.213749),
        arrayOf(-0.80368, 11.609444),
        arrayOf(13.44318, -15.310139),
        arrayOf(42.31540, 43.356892),
        arrayOf(51.16569, 10.451526),
        arrayOf(7.94652, -1.023194),
        arrayOf(39.07420, 21.824312),
        arrayOf(12.26277, -61.604171),
        arrayOf(15.78347, -90.230759),
        arrayOf(9.94558, -9.696645),
        arrayOf(11.80374, -15.180413),
        arrayOf(4.86041, -58.93018),
        arrayOf(18.97118, -72.285215),
        arrayOf(41.90291, 12.453389),
        arrayOf(15.19999, -86.241905),
        arrayOf(47.16249, 19.503304),
        arrayOf(64.96305, -19.020835),
        arrayOf(20.59368, 78.96288),
        arrayOf(-0.78927, 113.921327),
        arrayOf(32.42790, 53.688046),
        arrayOf(33.22319, 43.679291),
        arrayOf(53.4129, -8.24389),
        arrayOf(31.04605, 34.851612),
        arrayOf(41.8719, 12.56738),
        arrayOf(18.10958, -77.297508),
        arrayOf(36.20482, 138.252924),
        arrayOf(30.58516, 36.238414),
        arrayOf(48.01957, 66.923684),
        arrayOf(-0.02355, 37.906193),
        arrayOf(-3.37041, -168.734039),
        arrayOf(29.3116, 47.481766),
        arrayOf(41.2043, 74.766098),
        arrayOf(19.8562, 102.495496),
        arrayOf(56.87963, 24.603189),
        arrayOf(33.85472, 35.862285),
        arrayOf(-29.60998, 28.233608),
        arrayOf(6.42805, -9.429499),
        arrayOf(26.335, 17.228331),
        arrayOf(47.16, 9.555373),
        arrayOf(55.16943, 23.881275),
        arrayOf(49.81527, 6.129583),
        arrayOf(-18.76694, 46.869107),
        arrayOf(-13.25430, 34.301525),
        arrayOf(4.21048, 101.975766),
        arrayOf(3.20277, 73.22068),
        arrayOf(17.57069, -3.996166),
        arrayOf(35.93749, 14.375416),
        arrayOf(7.13147, 171.184478),
        arrayOf(21.0078, -10.940835),
        arrayOf(-20.34840, 57.552152),
        arrayOf(23.63450, -102.552784),
        arrayOf(7.42555, 150.550812),
        arrayOf(47.41163, 28.369885),
        arrayOf(43.75029, 7.412841),
        arrayOf(46.86249, 103.846656),
        arrayOf(42.70867, 19.37439),
        arrayOf(31.79170, -7.09262),
        arrayOf(-18.66569, 35.529562),
        arrayOf(21.91396, 95.956223),
        arrayOf(-22.9576, 18.49041),
        arrayOf(-0.52277, 166.931503),
        arrayOf(28.39485, 84.124008),
        arrayOf(52.13263, 5.291266),
        arrayOf(-40.90055, 174.885971),
        arrayOf(12.86541, -85.207229),
        arrayOf(17.60778, 8.081666),
        arrayOf(9.08199, 8.675277),
        arrayOf(40.33985, 127.510093),
        arrayOf(41.60863, 21.745275),
        arrayOf(60.47202, 8.468946),
        arrayOf(21.51258, 55.923255),
        arrayOf(30.37532, 69.345116),
        arrayOf(7.5149, 134.58252),
        arrayOf(31.04605, 34.851612),
        arrayOf(8.53798, -80.782127),
        arrayOf(-6.31499, 143.95555),
        arrayOf(-23.44250, -58.443832),
        arrayOf(-9.18996, -75.015152),
        arrayOf(12.87972, 121.774017),
        arrayOf(51.91943, 19.145136),
        arrayOf(39.39987, -8.224454),
        arrayOf(25.35482, 51.183884),
        arrayOf(45.94316, 24.96676),
        arrayOf(61.5240, 105.318756),
        arrayOf(-1.94027, 29.873888),
        arrayOf(17.35782, -62.782998),
        arrayOf(13.90944, -60.978893),
        arrayOf(12.98430, -61.287228),
        arrayOf(-13.75902, -172.104629),
        arrayOf(43.9423, 12.457777),
        arrayOf(0.1863, 6.613081),
        arrayOf(23.88594, 45.079162),
        arrayOf(14.49740, -14.452362),
        arrayOf(44.01652, 21.005859),
        arrayOf(-4.67957, 55.491977),
        arrayOf(8.46055, -11.779889),
        arrayOf(1.35208, 103.819836),
        arrayOf(48.66902, 19.699024),
        arrayOf(46.15124, 14.995463),
        arrayOf(-9.6457, 160.156194),
        arrayOf(5.15214, 46.199616),
        arrayOf(-30.55948, 22.937506),
        arrayOf(35.90775, 127.766922),
        arrayOf(40.46366, -3.74922),
        arrayOf(7.87305, 80.771797),
        arrayOf(12.86280, 30.217636),
        arrayOf(3.91930, -56.027783),
        arrayOf(60.12816, 18.643501),
        arrayOf(46.81818, 8.227512),
        arrayOf(34.80207, 38.996815),
        arrayOf(23.6978, 120.960515),
        arrayOf(38.86103, 71.276093),
        arrayOf(-6.36902, 34.888822),
        arrayOf(15.87003, 100.992541),
        arrayOf(-8.87421, 125.727539),
        arrayOf(8.61954, 0.824782),
        arrayOf(-21.17898, -175.198242),
        arrayOf(10.69180, -61.222503),
        arrayOf(33.88691, 9.537499),
        arrayOf(38.96374, 35.243322),
        arrayOf(38.96971, 59.556278),
        arrayOf(-7.10953, 177.64933),
        arrayOf(1.37333, 32.290275),
        arrayOf(48.37943, 31.16558),
        arrayOf(23.42407, 53.847818),
        arrayOf(55.37805, -3.435973),
        arrayOf(37.0902, -95.712891),
        arrayOf(-32.52277, -55.765835),
        arrayOf(41.37749, 64.585262),
        arrayOf(-15.37670, 166.959158),
        arrayOf(6.4237, -66.58973),
        arrayOf(14.05832, 108.277199),
        arrayOf(15.55272, 48.516388),
        arrayOf(-13.13389, 27.849332),
        arrayOf(-19.01543, 29.154857),
        )

    // Order of the hints to be shown
    private var order = intArrayOf(0, 4, 2, 3, 1)
    /*
    * For the simplicity of randomly selecting an answer country without a pattern. The country entries
    * are added as elements in a 2-Dimensional array. Each variable such as "i001" is a country within
    * the array, along with their associated images.
    */
    private var arr = arrayOf(i001, i002, i003, i004, i005, i006, i007, i008, i009, i010, i011, i012, i013, i014, i015, i016, i017, i018, i019, i020, i021, i022, i023, i024, i025, i026, i027, i028, i029, i030, i031, i032, i033, i034, i035, i036, i037, i038, i039,
        i040, i041, i042, i043, i044, i045, i046, i047, i048, i049, i050, i051, i052, i053, i054, i055, i056, i057, i058, i059, i060, i061, i062, i063, i064, i065, i066, i067, i068, i069, i070, i071, i072, i073, i074, i075, i076, i077, i078,
        i079, i080, i081, i082, i083, i084, i085, i086, i087, i088, i089, i090)
    /*
    * This array of Strings contains all of the corresponding text answers for each country.
    * Each answer is matched to the array of countries per index for chronological orders sake of organisation.
    * More String answer elements will be added in the future.
     */
    private var answers = arrayOf("Afghanistan", "Albania", "Algeria", "Andorra", "Angola", "Antigua and Barbuda", "Argentina",
        "Armenia", "Australia", "Austria", "Azerbaijan", "Bahamas", "Bahrain", "Bangladesh", "Barbados", "Belarus", "Belgium",
        "Belize", "Benin", "Bhutan", "Bolivia", "Bosnia and Herzegovina", "Botswana", "Brazil", "Brunei", "Bulgaria",
        "Burkina Faso", "Burundi", "Côte d'Ivoire", "Cabo Verde", "Cambodia", "Cameroon", "Canada", "Central African Republic",
        "Chad", "Chile", "China", "Colombia", "Comoros", "Republic of the Congo", "Costa Rica", "Croatia", "Cuba", "Cyprus",
        "Czechia (Czech Republic)", "Democratic Republic of the Congo", "Denmark", "Djibouti", "Dominica", "Dominican Republic",
        "Ecuador", "Egypt", "El Salvador", "Equatorial Guinea", "Eritrea", "Estonia", "Eswatini", "Ethiopia", "Fiji", "Finland",
        "France", "Gabon", "Gambia", "Georgia", "Germany", "Ghana", "Greece", "Grenada", "Guatemala", "Guinea", "Guinea-Bissau",
        "Guyana", "Haiti", "Holy See", "Honduras", "Hungary", "Iceland", "India", "Indonesia", "Iran", "Iraq", "Ireland", "Israel",
        "Italy", "Jamaica", "Japan", "Jordan", "Kazakhstan", "Kenya", "Kiribati", "Kuwait", "Kyrgyzstan", "Laos", "Latvia", "Lebanon",
        "Lesotho", "Liberia", "Libya", "Liechtenstein", "Lithuania", "Luxembourg", "Madagascar", "Malawi", "Malaysia", "Maldives", "Mali",
        "Malta", "Marshall Islands", "Mauritania", "Mauritius", "Mexico", "Micronesia", "Moldova", "Monaco", "Mongolia", "Montenegro", "Morocco",
        "Mozambique", "Myanmar (formerly Burma)", "Namibia", "Nauru", "Nepal", "Netherlands", "New Zealand", "Nicaragua", "Niger", "Nigeria",
        "North Korea", "North Macedonia", "Norway", "Oman", "Pakistan", "Palau", "Palestine State", "Panama", "Papua New Guinea", "Paraguay",
        "Peru", "Philippines", "Poland", "Portugal", "Qatar", "Romania", "Russia", "Rwanda", "Saint Kitts and Nevis", "Saint Lucia",
        "Saint Vincent and the Grenadines", "Samoa", "San Marino", "Sao Tome and Principe", "Saudi Arabia", "Senegal", "Serbia", "Seychelles",
        "Sierra Leone", "Singapore", "Slovakia", "Slovenia", "Solomon Islands", "Somalia", "South Africa", "South Korea", "South Sudan", "Spain",
        "Sri Lanka", "Sudan", "Suriname", "Sweden", "Switzerland", "Syria", "Tajikistan", "Tanzania", "Thailand", "Timor-Leste", "Togo", "Tonga",
        "Trinidad and Tobago", "Tunisia", "Turkey", "Turkmenistan", "Tuvalu", "Uganda", "Ukraine", "United Arab Emirates", "United Kingdom",
        "United States of America", "Uruguay", "Uzbekistan", "Vanuatu", "Venezuela", "Vietnam", "Yemen", "Zambia", "Zimbabwe")


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
    private var todaysCountry = "NONE"
    private val rnd = Random()
    private var todayCountry = rnd.nextInt(arr.size)
    private var currentIndex = 0
    private var hintDisplay: TextView? = null
    private var hints = arrayOf("Hint 1/5: National Animal", "Hint 2/5: National Artwork", "Hint 3/5: National Cuisine", "Hint 4/5: National Languages", "Hint 5/5: National Flag")
    private var distances = arrayOf("", "", "", "", "")
    private var guessDistance: TextView? = null


    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        hintDisplay = findViewById<TextView>(R.id.hintTitleTextView)
        // creates a random index column number for the 2-dimensional array so a country entry containing
        // images is chosen at random.
        val correctAnsButtonSound = MediaPlayer.create(this, R.raw.sound_byte_5)
        val incorrectAnsButtonSound = MediaPlayer.create(this, R.raw.sound_byte_3)

        val dailyMode = intent.getBooleanExtra("dailyMode", false)
        if(dailyMode) {
            todayCountry = getTodayNumber()
            val preferenceManager = PreferenceManager()
            val gamesPlayed = preferenceManager.getIntValue("gamesPlayed",this)
            preferenceManager.setIntPreference("gamesPlayed", gamesPlayed + 1,this)
            preferenceManager.setIntPreference("attemptedDaily", 1, this)
        }

        // This variable is dynamically used to produce a random int number for the 2-dimensional array based on the
        // number of elements it contains. This variable number range will be updated when the completion of more countries can be
        // entered.
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

        val leftBtn = findViewById<ImageButton>(R.id.leftButton)
        leftBtn.setOnClickListener {
            if(currentIndex > 0){
                updateVariables(currentIndex-1)
                currentIndex--
            }
        }
        val rightBtn = findViewById<ImageButton>(R.id.rightButton)
        rightBtn.setOnClickListener {
            if(currentIndex < 4 && currentIndex < i){
                updateVariables(currentIndex+1)
                currentIndex++
            }
        }

        val guessBtn = findViewById<ImageButton>(R.id.guessButton)
        // This if statement block is used to compare the guess country entered by the user
        // to the country held as an answer by the game
        if (guessBtn != null) {
            guessBtn.setOnClickListener {
                /*
                button_sound.start()
                 */
                enteredText = autotextView.text.toString()
                //val enteredText = getString(R.string.submitted_country) + " " + autotextView.getText()
            }
            //val textView = findViewById<AutoCompleteTextView>(R.id.autoTextView)
            val countryResources = resources.getStringArray(R.array.Countries)
            val countryAdapter = ArrayAdapter(
                this,
                android.R.layout.simple_list_item_1, countryResources
            )
            autotextView.setAdapter(countryAdapter)
            flag = true
            //b1 = findViewById<View>(R.id.guessButton) as Button
            iv = findViewById<View>(R.id.hintImage) as ImageView?
            iv!!.setImageResource(arr[todayCountry][0])
            guessBtn.setOnClickListener {
                //guessBtn!!.setOnClickListener {
                enteredText = autotextView.text.toString()

                todaysCountry = answers[todayCountry]

                // These blocks of if and else statements are used to determine if the user has entered
                // a guess which results in a win or a loss that the user is directed to either the loss
                // page of the game or then win page which displays the points and gains of their attempts.
                if (enteredText == answers[todayCountry]) {
                    // this line of code plays the correct button sound.
                    correctAnsButtonSound.start()
                    val intent = Intent(this, WinScreen::class.java)
                    intent.putExtra("todaysCountry", todaysCountry)
                    intent.putExtra("todaysFlag", arr[todayCountry])
                    intent.putExtra("dailyMode", dailyMode)
                    intent.putExtra("numGuesses", numGuesses)
                    startActivity(intent)
                    // if this if statement condition results as true. This win page is displayed
                    // if the enteredText variable by the user matches the random text value selected
                    // from the answers array. The answer is picked by the random number generator value.
                } else {
                    // if this if statement condition results as a False Boolean value, the incorrect
                    // answer is removed from the text box component.
                    autotextView.text.clear()
                    incorrectAnsButtonSound.start()
                    val currentIndex = answers.indexOf(todaysCountry)
                    var guessIndex = 0
                    if (answers.indexOf(enteredText) != -1) {
                        guessIndex = answers.indexOf(enteredText)
                    }
                    val lat1 = countryCoordArr[guessIndex][0]
                    val lon1 = countryCoordArr[guessIndex][1]
                    val lat2 = countryCoordArr[currentIndex][0]
                    val lon2 = countryCoordArr[currentIndex][1]
                    guessDistance = findViewById<TextView>(R.id.distGuess)
                    val distance = calcDistance(lat1, lon1, lat2, lon2)
                    if (answers.indexOf(enteredText) != -1) {
                        guessDistance?.text = "Your guess (" + enteredText + ") is ~" + distance.toInt() + "km from the target country."
                        distances[i] = "Your guess (" + enteredText + ") is ~" + distance.toInt() + "km from the target country."
                    } else {
                        guessDistance?.text = "Your guess is not a valid country. Unknown distance from the target country."
                        distances[i] = "Your guess is not a valid country. Unknown distance from the target country."
                    }
                    hintDisplay = findViewById<TextView>(R.id.hintTitleTextView)
                    if(i != 4) {
                        hintDisplay?.text = hints[i + 1]
                    }
                }
                // This if statement executes if the maximum number of guesses has been attempted per
                // daily game. if the iterator variable for the number of games is equal to 5 the game
                // displays its end screen.
                if (i == 4) {
                    val intent = Intent(this, EndScreen::class.java)
                    intent.putExtra("todaysCountry", todaysCountry)
                    intent.putExtra("todaysFlag", arr[todayCountry])
                    intent.putExtra("dailyMode", dailyMode)
                    startActivity(intent)
                }
                // This if statement executes if the  number of guesses attempted per
                // daily game is less than the limit. This variable increases for the number guess attempts
                // entered by the user. When this variable increments higher a new image is displayed in
                // the setImageResource variable from the array of country images.
                if (i < 4) {
                    i++
                    currentIndex = i
                    numGuesses++
                }
                iv!!.setImageResource(arr[todayCountry][order[i]])
            }
        }
    }

    private fun calcDistance(lat1: Double, lon1: Double, lat2: Double, lon2: Double): Double {
        val r = 6371 // Radius of the earth in km
        val dLat = deg2rad(lat2 - lat1)  // deg2rad below
        val dLon = deg2rad(lon2 - lon1)
        val a =
            kotlin.math.sin(dLat / 2) * kotlin.math.sin(dLat / 2) +
                    kotlin.math.cos(deg2rad(lat1)) * kotlin.math.cos(deg2rad(lat2)) *
                    kotlin.math.sin(dLon / 2) * kotlin.math.sin(dLon / 2)

        val c = 2 * kotlin.math.atan2(kotlin.math.sqrt(a), kotlin.math.sqrt(1 - a))
        return r * c
    }

    private fun deg2rad(deg : Double) : Double {
        return deg * (PI/180)
    }

    @SuppressLint("SimpleDateFormat")
    private fun getTodayNumber() : Int{
        val sdf1 = SimpleDateFormat("dd")
        val sdf2 = SimpleDateFormat("M")
        val currentDate1 = sdf1.format(Date())
        val currentDate2 = sdf2.format(Date())
        val day = currentDate1.toInt()
        val month = currentDate2.toInt()
        return if(day * month <= 90){
            day * month
        } else{
            day + month
        }
    }

    private fun updateVariables(target : Int){
        guessDistance = findViewById<TextView>(R.id.distGuess)
        hintDisplay = findViewById<TextView>(R.id.hintTitleTextView)
        iv!!.setImageResource(arr[todayCountry][order[target]])
        hintDisplay?.text = hints[target]
        guessDistance?.text = distances[target]
    }
}
