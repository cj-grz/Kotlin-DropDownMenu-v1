package com.justin.didi

import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val list : MutableList<String> = ArrayList()
        list.add("Inicio")
        list.add("31 cosas por las que no estar triste")
        list.add("Random")



        val adapter = ArrayAdapter(this, R.layout.support_simple_spinner_dropdown_item, list)
        spnTest.adapter = adapter

        spnTest.onItemSelectedListener = object :  AdapterView.OnItemSelectedListener{
            override fun onNothingSelected(parent: AdapterView<*>?) {}

            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                    val item = list[p2]
                    Toast.makeText(this@MainActivity, "$item selected", Toast.LENGTH_SHORT).show()
                    textView.setMovementMethod(ScrollingMovementMethod())
                    val textView: TextView = findViewById(R.id.textView) as TextView
                    when (p2) {
                        0 -> textView.setText("Hola")
                        1 -> textView.setText("1. Te ves mejor sonriendo\n2. Las mejores Cajas padan citando feliz\n3. No hay Por que desperdiciar el tiempo estando triste.\n4. Hay más razones para sonreir.\n5. To sistema inmunológico se resiente y puedes enfermarte.\n6. Mayores Probabilidades a subir de Peso.\n7. La tristeza afecta a tu piel.\n8. creas arrugas.\n9. Tienes incapacidad de concentracion\n10. Nadie merece tus lágrimas, quien se evitara hacerte llorar.\n11. Sonrie porque sucedió, ahora saber que no hacer y que hacer.\n12. Las mejores coas suceden cuando menos las esperas\n13. Todo Pasa por algo, hay que estar feliz por ello.\n14. Date cuenta de lo afortunada que eres.\n15. Recuerda que hay gente que te quiere.\n16. Yo te quiero\n17. Yo estoy triste sabiendo que estas triste.\n18. No quiero que este triste.\n19. Quiero que tengas recuerdos felices.\n20. Felices como nuestras recuerdos, salidas llamadas, desvelados.\n21. Un recuerdo es mejor estando feliz.\n22. Ese momento no cambiará, Procura que sea alegre\n23. Hay 29 bys en el día, no las desperdicio llorando.\n24. Vienen mejores cosas en ei futuro.\n25. La comida sabe mejor feliz.\n26. una carta se lee mejor feliz.\n27. si lloras mojas esta carta.\n28. una carta mojada es débil y se rompe.\n29. No quiero que dañes to regalo\n30. No quiero verte lastimado\n31. Quiero verte feliz"
                        )
                        else -> textView.setText("otherwise")
                }
            }
        }


        limitDropDownHeight(spnTest)
    }

    fun limitDropDownHeight(spnTest: Spinner){
        val popup = Spinner::class.java.getDeclaredField("mPopup")
        popup.isAccessible = true

        val popupWindow = popup.get(spnTest) as ListPopupWindow
        popupWindow.height = (100 * resources.displayMetrics.density).toInt()
    }
}