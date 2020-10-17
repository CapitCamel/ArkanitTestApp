package com.example.arkanittestapp


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_users.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class UsersFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val apiService = ServiceBuilder.buildService()
        GlobalScope.launch(Dispatchers.Main) {
            val usersRequest = apiService.getUsers()
            try {
                val response = usersRequest.await()

                recyclerView.apply {
                    setHasFixedSize(true)
                    layoutManager = LinearLayoutManager(context)
                    adapter = RvAdapter(response)
                }
            }catch (e: Exception){

            }
        }


        return inflater.inflate(R.layout.fragment_users, container, false)
    }


}
