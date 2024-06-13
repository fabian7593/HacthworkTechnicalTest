package com.hatchworks.newyorktimes.utils

import android.widget.ImageView
import com.hatchworks.newyorktimes.R
import com.hatchworks.newyorktimes.models.Multimedia
import com.squareup.picasso.Picasso
import java.util.Calendar

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

        fun getCurrentMonth(): Int {
            val calendar = Calendar.getInstance()
            //the month is here from 0 to 11
            return calendar.get(Calendar.MONTH) + 1
        }

        fun getCurrentYear(): Int {
            val calendar = Calendar.getInstance()
            return calendar.get(Calendar.YEAR)
        }

        fun setPicassoToImageView(url : String?, imageView: ImageView?){
            Picasso.get()
                .load(if (url != null) GradleInfo.imgUrl + url else null)
                .fit()
                .centerInside()
                .placeholder(R.drawable.ic_hatchworks)
                .error(R.drawable.ic_hatchworks)
                .into(imageView)
        }
    }
}