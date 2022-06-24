package x.stefanji.audiovisulizer.view

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.util.Log
import android.view.View

/**
 * 自定义 Switch
 */
class TrackVolumeWave(context: Context?, attrs: AttributeSet?) : View(context, attrs) {

    private val paint = Paint(Paint.ANTI_ALIAS_FLAG)

    private var lineStartX = 40f + 12
    private var lineEndX = 0f
    private var lineNum = 0
    private var linePresent = mutableListOf<Float>()

    private var percent = 0f

    companion object LineNum {
        const val value = 108
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        // 背景
        paint.style = Paint.Style.FILL
        paint.color = Color.parseColor("#60440d")
        canvas.drawRoundRect(40f, 16f, width - 40f, height - 16f, 20f, 20f, paint)

        // 边框
        paint.strokeWidth = 4f
        paint.style = Paint.Style.STROKE
        paint.color = Color.parseColor("#FFB313")
        canvas.drawRoundRect(40f, 16f, width - 40f, height - 16f, 20f, 20f, paint)

        // 音频竖线
        paint.strokeWidth = 3f
        paint.strokeCap = Paint.Cap.ROUND
        paint.color = Color.parseColor("#dfdacf")
        lineEndX = width - lineStartX
//        while (lineStartX <= lineEndX) {
//            canvas.drawLine(lineStartX, 16f + 12f, lineStartX, height - 16f - 12f, paint)
////            lineNum++
//            lineStartX += 8f
//        }

        if (linePresent.size != 0)
            for (i in 1..108) {
                val h = (height - 32f) * linePresent[i - 1]
                canvas.drawLine(lineStartX, (height - h) / 2, lineStartX, (height + h) / 2, paint)
                lineStartX += 8f
            }


        // 播放进度竖线
        paint.strokeWidth = 16f
        paint.color = Color.parseColor("#4069DA")
        canvas.drawLine(56f, 32f, 56f, height - 32f, paint)

        Log.d("4d4q22wf", "" + lineNum)


    }

    fun drawLine(index: Int, value: Float) {
        linePresent.add(value)
        lineNum = index
        invalidate()
    }

    fun drawLine(list: List<Float>) {
        linePresent = list as MutableList<Float>
        invalidate()
    }

    fun setPresent(p: Float) {
        percent = p
        invalidate()
    }
}