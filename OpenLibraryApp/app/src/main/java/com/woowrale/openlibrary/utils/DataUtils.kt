package com.woowrale.openlibrary.utils

import com.woowrale.openlibrary.BuildConfig
import com.woowrale.openlibrary.domain.model.Author
import com.woowrale.openlibrary.domain.model.Language
import com.woowrale.openlibrary.domain.model.Picture

class DataUtils {

    companion object {

        private val BASE_URL_SEED_API = BuildConfig.BASE_URL + BuildConfig.API_LIST
        private val BASE_URL_BOOK_API = BuildConfig.BASE_URL + BuildConfig.API_BOOKS

        fun concatUrl(url: String): String {
            return "https:$url";
        }

        fun getUrl(url: String): String {
            val urls = url.split("/")
            return urls?.get(2)
        }

        fun getBibKey(bibKey: String): String{
            val bibKey = bibKey.split(":")
            return bibKey?.get(1)
        }

        fun getSeedsUrl(seedId: String): String {
            val url = BASE_URL_SEED_API + seedId + BuildConfig.SEEDS_URL
            return url
        }

        fun getBookUrl(olid: String): String {
            val url = BASE_URL_BOOK_API + BuildConfig.URL_BOOK_BIBKEY + olid + BuildConfig.URL_JSCMD + BuildConfig.URL_JSON
            return url
        }

        fun getPictureUrl(picture: Picture?): String{
            var pUrl = ""
            if(picture != null){
                pUrl = picture.url!!
            }
            return pUrl
        }

        fun getAuthors(authors: List<Author>): String{
            var authorsList: String = ""
            for (author in authors){
                authorsList += author.name + ", "
            }
            return authorsList
        }

        fun getLanguages(languages: List<Language>): String{
            var languageList: String = ""
            for (language in languages){
                val lArray = language.key.split("/")
                languageList += lArray?.get(2)
            }
            return languageList
        }

        fun getSubjects(subjects: List<String>): String{
            var subjectList: String = ""
            for (subject in subjects){
                subjectList += subject + ", "
            }
            return subjectList
        }
    }

}