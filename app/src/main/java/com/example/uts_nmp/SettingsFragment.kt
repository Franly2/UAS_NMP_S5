package com.example.uts_nmp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.uts_nmp.databinding.FragmentSettingsBinding
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.android.volley.Request

class SettingsFragment : Fragment() {

    private var _binding: FragmentSettingsBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSettingsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnResetFriends.setOnClickListener {
            resetFriends()
        }
    }

    private fun resetFriends() {
        val url = "http://10.0.2.2/uas_nmp_FriendsApp/reset_friends.php"

        val request = StringRequest(
            Request.Method.GET,
            url,
            { response ->
                Toast.makeText(requireContext(), "Friends reset!", Toast.LENGTH_SHORT).show()
            },
            {
                Toast.makeText(requireContext(), "Failed to reset!", Toast.LENGTH_SHORT).show()
            }
        )

        Volley.newRequestQueue(requireContext()).add(request)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
