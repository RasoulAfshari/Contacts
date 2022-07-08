package com.example.note

import android.content.Intent
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val name:EditText=findViewById(R.id.edt_note2)
        val note1:EditText=findViewById(R.id.edt_note1)
        val btn_save:Button=findViewById(R.id.btn_edit)
        val btn_close:Button=findViewById(R.id.btn_close)
        val mediaPlayer: MediaPlayer = MediaPlayer.create(this,R.raw.bikalam)
//        val rgb:RadioGroup=findViewById(R.id.ac_main_rgb)

        btn_save.setOnClickListener {
            mediaPlayer.start()
            if( note1.text.toString()=="" || name.text.toString()==""){
                Toast.makeText(this, "فیلد ها نباید خالی باشد", Toast.LENGTH_SHORT).show()
            }
            else if(!note1.text.toString().startsWith("09")){
                Toast.makeText(this,"شماره نامعتبر است", Toast.LENGTH_SHORT).show()
            }
            else if(note1.text.toString().length!=11){
                Toast.makeText(this,"شماره نامعتبر است", Toast.LENGTH_SHORT).show()
            }
//            else if(rgb.checkedRadioButtonId==-1) {
//                Toast.makeText(this, "جنسیت انتخاب نشده است.", Toast.LENGTH_SHORT).show()
//            }

            else{
//                val rb:RadioButton=findViewById(rgb.checkedRadioButtonId)
                val db = AppDatabase(this)
                var existnote = db.noteDao().findBynote1(note1.text.toString())

                if(existnote==null){
                    var n:note=note(note1.text.toString(),name.text.toString())
                    db.noteDao().insertAll(n)
                    Toast.makeText(this, "ثبت با موفقیت انجام شد", Toast.LENGTH_SHORT).show()
                }
                else{
                    Toast.makeText(this, "شماره تکراری است", Toast.LENGTH_SHORT).show()
                }
            }
        }
        btn_close.setOnClickListener {
            mediaPlayer.start()
            val intent:Intent= Intent(this,Activitylistnote::class.java)
            startActivity(intent)
        }

    }
}