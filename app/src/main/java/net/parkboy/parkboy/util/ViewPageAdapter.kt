package net.parkboy.parkboy.util

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter

class ViewPageAdapter : FragmentPagerAdapter {
    constructor(fm: FragmentManager?) : super(fm)

    var fragmentList: MutableList<Fragment> = arrayListOf()
    var fragmentListTittles: MutableList<String> = arrayListOf()
    override fun getItem(position: Int): Fragment {
        return fragmentList[position]
    }

    override fun getCount(): Int {
        return fragmentListTittles.size
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return fragmentListTittles[position]
    }

    fun AddFragment(frag: Fragment, tittle: String) {
        fragmentList.add(frag)
        fragmentListTittles.add(tittle)
    }
}