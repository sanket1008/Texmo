package com.texmo_app.texmo

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.EditText
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.print.PrintHelper
import com.google.zxing.BarcodeFormat
import com.google.zxing.MultiFormatWriter
import com.journeyapps.barcodescanner.BarcodeEncoder


class MainActivity : AppCompatActivity(), View.OnClickListener {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val editText = findViewById<EditText>(R.id.etCode)
        val imageView = findViewById<ImageView>(R.id.image)



        editText.addTextChangedListener(object : TextWatcher {

            override fun afterTextChanged(s: Editable) {}

            override fun beforeTextChanged(
                s: CharSequence, start: Int,
                count: Int, after: Int
            ) {
            }

            override fun onTextChanged(
                s: CharSequence, start: Int,
                before: Int, count: Int
            ) {

                if (s.isNotEmpty()) {
                    var multiFormatWriter = MultiFormatWriter();
                    try {
                        val bitMatrix =
                            multiFormatWriter.encode(s.toString(), BarcodeFormat.QR_CODE, 300, 300);
                        val barcodeEncoder= BarcodeEncoder();
                        val bitmap=barcodeEncoder.createBitmap(bitMatrix);
                        imageView.setImageBitmap(bitmap);
                    } catch (e: Exception) {
                        e.printStackTrace();
                    }

                } else {

                }

            }
        })

    }

    override fun onClick(p0: View?) {

    }


}