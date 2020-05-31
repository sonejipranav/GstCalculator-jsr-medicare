package com.gst.gstcalculator;

import android.app.Dialog;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;
//import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    int selectid;
    EditText pEdit;
    TextView pText;
    TextView info;
    TextView copyval;
    RadioGroup radioGroup;

    private Context context = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // layout instances
        Button button = (Button) findViewById(R.id.button_send);

        Button buttonn = (Button) findViewById(R.id.button_clear);

        info = (TextView)findViewById(R.id.textView6);

        copyval = (TextView)findViewById(R.id.textView);



        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                pEdit = (EditText)findViewById(R.id.editText);
                pText = (TextView)findViewById(R.id.textView);
                double price = Double.parseDouble(pEdit.getText().toString());
                double p1 = 0;
                double sale = 0;

                if(selectid == 1) {
                    sale = price - 0.17*price;
                    pText.setText(String.valueOf(sale));
                    //Toast.makeText(getApplicationContext(),"Option 5 -" + sale,Toast.LENGTH_SHORT).show();
                }
                else if (selectid == 2) {
                    sale = price - 0.29*price;
                    pText.setText(String.valueOf(sale));
                    //Toast.makeText(getApplicationContext(),"Option 12 -" + sale,Toast.LENGTH_SHORT).show();
                }

                else if (selectid == 3) {
                    p1 = price - 0.20*price;
                    sale = p1 - 0.18*p1;
                    pText.setText(String.valueOf(sale));
                    //Toast.makeText(getApplicationContext(),"Option 18 -" + sale,Toast.LENGTH_SHORT).show();
                }

                else if (selectid == 4) {
                    p1 = price - 0.20*price;
                    sale = p1 - 0.28*p1;
                    pText.setText(String.valueOf(sale));
                    //Toast.makeText(getApplicationContext(),"Option 28 -" + sale,Toast.LENGTH_SHORT).show();
                }

            }
        });



        buttonn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                radioGroup = findViewById(R.id.radioGst);

                pEdit.setText("");
                radioGroup.clearCheck();
                pText.setText("0.0");

            }
        });


        copyval.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                String text;
                text = copyval.getText().toString();
                ClipboardManager clipboard = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
                ClipData clip = ClipData.newPlainText("text", text);
                clipboard.setPrimaryClip(clip);

                Toast toast = Toast.makeText(getApplicationContext(), " Copied", Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.BOTTOM | Gravity.CENTER , 0 , 0);
                toast.show();

            }
        });


        info.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                final Dialog dialog = new Dialog(context);
                dialog.setContentView(R.layout.custom);
                dialog.setTitle("Developer Contact");
                TextView dialogTextContent = dialog.findViewById(R.id.dialog_text);

                Button dialogCloseButton = (Button)dialog.findViewById(R.id.dialog_button);
                dialogCloseButton.setOnClickListener(new View.OnClickListener(){
                    @Override
                    public void onClick(View v) {

                        dialog.dismiss();
                    }
                });
                dialog.show();

            }
        });


    } // on create close


    public void onRadioButtonClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch(view.getId()) {

            case R.id.radioButton1:
                if (checked) {
                    selectid = 1;
                }
                break;
            case R.id.radioButton2:
                if (checked) {
                    selectid = 2;
                }
                break;
            case R.id.radioButton3:
                if (checked) {
                    selectid = 3;
                }
                break;
            case R.id.radioButton4:
                if (checked) {
                    selectid = 4;
                }
                break;
        }
    }


}