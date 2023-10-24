package com.example.demokotlin.Components

import android.content.Context
import android.widget.Button
import android.widget.LinearLayout
import com.example.demokotlin.R

class ButtonsGrid(val context: Context, val parentLinearLayout: LinearLayout) {

    class ButtonsRow(val context: Context, val parentLinearLayout: LinearLayout){

        private var buttons: MutableList<Button> = mutableListOf();
        private val linearLayout: LinearLayout = LinearLayout(context);

        init {
            linearLayout.orientation = LinearLayout.HORIZONTAL;
            linearLayout.layoutParams = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.MATCH_PARENT,
                1f
            )
            linearLayout.setBackgroundColor(context.getColor(R.color.teal_700))

            parentLinearLayout.addView(linearLayout);
        }

        fun AddButton(text: String) : Button{

            var button = Button(context)
            button.text = text;
            button.layoutParams = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.MATCH_PARENT,
                1f
            )
            linearLayout.addView(button);
            buttons.add(button)
            return button;
        }

    }

    private var rows: MutableList<ButtonsRow> = mutableListOf();

    fun GetRow(index: Int) : ButtonsRow? {

        if (index >= rows.count() || index < 0){
            return null;
        }
        return rows[index];
    }

    fun AddRow() : ButtonsRow {

        val buttonRow = ButtonsRow(context, parentLinearLayout);
        rows.add(buttonRow);
        return  buttonRow;
    }
}