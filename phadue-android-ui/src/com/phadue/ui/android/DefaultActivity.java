package com.phadue.ui.android;

import android.app.Activity;
import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import com.phadue.R;
import com.phadue.communicator.MessageSender;

import java.io.IOException;

public class DefaultActivity extends Activity {

    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        final CheckBox checkBox = (CheckBox) findViewById(R.id.checkbox);
        final MessageSender messageSender = new MessageSender();

        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(final CompoundButton compoundButton, final boolean isChecked) {

                try {
                    if (isChecked) {
                        messageSender.send("1");
                    } else {
                        messageSender.send("0");
                    }
                } catch (IOException e) {
                    throw new IllegalStateException("Erro", e);
                }
            }
        });
    }
}
