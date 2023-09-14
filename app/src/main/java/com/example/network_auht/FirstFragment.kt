package com.example.network_auht

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.network_auht.databinding.FragmentFirstBinding


class FirstFragment : Fragment() {

    private val quizViewModel : QuizViewModel by viewModels()
    private var _binding: FragmentFirstBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        quizViewModel.getQuiz()
        observeLiveData()
        binding.AnswerButton.setOnClickListener{
            quizViewModel.result.observe(viewLifecycleOwner){ quizData ->
                if (quizData != null) {
                    val answer = quizData.answer
                Toast.makeText(requireContext(),answer, Toast.LENGTH_SHORT).show()
                }
            }

        }

    }

    fun observeLiveData(){
        quizViewModel.result.observe(viewLifecycleOwner){ quizData ->
            if(quizData!= null) {
                binding.Question.text = quizData.question
                binding.aAnswer.text = quizData.a
                binding.bAnswer.text = quizData.b
                binding.cAnswer.text = quizData.c
                binding.dAnswer.text = quizData.d
            }

        }
    }
}
