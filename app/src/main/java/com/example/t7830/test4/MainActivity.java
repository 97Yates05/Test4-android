package com.example.t7830.test4;

import android.Manifest;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private EditText editText;
    private RadioGroup radioGroup;
    private EditText editText1;
    private CheckBox checkBox1, checkBox2, checkBox3;
    private SeekBar seekBar;
    private ImageView imageView;
    private TextView textView1, textView2, textView3;
    private Button button1, button2;
    private List<Book> list_books;
    private List<Book> list_get;
    private Person person;
    private Date date;
    private Date back_date;
    private TextView back;
    private DateFormat dateFormat;
    private int b = 0;


    public void init() {
        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        editText = findViewById(R.id.edit_text);
        editText1 = findViewById(R.id.edit_text1);
        radioGroup = findViewById(R.id.button);
        checkBox1 = findViewById(R.id.checkbox1);
        checkBox2 = findViewById(R.id.checkbox2);
        checkBox3 = findViewById(R.id.checkbox3);
        seekBar = findViewById(R.id.bar);
        imageView = findViewById(R.id.image1);
        textView1 = findViewById(R.id.text1);
        textView2 = findViewById(R.id.text3);
        textView3 = findViewById(R.id.text4);
        back = findViewById(R.id.back);
        person = new Person();
        dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        list_books = new ArrayList<>();
        list_get = new ArrayList<>();
        list_books.add(new Book("中国古代文学", 13, R.drawable.ff, true, false, false));
        list_books.add(new Book("宋词三百首", 6, R.drawable.ee, false, false, true));
        list_books.add(new Book("sapir", 20, R.drawable.cc, false, true, false));
        list_books.add(new Book("人生感悟", 15, R.drawable.aa, false, true, false));
        list_books.add(new Book("边城", 25, R.drawable.bb, false, true, false));
        list_books.add(new Book("光辉岁月", 18, R.drawable.dd, true, false, false));
        list_books.add(new Book("无花果", 20, R.drawable.gg, false, false, true));
        back_date = new Date();
        back.setText(dateFormat.format(back_date));
        System.out.println();

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        setListener();

    }

    private void setListener() {
        CheckboxListener checkBoxlistener = new CheckboxListener();
        ClickListener clickListener = new ClickListener();
        RadioListener radioListener = new RadioListener();
        SeekBarListener seekBarListener = new SeekBarListener();
        radioGroup.setOnCheckedChangeListener(radioListener);
        checkBox1.setOnCheckedChangeListener(checkBoxlistener);
        checkBox2.setOnCheckedChangeListener(checkBoxlistener);
        checkBox3.setOnCheckedChangeListener(checkBoxlistener);
        seekBar.setOnSeekBarChangeListener(seekBarListener);
        button1.setOnClickListener(clickListener);
        button2.setOnClickListener(clickListener);
    }

    private void check_data() {
        for (Book book : list_books) {
            if ((seekBar.getProgress() >= book.getAge() && (person.getHistory() == book.getHistory() ||
                    person.getSuspense() == book.getSuspense() || person.getLiterary() == book.getLiterary()))) {
                list_get.add(book);

            }
        }
        System.out.println(list_get.size());
    }

    class ClickListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {

            try {
                date = dateFormat.parse(editText1.getText().toString());
            } catch (ParseException e) {
                e.printStackTrace();
            }

            switch (v.getId()) {

                case R.id.button1:
                    if (date.getTime() < back_date.getTime()) {
                        person.setAge(seekBar.getProgress());
                        person.setName(editText.getText().toString());
                        person.setTime(editText1.getText().toString());
                        list_get.clear();
                        b=0;
                        imageView.setImageResource(R.drawable.f);
                        textView1.setText("书名");
                        textView2.setText("类型");
                        textView3.setText("适用年龄");
                        check_data();
                        if (list_get.size() != 0) {
                            Toast.makeText(MainActivity.this, person.toString(), Toast.LENGTH_SHORT).show();
                            imageView.setImageResource(list_get.get(b).getImage_id());
                            textView1.setText(list_books.get(b).getBook_name());
                            textView2.setText(list_books.get(b).getType());
                            textView3.setText(String.valueOf(list_books.get(b).getAge()));
                        }else{
                            Toast.makeText(MainActivity.this,"没有查询到符合条件的书籍！",Toast.LENGTH_SHORT).show();
                        }
                    } else {
                        finish();
                    }
                    break;
                case R.id.button2:
                    b++;
                    if (b < list_get.size()) {
                        Toast.makeText(MainActivity.this, person.toString(), Toast.LENGTH_SHORT).show();
                        imageView.setImageResource(list_get.get(b).getImage_id());
                        textView1.setText(list_books.get(b).getBook_name());
                        textView2.setText(list_books.get(b).getType());
                        textView3.setText(String.valueOf(list_books.get(b).getAge()));
                    } else {
                        Toast.makeText(MainActivity.this, "已经到最后一个", Toast.LENGTH_SHORT).show();
                    }
                    break;
            }

        }
    }

    class SeekBarListener implements SeekBar.OnSeekBarChangeListener {
        @Override
        public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

        }

        @Override
        public void onStartTrackingTouch(SeekBar seekBar) {

        }

        @Override
        public void onStopTrackingTouch(SeekBar seekBar) {
            Toast.makeText(MainActivity.this, "年龄:" + seekBar.getProgress(), Toast.LENGTH_SHORT).show();
        }
    }

    class RadioListener implements RadioGroup.OnCheckedChangeListener {
        @Override
        public void onCheckedChanged(RadioGroup group, int checkedId) {
            switch (checkedId) {
                case R.id.man:
                    person.setSex("男");
                    break;
                case R.id.woman:
                    person.setSex("女");
                    break;
            }

        }
    }

    class CheckboxListener implements CompoundButton.OnCheckedChangeListener {
        @Override
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            switch (buttonView.getId()) {
                case R.id.checkbox1:
                    if (isChecked) {
                        person.setHistory(true);
                    } else {
                        person.setHistory(false);
                    }
                    break;
                case R.id.checkbox2:
                    if (isChecked) {
                        person.setSuspense(true);
                    } else {
                        person.setSuspense(false);
                    }
                    break;
                case R.id.checkbox3:
                    if (isChecked) {
                        person.setLiterary(true);
                    } else {
                        person.setLiterary(false);
                    }
                    break;
            }
        }
    }
}
