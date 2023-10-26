package com.spcreations.tutorsapp

import androidx.lifecycle.*
import com.spcreations.tutorsapp.data.Batch
import com.spcreations.tutorsapp.data.Student
import com.spcreations.tutorsapp.data.User
import kotlinx.coroutines.Job
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

class TutorViewModel(private val repository: TutorRepository): ViewModel() {

    private val _result = MutableLiveData<Int>()
    val result: LiveData<Int> = _result

    fun insertUser(user: User)= viewModelScope.launch {
        repository.insertUser(user)
    }

    fun insertBatch(batch:Batch) = viewModelScope.launch {
        repository.insertBatch(batch)
    }

    fun insertStudent(student: Student) = viewModelScope.launch {
        repository.insertStudent(student)
    }

    fun verifyLogin(email:String, password:String):LiveData<Int> {
        return repository.verifyLogin(email,password)
    }

   /* private suspend fun loginVerification(email:String, password:String):Int  {
      delay(1000)
       return repository.verifyLogin(email,password)
    }

    fun verifyLogin(email: String,password: String){
        viewModelScope.launch{
            val deferredResult = async{ loginVerification(email,password)}
            _result.value =deferredResult.await()

        }

    }*/


}

class TutorViewModelFactory(private val tutorRepository: TutorRepository): ViewModelProvider.Factory{
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(TutorViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return TutorViewModel(tutorRepository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }

}