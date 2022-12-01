package com.techyourchance.dagger2course.screens.viewmodel

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.techyourchance.dagger2course.R
import com.techyourchance.dagger2course.questions.Question
import com.techyourchance.dagger2course.screens.common.ScreensNavigator
import com.techyourchance.dagger2course.screens.common.activities.BaseActivity
import com.techyourchance.dagger2course.screens.common.toolbar.MyToolbar
import com.techyourchance.dagger2course.screens.viewmodel.MyViewModel.*
import kotlinx.coroutines.flow.collect
import javax.inject.Inject

class ViewModelActivity : BaseActivity() {

    @Inject
    lateinit var screensNavigator: ScreensNavigator

    @Inject
    lateinit var myViewModelFactory: MyViewModelFactory
    private lateinit var viewModel: MyViewModel

    private lateinit var toolbar: MyToolbar

    override fun onCreate(savedInstanceState: Bundle?) {
        injector.inject(this)
        super.onCreate(savedInstanceState)

        setContentView(R.layout.layout_view_model)

        toolbar = findViewById(R.id.toolbar)
        toolbar.setNavigateUpListener {
            screensNavigator.navigateBack()
        }

        viewModel = ViewModelProvider(this, myViewModelFactory)[MyViewModel::class.java]

        subscribeObservers()
    }

    private fun subscribeObservers() {
        lifecycleScope.launchWhenStarted {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.questions.collect { questions ->
                    doSomething(questions)
                }
            }
        }
    }

    private fun doSomething(questions: List<Question>) {
        Toast.makeText(this, "fetches ${questions.size} questions", Toast.LENGTH_SHORT).show()
    }

    companion object {
        fun start(context: Context) {
            val intent = Intent(context, ViewModelActivity::class.java)
            context.startActivity(intent)
        }
    }
}
