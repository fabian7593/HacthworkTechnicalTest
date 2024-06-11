package com.hatchworks.newyorktimes.utils

//This is a list of constants for use in all application
//This use DRY variables to avoid repeting text in all the application
class Const {
    companion object {
        const val URL_ARCHIVE_API = "archive/v1/{year}/{month}.json"
        const val ARCHIVE_PARAM_YEAR = "year"
        const val ARCHIVE_PARAM_MONTH = "month"
        const val ARCHIVE_PARAM_API_KEY = "api-key"
    }
}




//archive/v1/2024/6.json?api-key=5ADNG9aWHAASfs4r0XaUsYUfQ2ThsoFg