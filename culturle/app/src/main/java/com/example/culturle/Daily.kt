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
    //        <item>Antigua and Barbuda</item>
    private val i001 = intArrayOf(R.drawable.i001_animal, R.drawable.i001_flag, R.drawable.i001_food, R.drawable.i001_lang,  R.drawable.i001_paint)
    //        <item>Argentina</item>
    private val i002 = intArrayOf(R.drawable.i002_animal, R.drawable.i002_flag, R.drawable.i002_food, R.drawable.i002_lang,  R.drawable.i002_paint)
    //        <item>Armenia</item>
    private val i003 = intArrayOf(R.drawable.i003_animal, R.drawable.i003_flag, R.drawable.i003_food, R.drawable.i003_lang,  R.drawable.i003_paint)
    //        <item>Australia</item>
    private val i004 = intArrayOf(R.drawable.i004_animal, R.drawable.i004_flag, R.drawable.i004_food, R.drawable.i004_lang,  R.drawable.i004_paint)
    //        <item>Austria</item>
    private val i005 = intArrayOf(R.drawable.i005_animal, R.drawable.i005_flag, R.drawable.i005_food, R.drawable.i005_lang,  R.drawable.i005_paint)
    //        <item>Azerbaijan</item>
    private val i006 = intArrayOf(R.drawable.i006_animal, R.drawable.i006_flag, R.drawable.i006_food, R.drawable.i006_lang,  R.drawable.i006_paint)
    //        <item>Bahamas</item>
    private val i007 = intArrayOf(R.drawable.i007_animal, R.drawable.i007_flag, R.drawable.i007_food, R.drawable.i007_lang,  R.drawable.i007_paint)
    //        <item>Bahrain</item>
    private val i008 = intArrayOf(R.drawable.i008_animal, R.drawable.i008_flag, R.drawable.i008_food, R.drawable.i008_lang,  R.drawable.i008_paint)
    //        <item>Bangladesh</item>
    private val i009 = intArrayOf(R.drawable.i009_animal, R.drawable.i009_flag, R.drawable.i009_food, R.drawable.i009_lang,  R.drawable.i009_paint)
    //        <item>Barbados</item>
    private val i010 = intArrayOf(R.drawable.i010_animal, R.drawable.i010_flag, R.drawable.i010_food, R.drawable.i010_lang,  R.drawable.i010_paint)
    //        <item>Belarus</item>
    private val i011 = intArrayOf(R.drawable.i011_animal, R.drawable.i011_flag, R.drawable.i011_food, R.drawable.i011_lang,  R.drawable.i011_paint)
    //        <item>Belgium</item>
    private val i012 = intArrayOf(R.drawable.i012_animal, R.drawable.i012_flag, R.drawable.i012_food, R.drawable.i012_lang,  R.drawable.i012_paint)
    //        <item>Belize</item>
    private val i013 = intArrayOf(R.drawable.i013_animal, R.drawable.i013_flag, R.drawable.i013_food, R.drawable.i013_lang,  R.drawable.i013_paint)
    //        <item>Benin</item>
    private val i014 = intArrayOf(R.drawable.i014_animal, R.drawable.i014_flag, R.drawable.i014_food, R.drawable.i014_lang,  R.drawable.i014_paint)
    //        <item>Bhutan</item>
    private val i015 = intArrayOf(R.drawable.i015_animal, R.drawable.i015_flag, R.drawable.i015_food, R.drawable.i015_lang,  R.drawable.i015_paint)
    //        <item>Bolivia</item>
    private val i016 = intArrayOf(R.drawable.i016_animal, R.drawable.i016_flag, R.drawable.i016_food, R.drawable.i016_lang,  R.drawable.i016_paint)
    //        <item>Bosnia Herzegovina</item>
    private val i017 = intArrayOf(R.drawable.i017_animal, R.drawable.i017_flag, R.drawable.i017_food, R.drawable.i017_lang,  R.drawable.i017_paint)
    //        <item>Botswana</item>
    private val i018 = intArrayOf(R.drawable.i018_animal, R.drawable.i018_flag, R.drawable.i018_food, R.drawable.i018_lang,  R.drawable.i018_paint)
    //        <item>Brazil</item>
    private val i019 = intArrayOf(R.drawable.i019_animal, R.drawable.i019_flag, R.drawable.i019_food, R.drawable.i019_lang,  R.drawable.i019_paint)
    //        <item>Brunei</item>
    private val i020 = intArrayOf(R.drawable.i020_animal, R.drawable.i020_flag, R.drawable.i020_food, R.drawable.i020_lang,  R.drawable.i020_paint)
    //        <item>Bulgaria</item>
    private val i021 = intArrayOf(R.drawable.i021_animal, R.drawable.i021_flag, R.drawable.i021_food, R.drawable.i021_lang,  R.drawable.i021_paint)
    //        <item>Burkina Faso</item>
    private val i022 = intArrayOf(R.drawable.i022_animal, R.drawable.i022_flag, R.drawable.i022_food, R.drawable.i022_lang,  R.drawable.i022_paint)
    //        <item>Burundi</item>
    private val i023 = intArrayOf(R.drawable.i023_animal, R.drawable.i023_flag, R.drawable.i023_food, R.drawable.i023_lang,  R.drawable.i023_paint)
    //        <item>Cabo Verde</item>
    private val i024 = intArrayOf(R.drawable.i024_animal, R.drawable.i024_flag, R.drawable.i024_food, R.drawable.i024_lang,  R.drawable.i024_paint)
    //        <item>Cambodia</item>
    private val i025 = intArrayOf(R.drawable.i025_animal, R.drawable.i025_flag, R.drawable.i025_food, R.drawable.i025_lang,  R.drawable.i025_paint)
    //        <item>Cameroon</item>
    private val i026 = intArrayOf(R.drawable.i026_animal, R.drawable.i026_flag, R.drawable.i026_food, R.drawable.i026_lang,  R.drawable.i026_paint)
    //        <item>Canada</item>
    private val i027 = intArrayOf(R.drawable.i027_animal, R.drawable.i027_flag, R.drawable.i027_food, R.drawable.i027_lang,  R.drawable.i027_paint)
    //        <item>Central African Republic</item>
    private val i028 = intArrayOf(R.drawable.i028_animal, R.drawable.i028_flag, R.drawable.i028_food, R.drawable.i028_lang,  R.drawable.i028_paint)
    //        <item>Chad</item>
    private val i029 = intArrayOf(R.drawable.i029_animal, R.drawable.i029_flag, R.drawable.i029_food, R.drawable.i029_lang,  R.drawable.i029_paint)
    //        <item>Chile</item>
    private val i030 = intArrayOf(R.drawable.i030_animal, R.drawable.i030_flag, R.drawable.i030_food, R.drawable.i030_lang,  R.drawable.i030_paint)
    //        <item>China</item>
    private val i031 = intArrayOf(R.drawable.i031_animal, R.drawable.i031_flag, R.drawable.i031_food, R.drawable.i031_lang,  R.drawable.i031_paint)
    //        <item>Colombia</item>
    private val i032 = intArrayOf(R.drawable.i032_animal, R.drawable.i032_flag, R.drawable.i032_food, R.drawable.i032_lang,  R.drawable.i032_paint)
    //        <item>Comoros</item>
    private val i033 = intArrayOf(R.drawable.i033_animal, R.drawable.i033_flag, R.drawable.i033_food, R.drawable.i033_lang,  R.drawable.i033_paint)
    //        <item>Congo</item>
    private val i034 = intArrayOf(R.drawable.i034_animal, R.drawable.i034_flag, R.drawable.i034_food, R.drawable.i034_lang,  R.drawable.i034_paint)
    //        <item>Costa Rica</item>
    private val i035 = intArrayOf(R.drawable.i035_animal, R.drawable.i035_flag, R.drawable.i035_food, R.drawable.i035_lang,  R.drawable.i035_paint)
    //        <item>Côte d’Ivoire</item>
    private val i036 = intArrayOf(R.drawable.i036_animal, R.drawable.i036_flag, R.drawable.i036_food, R.drawable.i036_lang,  R.drawable.i036_paint)
    //        <item>Croatia</item>
    private val i037 = intArrayOf(R.drawable.i037_animal, R.drawable.i037_flag, R.drawable.i037_food, R.drawable.i037_lang,  R.drawable.i037_paint)
    //        <item>Cuba</item>
    private val i038 = intArrayOf(R.drawable.i038_animal, R.drawable.i038_flag, R.drawable.i038_food, R.drawable.i038_lang,  R.drawable.i038_paint)
    //        <item>Cyprus</item>
    private val i039 = intArrayOf(R.drawable.i039_animal, R.drawable.i039_flag, R.drawable.i039_food, R.drawable.i039_lang,  R.drawable.i039_paint)
    //        <item>Czech Republic</item>
    private val i040 = intArrayOf(R.drawable.i040_animal, R.drawable.i040_flag, R.drawable.i040_food, R.drawable.i040_lang,  R.drawable.i040_paint)
    //        <item>Denmark</item>
    private val i041 = intArrayOf(R.drawable.i041_animal, R.drawable.i041_flag, R.drawable.i041_food, R.drawable.i041_lang,  R.drawable.i041_paint)
    //        <item>Djibouti</item>
    private val i042 = intArrayOf(R.drawable.i042_animal, R.drawable.i042_flag, R.drawable.i042_food, R.drawable.i042_lang,  R.drawable.i042_paint)
    //        <item>Dominica</item>
    private val i043 = intArrayOf(R.drawable.i043_animal, R.drawable.i043_flag, R.drawable.i043_food, R.drawable.i043_lang,  R.drawable.i043_paint)
    //        <item>Dominican Republic</item>
    private val i044 = intArrayOf(R.drawable.i044_animal, R.drawable.i044_flag, R.drawable.i044_food, R.drawable.i044_lang,  R.drawable.i044_paint)
    //        <item>East Timor (Timor-Leste)</item>
    private val i045 = intArrayOf(R.drawable.i045_animal, R.drawable.i045_flag, R.drawable.i045_food, R.drawable.i045_lang,  R.drawable.i045_paint)
    //        <item>Ecuador</item>
    private val i046 = intArrayOf(R.drawable.i046_animal, R.drawable.i046_flag, R.drawable.i046_food, R.drawable.i046_lang,  R.drawable.i046_paint)
    //        <item>Egypt</item>
    private val i047 = intArrayOf(R.drawable.i047_animal, R.drawable.i047_flag, R.drawable.i047_food, R.drawable.i047_lang,  R.drawable.i047_paint)
    //        <item>El Salvador</item>
    private val i048 = intArrayOf(R.drawable.i048_animal, R.drawable.i048_flag, R.drawable.i048_food, R.drawable.i048_lang,  R.drawable.i048_paint)
    //        <item>Equatorial Guinea</item>
    private val i049 = intArrayOf(R.drawable.i049_animal, R.drawable.i049_flag, R.drawable.i049_food, R.drawable.i049_lang,  R.drawable.i049_paint)
    //        <item>Eritrea</item>
    private val i050 = intArrayOf(R.drawable.i050_animal, R.drawable.i050_flag, R.drawable.i050_food, R.drawable.i050_lang,  R.drawable.i050_paint)
    //        <item>Estonia</item>
    private val i051 = intArrayOf(R.drawable.i051_animal, R.drawable.i051_flag, R.drawable.i051_food, R.drawable.i051_lang,  R.drawable.i051_paint)
    //        <item>Eswatini</item>
    private val i052 = intArrayOf(R.drawable.i052_animal, R.drawable.i052_flag, R.drawable.i052_food, R.drawable.i052_lang,  R.drawable.i052_paint)
    //        <item>Ethiopia</item>
    private val i053 = intArrayOf(R.drawable.i053_animal, R.drawable.i053_flag, R.drawable.i053_food, R.drawable.i053_lang,  R.drawable.i053_paint)
    //        <item>Fiji</item>
    private val i054 = intArrayOf(R.drawable.i054_animal, R.drawable.i054_flag, R.drawable.i054_food, R.drawable.i054_lang,  R.drawable.i054_paint)
    //        <item>Finland</item>
    private val i055 = intArrayOf(R.drawable.i055_animal, R.drawable.i055_flag, R.drawable.i055_food, R.drawable.i055_lang,  R.drawable.i055_paint)
    //        <item>France</item>
    private val i056 = intArrayOf(R.drawable.i056_animal, R.drawable.i056_flag, R.drawable.i056_food, R.drawable.i056_lang,  R.drawable.i056_paint)
    //        <item>Gabon</item>
    private val i057 = intArrayOf(R.drawable.i057_animal, R.drawable.i057_flag, R.drawable.i057_food, R.drawable.i057_lang,  R.drawable.i057_paint)
    //        <item>The Gambia</item>
    private val i058 = intArrayOf(R.drawable.i058_animal, R.drawable.i058_flag, R.drawable.i058_food, R.drawable.i058_lang,  R.drawable.i058_paint)
    //        <item>Georgia</item>
    private val i059 = intArrayOf(R.drawable.i059_animal, R.drawable.i059_flag, R.drawable.i059_food, R.drawable.i059_lang,  R.drawable.i059_paint)
    //        <item>Germany</item>
    private val i060 = intArrayOf(R.drawable.i060_animal, R.drawable.i060_flag, R.drawable.i060_food, R.drawable.i060_lang,  R.drawable.i060_paint)
    //        <item>Ghana</item>
    private val i061 = intArrayOf(R.drawable.i061_animal, R.drawable.i061_flag, R.drawable.i061_food, R.drawable.i061_lang,  R.drawable.i061_paint)
    //        <item>Greece</item>
    private val i062 = intArrayOf(R.drawable.i062_animal, R.drawable.i062_flag, R.drawable.i062_food, R.drawable.i062_lang,  R.drawable.i062_paint)
    //        <item>Grenada</item>
    private val i063 = intArrayOf(R.drawable.i063_animal, R.drawable.i063_flag, R.drawable.i063_food, R.drawable.i063_lang,  R.drawable.i063_paint)
    //        <item>Guatemala</item>
    private val i064 = intArrayOf(R.drawable.i064_animal, R.drawable.i064_flag, R.drawable.i064_food, R.drawable.i064_lang,  R.drawable.i064_paint)
    //        <item>Guinea</item>
    private val i065 = intArrayOf(R.drawable.i065_animal, R.drawable.i065_flag, R.drawable.i065_food, R.drawable.i065_lang,  R.drawable.i065_paint)
    //        <item>Guinea-Bissau</item>
    private val i066 = intArrayOf(R.drawable.i066_animal, R.drawable.i066_flag, R.drawable.i066_food, R.drawable.i066_lang,  R.drawable.i066_paint)
    //        <item>Guyana</item>
    private val i067 = intArrayOf(R.drawable.i067_animal, R.drawable.i067_flag, R.drawable.i067_food, R.drawable.i067_lang,  R.drawable.i067_paint)
    //        <item>Haiti</item>
    private val i068 = intArrayOf(R.drawable.i068_animal, R.drawable.i068_flag, R.drawable.i068_food, R.drawable.i068_lang,  R.drawable.i068_paint)
    //        <item>Honduras</item>
    private val i069 = intArrayOf(R.drawable.i069_animal, R.drawable.i069_flag, R.drawable.i069_food, R.drawable.i069_lang,  R.drawable.i069_paint)
    //        <item>Hungary</item>
    private val i070 = intArrayOf(R.drawable.i070_animal, R.drawable.i070_flag, R.drawable.i070_food, R.drawable.i070_lang,  R.drawable.i070_paint)
    //        <item>Iceland</item>
    private val i071 = intArrayOf(R.drawable.i071_animal, R.drawable.i071_flag, R.drawable.i071_food, R.drawable.i071_lang,  R.drawable.i071_paint)
    //        <item>India</item>
    private val i072 = intArrayOf(R.drawable.i072_animal, R.drawable.i072_flag, R.drawable.i072_food, R.drawable.i072_lang,  R.drawable.i072_paint)
    //        <item>Indonesia</item>
    private val i073 = intArrayOf(R.drawable.i073_animal, R.drawable.i073_flag, R.drawable.i073_food, R.drawable.i073_lang,  R.drawable.i073_paint)
    //        <item>Iran</item>
    private val i074 = intArrayOf(R.drawable.i074_animal, R.drawable.i074_flag, R.drawable.i074_food, R.drawable.i074_lang,  R.drawable.i074_paint)
    //        <item>Iraq</item>
    private val i075 = intArrayOf(R.drawable.i075_animal, R.drawable.i075_flag, R.drawable.i075_food, R.drawable.i075_lang,  R.drawable.i075_paint)
    //        <item>Ireland</item>
    private val i076 = intArrayOf(R.drawable.i076_animal, R.drawable.i076_flag, R.drawable.i076_food, R.drawable.i076_lang,  R.drawable.i076_paint)
    //        <item>Israel</item>
    private val i077 = intArrayOf(R.drawable.i077_animal, R.drawable.i077_flag, R.drawable.i077_food, R.drawable.i077_lang,  R.drawable.i077_paint)
    //        <item>Italy</item>
    private val i078 = intArrayOf(R.drawable.i078_animal, R.drawable.i078_flag, R.drawable.i078_food, R.drawable.i078_lang,  R.drawable.i078_paint)
    //        <item>Jamaica</item>
    private val i079 = intArrayOf(R.drawable.i079_animal, R.drawable.i079_flag, R.drawable.i079_food, R.drawable.i079_lang,  R.drawable.i079_paint)
    //        <item>Japan</item>
    private val i080 = intArrayOf(R.drawable.i080_animal, R.drawable.i080_flag, R.drawable.i080_food, R.drawable.i080_lang,  R.drawable.i080_paint)
    //        <item>Jordan</item>
    private val i081 = intArrayOf(R.drawable.i081_animal, R.drawable.i081_flag, R.drawable.i081_food, R.drawable.i081_lang,  R.drawable.i081_paint)
    //        <item>Kazakhstan</item>
    private val i082 = intArrayOf(R.drawable.i082_animal, R.drawable.i082_flag, R.drawable.i082_food, R.drawable.i082_lang,  R.drawable.i082_paint)
    //        <item>Kenya</item>
    private val i083 = intArrayOf(R.drawable.i083_animal, R.drawable.i083_flag, R.drawable.i083_food, R.drawable.i083_lang,  R.drawable.i083_paint)
    //        <item>Kiribati</item>
    private val i084 = intArrayOf(R.drawable.i084_animal, R.drawable.i084_flag, R.drawable.i084_food, R.drawable.i084_lang,  R.drawable.i084_paint)
    //        <item>Korea, North</item>
    private val i085 = intArrayOf(R.drawable.i085_animal, R.drawable.i085_flag, R.drawable.i085_food, R.drawable.i085_lang,  R.drawable.i085_paint)
    //        <item>Korea, South</item>
    private val i086 = intArrayOf(R.drawable.i086_animal, R.drawable.i086_flag, R.drawable.i086_food, R.drawable.i086_lang,  R.drawable.i086_paint)
    //        <item>Kosovo</item>
    private val i087 = intArrayOf(R.drawable.i087_animal, R.drawable.i087_flag, R.drawable.i087_food, R.drawable.i087_lang,  R.drawable.i087_paint)
    //        <item>Kuwait</item>
    private val i088 = intArrayOf(R.drawable.i088_animal, R.drawable.i088_flag, R.drawable.i088_food, R.drawable.i088_lang,  R.drawable.i088_paint)
    //        <item>Kyrgyzstan</item>
    private val i089 = intArrayOf(R.drawable.i089_animal, R.drawable.i089_flag, R.drawable.i089_food, R.drawable.i089_lang,  R.drawable.i089_paint)
    //        <item>Laos</item>
    private val i090 = intArrayOf(R.drawable.i090_animal, R.drawable.i090_flag, R.drawable.i090_food, R.drawable.i090_lang,  R.drawable.i090_paint)
    //        <item>Latvia</item>
    private val i091 = intArrayOf(R.drawable.i091_animal, R.drawable.i091_flag, R.drawable.i091_food, R.drawable.i091_lang,  R.drawable.i091_paint)
    //        <item>Lebanon</item>
    private val i092 = intArrayOf(R.drawable.i092_animal, R.drawable.i092_flag, R.drawable.i092_food, R.drawable.i092_lang,  R.drawable.i092_paint)
    //        <item>Lesotho</item>
    private val i093 = intArrayOf(R.drawable.i093_animal, R.drawable.i093_flag, R.drawable.i093_food, R.drawable.i093_lang,  R.drawable.i093_paint)
    //        <item>Liberia</item>
    private val i094 = intArrayOf(R.drawable.i094_animal, R.drawable.i094_flag, R.drawable.i094_food, R.drawable.i094_lang,  R.drawable.i094_paint)
    //        <item>Libya</item>
    private val i095 = intArrayOf(R.drawable.i095_animal, R.drawable.i095_flag, R.drawable.i095_food, R.drawable.i095_lang,  R.drawable.i095_paint)
    //        <item>Liechtenstein</item>
    private val i096 = intArrayOf(R.drawable.i096_animal, R.drawable.i096_flag, R.drawable.i096_food, R.drawable.i096_lang,  R.drawable.i096_paint)
    //        <item>Lithuania</item>
    private val i097 = intArrayOf(R.drawable.i097_animal, R.drawable.i097_flag, R.drawable.i097_food, R.drawable.i097_lang,  R.drawable.i097_paint)
    //        <item>Luxembourg</item>
    private val i098 = intArrayOf(R.drawable.i098_animal, R.drawable.i098_flag, R.drawable.i098_food, R.drawable.i098_lang,  R.drawable.i098_paint)
    //        <item>Madagascar</item>
    private val i099 = intArrayOf(R.drawable.i099_animal, R.drawable.i099_flag, R.drawable.i099_food, R.drawable.i099_lang,  R.drawable.i099_paint)
    //        <item>Malawi</item>
    private val i100 = intArrayOf(R.drawable.i100_animal, R.drawable.i100_flag, R.drawable.i100_food, R.drawable.i100_lang,  R.drawable.i100_paint)
    //        <item>Malaysia</item>
    private val i101 = intArrayOf(R.drawable.i101_animal, R.drawable.i101_flag, R.drawable.i101_food, R.drawable.i101_lang,  R.drawable.i101_paint)
    //        <item>Maldives</item>
    private val i102 = intArrayOf(R.drawable.i102_animal, R.drawable.i102_flag, R.drawable.i102_food, R.drawable.i102_lang,  R.drawable.i102_paint)
    //        <item>Mali</item>
    private val i103 = intArrayOf(R.drawable.i103_animal, R.drawable.i103_flag, R.drawable.i103_food, R.drawable.i103_lang,  R.drawable.i103_paint)
    //        <item>Malta</item>
    private val i104 = intArrayOf(R.drawable.i104_animal, R.drawable.i104_flag, R.drawable.i104_food, R.drawable.i104_lang,  R.drawable.i104_paint)
    //        <item>Marshall Islands</item>
    private val i105 = intArrayOf(R.drawable.i105_animal, R.drawable.i105_flag, R.drawable.i105_food, R.drawable.i105_lang,  R.drawable.i105_paint)
    //        <item>Mauritania</item>
    private val i106 = intArrayOf(R.drawable.i106_animal, R.drawable.i106_flag, R.drawable.i106_food, R.drawable.i106_lang,  R.drawable.i106_paint)
    //        <item>Mauritius</item>
    private val i107 = intArrayOf(R.drawable.i107_animal, R.drawable.i107_flag, R.drawable.i107_food, R.drawable.i107_lang,  R.drawable.i107_paint)
    //        <item>Mexico</item>
    private val i108 = intArrayOf(R.drawable.i108_animal, R.drawable.i108_flag, R.drawable.i108_food, R.drawable.i108_lang,  R.drawable.i108_paint)
    //        <item>Moldova</item>
    private val i109 = intArrayOf(R.drawable.i109_animal, R.drawable.i109_flag, R.drawable.i109_food, R.drawable.i109_lang,  R.drawable.i109_paint)
    //        <item>Monaco</item>
    private val i110 = intArrayOf(R.drawable.i110_animal, R.drawable.i110_flag, R.drawable.i110_food, R.drawable.i110_lang,  R.drawable.i110_paint)
    //        <item>Mongolia</item>
    private val i111 = intArrayOf(R.drawable.i111_animal, R.drawable.i111_flag, R.drawable.i111_food, R.drawable.i111_lang,  R.drawable.i111_paint)
    //        <item>Montenegro</item>
    private val i112 = intArrayOf(R.drawable.i112_animal, R.drawable.i112_flag, R.drawable.i112_food, R.drawable.i112_lang,  R.drawable.i112_paint)
    //        <item>Morocco</item>
    private val i113 = intArrayOf(R.drawable.i113_animal, R.drawable.i113_flag, R.drawable.i113_food, R.drawable.i113_lang,  R.drawable.i113_paint)
    //        <item>Mozambique</item>
    private val i114 = intArrayOf(R.drawable.i114_animal, R.drawable.i114_flag, R.drawable.i114_food, R.drawable.i114_lang,  R.drawable.i114_paint)
    //        <item>Myanmar (Burma)</item>
    private val i115 = intArrayOf(R.drawable.i115_animal, R.drawable.i115_flag, R.drawable.i115_food, R.drawable.i115_lang,  R.drawable.i115_paint)
    //        <item>Namibia</item>
    private val i116 = intArrayOf(R.drawable.i116_animal, R.drawable.i116_flag, R.drawable.i116_food, R.drawable.i116_lang,  R.drawable.i116_paint)
    //        <item>Nauru</item>
    private val i117 = intArrayOf(R.drawable.i117_animal, R.drawable.i117_flag, R.drawable.i117_food, R.drawable.i117_lang,  R.drawable.i117_paint)
    //        <item>Nepal</item>
    private val i118 = intArrayOf(R.drawable.i118_animal, R.drawable.i118_flag, R.drawable.i118_food, R.drawable.i118_lang,  R.drawable.i118_paint)
    //        <item>Netherlands</item>
    private val i119 = intArrayOf(R.drawable.i119_animal, R.drawable.i119_flag, R.drawable.i119_food, R.drawable.i119_lang,  R.drawable.i119_paint)
    //        <item>New Zealand</item>
    private val i120 = intArrayOf(R.drawable.i120_animal, R.drawable.i120_flag, R.drawable.i120_food, R.drawable.i120_lang,  R.drawable.i120_paint)
    //        <item>Nicaragua</item>
    private val i121 = intArrayOf(R.drawable.i121_animal, R.drawable.i121_flag, R.drawable.i121_food, R.drawable.i121_lang,  R.drawable.i121_paint)
    //        <item>Niger</item>
    private val i122 = intArrayOf(R.drawable.i122_animal, R.drawable.i122_flag, R.drawable.i122_food, R.drawable.i122_lang,  R.drawable.i122_paint)
    //        <item>Nigeria</item>
    private val i123 = intArrayOf(R.drawable.i123_animal, R.drawable.i123_flag, R.drawable.i123_food, R.drawable.i123_lang,  R.drawable.i123_paint)
    //        <item>North Macedonia</item>
    private val i124 = intArrayOf(R.drawable.i124_animal, R.drawable.i124_flag, R.drawable.i124_food, R.drawable.i124_lang,  R.drawable.i124_paint)
    //        <item>Norway</item>
    private val i125 = intArrayOf(R.drawable.i125_animal, R.drawable.i125_flag, R.drawable.i125_food, R.drawable.i125_lang,  R.drawable.i125_paint)
    //        <item>Oman</item>
    private val i126 = intArrayOf(R.drawable.i126_animal, R.drawable.i126_flag, R.drawable.i126_food, R.drawable.i126_lang,  R.drawable.i126_paint)
    //        <item>Pakistan</item>
    private val i127 = intArrayOf(R.drawable.i127_animal, R.drawable.i127_flag, R.drawable.i127_food, R.drawable.i124_lang,  R.drawable.i124_paint)
    //        <item>Palau</item>
    private val i128 = intArrayOf(R.drawable.i128_animal, R.drawable.i128_flag, R.drawable.i128_food, R.drawable.i128_lang,  R.drawable.i128_paint)
    //        <item>Panama</item>
    private val i129 = intArrayOf(R.drawable.i129_animal, R.drawable.i129_flag, R.drawable.i129_food, R.drawable.i129_lang,  R.drawable.i129_paint)
    //        <item>Papua New Guinea</item>
    private val i130 = intArrayOf(R.drawable.i130_animal, R.drawable.i130_flag, R.drawable.i130_food, R.drawable.i130_lang,  R.drawable.i130_paint)
    //        <item>Paraguay</item>
    private val i131 = intArrayOf(R.drawable.i131_animal, R.drawable.i131_flag, R.drawable.i131_food, R.drawable.i131_lang,  R.drawable.i131_paint)
    //        <item>Peru</item>
    private val i132 = intArrayOf(R.drawable.i132_animal, R.drawable.i132_flag, R.drawable.i132_food, R.drawable.i132_lang,  R.drawable.i132_paint)
    //        <item>Philippines</item>
    private val i133 = intArrayOf(R.drawable.i133_animal, R.drawable.i133_flag, R.drawable.i133_food, R.drawable.i133_lang,  R.drawable.i133_paint)
    //        <item>Poland</item>
    private val i134 = intArrayOf(R.drawable.i134_animal, R.drawable.i134_flag, R.drawable.i134_food, R.drawable.i134_lang,  R.drawable.i134_paint)
    //        <item>Portugal</item>
    private val i136 = intArrayOf(R.drawable.i136_animal, R.drawable.i136_flag, R.drawable.i136_food, R.drawable.i136_lang,  R.drawable.i136_paint)
    //        <item>Qatar</item>
    private val i137 = intArrayOf(R.drawable.i137_animal, R.drawable.i137_flag, R.drawable.i137_food, R.drawable.i137_lang,  R.drawable.i137_paint)
    //        <item>Romania</item>
    private val i138 = intArrayOf(R.drawable.i138_animal, R.drawable.i138_flag, R.drawable.i138_food, R.drawable.i138_lang,  R.drawable.i138_paint)
    //        <item>Russia</item>
    private val i139 = intArrayOf(R.drawable.i139_animal, R.drawable.i139_flag, R.drawable.i139_food, R.drawable.i139_lang,  R.drawable.i139_paint)
    //        <item>Rwanda</item>
    private val i141 = intArrayOf(R.drawable.i141_animal, R.drawable.i141_flag, R.drawable.i141_food, R.drawable.i141_lang,  R.drawable.i141_paint)
    //        <item>Saint Kitts and Nevis</item>
    private val i142 = intArrayOf(R.drawable.i142_animal, R.drawable.i142_flag, R.drawable.i142_food, R.drawable.i142_lang,  R.drawable.i142_paint)
    //        <item>Saint Lucia</item>
    private val i143 = intArrayOf(R.drawable.i143_animal, R.drawable.i143_flag, R.drawable.i143_food, R.drawable.i143_lang,  R.drawable.i143_paint)
    //        <item>Saint Vincent and the Grenadines</item>
    private val i144 = intArrayOf(R.drawable.i144_animal, R.drawable.i144_flag, R.drawable.i144_food, R.drawable.i144_lang,  R.drawable.i144_paint)
    //        <item>Samoa</item>
    private val i145 = intArrayOf(R.drawable.i145_animal, R.drawable.i145_flag, R.drawable.i145_food, R.drawable.i145_lang,  R.drawable.i145_paint)
    //        <item>San Marino</item>
    private val i146 = intArrayOf(R.drawable.i146_animal, R.drawable.i146_flag, R.drawable.i146_food, R.drawable.i146_lang,  R.drawable.i146_paint)
    //        <item>Sao Tome and Principe</item>
    private val i147 = intArrayOf(R.drawable.i147_animal, R.drawable.i147_flag, R.drawable.i147_food, R.drawable.i147_lang,  R.drawable.i147_paint)
    //        <item>Saudi Arabia</item>
    private val i148 = intArrayOf(R.drawable.i148_animal, R.drawable.i148_flag, R.drawable.i148_food, R.drawable.i148_lang,  R.drawable.i148_paint)
    //        <item>Senegal</item>
    private val i149 = intArrayOf(R.drawable.i149_animal, R.drawable.i149_flag, R.drawable.i149_food, R.drawable.i149_lang,  R.drawable.i149_paint)
    //        <item>Serbia</item>
    private val i150 = intArrayOf(R.drawable.i150_animal, R.drawable.i150_flag, R.drawable.i150_food, R.drawable.i150_lang,  R.drawable.i150_paint)
    //        <item>Seychelles</item>
    private val i151 = intArrayOf(R.drawable.i151_animal, R.drawable.i151_flag, R.drawable.i151_food, R.drawable.i151_lang,  R.drawable.i151_paint)
    //        <item>Sierra Leone</item>
    private val i152 = intArrayOf(R.drawable.i152_animal, R.drawable.i152_flag, R.drawable.i152_food, R.drawable.i152_lang,  R.drawable.i152_paint)
    //        <item>Singapore</item>
    private val i153 = intArrayOf(R.drawable.i153_animal, R.drawable.i153_flag, R.drawable.i153_food, R.drawable.i153_lang,  R.drawable.i153_paint)
    //        <item>Slovakia</item>
    private val i154 = intArrayOf(R.drawable.i154_animal, R.drawable.i154_flag, R.drawable.i154_food, R.drawable.i154_lang,  R.drawable.i154_paint)
    //        <item>Slovenia</item>
    private val i156 = intArrayOf(R.drawable.i156_animal, R.drawable.i156_flag, R.drawable.i156_food, R.drawable.i156_lang,  R.drawable.i156_paint)
    //        <item>Solomon Island</item>s
    private val i157 = intArrayOf(R.drawable.i157_animal, R.drawable.i157_flag, R.drawable.i157_food, R.drawable.i157_lang,  R.drawable.i157_paint)
    //        <item>Somalia</item>
    private val i158 = intArrayOf(R.drawable.i158_animal, R.drawable.i158_flag, R.drawable.i158_food, R.drawable.i158_lang,  R.drawable.i158_paint)
    //        <item>South Africa</item>
    private val i159 = intArrayOf(R.drawable.i159_animal, R.drawable.i159_flag, R.drawable.i159_food, R.drawable.i159_lang,  R.drawable.i159_paint)
    //        <item>Spain</item>
    private val i160 = intArrayOf(R.drawable.i160_animal, R.drawable.i160_flag, R.drawable.i160_food, R.drawable.i160_lang,  R.drawable.i160_paint)
    //        <item>Sri Lanka</item>
    private val i162 = intArrayOf(R.drawable.i162_animal, R.drawable.i162_flag, R.drawable.i162_food, R.drawable.i162_lang,  R.drawable.i162_paint)
    //        <item>Sudan</item>
    private val i163 = intArrayOf(R.drawable.i163_animal, R.drawable.i163_flag, R.drawable.i163_food, R.drawable.i163_lang,  R.drawable.i163_paint)
    //        <item>Sudan, South</item>
    private val i164 = intArrayOf(R.drawable.i164_animal, R.drawable.i164_flag, R.drawable.i164_food, R.drawable.i164_lang,  R.drawable.i164_paint)
    //        <item>Suriname</item>
    private val i165 = intArrayOf(R.drawable.i165_animal, R.drawable.i165_flag, R.drawable.i165_food, R.drawable.i165_lang,  R.drawable.i165_paint)
    //        <item>Sweden</item>
    private val i166 = intArrayOf(R.drawable.i166_animal, R.drawable.i166_flag, R.drawable.i166_food, R.drawable.i166_lang,  R.drawable.i166_paint)
    //        <item>Switzerland</item>
    private val i167 = intArrayOf(R.drawable.i167_animal, R.drawable.i167_flag, R.drawable.i167_food, R.drawable.i167_lang,  R.drawable.i167_paint)
    //        <item>Syria</item>
    private val i168 = intArrayOf(R.drawable.i168_animal, R.drawable.i168_flag, R.drawable.i168_food, R.drawable.i168_lang,  R.drawable.i168_paint)
    //        <item>Taiwan</item>
    private val i170 = intArrayOf(R.drawable.i170_animal, R.drawable.i170_flag, R.drawable.i170_food, R.drawable.i170_lang,  R.drawable.i170_paint)
    //        <item>Tajikistan</item>
    private val i171 = intArrayOf(R.drawable.i171_animal, R.drawable.i171_flag, R.drawable.i171_food, R.drawable.i171_lang,  R.drawable.i171_paint)
    //        <item>Tanzania</item>
    private val i172 = intArrayOf(R.drawable.i172_animal, R.drawable.i172_flag, R.drawable.i172_food, R.drawable.i172_lang,  R.drawable.i172_paint)
    //        <item>Thailand</item>
    private val i173 = intArrayOf(R.drawable.i173_animal, R.drawable.i173_flag, R.drawable.i173_food, R.drawable.i173_lang,  R.drawable.i173_paint)
    //        <item>Togo</item>
    private val i174 = intArrayOf(R.drawable.i174_animal, R.drawable.i174_flag, R.drawable.i174_food, R.drawable.i174_lang,  R.drawable.i174_paint)
    //        <item>Tonga</item>
    private val i175 = intArrayOf(R.drawable.i175_animal, R.drawable.i175_flag, R.drawable.i175_food, R.drawable.i175_lang,  R.drawable.i175_paint)
    //        <item>Trinidad and Tobago</item>
    private val i176 = intArrayOf(R.drawable.i176_animal, R.drawable.i176_flag, R.drawable.i176_food, R.drawable.i176_lang,  R.drawable.i176_paint)
    //        <item>Tunisia</item>
    private val i177 = intArrayOf(R.drawable.i177_animal, R.drawable.i178_flag, R.drawable.i177_food, R.drawable.i177_lang,  R.drawable.i177_paint)
    //        <item>Turkey</item>
    private val i178 = intArrayOf(R.drawable.i178_animal, R.drawable.i178_flag, R.drawable.i178_food, R.drawable.i178_lang,  R.drawable.i178_paint)
    //        <item>Turkmenistan</item>
    private val i179 = intArrayOf(R.drawable.i179_animal, R.drawable.i179_flag, R.drawable.i179_food, R.drawable.i179_lang,  R.drawable.i179_paint)
    //        <item>Tuvalu</item>
    private val i180 = intArrayOf(R.drawable.i180_animal, R.drawable.i180_flag, R.drawable.i180_food, R.drawable.i180_lang,  R.drawable.i180_paint)
    //        <item>Uganda</item>
    private val i181 = intArrayOf(R.drawable.i181_animal, R.drawable.i181_flag, R.drawable.i181_food, R.drawable.i181_lang,  R.drawable.i181_paint)
    //        <item>Ukraine</item>
    private val i182 = intArrayOf(R.drawable.i182_animal, R.drawable.i182_flag, R.drawable.i182_food, R.drawable.i182_lang,  R.drawable.i182_paint)
    //        <item>United Arab Emirates</item>
    private val i183 = intArrayOf(R.drawable.i183_animal, R.drawable.i183_flag, R.drawable.i183_food, R.drawable.i183_lang,  R.drawable.i183_paint)
    //        <item>United Kingdom</item>
    private val i184 = intArrayOf(R.drawable.i184_animal, R.drawable.i184_flag, R.drawable.i184_food, R.drawable.i184_lang,  R.drawable.i184_paint)
    //        <item>United States</item>
    private val i185 = intArrayOf(R.drawable.i185_animal, R.drawable.i185_flag, R.drawable.i185_food, R.drawable.i185_lang,  R.drawable.i185_paint)
    //        <item>Uruguay</item>
    private val i186 = intArrayOf(R.drawable.i186_animal, R.drawable.i186_flag, R.drawable.i186_food, R.drawable.i186_lang,  R.drawable.i186_paint)
    //        <item>Uzbekistan</item>
    private val i187 = intArrayOf(R.drawable.i187_animal, R.drawable.i187_flag, R.drawable.i187_food, R.drawable.i187_lang,  R.drawable.i187_paint)
    //        <item>Vanuatu</item>
    private val i188 = intArrayOf(R.drawable.i188_animal, R.drawable.i188_flag, R.drawable.i188_food, R.drawable.i188_lang,  R.drawable.i188_paint)



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

                // These blocks of if and else statements are used to determine if the user has entered
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
