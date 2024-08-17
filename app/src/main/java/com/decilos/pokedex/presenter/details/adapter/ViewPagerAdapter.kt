package com.decilos.pokedex.presenter.details.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter

class ViewPagerAdapter(manager: FragmentManager, lifeCycle: Lifecycle) :
    FragmentStateAdapter(manager, lifeCycle) {

    val pageList: ArrayList<Fragment> = ArrayList()

    override fun getItemCount(): Int = pageList.size

    override fun createFragment(position: Int): Fragment = pageList[position]

}