/*
 * Created by dengshiwei on 2022/06/28.
 * Copyright 2015－2021 Sensors Data Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.sensorsdata.sdk.demo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.sensorsdata.analytics.android.sdk.visual.VisualizedAutoTrackService;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initLambdaButton();
        initButton();
    }

    public void onViewClick(View view) {

    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    public void test(View view) {
        TestUtil testUtil=new TestUtil();
        testUtil.testMethod();
        System.out.println("打的什么鬼");
    }

    private void initLambdaButton() {
        Button button = (Button) findViewById(R.id.lambdaButton);
        button.setOnClickListener(v -> {
            startActivity(new Intent(MainActivity.this, BActivity.class));
        });
    }

    private void initButton() {
        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                VisualizedAutoTrackService.getInstance().start(MainActivity.this, "110",
                        MyApplication.SA_SERVER_URL);
            }
        });
    }
}
