package com.russia.app_calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.BaseInputConnection;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    /*khai bao cac thanh phan cua view trong xml*/
    private EditText edt_NumberInput;
    private TextView tv_Result;
    private Button btn_1;
    private Button btn_2;
    private Button btn_3;
    private Button btn_4;
    private Button btn_5;
    private Button btn_6;
    private Button btn_7;
    private Button btn_8;
    private Button btn_9;
    private Button btn_0;
    private Button btn_Cong;
    private Button btn_Tru;
    private Button btn_Nhan;
    private Button btn_Chia;
    private Button btn_Bang;
    private Button btn_Dot;
    private Button btn_AC;
    private Button btn_C;

    public void connectView() {
        edt_NumberInput = findViewById(R.id.edt_NumberInput);
        tv_Result = findViewById(R.id.tv_Result);
        btn_0 = findViewById(R.id.btn_0);
        btn_1 = findViewById(R.id.btn_1);
        btn_2 = findViewById(R.id.btn_2);
        btn_3 = findViewById(R.id.btn_3);
        btn_4 = findViewById(R.id.btn_4);
        btn_5 = findViewById(R.id.btn_5);
        btn_6 = findViewById(R.id.btn_6);
        btn_7 = findViewById(R.id.btn_7);
        btn_8 = findViewById(R.id.btn_8);
        btn_9 = findViewById(R.id.btn_9);
        btn_Cong = findViewById(R.id.btn_Cong);
        btn_Tru = findViewById(R.id.btn_Tru);
        btn_Nhan = findViewById(R.id.btn_Nhan);
        btn_Chia = findViewById(R.id.btn_Chia);
        btn_Bang = findViewById(R.id.btn_Bang);
        btn_Dot = findViewById(R.id.btn_Dot);
        btn_AC = findViewById(R.id.btn_ClearAll);
        btn_C = findViewById(R.id.btn_Clear);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        connectView();
        setEventOnClickButton();
    }


    public void setEventOnClickButton() {
        btn_1.setOnClickListener(this);
        btn_2.setOnClickListener(this);
        btn_3.setOnClickListener(this);
        btn_4.setOnClickListener(this);
        btn_5.setOnClickListener(this);
        btn_6.setOnClickListener(this);
        btn_7.setOnClickListener(this);
        btn_8.setOnClickListener(this);
        btn_9.setOnClickListener(this);
        btn_0.setOnClickListener(this);
        btn_Cong.setOnClickListener(this);
        btn_Tru.setOnClickListener(this);
        btn_Nhan.setOnClickListener(this);
        btn_Chia.setOnClickListener(this);
        btn_Bang.setOnClickListener(this);
        btn_Dot.setOnClickListener(this);
        btn_AC.setOnClickListener(this);
        btn_C.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_0: {
                edt_NumberInput.append("0");
                break;
            }
            case R.id.btn_1: {
                edt_NumberInput.append("1");
                break;
            }
            case R.id.btn_2: {
                edt_NumberInput.append("2");
                break;
            }
            case R.id.btn_3: {
                edt_NumberInput.append("3");
                break;
            }
            case R.id.btn_4: {
                edt_NumberInput.append("4");
                break;
            }
            case R.id.btn_5: {
                edt_NumberInput.append("5");
                break;
            }
            case R.id.btn_6: {
                edt_NumberInput.append("6");
                break;
            }
            case R.id.btn_7: {
                edt_NumberInput.append("7");
                break;
            }
            case R.id.btn_8: {
                edt_NumberInput.append("8");
                break;
            }
            case R.id.btn_9: {
                edt_NumberInput.append("9");
                break;
            }
            case R.id.btn_Cong: {
                edt_NumberInput.append("+");
                break;
            }
            case R.id.btn_Tru: {
                edt_NumberInput.append("-");
                break;
            }
            case R.id.btn_Nhan: {
                edt_NumberInput.append("*");
                break;
            }
            case R.id.btn_Chia: {
                edt_NumberInput.append("/");
                break;
            }
            case R.id.btn_Dot: {
                edt_NumberInput.append(".");
                break;
            }
            case R.id.btn_Clear: {
                BaseInputConnection baseInputConnection = new BaseInputConnection(edt_NumberInput, true);
                baseInputConnection.sendKeyEvent(new KeyEvent(KeyEvent.ACTION_DOWN, KeyEvent.KEYCODE_DEL));
                break;
            }
            case R.id.btn_ClearAll: {
                edt_NumberInput.setText("");
                tv_Result.setText("");
                break;
            }
            case R.id.btn_Bang: {
                DecimalFormat decimalFormat = new DecimalFormat("###.#######");
                double result = 0;
                AddNumber(edt_NumberInput.getText().toString());
                AddOperator(edt_NumberInput.getText().toString());
                if (arrOperator.size() >= arrNumber.size() || arrOperator.size() < 1) {
                    tv_Result.setText("Invalid");
                } else {
                    for (int i = 0; i < arrNumber.size() - 1; i++) {
                        switch (arrOperator.get(i)) {
                            case "+": {
                                if (i == 0) {
                                    result = arrNumber.get(i) + arrNumber.get(i + 1);
                                } else {
                                    /*truong hop nay co the hieu, vi du ta tien hanh hai phep cong lien tiep chang han, thi gia tri kq cua phep cong dau tien*/
                                    // da duoc set va lai dung chinh gia tri do de cong voi gia tri cua phan tu tiep theo
                                    result = result + arrNumber.get(i + 1);
                                }
                                break;
                            }
                            case "-": {
                                if (i == 0) {
                                    result = arrNumber.get(i) - arrNumber.get(i + 1);
                                } else {
                                    /*truong hop nay co the hieu, vi du ta tien hanh hai phep cong lien tiep chang han, thi gia tri kq cua phep cong dau tien*/
                                    // da duoc set va lai dung chinh gia tri do de cong voi gia tri cua phan tu tiep theo
                                    result = result - arrNumber.get(i + 1);
                                }
                                break;
                            }
                            case "*": {
                                if (i == 0) {
                                    result = arrNumber.get(i) * arrNumber.get(i + 1);
                                } else {
                                    /*truong hop nay co the hieu, vi du ta tien hanh hai phep cong lien tiep chang han, thi gia tri kq cua phep cong dau tien*/
                                    // da duoc set va lai dung chinh gia tri do de cong voi gia tri cua phan tu tiep theo
                                    result = result * arrNumber.get(i + 1);
                                }
                                break;
                            }
                            case "/": {
                                if (i == 0) {
                                    result = arrNumber.get(i) / arrNumber.get(i + 1);
                                } else {
                                    /*truong hop nay co the hieu, vi du ta tien hanh hai phep cong lien tiep chang han, thi gia tri kq cua phep cong dau tien*/
                                    // da duoc set va lai dung chinh gia tri do de cong voi gia tri cua phan tu tiep theo
                                    result = result / arrNumber.get(i + 1);
                                }
                                break;
                            }
                            default: {
                                break;
                            }
                        }
                        tv_Result.setText(decimalFormat.format(result) + "");
                    }
                }
            }
        }
    }

    /*luu toan tu*/
    public ArrayList<String> arrOperator ;
    public ArrayList<Double> arrNumber ;

    public int AddOperator(String input) {
        arrOperator = new ArrayList<>();
        char character[] = input.toCharArray();
        for (int i = 0; i < character.length; i++) {
            switch (character[i]) {
                case '+': {
                    arrOperator.add(String.valueOf(character[i]));
                    break;
                }
                case '-': {
                    arrOperator.add(String.valueOf(character[i]));
                    break;
                }
                case '*': {
                    arrOperator.add(String.valueOf(character[i]));
                    break;
                }
                case '/': {
                    arrOperator.add(String.valueOf(character[i]));
                    break;
                }
                default: {
                    break;
                }
            }
        }
        return 0;
    }

    public void AddNumber(String input) {
        /*toan bo Pattern la group 0*/
        arrNumber = new ArrayList<>();
        Pattern regex = Pattern.compile("(\\d+(?:\\.\\d+)?)");
        Matcher matcher = regex.matcher(input);
        while (matcher.find()) {
            arrNumber.add(Double.valueOf(matcher.group(1)));
        }
    }
}
