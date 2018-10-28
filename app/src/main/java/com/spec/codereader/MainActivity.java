package com.spec.codereader;

import android.app.*;
import android.os.*;
import android.view.*;
import android.view.View.*;
import android.widget.*;
import java.io.*;

public class MainActivity extends Activity 
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
		
		Button btn =(Button)findViewById(R.id.btn1);
		
		
		final TextView tv,nulls,ms;
		final EditText path;

		tv = (TextView)findViewById(R.id.result);
		nulls = (TextView)findViewById(R.id.nullline);
		ms = (TextView)findViewById(R.id.mark);
		path = (EditText)findViewById(R.id.Path);
		
		btn.setOnClickListener(new OnClickListener(){

				@Override
				public void onClick(View p1)
				{
					if(!path.getText().toString().equals("")){
						File f = new File(path.getText().toString());
					//int line;
					Counter c = new Counter();

					int t = c.ReadLine(f.listFiles());
					//c.printInfo();

					//tv.setText("一共有："+String.valueOf(t)+" 行");
					
					int[] info = c.getFullInfo();
					tv.setText("一共有："+String.valueOf(info[0])+" 行");
					nulls.setText("有："+String.valueOf(info[1])+" 条空行");
						ms.setText("有："+String.valueOf(info[2])+" 条注释行");
					}
				}
				
			
		});
   }
	
	
}
