package uz.ubtuit.bookingapp.utills

import android.content.Context
import android.content.SharedPreferences


object MySharedPreferences {
    private const val NAME = "BeautyApp"
    private const val MODE = Context.MODE_PRIVATE
    private lateinit var preferences: SharedPreferences

    fun init(context: Context) {
        preferences = context.getSharedPreferences(NAME, MODE)
    }

    private inline fun SharedPreferences.edit(operation: (SharedPreferences.Editor) -> Unit) {
        val editor = edit()
        operation(editor)
        editor.apply()
    }

    var user: String?

        get() = preferences.getString("key1", "bug")

        set(value) = preferences.edit {
            if (value != null) {
                it.putString("key1", value)
            }
        }


}