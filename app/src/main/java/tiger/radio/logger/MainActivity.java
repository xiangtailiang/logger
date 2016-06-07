package tiger.radio.logger;

import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import java.io.File;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initLogger();
    }

    private void initLogger() {
        String outputDir = Environment.getExternalStorageDirectory().getAbsolutePath() + "/logger";
        File file = new File(outputDir);
        if (!file.isDirectory()) {
            file.delete();
        }
        if (!file.exists()) {
            file.mkdirs();
        }
        Logger.configure(new File(outputDir), "test");
    }

    private int count = 100000;

    public void onLogBtnClick(final View v) {
        Logger.d(TAG, "onLogBtnClick");
        v.postDelayed(new Runnable() {
            @Override
            public void run() {

                Logger.d(TAG, "log log log log log log log log     private void initLogger() {\n" +
                        "        String outputDir = Environment.getExternalStorageDirectory().getAbsolutePath() + \"/logger\";\n" +
                        "        File file = new File(outputDir);\n" +
                        "        if (!file.isDirectory()) {\n" +
                        "            file.delete();\n" +
                        "        }\n" +
                        "        if (!file.exists()) {\n" +
                        "            file.mkdirs();\n" +
                        "        }\n" +
                        "        Logger.configure(new File(outputDir), \"test\");\n" +
                        "    }");

                if (count-- > 0) {
                    v.postDelayed(this, 500);
                }
            }
        }, 100);


    }

}
