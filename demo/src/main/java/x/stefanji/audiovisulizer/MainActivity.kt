package x.stefanji.audiovisulizer

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import x.stefanji.audiovisulizer.view.TrackVolumeWaveHelp

private const val TAG = "Main"
private const val MP3 = "output.mp3"
private const val M4a = "test.m4a"
private const val f1 = "t.pcm"
private const val f2 = "t.mp3"
private const val f3 = "t2.mp3"
private const val f4 = "5.pcm"
//private const val INPUT_FILE = f4

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.btnStart).setOnClickListener {
            TrackVolumeWaveHelp.drawFile(
                this@MainActivity,
                "/sdcard/z.mp3", findViewById(R.id.tvw)
            )
        }
    }
}
