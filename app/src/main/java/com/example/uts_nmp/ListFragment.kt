package com.example.uts_nmp

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.uts_nmp.databinding.FragmentListBinding
class ListFragment : Fragment() {

    companion object {
        fun newInstance(mode: String): ListFragment {
            val fragment = ListFragment()
            val args = Bundle()
            args.putString("mode", mode)
            fragment.arguments = args
            return fragment
        }
    }

    private var mode: String = "all"

    private var _binding: FragmentListBinding? = null
    private val binding get() = _binding!!


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mode = arguments?.getString("mode") ?: "all"
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.recyclerViewList.layoutManager = LinearLayoutManager(requireContext())

        if (mode == "friends") {
            StudentRepository.getFriendsFromAPI(requireContext()) { students ->
                setAdapter(students)
            }
        } else {
            StudentRepository.getStudentsFromAPI(requireContext()) { students ->
                setAdapter(students)
            }
        }
    }

    private fun setAdapter(students: List<Student>) {
        Log.d("API_STUDENTS", "Total data: ${students.size}")

        if (students.isNotEmpty()) {
            binding.recyclerViewList.adapter = StudentAdapter(students)
        } else {
            Log.e("API_STUDENTS", "List kosong! Data tidak ter-load.")
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
