package com.satwik.whatsappoperer

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.text.isDigitsOnly

//
//class MainActivity : AppCompatActivity() {
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
//        var number: String="0"
//        if(intent.action==Intent.ACTION_PROCESS_TEXT)
//        {
//            number=intent.getCharSequenceExtra(Intent.EXTRA_PROCESS_TEXT).toString()
//        }
//
//        if(number.isDigitsOnly())
//        {
//         startWhatsaap(number)
//        }
//        else
//        {
//            Toast.makeText(this,"Please check the number !!",Toast.LENGTH_LONG).show()
//        }
//    }
//    private fun startWhatsaap(number: String) {
//        val intent=Intent(Intent.ACTION_VIEW)
//        intent.setPackage("com.whatsaap")
//        val data= if(number[0]=='+')
//            number.substring(1)
//        else if(number.length==10)
//            "91"+number
//        else
//            number
//        intent.data= Uri.parse("https://wa.me/$data")
//        if(packageManager.resolveActivity(intent,0)!=null)
//            startActivity(intent)
//        else
//            Toast.makeText(this,"Install whatsaap first !!",Toast.LENGTH_LONG).show()
//
//    }
//}
//import android.content.Intent
//import android.net.Uri
//import androidx.appcompat.app.AppCompatActivity
//import android.os.Bundle
//import android.widget.Toast
//else if (intent.action == Intent.ACTION_DIAL ||
//            intent.action == Intent.ACTION_VIEW
//        ) {
//            intent?.data?.schemeSpecificPart.toString()
//        }

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        title = "WhatsAap Operne"
        setContentView(R.layout.activity_main)
        var number: String = "9754095967"

        if (intent.action == Intent.ACTION_DIAL ||
            intent.action == Intent.ACTION_VIEW
        ) {
            number = intent?.data?.schemeSpecificPart.toString()
        }

        startWhatsapp(number)
    }

    private fun startWhatsapp(number: String) {
        val i = Intent(Intent.ACTION_VIEW)
        i.setPackage("com.whatsapp")
        var data = if (number[0] == '+') {
            number.substring(1)
        } else {
            number
        }
        data = if (data.length == 10) {
            "91$data"
        } else {
            data
        }
        i.data = Uri.parse("https://wa.me/$data")
        if (packageManager.resolveActivity(i, 0) != null) {
            startActivity(i)
        } else {
            Toast.makeText(this, "Please install Whatsapp!!", Toast.LENGTH_SHORT).show()
        }
        finish()
    }
}