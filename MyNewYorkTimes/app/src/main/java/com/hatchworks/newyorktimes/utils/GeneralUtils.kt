package com.hatchworks.newyorktimes.utils

import com.hatchworks.newyorktimes.models.Multimedia

class GeneralUtils {
    companion object {

        //This method verify the type and subtype of the image
        fun getUrlMultimedia(multimediaList: List<Multimedia>, subtype: String): String?{
            for (multimediaItem in multimediaList) {
                if (multimediaItem.type == Const.IMG_TYPE &&
                    multimediaItem.subtype == subtype) {
                    return multimediaItem.url ?: null
                }
            }
            return null
        }
    }
}