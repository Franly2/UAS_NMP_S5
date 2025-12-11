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

    private var _binding: FragmentListBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.recyclerViewList.layoutManager =
            LinearLayoutManager(requireContext())

        StudentRepository.getStudentsFromAPI(requireContext()) { students ->

            Log.d("API_STUDENTS", "Total data: ${students.size}")

            Log.d("API_STUDENTS", students.toString())

            if (students.isNotEmpty()) {
                val adapter = StudentAdapter(students)
                binding.recyclerViewList.adapter = adapter
            } else {
                Log.e("API_STUDENTS", "List kosong! Data tidak ter-load.")
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
