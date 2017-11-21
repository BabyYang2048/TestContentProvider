package com.example.babyyang.testcontentprovider;

import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button query_But;
    private String newId;
    private TextView showdb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        query_But = (Button)findViewById(R.id.query_data);
        showdb = (TextView)findViewById(R.id.showDB);
        query_But.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("content://com.example.babyyang.mywordapp.provider/words");
                Cursor cursor = getContentResolver().query(uri,null,null,null,null);
                if(cursor != null){
                    while(cursor.moveToNext()){
                        String word1 = cursor.getString(cursor.getColumnIndex("word"));
                        String word2 = cursor.getString(cursor.getColumnIndex("meaning"));
                        showdb.setText(showdb.getText().toString()+word1+word2+"\n");
                        Log.i("info",word1);
                        Log.i("info",word2);
                    }
                    cursor.close();
                }
            }
        });

    }
}
//    private static final String TAG="MyWordsTag";
//    private ContentResolver resolver;


//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        Button buttonAll=(Button)findViewById(R.id.btAll);

//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//
//        resolver = this.getContentResolver();

        //得到按钮

//        Button buttonInsert=(Button)findViewById(R.id.btAdd);
//        Button buttonDelete=(Button)findViewById(R.id.btDelete);
//        Button buttonDeleteAll=(Button)findViewById(R.id.btAllDelete);
//        Button buttonUpdate=(Button)findViewById(R.id.btUpdate);
//        Button buttonQuery=(Button)findViewById(R.id.btSearch);

        //为每个按钮设置监听器
//        buttonAll.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view){
//
//                Cursor cursor = resolver.query(
//                        Words.Word.CONTENT_URI,
//                        new String[] { Words.Word._ID,
//                                Words.Word.COLUMN_NAME_WORD,
//                                Words.Word.COLUMN_NAME_MEANING,
//                                Words.Word.COLUMN_NAME_SAMPLE },
//                        null, null, null);
//                if (cursor == null) {
//                    Toast.makeText(MainActivity.this, "没有找到记录", Toast.LENGTH_LONG).show();
//                    return;
//                }
//                String msg = "";
//                if (cursor.moveToFirst()){//找到记录，这里简单起见，使用Log输出
//                     do{
//                         msg += "ID:" + cursor.getInt(cursor.getColumnIndex(Words.Word._ID)) + ",";
//                         msg += "单词：" + cursor.getString(cursor.getColumnIndex(Words.Word.COLUMN_NAME_WORD))+ ",";
//                         msg += "含义：" + cursor.getInt(cursor.getColumnIndex(Words.Word.COLUMN_NAME_MEANING)) + ",";
//                         msg += "示例" + cursor.getFloat(cursor.getColumnIndex(Words.Word.COLUMN_NAME_SAMPLE)) + "\n";
//                     }while(cursor.moveToNext());
//                }
//                Log.v(TAG,msg);
//            }
//        });
//        buttonUpdate.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                String id="3";
//                String strWord="Banana";
//                String strMeaning="banana";
//                String strSample="This banana is very nice.";
//                ContentValues values = new ContentValues();
//                values.put(Words.Word.COLUMN_NAME_WORD, strWord);
//                values.put(Words.Word.COLUMN_NAME_MEANING, strMeaning);
//                values.put(Words.Word.COLUMN_NAME_SAMPLE, strSample);
//                Uri uri = Uri.parse(Words.Word.CONTENT_URI_STRING + "/" + id);
//                int result = resolver.update(uri, values, null, null);
//            }
//        });

//        buttonInsert.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                String strWord="Banana";
//                String strMeaning="banana";
//                String strSample="This banana is very nice.";
//                ContentValues values = new ContentValues();
//
//                values.put(Words.Word.COLUMN_NAME_WORD, strWord);
//                values.put(Words.Word.COLUMN_NAME_MEANING, strMeaning);
//                values.put(Words.Word.COLUMN_NAME_SAMPLE, strSample);
//
//                Uri newUri = resolver.insert(Words.Word.CONTENT_URI, values);
//            }
//        });
//
//        buttonDelete.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                String id="3";//简单起见，这里指定ID，用户可在程序中设置id的实际值
//                Uri uri = Uri.parse(Words.Word.CONTENT_URI_STRING + "/" + id);
//                int result = resolver.delete(uri, null, null);
//            }
//        });
//
//        buttonDeleteAll.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                resolver.delete(Words.Word.CONTENT_URI, null, null);
//            }
//        });
//
//        buttonQuery.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                String id="3";
//                   Uri uri = Uri.parse(Words.Word.CONTENT_URI_STRING + "/" + id);
//                   Cursor cursor = resolver.query(Words.Word.CONTENT_URI,
//                           new String[] { Words.Word._ID,
//                                   Words.Word.COLUMN_NAME_WORD,
//                                   Words.Word.COLUMN_NAME_MEANING,
//                                   Words.Word.COLUMN_NAME_SAMPLE },
//                           null, null, null);
//                if (cursor == null){
//                    Toast.makeText(MainActivity.this,"没有找到记录",Toast.LENGTH_LONG).show();
//                    return;
//                }
//                //找到记录，这里简单起见，使用Log输出
//                String msg = "";
//                if (cursor.moveToFirst()){
//                    do{
//                        msg += "ID:" + cursor.getInt(cursor.getColumnIndex(Words.Word._ID)) + ",";
//                        msg += "单词：" + cursor.getString(cursor.getColumnIndex(Words.Word.COLUMN_NAME_WORD))+ ",";
//                        msg += "含义：" + cursor.getInt(cursor.getColumnIndex(Words.Word.COLUMN_NAME_MEANING)) + ",";
//                        msg += "示例" + cursor.getFloat(cursor.getColumnIndex(Words.Word.COLUMN_NAME_SAMPLE)) + "\n";
//                    }while(cursor.moveToNext());
//                }
//            }
//        });
//
//        }

//}

