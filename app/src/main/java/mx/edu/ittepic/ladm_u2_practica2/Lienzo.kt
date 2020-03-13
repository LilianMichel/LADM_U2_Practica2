package mx.edu.ittepic.ladm_u2_practica2

import android.graphics.BitmapFactory
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.view.MotionEvent
import android.view.View

class Lienzo (p:MainActivity) : View(p){
    var circuloch = Circulo(634, 936, 30)
    var circuloch1 = Circulo(152, 865, 30)
    var circuloch2 = Circulo(754, 10, 30)
    var circuloch3 = Circulo(532, 256, 30)
    var circuloch4 = Circulo(922, 565, 30)
    var circulom = Circulo(727, 225, 60)
    var circulom1 = Circulo(856, 745, 60)
    var circulom2 = Circulo(164, 945, 60)
    var circulom3 = Circulo(341, 634, 60)
    var circulom4 = Circulo(725, 923, 60)
    var circulog = Circulo(736, 436, 100)
    var circulog1 = Circulo(542, 10, 100)
    var circulog2 = Circulo(326, 900, 100)
    var circulog3 = Circulo(927, 683, 100)
    var circulog4 = Circulo(72, 155, 100)
    var puntero=p
    var CirculoFig : Circulo?=null
    var fondo = Circulo(BitmapFactory.decodeResource(resources, R.drawable.fondo2),x=-170, y=-100)

    override fun onDraw(c: Canvas) {
        super.onDraw(c)
        var p=Paint()

        fondo.pintar(c,p)
        p.color=(Color.parseColor("#E0BBE4"))
        circuloch.pintar(c,p)
        p.color=(Color.parseColor("#957DAD"))
        circuloch1.pintar(c,p)
        p.color=(Color.parseColor("#D291BC"))
        circuloch2.pintar(c,p)
        p.color=(Color.parseColor("#FEC8D8"))
        circuloch3.pintar(c,p)
        p.color=(Color.parseColor("#FFDFD3"))
        circuloch4.pintar(c,p)

        p.color=(Color.parseColor("#C1E7E3"))
        circulom.pintar(c,p)
        p.color=(Color.parseColor("#DCFFFB"))
        circulom1.pintar(c,p)
        p.color=(Color.parseColor("#FFDCF4"))
        circulom2.pintar(c,p)
        p.color=(Color.parseColor("#DABFDE"))
        circulom3.pintar(c,p)
        p.color=(Color.parseColor("#C1BBDD"))
        circulom4.pintar(c,p)

        p.color=(Color.parseColor("#F3DCD4"))
        circulog.pintar(c,p)
        p.color=(Color.parseColor("#ECC9C7"))
        circulog1.pintar(c,p)
        p.color=(Color.parseColor("#D9E3DA"))
        circulog2.pintar(c,p)
        p.color=(Color.parseColor("#D1CFC0"))
        circulog3.pintar(c,p)
        p.color=(Color.parseColor("#C2C2B4"))
        circulog4.pintar(c,p)



    }

    override fun onTouchEvent(event: MotionEvent): Boolean {
        puntero.setTitle("")
        when (event.action) {
            MotionEvent.ACTION_DOWN -> {
                if (circuloch.selectArea(event) && circuloch1.selectArea(event) && circuloch2.selectArea(event) && circuloch3.selectArea(event) && circuloch4.selectArea(event)) {
                    CirculoFig = circuloch
                    puntero.setTitle("TOCASTE CIRCULO CHICO")
                }
                if (circulom.selectArea(event) && circulom1.selectArea(event) && circulom2.selectArea(event) && circulom3.selectArea(event) && circulom4.selectArea(event)) {
                    CirculoFig = circulom
                    puntero.setTitle("TOCASTE CIRCULO MEDIANO")
                }
                if (circulog.selectArea(event) && circulog1.selectArea(event) && circulog2.selectArea(event) && circulog3.selectArea(event) && circulog4.selectArea(event)) {
                    CirculoFig = circulog
                    puntero.setTitle("TOCASTE CIRCULO GRANDE")
                }
            }
            MotionEvent.ACTION_MOVE -> {
                if (CirculoFig != null) {
                    CirculoFig!!.arrastrar(event)
                }
            }
            MotionEvent.ACTION_UP -> {
                CirculoFig = null
            }
        }
        invalidate()
        return true
    }

    fun reboteCirculoChico(){
        circuloch.rebotech(width,height)
        circuloch1.rebotech(width,height)
        circuloch2.rebotech(width,height)
        circuloch3.rebotech(width,height)
        circuloch4.rebotech(width,height)
        invalidate()
    }

    fun reboteCirculoMediano(){
        circulom.rebotem(width,height)
        circulom1.rebotem(width,height)
        circulom2.rebotem(width,height)
        circulom3.rebotem(width,height)
        circulom4.rebotem(width,height)
        invalidate()
    }
    fun reboteCirculoGrande(){
        circulog.reboteg(width,height)
        circulog1.reboteg(width,height)
        circulog2.reboteg(width,height)
        circulog3.reboteg(width,height)
        circulog4.reboteg(width,height)
        invalidate()
    }

}