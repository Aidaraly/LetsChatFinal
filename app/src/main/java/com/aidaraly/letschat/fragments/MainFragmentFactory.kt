package com.aidaraly.letschat.fragments

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentFactory
import com.aidaraly.letschat.fragments.contacts.FContacts
import com.aidaraly.letschat.utils.MPreference
import javax.inject.Inject

class MainFragmentFactory @Inject constructor(
private val preference: MPreference
) : FragmentFactory() {

    override fun instantiate(classLoader: ClassLoader, className: String): Fragment {
        return when(className) {
            FContacts::class.java.name -> FContacts(preference)
            else -> super.instantiate(classLoader, className)
        }

    }
}