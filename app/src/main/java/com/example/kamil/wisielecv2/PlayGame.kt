package com.example.kamil.wisielecv2

import android.graphics.Color
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Button
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_play_game.*
import java.util.*

class PlayGame : AppCompatActivity(){
    var namePlayer:String?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_play_game)

        buLosuj.setOnClickListener { getWord() }

        val bundle:Bundle = intent.extras
        namePlayer = bundle.getString("playerOne")
        getWord()
    }

    var words = mutableListOf<String>("kamień","rower","piasek","dziedzictwo","droga","plażą",
            "samochód","autostrada","opłata celna","rzeka","morze", "tratwa", "matematyka","szpieg")
    var word = ArrayList<Char>()
    var wordView = ArrayList<Boolean>()
    val numOfChance:Int = 12
    var chance:Int = numOfChance
    var score = 0


    fun rand(from: Int, to: Int): Int {
        val random = Random()
        return random.nextInt(to - from) + from
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

    fun clearButtons(){
        bu1.isEnabled = true
        bu1.setBackgroundResource(android.R.drawable.btn_default)

        bu2.isEnabled = true
        bu2.setBackgroundResource(android.R.drawable.btn_default)

        bu3.isEnabled = true
        bu3.setBackgroundResource(android.R.drawable.btn_default)

        bu4.isEnabled = true
        bu4.setBackgroundResource(android.R.drawable.btn_default)

        bu5.isEnabled = true
        bu5.setBackgroundResource(android.R.drawable.btn_default)

        bu6.isEnabled = true
        bu6.setBackgroundResource(android.R.drawable.btn_default)

        bu7.isEnabled = true
        bu7.setBackgroundResource(android.R.drawable.btn_default)

        bu8.isEnabled = true
        bu8.setBackgroundResource(android.R.drawable.btn_default)

        bu9.isEnabled = true
        bu9.setBackgroundResource(android.R.drawable.btn_default)

        bu10.isEnabled = true
        bu10.setBackgroundResource(android.R.drawable.btn_default)

        bu11.isEnabled = true
        bu11.setBackgroundResource(android.R.drawable.btn_default)

        bu12.isEnabled = true
        bu12.setBackgroundResource(android.R.drawable.btn_default)

        bu13.isEnabled = true
        bu13.setBackgroundResource(android.R.drawable.btn_default)

        bu14.isEnabled = true
        bu14.setBackgroundResource(android.R.drawable.btn_default)

        bu15.isEnabled = true
        bu15.setBackgroundResource(android.R.drawable.btn_default)

        bu16.isEnabled = true
        bu16.setBackgroundResource(android.R.drawable.btn_default)

        bu17.isEnabled = true
        bu17.setBackgroundResource(android.R.drawable.btn_default)

        bu18.isEnabled = true
        bu18.setBackgroundResource(android.R.drawable.btn_default)

        bu19.isEnabled = true
        bu19.setBackgroundResource(android.R.drawable.btn_default)

        bu20.isEnabled = true
        bu20.setBackgroundResource(android.R.drawable.btn_default)

        bu21.isEnabled = true
        bu21.setBackgroundResource(android.R.drawable.btn_default)

        bu22.isEnabled = true
        bu22.setBackgroundResource(android.R.drawable.btn_default)

        bu23.isEnabled = true
        bu23.setBackgroundResource(android.R.drawable.btn_default)

        bu24.isEnabled = true
        bu24.setBackgroundResource(android.R.drawable.btn_default)

        bu25.isEnabled = true
        bu25.setBackgroundResource(android.R.drawable.btn_default)

        bu26.isEnabled = true
        bu26.setBackgroundResource(android.R.drawable.btn_default)

        bu27.isEnabled = true
        bu27.setBackgroundResource(android.R.drawable.btn_default)

        bu28.isEnabled = true
        bu28.setBackgroundResource(android.R.drawable.btn_default)

        bu29.isEnabled = true
        bu29.setBackgroundResource(android.R.drawable.btn_default)

        bu30.isEnabled = true
        bu30.setBackgroundResource(android.R.drawable.btn_default)

        bu31.isEnabled = true
        bu31.setBackgroundResource(android.R.drawable.btn_default)

        bu32.isEnabled = true
        bu32.setBackgroundResource(android.R.drawable.btn_default)
    }

    fun getWord(){
        val num:Int
        var wordX=""
        chance=numOfChance
        word.clear()
        wordView.clear()
        clearButtons()
        if(words.size==0){
            viewWord.setTextColor(Color.RED)
            viewWord.text="Wyczerpałeś bazę haseł!"
            buLosuj.isEnabled = false
            lockButtons()
        }
        else{
            num = rand(0,words.size)
            for(i in words[num]){
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
            words.removeAt(num)
            viewWord.text=wordX
        }


    }
    fun checkIfWin(w:ArrayList<Boolean>,x:ArrayList<Char>){
        var showWord=""
        for (i in x){
            showWord+=i
        }

        if (!(w.contains(false))){
            viewWord.text = showWord
            score+=1
            Toast.makeText(this,"$namePlayer you win! Your current score: $score",Toast.LENGTH_SHORT).show()
            lockButtons()
        }
        else if (chance==0){
            viewWord.text = showWord
            Toast.makeText(this,"$namePlayer you lose! Your current score: $score",Toast.LENGTH_SHORT).show()
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
}
