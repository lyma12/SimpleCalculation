package com.example.simplecalculation

import android.os.Bundle
import android.view.View
import android.view.View.OnClickListener
import android.widget.TextView
import androidx.activity.ComponentActivity
import java.util.Stack

class MainActivity : ComponentActivity(), OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }

    override fun onClick(v: View?) {
        val textView : TextView = findViewById(R.id.text)
        var text = textView.text.toString()
        if(v?.id == R.id.button0){
            if(text.equals("0")) text = "0"
            else text = text + "0"
        }
        else if(v?.id == R.id.button1){
            if(text.equals("0")) text = "1"
            else text = text + "1"
        }
        else if(v?.id == R.id.button2){
            if(text.equals("0")) text = "2"
            else text = text + "2"
        }
        else if(v?.id == R.id.button3){
            if(text.equals("0")) text = "3"
            else text = text + "3"
        }
        else if(v?.id == R.id.button4){
            if(text.equals("0")) text = "4"
            else text = text + "4"
        }
        else if(v?.id == R.id.button5){
            if(text.equals("0")) text = "5"
            else text = text + "5"
        }
        else if(v?.id == R.id.button6){
            if(text.equals("0")) text = "6"
            else text = text + "6"
        }
        else if(v?.id == R.id.button7){
            if(text.equals("0")) text = "7"
            else text = text + "7"
        }
        else if(v?.id == R.id.button8){
            if(text.equals("0")) text = "8"
            else text = text + "8"
        }
        else if(v?.id == R.id.button9){
            if(text.equals("0")) text = "9"
            else text = text + "9"
        }
        else if(v?.id == R.id.buttonBS){
            if(text.count() > 1){
                text = text.substring(0, text.count() - 1)
            }
            else text = "0"
        }
        else if(v?.id == R.id.buttonCE){
            text = "0"
        }
        else if(v?.id == R.id.buttonC){
            text = "0"
        }
        else if(v?.id == R.id.buttonChia){
            var i: Char = text[text.count()-1]
            if(i.equals('+') || i.equals('-')||i.equals('/')||i.equals('x')){
                text = text.substring(0, text.count() - 1)
            }
            text = text + "/"
        }else if(v?.id == R.id.buttonCong){
            var i: Char = text[text.count()-1]
            if(i.equals('+') || i.equals('-')||i.equals('/')||i.equals('x')){
                text = text.substring(0, text.count() - 1)
            }
            text = text + "+"
        }
        else if(v?.id == R.id.buttonNhan){
            var i: Char = text[text.count()-1]
            if(i.equals('+') || i.equals('-')||i.equals('/')||i.equals('x')){
                text = text.substring(0, text.count() - 1)
            }
            text = text + "x"

        }
        else if(v?.id == R.id.buttonTru){
            var i: Char = text[text.count()-1]
            if(i.equals('+') || i.equals('-')||i.equals('/')||i.equals('x')){
                text = text.substring(0, text.count() - 1)
            }
            text = text + "-"
        }
        else if(v?.id == R.id.buttonBang){
            var i: Char = text[text.count()-1]
            if(i.equals('+') || i.equals('-')||i.equals('/')||i.equals('x')){
                text = text.substring(0, text.count() - 1)
            }
            var rs = calculator(text)
            text = rs.toString()
        }
        textView.text = text
    }
    public fun calculator(text : String): Double{
        var rs: String = ""
        // chuyen trung to sang hau to
        var stack : Stack<Char> = Stack()
        for(i in text){
            if(i.equals('+') || i.equals('-')||i.equals('/')||i.equals('x')) {
                rs = rs + "*"
                if(stack.empty()) stack.push(i)
                else{
                    var tmp: Char = stack.peek()
                    if(privotOperator(tmp) >= privotOperator(i)){
                        rs = rs + stack.peek()
                        stack.pop()
                        stack.push(i)
                    }
                    else{
                        stack.push(i)
                    }
                }
            }else{
                rs = rs + i
            }
        }
        rs = rs +"*"
        while(!stack.empty()){
            rs = rs + stack.peek()
            stack.pop()
        }
        // tinh phep tinh cua hau to
        var st : Stack<Double> = Stack()
        var l: String = ""
        for(i in rs){
            if(i.equals('+') || i.equals('-')||i.equals('/')||i.equals('x')){
                var x = st.peek()
                st.pop()
                var y = st.peek()
                st.pop()
                if(i.equals('+')) x = x + y
                else if(i.equals('-')) x = x - y
                else if(i.equals('/')) x = x/y
                else if(i.equals('x')) x = x * y
                st.push(x)
            }
            else if(i.equals('*')){
                st.push(l.toDouble())
                l = ""
            }
            else{
                l = l + i
            }
        }
        return st.peek()
    }

    public  fun privotOperator(i : Char): Int{
        if(i.equals('/') || i.equals('x')) return 2
        else return 1
    }
}



