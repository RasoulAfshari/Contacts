package com.example.note

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*

class ActivityAddNote : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_note)

        val note1: EditText =findViewById(R.id.edt_note2)
        val name: TextView =findViewById(R.id.textname)
        val btn_save: Button =findViewById(R.id.btn_edit)
        val btn_close: Button =findViewById(R.id.btn_close)
        val rgb:RadioGroup=findViewById(R.id.ac_main_rgb)
//        if(rgb.checkedRadioButtonId==-1)


        btn_save.setOnClickListener {
//            val rb: RadioButton =findViewById(rgb.checkedRadioButtonId)
            val db = AppDatabase(this)
            var n:note=note(note1.text.toString(),name.text.toString())
            db.noteDao().insertAll(n)
            Toast.makeText(this, "ثبت با موفقیت انجام شد", Toast.LENGTH_SHORT).show()

        }
    }
}