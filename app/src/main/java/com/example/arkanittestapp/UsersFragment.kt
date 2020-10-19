package com.example.arkanittestapp


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_users.*
import kotlinx.android.synthetic.main.user_item.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class UsersFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_users, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val apiService = ServiceBuilder.buildService()

        viewLifecycleOwner.lifecycleScope.launch(Dispatchers.IO) {
            try {
                val users = apiService.getUsers()
                val posts = apiService.getPosts()

                withContext(Dispatchers.Main){
                    recyclerView.adapter = RvAdapter(users, posts)
                }
            }catch (e: Exception){

            }
        }
    }
}
