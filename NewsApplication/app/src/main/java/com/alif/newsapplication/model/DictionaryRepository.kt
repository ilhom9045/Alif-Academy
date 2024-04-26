package com.alif.newsapplication.model

import com.alif.newsapplication.model.dataSource.db.dictionary.entity.DictionaryEntity
import com.alif.newsapplication.model.dataSource.db.history.DataBaseDataSource
import com.alif.newsapplication.view.dictionary.vm.DictionaryResult

interface DictionaryRepository {

    suspend fun asyncLoadVictorinaWords(): DictionaryResult.VictorinaWordsModel

    suspend fun asyncLoadWordById(queryId: Int): DictionaryEntity


    class Base() : DictionaryRepository {

        private val dataBase = DataBaseDataSource.dictionaryDataBase.dictionaryDao()

        override suspend fun asyncLoadVictorinaWords(): DictionaryResult.VictorinaWordsModel {
            val result = dataBase.randomData()
            return DictionaryResult.VictorinaWordsModel(
                id = result.first().id,
                word = result.first().wordTj,
                answers = result.map { it.wordEng }.shuffled()
            )
        }

        override suspend fun asyncLoadWordById(queryId: Int): DictionaryEntity {
            return dataBase.wordById(queryId)
        }
    }
}