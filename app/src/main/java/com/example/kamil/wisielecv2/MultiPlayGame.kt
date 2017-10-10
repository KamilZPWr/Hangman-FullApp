package com.example.kamil.wisielecv2

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Button
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_multi_play_game.*
import java.util.*

class MultiPlayGame : AppCompatActivity(){
    var playerOne:String?=null
    var playerTwo:String?=null
    var activePlayer:Int?=null
    var word = ArrayList<Char>()
    var wordView = ArrayList<Boolean>()
    val numOfChance:Int = 12
    var chance:Int = numOfChance
    var score = 0
    var playerOnePoints:Int?=null
    var playerTwoPoints:Int?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_multi_play_game)

        val bundle:Bundle = intent.extras

        playerOne = bundle.getString("playerOne")
        playerTwo = bundle.getString("playerTwo")
        activePlayer = bundle.getInt("activePlayer")
        playerOnePoints = bundle.getInt("playerOnePoints")
        playerTwoPoints = bundle.getInt("playerTwoPoints")
        var wordX=""

        if (activePlayer==1){
            activePlayer=2
            Toast.makeText(this,"$playerTwo guess the word!",Toast.LENGTH_LONG).show()
        }
        else if (activePlayer==2) {
            activePlayer=1
            Toast.makeText(this,"$playerOne guess the word!",Toast.LENGTH_LONG).show()
        }


        for(i in bundle.getString("word")){
            word.add(i.toUpperCase().toChar())

            if (i==' '){
                wordX +="  "
                wordView.add(true)
            }
            else{
                wordX +="_ "
                wordView.add(false)
            }
        }
        viewWord.text=wordX

    }

    fun lockButtons(){
        bu1.isEnabled=false
        bu2.isEnabled=false
        bu3.isEnabled=false
        bu4.isEnabled=false
        bu5.isEnabled=false
        bu6.isEnabled=false
        bu7.isEnabled=false
        bu8.isEnabled=false
        bu9.isEnabled=false
        bu10.isEnabled=false
        bu11.isEnabled=false
        bu12.isEnabled=false
        bu13.isEnabled=false
        bu14.isEnabled=false
        bu15.isEnabled=false
        bu16.isEnabled=false
        bu17.isEnabled=false
        bu18.isEnabled=false
        bu19.isEnabled=false
        bu20.isEnabled=false
        bu21.isEnabled=false
        bu22.isEnabled=false
        bu23.isEnabled=false
        bu24.isEnabled=false
        bu25.isEnabled=false
        bu26.isEnabled=false
        bu27.isEnabled=false
        bu28.isEnabled=false
        bu29.isEnabled=false
        bu30.isEnabled=false
        bu31.isEnabled=false
        bu32.isEnabled=false
    }

    fun checkIfWin(w: ArrayList<Boolean>, x: ArrayList<Char>){
        var showWord=""
        for (i in x){
            showWord+=i
        }

        if (!(w.contains(false))){
            viewWord.text = showWord
            if (activePlayer==1){
                playerOnePoints = playerOnePoints?.plus(1)
            }
            else{
                playerTwoPoints = playerTwoPoints?.plus(1)
            }
            Toast.makeText(this,"Good! Current score: $playerOne $playerOnePoints:$playerTwoPoints $playerTwo"
                    , Toast.LENGTH_LONG).show()
            lockButtons()
        }
        else if (chance==0){
            viewWord.text = showWord
            Toast.makeText(this,"Not good! Current score: $playerOne $playerOnePoints:$playerTwoPoints $playerTwo"
                    , Toast.LENGTH_LONG).show()
            lockButtons()
        }
    }

    fun chooseButton(view: View){
        val buSelected = view as Button
        var wordX=""
        var cellID:Char='A'

        if(word.isEmpty()==true){
            return
        }

        when(buSelected.id){
            R.id.bu1-> cellID = 'A'
            R.id.bu2-> cellID = 'Ą'
            R.id.bu3-> cellID = 'B'
            R.id.bu4-> cellID = 'C'
            R.id.bu5-> cellID = 'Ć'
            R.id.bu6-> cellID = 'D'
            R.id.bu7-> cellID = 'E'
            R.id.bu8-> cellID = 'Ę'
            R.id.bu9-> cellID = 'F'
            R.id.bu10-> cellID = 'G'
            R.id.bu11-> cellID = 'H'
            R.id.bu12-> cellID = 'I'
            R.id.bu13-> cellID = 'J'
            R.id.bu14-> cellID = 'K'
            R.id.bu15-> cellID = 'L'
            R.id.bu16-> cellID = 'Ł'
            R.id.bu17-> cellID = 'M'
            R.id.bu18-> cellID = 'N'
            R.id.bu19-> cellID = 'Ń'
            R.id.bu20-> cellID = 'O'
            R.id.bu21-> cellID = 'Ó'
            R.id.bu22-> cellID = 'P'
            R.id.bu23-> cellID = 'R'
            R.id.bu24-> cellID = 'S'
            R.id.bu25-> cellID = 'Ś'
            R.id.bu26-> cellID = 'T'
            R.id.bu27-> cellID = 'U'
            R.id.bu28-> cellID = 'W'
            R.id.bu29-> cellID = 'Y'
            R.id.bu30-> cellID = 'Z'
            R.id.bu31-> cellID = 'Ź'
            R.id.bu32-> cellID = 'Ż'
        }
        buSelected.isEnabled=false

        if (word.contains(cellID)){
            for(i in 0..word.size-1){
                if(word[i]==cellID){
                    wordView[i]=true
                }
            }
            wordView[word.indexOf(cellID)] = true
            buSelected.setBackgroundResource(R.color.greenGood)
        }
        else{
            buSelected.setBackgroundResource(R.color.redWrong)
            chance-=1

        }

        for (i in 0..word.size-1){
            if (wordView[i]==true){
                wordX += word[i].toUpperCase()
            }
            else{
                wordX +="_ "
            }
        }
        viewWord.text=wordX
        checkIfWin(wordView,word)
    }

    fun getWord(view:View){
        val intent = Intent(this, GiveWord::class.java)
        intent.putExtra("playerOne", playerOne)
        intent.putExtra("playerTwo",playerTwo)
        intent.putExtra("activePlayer",activePlayer)
        intent.putExtra("playerOnePoints",playerOnePoints)
        intent.putExtra("playerTwoPoints",playerTwoPoints)
        startActivity(intent)
    }
}
