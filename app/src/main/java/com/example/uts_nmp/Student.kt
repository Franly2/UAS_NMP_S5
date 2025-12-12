package com.example.uts_nmp

import android.content.Context
import android.util.Log
import com.android.volley.Request
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import org.json.JSONArray

data class Student(
    val nrp: String,
    val nama: String,
    val email: String,
    val program: String,
    val about_me: String,
    val my_course: String,
    val my_experiences: String,
    val photo_url: String
)

object StudentRepository {

    fun getStudentsFromAPI(context: Context, callback: (List<Student>) -> Unit) {

        val url = "http://10.0.2.2/uas_nmp_FriendsApp/get_all_student.php"

        val request = StringRequest(
            Request.Method.GET, url,
            { response ->
                val jsonArray = JSONArray(response)
                val list = ArrayList<Student>()

                for (i in 0 until jsonArray.length()) {
                    val obj = jsonArray.getJSONObject(i)

                    val student = Student(
                        nrp = obj.getString("nrp"),
                        nama = obj.getString("nama"),
                        email = obj.getString("email"),
                        program = obj.getString("program"),
                        about_me = obj.getString("about_me"),
                        my_course = obj.getString("my_course"),
                        my_experiences = obj.getString("my_experiences"),
                        photo_url = obj.getString("photo_url")
                    )

                    list.add(student)
                }

                callback(list)
            },
            { error ->
                Log.e("API_STUDENTS", "Volley error: ${error.networkResponse?.statusCode} - ${error.message}")
                error.printStackTrace()
                callback(emptyList())
            }
        )

        Volley.newRequestQueue(context).add(request)
    }

    fun getFriendsFromAPI(context: Context, callback: (List<Student>) -> Unit) {
        val url = "http://10.0.2.2/uas_nmp_FriendsApp/get_friends.php"

        val request = StringRequest(
            Request.Method.GET, url,
            { response ->
                val jsonArray = JSONArray(response)
                val list = ArrayList<Student>()

                for (i in 0 until jsonArray.length()) {
                    val obj = jsonArray.getJSONObject(i)

                    val student = Student(
                        nrp = obj.getString("nrp"),
                        nama = obj.getString("nama"),
                        email = obj.getString("email"),
                        program = obj.getString("program"),
                        about_me = obj.getString("about_me"),
                        my_course = obj.getString("my_course"),
                        my_experiences = obj.getString("my_experiences"),
                        photo_url = obj.getString("photo_url")
                    )
                    list.add(student)
                }

                callback(list)
            },
            { error ->
                error.printStackTrace()
                callback(emptyList())
            }
        )

        Volley.newRequestQueue(context).add(request)
    }

}
