package com.example.kolgi.myapplication

import android.app.Activity
import android.content.Intent
import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.constraint.ConstraintLayout
import android.view.View
import android.widget.LinearLayout
import kotlinx.android.synthetic.main.activity_main.*
import java.util.ArrayList
import android.widget.RelativeLayout



class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        firstStack.setText("")
        val rl = findViewById(R.id.stackView) as LinearLayout
        rl.setBackgroundColor(Color.LTGRAY)
        setTitle("Kalkulator RPN")
    }

    val SETTINGS_CODE=1000
    var  currStack = 0.0
    val stackList = ArrayList<Double>()
    var newLine = false
    var operation = false
    var precision = 6
    var color = 4

    fun button1Click(v: View)
    {
        if(newLine == true)
        {
            if(operation==true)
            newLine()
            firstStack.setText("")
            newLine= false
            operation = false

        }
        firstStack.append("1")
        updateTop()
    }

    fun showSetting()
    {
        val i= Intent(this,SettingsActivity::class.java)
        i.putExtra("Precision",precision)
        startActivityForResult(i,SETTINGS_CODE)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if((requestCode==SETTINGS_CODE)
            &&(resultCode==Activity.RESULT_OK))
                {
                    if(data!=null)
                    {
                        if (data.extras["precision"].toString().length>0)
                        precision = data.extras.getString("precision").toInt()


                    }
                }
    }


    fun getFormatted(s: String):String
    {
        if(!s.contains("E")) {
            if (s.contains('.')) {
                if ((s.indexOf('.') + precision) <= s.length)
                    return s.substring(0, s.indexOf('.') + precision + 1)
            } else
                return s
        }
        return s
    }
    fun buttonSettingsClick(v: View)
    {
       showSetting()
    }
    fun button2Click(v: View)
    {
        if(newLine == true)
        {
            if(operation==true)
                newLine()
            firstStack.setText("")
            newLine= false
            operation = false

        }
        firstStack.append("2")
        updateTop()
    }
    fun button3Click(v: View)
    {
        if(newLine == true)
        {
            if(operation==true)
                newLine()
            firstStack.setText("")
            newLine= false
            operation = false

        }
        firstStack.append("3")
        updateTop()
    }
    fun button4Click(v: View)
    {
        if(newLine == true)
        {
            if(operation==true)
                newLine()
            firstStack.setText("")
            newLine= false
            operation = false

        }
        firstStack.append("4")
        updateTop()
    }
    fun button5Click(v: View)
    {
        if(newLine == true)
        {
            if(operation==true)
                newLine()
            firstStack.setText("")
            newLine= false
            operation = false

        }
        firstStack.append("5")
        updateTop()
    }
    fun button6Click(v: View)
    {
        if(newLine == true)
        {
            if(operation==true)
                newLine()
            firstStack.setText("")
            newLine= false
            operation = false

        }
        firstStack.append("6")
        updateTop()
    }
    fun button7Click(v: View)
    {
        if(newLine == true)
        {
            if(operation==true)
                newLine()
            firstStack.setText("")
            newLine= false
            operation = false

        }
        firstStack.append("7")
        updateTop()
    }
    fun button8Click(v: View)
    {
        if(newLine == true)
        {
            if(operation==true)
                newLine()
            firstStack.setText("")
            newLine= false
            operation = false

        }
        firstStack.append("8")
        updateTop()
    }
    fun button9Click(v: View)
    {
        if(newLine == true)
        {
            if(operation==true)
                newLine()
            firstStack.setText("")
            newLine= false
            operation = false

        }
        firstStack.append("9")
        updateTop()
    }
    fun button0Click(v: View)
    {
        if(newLine == true)
        {
            if(operation==true)
                newLine()
            firstStack.setText("")
            newLine= false
            operation = false

        }
        firstStack.append("0")
        updateTop()
    }

    fun changeSign(v: View)
    {
        if(firstStack.text[0]=='-')
        firstStack.setText(firstStack.text.substring(1))
        else
        {
            val pom = firstStack.text
            firstStack.setText("-"+pom)
        }
        updateTop()
    }

    fun buttonClickEnter(v: View)
    {
        if(firstStack.text.length>0) {
            val pom = firstStack.text.toString()
           // pom.replace("\\s".toRegex(), "")
            stackList.add(0, firstStack.text.toString().toDouble())
            updateStackEnter()
            newLine = true
            operation = false
        }

    }

    fun newLine()
    {
        if(firstStack.text.length>0) {
            val pom = firstStack.text.toString()
            // pom.replace("\\s".toRegex(), "")
            stackList.add(0, firstStack.text.toString().toDouble())
            updateStackEnter()
        }
    }

    fun updateStackEnter()
    {
        clearStack()
        if(stackList.size>0)
        secondStack.setText(getFormatted(stackList[0].toString()))
        if(stackList.size>1)
        thirdStack.setText(getFormatted(stackList[1].toString()))
        if(stackList.size>2)
        fourthStack.setText(getFormatted(stackList[2].toString()))
        currStack = stackList[0]
        firstStack.setText(getFormatted(currStack.toString()))
    }

    fun clearStack()
    {
        secondStack.setText("")
        thirdStack.setText("")
        fourthStack.setText("")
    }
    fun updateStack()
    {
        clearStack()
        if(stackList.size>0)
            secondStack.setText(getFormatted(stackList[0].toString()))
        if(stackList.size>1)
            thirdStack.setText(getFormatted(stackList[1].toString()))
        if(stackList.size>2)
            fourthStack.setText(getFormatted(stackList[2].toString()))
        firstStack.setText(getFormatted(currStack.toString()))
    }
    fun buttonAddClick(v: View)
    {
        if(stackList.size>0)
        {
            currStack = currStack + stackList[0]
            stackList.removeAt(0)
            updateStack()
            newLine = true
            operation= true
        }

    }

    fun buttonSubClick(v: View)
    {
        if(stackList.size>0)
        {
            currStack =  stackList[0] - currStack
            stackList.removeAt(0)
            updateStack()
            newLine = true
            operation= true
        }

    }

    fun buttonMultiClick(v: View)
    {
        if(stackList.size>0)
        {
            currStack = currStack * stackList[0]
            stackList.removeAt(0)
            updateStack()
            newLine = true
            operation= true
        }

    }

    fun buttonDivideClick(v: View)
    {
        if(stackList.size>0)
        {
            currStack = stackList[0]/currStack
            stackList.removeAt(0)
            updateStack()
            newLine = true
            operation= true
        }

    }

    fun buttonPowClick(v: View)
    {
        if(stackList.size>0)
        {
            currStack = Math.pow(stackList[0],currStack)
            stackList.removeAt(0)
            updateStack()
            newLine = true
            operation= true
        }

    }

    fun buttonRootClick(v: View)
    {
        if(firstStack.text.length>0 && firstStack.text.toString().toDouble()>0)
        {
            currStack = Math.sqrt(currStack)
            updateStack()
            newLine = true
            operation= true
        }

    }

    fun updateTop()
    {
       currStack = firstStack.text.toString().toDouble();
    }

    fun buttonSwapClick(v: View)
    {
        if(stackList.size>0)
        {
            val pom = currStack
            currStack = stackList[0]
            stackList[0] = pom
            updateStack()
            newLine = true
            operation= true
        }

    }

    fun buttonClearClick(v: View)
    {
        currStack = 0.0
        stackList.clear()
        clearStack()
        firstStack.setText("")
        newLine=false
        operation=false
    }

    fun buttonDropClick(v: View)
    {
        if(firstStack.text.length>0)
        {
            if(stackList.size>0)
            {
                val pom =  stackList[0].toString()
                stackList.removeAt(0)
                updateStack()
                firstStack.setText(pom)
                updateTop()
            }
            else
            {
                firstStack.setText("")
                currStack= 0.0
            }
            newLine = true
            operation= true
        }

    }

    fun buttonBackClick(v: View)
    {
        if(firstStack.text.length>0)
        {
            if(newLine==false)
            {
                firstStack.setText(firstStack.text.substring(0,firstStack.text.length-1))
            }
            else
            {
                buttonDropClick(v)
            }
        }

    }

    fun buttonDotClick(v: View)
    {
        if(firstStack.text.length>0 && !firstStack.text.toString().contains("."))
        {
            if(newLine==false)
            {
                firstStack.append(".")
                updateTop()
            }

        }
    }








}
