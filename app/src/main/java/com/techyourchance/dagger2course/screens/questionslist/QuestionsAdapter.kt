package com.techyourchance.dagger2course.screens.questionslist

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.techyourchance.dagger2course.R
import com.techyourchance.dagger2course.questions.Question
import java.util.ArrayList

class QuestionsAdapter(
    private val onQuestionClickListener: (Question) -> Unit
) : RecyclerView.Adapter<QuestionsAdapter.QuestionViewHolder>() {

    private var questionsList: List<Question> = ArrayList(0)

    inner class QuestionViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val title: TextView = view.findViewById(R.id.txt_title)
    }

    fun bindData(questions: List<Question>) {
        questionsList = ArrayList(questions)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): QuestionViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.layout_question_list_item, parent, false)
        return QuestionViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: QuestionViewHolder, position: Int) {
        holder.title.text = questionsList[position].title
        holder.itemView.setOnClickListener {
            onQuestionClickListener.invoke(questionsList[position])
        }
    }

    override fun getItemCount(): Int {
        return questionsList.size
    }
}
