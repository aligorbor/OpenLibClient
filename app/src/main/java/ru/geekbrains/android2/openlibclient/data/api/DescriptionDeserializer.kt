package ru.geekbrains.android2.openlibclient.data.api

import com.google.gson.JsonDeserializationContext
import com.google.gson.JsonDeserializer
import com.google.gson.JsonElement
import ru.geekbrains.android2.openlibclient.data.book.Description
import java.lang.reflect.Type

class DescriptionDeserializer : JsonDeserializer<Description> {
    override fun deserialize(
        json: JsonElement?,
        typeOfT: Type?,
        context: JsonDeserializationContext?
    ): Description {
        json?.let {
            when {
                it.isJsonPrimitive -> {
                    return Description("/type/text", json.toString())
                }
                else -> {
                    return Description(
                        json.asJsonObject.get("type").asString,
                        json.asJsonObject.get("value").asString
                    )
                }
            }
        }
        return Description("", "Description is empty")
    }

}