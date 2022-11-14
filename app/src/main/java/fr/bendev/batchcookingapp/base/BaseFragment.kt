package fr.bendev.batchcookingapp.base

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider

abstract class BaseFragment<B : ViewDataBinding, out V : fr.bendev.batchcookingapp.base.BaseViewModel> : Fragment() {

    @get:LayoutRes
    protected abstract val layoutRes: Int
    protected abstract val viewModel: V
    protected abstract val homeAsUpEnable: Boolean
    protected abstract fun setupView()

    protected lateinit var binding: B

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, layoutRes, container, false)
        binding.lifecycleOwner = this
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupView()
    }


    override fun onAttach(context: Context) {
        super.onAttach(context)
        requireActivity().onBackPressedDispatcher.addCallback(this, onBackPressedCallback)
    }

    private val onBackPressedCallback = object : OnBackPressedCallback(true) {
        override fun handleOnBackPressed() {
            if (!onBackPressed()) {
                isEnabled = false
                requireActivity().onBackPressed()
            }
        }
    }

    /**
     * @return boolean Return false to allow normal onBackPressed processing to
     *         proceed, true to consume it here.
     * */
    open fun onBackPressed(): Boolean {
        return false
    }

    /**
     * Inline function to defer the initialization of the ViewModel directly in the fragment that
     * implements BaseFragment.
     *
     * @param creator: is a lambda
     * @return V: a child of ViewModel
     * */
    protected inline fun <reified T: fr.bendev.batchcookingapp.base.BaseViewModel> getViewModel(
        noinline creator: (() -> T)? = null
    ): T {
        return if (creator == null) {
            ViewModelProvider(this)[T::class.java]
        } else {
            ViewModelProvider(this, fr.bendev.batchcookingapp.base.BaseViewModelFactory(creator))[T::class.java]
        }
    }

}