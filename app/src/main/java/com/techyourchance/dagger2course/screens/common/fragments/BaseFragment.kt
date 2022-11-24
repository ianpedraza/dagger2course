package com.techyourchance.dagger2course.screens.common.fragments

import androidx.fragment.app.Fragment
import com.techyourchance.dagger2course.common.di.PresentationModule
import com.techyourchance.dagger2course.screens.common.activities.BaseActivity

open class BaseFragment : Fragment() {

    protected val compositionRoot by lazy {
        PresentationModule((requireActivity() as BaseActivity).activityCompositionRoot)
    }
}
