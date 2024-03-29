package com.group16.oauid

import android.graphics.pdf.PdfDocument
import android.os.Environment
import android.view.View
import java.io.File
import java.io.FileOutputStream
import java.io.IOException

fun createAndDownloadPdf(fileName: String, view: View) : FileOutputStream? {
    val document = PdfDocument()
    val pageInfo = PdfDocument.PageInfo.Builder(view.width, view.height, 1).create()
    val page = document.startPage(pageInfo)

    // Draw the view and its children onto the PDF page
    val canvas = page.canvas
    view.draw(canvas)

    document.finishPage(page)

    // Create a file for the PDF
    val directory = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS)
    val file = File(directory, fileName)

    return try {
        val output = FileOutputStream(file)
        document.writeTo(output)
        document.close()
        output.close()

        output
    } catch (e: IOException) {
        e.printStackTrace()
        null
    }
}
