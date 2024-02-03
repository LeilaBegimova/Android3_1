package com.example.android3_1.ui.data

import android.content.Context

class PreferensHelper(val contex: Context)  {
    private val preferensHelper = contex.getSharedPreferences("myPref",Context.MODE_PRIVATE)

    var register :Boolean
        get() = preferensHelper.getBoolean(IS_SHOW_REGISTER, false)
        set(value) {
            preferensHelper.edit().putBoolean(IS_SHOW_REGISTER,value).apply()
        }

    var username: String?
        get() = preferensHelper.getString(USER_NAME_KEY,"")
        set(value) {
            preferensHelper.edit().putString(USER_NAME_KEY,value).apply()
        }
    var userage:String?
        get() = preferensHelper.getString(AGE_KEY,"")
        set(value) {
            preferensHelper.edit().putString(AGE_KEY,value).apply()
        }
    var useremail:String?
        get() = preferensHelper.getString(EMAIL_KEY,"")
        set(value) {
            preferensHelper.edit().putString(EMAIL_KEY,value).apply()
        }

    var userpassword:String?
        get() = preferensHelper.getString(PASSWORD_KEY,"")
        set(value) {
            preferensHelper.edit().putString(PASSWORD_KEY,value).apply()
        }

    companion object{
        private const val USER_NAME_KEY = "jdj"
        private const val AGE_KEY = "aaa"
        private const val EMAIL_KEY = "ss"
        private const val PASSWORD_KEY = "aa"
        private const val IS_SHOW_REGISTER = "isShowRegister"
    }
}