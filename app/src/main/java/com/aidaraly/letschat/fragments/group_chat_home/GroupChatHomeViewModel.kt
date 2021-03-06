package com.aidaraly.letschat.fragments.group_chat_home

import androidx.lifecycle.ViewModel
import com.google.firebase.firestore.CollectionReference
import com.aidaraly.letschat.db.DbRepository
import com.aidaraly.letschat.utils.MPreference
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class GroupChatHomeViewModel @Inject constructor(
    private val preference: MPreference,
    private val dbRepository: DbRepository,
    private val usersCollection: CollectionReference) : ViewModel()  {


    fun getGroupMessages() = dbRepository.getGroupWithMessages()

    fun getGroupMessagesAsList() = dbRepository.getGroupWithMessagesList()


}