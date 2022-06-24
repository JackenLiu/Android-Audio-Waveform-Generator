package x.stefanji.audiovisulizer.view

import android.content.Context
import x.stefanji.audiovisulizer.pcmToWav
import x.stefanji.library.AudioWaveformGenerator
import java.io.File

object TrackVolumeWaveHelp {

    fun drawFile(context: Context, path: String, view: TrackVolumeWave) {
        Thread {
            val file = File(path)
            pcmToWav(file.absolutePath, context.cacheDir.absolutePath + "/t.wav", 44100, 2, 16)
            val decoder = AudioWaveformGenerator(
                file.absolutePath,
//                context.cacheDir.absolutePath + "/t.wav",
                108
            )
            decoder.startDecode()
            val samples = decoder.getSampleData()
            view.post {
                view.drawLine(samples)
            }
        }.start()
    }


}