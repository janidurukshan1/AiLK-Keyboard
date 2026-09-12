package com.ailk.keyboard

import android.inputmethodservice.InputMethodService
import android.view.View
import android.widget.Button
import android.widget.LinearLayout

class AiLKKeyboardService : InputMethodService() {

    private lateinit var root: LinearLayout

    override fun onCreateInputView(): View {

        root = LinearLayout(this)
        root.orientation = LinearLayout.VERTICAL

        val row = LinearLayout(this)

        val keys = listOf(
            "Q", "W", "E", "R", "T",
            "Y", "U", "I", "O", "P"
        )

        for (key in keys) {

            val button = Button(this)

            button.text = key

            button.setOnClickListener {
                currentInputConnection
                    ?.commitText(key.lowercase(), 1)
            }

            row.addView(
                button,
                LinearLayout.LayoutParams(
                    0,
                    120,
                    1f
                )
            )
        }

        root.addView(row)

        return root
    }
}
