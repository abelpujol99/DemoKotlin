package com.example.demokotlin

import android.os.Bundle
import android.widget.LinearLayout
import android.widget.TextView
import androidx.activity.ComponentActivity

class MainActivity : ComponentActivity() {

    val result: TextView by lazy { findViewById(R.id.result) }
    val buttonsContainer: LinearLayout by lazy { findViewById(R.id.buttons_container) }

    enum class Operation(private val operation: (a: Int, b:Int) -> Int, val operationCharacter : String){
        Add({a, b -> a + b}, " + "),
        Sub({a, b -> a - b}, " - "),
        Mul({a, b -> a * b}, " x "),
        Div({a, b -> a / b}, " / ");

        public fun Operate(a: Int, b : Int) : Int {
            return this.operation(a, b);
        }
    }

    var A : Int? = null;
    var B : Int? = null;
    var operation : Operation? = null;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.start_screen)

        val buttonsGrid = ButtonsGrid(this, buttonsContainer);

        var names: MutableList<MutableList<String>> = mutableListOf()

        names.add(mutableListOf("AC", "()", "%", "/"))
        names.add(mutableListOf("7", "8", "9", "X"))
        names.add(mutableListOf("4", "5", "6", "-"))
        names.add(mutableListOf("1", "2", "3", "+"))
        names.add(mutableListOf("0", ".", "<-", "="))

        for (i in names.indices){
            val row = buttonsGrid.AddRow();

            for (j in names[i].indices){
                val button = row.AddButton(names[i][j]);

                button.setOnClickListener{
                    when(names[i][j]){
                        "AC" -> {
                            A = null;
                            B = null;
                            operation = null;
                            result.text = "0";
                        }

                        "0", "1", "2", "3", "4", "5", "6", "7", "8", "9" -> {
                            NumberPress(names[i][j].toInt())
                        }

                        "+" -> {
                            OperationPress(Operation.Add)
                        }
                        "-" -> {
                            OperationPress(Operation.Sub)
                        }
                        "X" -> {
                            OperationPress(Operation.Mul)
                        }
                        "/" -> {
                            OperationPress(Operation.Div)
                        }
                        "=" -> {
                            A?.let { a ->
                                B?.let { b ->
                                    val resultNum = operation?.Operate(a, b);
                                    result.text = resultNum.toString();
                                    A = resultNum;
                                    B = null;
                                    operation = null;
                                }
                            }
                        }

                    }
                }
            }
        }
    }

    fun NumberPress(num : Int){
        if (operation == null){
            //Cosas de A
            A?.let { a ->
                A = (a * 10) + num
            } ?: run {
                A = num;
            }
            result.text = A.toString()
        }
        else
        {
            //Cosas de B
            B?.let { b ->
                B = (b * 10) + num
            } ?: run {
                B = num;
            }
            result.text = A.toString() + operation?.operationCharacter + B.toString();
        }
    }

    fun OperationPress(operation: Operation){
        if (A != null && B == null){
            this.operation = operation;
            result.text = A.toString() + operation?.operationCharacter;
        }
    }
}