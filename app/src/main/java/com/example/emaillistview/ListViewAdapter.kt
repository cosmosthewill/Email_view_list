package com.example.emaillistview

import android.content.Context
import android.content.res.ColorStateList
import android.content.res.Resources
import android.graphics.Color
import android.graphics.drawable.Drawable
import android.graphics.drawable.GradientDrawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.CheckBox
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.core.content.res.ResourcesCompat

class ListViewAdapter(val context: Context, val data: ArrayList<Email>) : BaseAdapter() {
    private val inflater: LayoutInflater
            = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater;

    override fun getCount(): Int {
        return data.size;
    }

    override fun getItem(p0: Int): Any {
        return  data[p0];
    }

    override fun getItemId(p0: Int): Long {
        return p0.toLong();
    }
    
    val state = arrayOf(
        intArrayOf(android.R.attr.state_checked),
        intArrayOf(android.R.attr.state_enabled)
    )
    val starColor = intArrayOf(
        Color.YELLOW,
        Color.LTGRAY
    )
    val starStateList = ColorStateList(state, starColor)
    override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
        val rowView = inflater.inflate(R.layout.email_text_view, p2, false)

        val nameIconTextView: TextView = rowView.findViewById(R.id.name_icon)
        val nameTextView : TextView = rowView.findViewById(R.id.name_textview)
        val titleTextView : TextView = rowView.findViewById(R.id.title_textview)
        val bodyTextView : TextView = rowView.findViewById(R.id.body_textview)
        val starCheckbox: CheckBox = rowView.findViewById(R.id.star_checkbox)

        val email : Email = getItem(p0) as Email
        nameIconTextView.text = email.senderName[0].toString().uppercase()
        val letter = email.senderName[0].toString().uppercase()
        var c = 0;
        if (letter[0] <= 'E') c = Color.parseColor("#F83F3F")
        else if (letter[0] <= 'J') c = Color.parseColor("#FF00AEFF")
        else if (letter[0] <= 'O') c = Color.parseColor("#FFF2F838")
        else if (letter[0] <= 'T') c = Color.parseColor("#FF60FF4E")
        else c = Color.parseColor("#FFDA6BF3")
        nameIconTextView.background.setTint(c)

        nameTextView.text = email.senderName
        titleTextView.text = email.emailTitle
        bodyTextView.text = email.emailBody
        starCheckbox.buttonTintList = starStateList

        return rowView;
    }
}