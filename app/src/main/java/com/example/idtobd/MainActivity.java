package com.example.idtobd;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputType;
import android.text.TextWatcher;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.EditText;
import android.content.res.Resources;
import android.util.TypedValue;
import android.graphics.Color;

import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {

    private String digInString,month,gender,day,year;
    private int digits,dayInt;

    private int dayFinder(int digits){
        return digits%1000;

    }
    private int realDay(int day){
        if(day>500) day=day-500;
        return  day;
    }
    private String yearFinder(int digits){
        return String.valueOf((digits-(digits%1000))/1000);
    }
    private String monthFinder(int day) {

        if (day > 0 && day <= 31) {

            return "January";

        } else if (day > 31 && day <= 60) {

            return "February";

        } else if (day > 60 && day <= 91) {

            return "March";

        } else if (day > 91 && day <= 121) {

            return "April";

        } else if (day > 121 && day <= 152) {

            return "May";

        } else if (day > 152 && day <= 182) {

            return "June";

        } else if (day > 182 && day <= 213) {

            return "July";

        } else if (day > 213 && day <= 244) {

            return "August";

        } else if (day > 244 && day <= 274) {

            return "September";

        } else if (day > 274 && day <= 305) {

            return "October";

        } else if (day > 305 && day <= 335) {

            return "November";

        } else if (day > 335 && day <= 366) {

            return "December";

        }
        else return " ";

    }
    private int monthDayFinder(int day) {

        if (day > 0 && day <= 31) {

            return day - 0;

        } else if (day > 31 && day <= 60) {

            return day - 31;

        } else if (day > 60 && day <= 91) {

            return day - 60;

        } else if (day > 91 && day <= 121) {

            return day - 91;

        } else if (day > 121 && day <= 152) {

            return day - 121;

        } else if (day > 152 && day <= 182) {

            return day - 152;

        } else if (day > 182 && day <= 213) {

            return day - 182;

        } else if (day > 213 && day <= 244) {

            return day - 213;

        } else if (day > 244 && day <= 274) {

            return day - 244;

        } else if (day > 274 && day <= 305) {

            return day - 274;

        } else if (day > 305 && day <= 335) {

            return day - 305;

        } else if (day > 335 && day <= 366) {

            return day - 335;

        }
        else {
            return 0;
        }
    }
    private String genderFinder(int day) {

        if (day >= 0 && day <=366) {

            return "Male";
        }
        else if (day >= 500 && day <= 866) {

            return "Female";
        }
        else return " ";
    }

    @SuppressLint("ResourceType")
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Resources r=getResources();
        int pxMar=(int)TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,100,r.getDisplayMetrics());
        int pxNum=(int)TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,70,r.getDisplayMetrics());

        RelativeLayout relativeLayout=new RelativeLayout(this);
        relativeLayout.setBackgroundColor(Color.BLACK);


        final EditText editText=new EditText(this);
        editText.setInputType(InputType.TYPE_CLASS_NUMBER);
        editText.setWidth(pxNum);
        editText.setTextColor(Color.WHITE);
        editText.setTextSize(TypedValue.COMPLEX_UNIT_DIP,20);

        editText.setId(1);
        RelativeLayout.LayoutParams editTextData=new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT
        );

        editTextData.addRule(RelativeLayout.CENTER_HORIZONTAL);
        editTextData.addRule(RelativeLayout.CENTER_VERTICAL);


        final TextView textView=new TextView(this);
        textView.setTextSize(TypedValue.COMPLEX_UNIT_DIP,20);
        textView.setTextColor(Color.WHITE);
        textView.setText("Birth Day");

        RelativeLayout.LayoutParams textViewData=new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT
        );

        textViewData.addRule(RelativeLayout.CENTER_HORIZONTAL);
        textViewData.addRule(RelativeLayout.ABOVE,editText.getId());
        textViewData.setMargins(0,0,0,pxMar);


        relativeLayout.addView(editText,editTextData);
        relativeLayout.addView(textView,textViewData);

        setContentView(relativeLayout);

        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {

                digInString=editText.getText().toString();

                if(digInString.length()==5){

                    digits=Integer.parseInt(digInString);

                    year = yearFinder(digits);

                    dayInt=dayFinder(digits);

                    month=monthFinder(realDay(dayInt));

                    day=String.valueOf(monthDayFinder(realDay(dayInt)));

                    gender=genderFinder(dayInt);

                    textView.setText("19"+year+" - "+month+" - "+day+" ( "+gender+" )");
                }
                else{
                    textView.setText("Birth Day");
                }

            }
        });
    }
}

