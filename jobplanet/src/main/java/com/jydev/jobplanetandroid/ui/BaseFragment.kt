package com.jydev.jobplanetandroid.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment
import androidx.navigation.NavDirections
import androidx.navigation.fragment.NavHostFragment.findNavController
import androidx.viewbinding.ViewBinding

abstract class BaseFragment<Binding : ViewBinding> constructor(
    @LayoutRes private val contentLayoutId: Int
) : Fragment() {

    private var _binding: Binding? = null
    val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = getFragmentBinding(inflater, container)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        observeView()
        setUpView()
    }

    protected fun NavDirections.navigate(){
        findNavController(this@BaseFragment).navigate(this)
    }

    protected fun String.showShortToast(){
        context?.let {
            Toast.makeText(it,this,Toast.LENGTH_SHORT).show()
        }
    }

    abstract fun getFragmentBinding(inflater: LayoutInflater, container: ViewGroup?): Binding
    open fun setUpView(){}
    open fun observeView(){}

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}