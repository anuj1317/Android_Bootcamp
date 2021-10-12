import android.content.Context
import android.content.SharedPreferences
import android.util.Log

class SharedPrefUtil(context: Context) {

    private val pref = context.getSharedPreferences("my_pref", Context.MODE_PRIVATE)

    companion object {
        const val KEY_EMAIL = "email"
        const val KEY_PASSWORD = "password"
        const val KEY_IS_LOOGGED_IN = "is_logged_in"

    }

    fun putPreference(key: String, value: String) {
        val editor: SharedPreferences.Editor = pref.edit()
        editor.putString(key, value)
        editor.apply()
        Log.d("", "====== key stored ${key}")
    }

    fun putPreference(key: String, value: Boolean) {
        val editor: SharedPreferences.Editor = pref.edit()
        editor.putBoolean(key, value)
        editor.apply()
        Log.d("SharedPrefUtil", "====== Boolean key stored ${key}")

    }

    fun removeKey(key: String) {
        val editor: SharedPreferences.Editor = pref.edit()
        editor.remove(key)
        editor.apply()
    }

    fun clearPref() {
        val editor: SharedPreferences.Editor = pref.edit()
        editor.clear()
        editor.apply()
    }

    fun getPreference(key: String, defaultValue: Boolean): Boolean {
        return pref.getBoolean(key, defaultValue)
    }

    fun getPreference(key: String, defaultValue: String): String? {
        return pref.getString(key, defaultValue)
    }


}