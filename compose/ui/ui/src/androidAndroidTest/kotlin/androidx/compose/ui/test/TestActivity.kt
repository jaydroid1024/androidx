/*
 * Copyright 2019 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package androidx.compose.ui.test

import android.view.KeyEvent
import androidx.activity.ComponentActivity
import java.util.concurrent.CountDownLatch

class TestActivity : ComponentActivity() {

    var receivedKeyEvent: KeyEvent? = null

    var hasFocusLatch = CountDownLatch(1)

    override fun onWindowFocusChanged(hasFocus: Boolean) {
        super.onWindowFocusChanged(hasFocus)
        if (hasFocus) {
            hasFocusLatch.countDown()
        }
    }

    override fun onKeyDown(keyCode: Int, event: KeyEvent?): Boolean {
        receivedKeyEvent = event
        return super.onKeyDown(keyCode, event)
    }
}
