package com.hatchworks.newyorktimes.utils


import java.util.Properties
import java.io.FileInputStream

//This class works as a singleton class
//This class have the contructor method to init gradle properties
//And then get secret variables, as apei keys, urls, and others from gradle.properties
object GradleInfo {

    //Instance the object properties
    private val properties = Properties()

    init {
        //read the file gradle.properties
        val file = FileInputStream("gradle.properties")

        //load file in the instance of properties
        properties.load(file)
        file.close()
    }

    //get the base url, as a "static" variable
    val baseUrl: String
        get() = properties.getProperty("NYT_BASE_URL", "")
}
