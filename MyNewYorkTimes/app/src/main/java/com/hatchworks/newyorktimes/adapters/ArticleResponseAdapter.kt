package com.hatchworks.newyorktimes.adapters
import com.google.gson.*
import com.google.gson.reflect.TypeToken
import com.hatchworks.newyorktimes.models.Article
import com.hatchworks.newyorktimes.models.Keyword
import com.hatchworks.newyorktimes.models.Multimedia
import java.lang.reflect.Type

// This class is an adapter for convert json response information into an object article
// I can this mainly for use the information of by line original, main of the headline,
// And some another info for keywords and multimedia list
class ArticleResponseAdapter : JsonDeserializer<Article> {
    override fun deserialize(json: JsonElement, typeOfT: Type, context: JsonDeserializationContext): Article {
        val jsonObject = json.asJsonObject

        //if the results is not null continue after ?, then asign null
        val headlineMain = jsonObject.get("headline")?.asJsonObject?.get("main")?.asString ?: ""
        val abstractText = jsonObject.get("abstract")?.asString
        val description = jsonObject.get("lead_paragraph")?.asString
        val sectionName = jsonObject.get("section_name")?.asString
        val pubDate = jsonObject.get("pub_date")?.asString
        val webUrl = jsonObject.get("web_url")?.asString

        //Deserialize the Json Array of multimedia to typetoken List of multimedia object
        val multimedia = context.deserialize<List<Multimedia>>(
            jsonObject.getAsJsonArray("multimedia"),
            object : TypeToken<List<Multimedia>>() {}.type
        )

        val id = jsonObject.get("_id")?.asString
        val source = jsonObject.get("source")?.asString
        val printSection = jsonObject.get("print_section")?.asString
        val keywords = context.deserialize<List<Keyword>>(jsonObject.get("keywords"), List::class.java)
        val printPage = jsonObject.get("print_page")?.asString
        val bylineOriginal = jsonObject.get("byline")?.asJsonObject?.get("original")?.asString

        return Article(
            headlineMain,
            abstractText,
            description,
            sectionName,
            pubDate,
            webUrl,
            multimedia,
            id,
            source,
            printSection,
            keywords,
            printPage,
            bylineOriginal
        )
    }
}
