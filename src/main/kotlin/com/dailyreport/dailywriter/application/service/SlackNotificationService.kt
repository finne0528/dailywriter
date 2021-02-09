package com.dailyreport.dailywriter.application.service

import com.dailyreport.dailywriter.application.lib.extension.formatDateSimply
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.RequestBody.Companion.toRequestBody
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Call
import okhttp3.Callback
import okhttp3.Response
import org.springframework.stereotype.Service
import java.io.IOException
import java.time.LocalDate

@Service
class SlackNotificationService {
    private val httpClient: OkHttpClient = OkHttpClient.Builder().build()

    fun sendDailyreportRegisterNotification(date: LocalDate, doneContent: String, memo: String? = null) {
        //TODO: webhook url は yaml とかで設定できるようにしたい（時間がなくてできん）
        val request: Request = Request.Builder()
            .url("replace to your slack webhook url here.")
            .post(buildPostJson(date, doneContent, memo).toRequestBody("application/json; charset=utf-8".toMediaType()))
            .build()

        httpClient.newCall(request).enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) {
                TODO("Not yet implemented")
            }

            override fun onResponse(call: Call, response: Response) {
                response.use { res ->
                    if (!res.isSuccessful) {
                        TODO("Not yet implemented")
                    }
                }
            }
        })
    }

    private fun buildPostJson(date: LocalDate, doneContent: String, memo: String? = null): String {
        //TODO: フォーマットを設定できたらかっこいいかも
        val memoText = if (memo != null) "\nメモ: $memo" else ""
        return "{\"text\": \"日報が投稿されました\n\n作業日: ${date.formatDateSimply()}\n作業内容: $doneContent$memoText\"}"
    }
}