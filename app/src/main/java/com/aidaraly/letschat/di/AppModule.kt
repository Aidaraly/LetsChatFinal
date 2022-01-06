package com.aidaraly.letschat.di

import com.google.firebase.firestore.CollectionReference
import com.google.firebase.firestore.FirebaseFirestore
import com.aidaraly.letschat.db.DbRepository
import com.aidaraly.letschat.db.DefaultDbRepo
import com.aidaraly.letschat.db.daos.ChatUserDao
import com.aidaraly.letschat.db.daos.GroupDao
import com.aidaraly.letschat.db.daos.GroupMessageDao
import com.aidaraly.letschat.db.daos.MessageDao
import com.aidaraly.letschat.ui.activities.MainActivity
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Qualifier
import javax.inject.Singleton

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class MessageCollection

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class GroupCollection

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideFireStoreInstance(): FirebaseFirestore {
        return FirebaseFirestore.getInstance()
    }

    @Singleton
    @Provides
    fun provideUsersCollectionRef(firestore: FirebaseFirestore): CollectionReference {
        return firestore.collection("Users")
    }

    @MessageCollection
    @Singleton
    @Provides
    fun provideMessagesCollectionRef(firestore: FirebaseFirestore): CollectionReference {
        return firestore.collection("Messages")
    }

    @GroupCollection
    @Singleton
    @Provides
    fun provideGroupCollectionRef(firestore: FirebaseFirestore): CollectionReference {
        return firestore.collection("Groups")
    }

    @Provides
    fun provideMainActivity(): MainActivity {
        return MainActivity()
    }

    @Provides
    fun provideDefaultDbRepo(userDao: ChatUserDao,
                             groupDao: GroupDao,
                             groupMsgDao: GroupMessageDao,
                             messageDao: MessageDao): DefaultDbRepo {
        return DbRepository(userDao, groupDao, groupMsgDao, messageDao)
    }

}