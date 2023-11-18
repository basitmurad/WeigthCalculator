package com.basit.weigthcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Toast;

import com.basit.weigthcalculator.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);

        setButtonClickListeners();


        binding.bac.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                binding.quintal.setText("");
                binding.kg.setText("");
                binding.gram.setText("");
                binding.answerMinus.setText("");
                binding.answerPlus.setText("");

            }
        });


        binding.btnequal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Get the values from the obtained and total EditText fields
                String qui = binding.quintal.getText().toString().trim();
                String kg = binding.kg.getText().toString().trim();
                String gr = binding.kg.getText().toString().trim();

                // Check if either obtained or total value is empty
                if (qui.isEmpty() || kg.isEmpty() || gr.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Enter quintal kg an gram length", Toast.LENGTH_SHORT).show();
                    return;
                } else {
//                    double obtainedValue1 = Double.parseD(binding.obtained.getText().toString().trim());
                    double quil = Double.parseDouble(binding.quintal.getText().toString().trim());
                    double kgs = Double.parseDouble(binding.kg.getText().toString().trim());
                    double gram = Double.parseDouble(binding.gram.getText().toString().trim());


                    Double sum = quil+kgs+gram;
                    Double sub = quil-kgs-gram;

                    binding.answerPlus.setText("After adding " +sum);
                    binding.answerMinus.setText("After Subtraction " +sub);

//
                }


            }
        });


    }

    private void setButtonClickListeners() {
        // Set click listeners for numeric buttons
        binding.b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                appendTextFromButton("1");
            }
        });

        binding.b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                appendTextFromButton("2");
            }
        });

        binding.b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                appendTextFromButton("3");
            }
        });

        binding.b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                appendTextFromButton("4");
            }
        });


        binding.b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                appendTextFromButton("5");
            }
        });

        binding.b6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                appendTextFromButton("6");
            }
        });

        binding.b7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                appendTextFromButton("7");
            }
        });

        binding.b8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                appendTextFromButton("8");
            }
        });

        binding.b9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                appendTextFromButton("9");
            }
        });

        binding.b0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                appendTextFromButton("0");
            }
        });


        binding.btnDot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                appendTextFromButton(".");
//                Toast.makeText(MainActivity.this, "Basit", Toast.LENGTH_SHORT).show();
            }
        });

        binding.quintal.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {
                    binding.quintal.setInputType(InputType.TYPE_NULL);


                    binding.bc.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            if (binding.quintal != null) {
                                String val = binding.quintal.getText().toString();
                                if (!val.isEmpty()) {
                                    val = val.substring(0, val.length() - 1);
                                    binding.quintal.setText(val);
                                }
                            }
                        }
                    });
                    hideKeyboard();
                }
            }
        });
        binding.kg.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {
                    binding.kg.setInputType(InputType.TYPE_NULL);


                    binding.bc.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            if (binding.kg != null) {
                                String val = binding.kg.getText().toString();
                                if (!val.isEmpty()) {
                                    val = val.substring(0, val.length() - 1);
                                    binding.kg.setText(val);
                                }
                            }
                        }
                    });
                    hideKeyboard();
                }
            }
        });
        binding.gram.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {
                    binding.gram.setInputType(InputType.TYPE_NULL);


                    binding.bc.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            if (binding.gram != null) {
                                String val = binding.gram.getText().toString();
                                if (!val.isEmpty()) {
                                    val = val.substring(0, val.length() - 1);
                                    binding.gram.setText(val);
                                }
                            }
                        }
                    });
                    hideKeyboard();
                }
            }
        });

    }

    // Method to append text from buttons to the EditText
    private void appendTextFromButton(String buttonText) {
        // Find the focused EditText
        EditText focusedEditText = getFocusedEditText();

        if (focusedEditText != null) {
            // Get the current cursor position
            int cursorPosition = focusedEditText.getSelectionStart();

            // Insert the button text at the current cursor position
            focusedEditText.getText().insert(cursorPosition, buttonText);
        }
    }

    // Method to determine the focused EditText
    private EditText getFocusedEditText() {
        if (binding.quintal.hasFocus()) {

            hideKeyboard();
            return binding.quintal;
        }else if (binding.kg.hasFocus())
        {
            hideKeyboard();
            return binding.kg;
        } else if (binding.gram.hasFocus())
        {
            hideKeyboard();
            return binding.gram;
        }

        else {
            // If neither has focus, you can choose a default or handle it as needed
            return null;
        }
    }

    private void hideKeyboard() {
        View view = this.getCurrentFocus();
        if (view != null) {
            InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }
}

