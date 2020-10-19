package com.example.arkanittestapp


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import kotlinx.android.synthetic.main.fragment_users.*
import kotlinx.coroutines.launch

class UsersFragment : Fragment(), RvAdapter.Listener {

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_users, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        retry.setOnClickListener { loadData() }
        loadData()
    }

    enum class UsersFragmentState { Loaded, Loading, Error }

    private var state: UsersFragmentState = UsersFragmentState.Loading
        set(value) {
            consumeState(value)
            field = value
        }

    private fun loadData() = viewLifecycleOwner.lifecycleScope.launch {
        state = UsersFragmentState.Loading
        val apiService = ServiceBuilder.buildService()

        try {
            val users = apiService.getUsers()
            val posts = apiService.getPosts()

            recyclerView.adapter = RvAdapter(users, posts, this@UsersFragment)

            state = UsersFragmentState.Loaded
        } catch (e: Exception) {
            state = UsersFragmentState.Error
        }

    }

    private fun consumeState(state: UsersFragmentState) = when (state) {
        UsersFragmentState.Loaded -> setLoadedState()
        UsersFragmentState.Loading -> setLoadingState()
        UsersFragmentState.Error -> setErrorState()
    }

    private fun setErrorState() {
        recyclerView.visibility = View.INVISIBLE
        error.visibility = View.VISIBLE
        loading.visibility = View.INVISIBLE
    }

    private fun setLoadingState() {
        recyclerView.visibility = View.INVISIBLE
        error.visibility = View.INVISIBLE
        loading.visibility = View.VISIBLE
    }

    private fun setLoadedState() {
        recyclerView.visibility = View.VISIBLE
        error.visibility = View.INVISIBLE
        loading.visibility = View.INVISIBLE
    }

    override fun onItemClick(uri: String) {
        if (activity is MainActivity) {
            (activity as MainActivity).onItemClick(uri)

        }
    }
}


