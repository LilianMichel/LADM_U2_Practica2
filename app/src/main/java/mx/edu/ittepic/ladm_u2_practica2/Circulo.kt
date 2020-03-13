package mx.edu.ittepic.ladm_u2_practica2

import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.Paint
import android.view.MotionEvent
import java.util.prefs.NodeChangeEvent

class Circulo() {
    var x = 0f
    var y = 0f
    var radio = 0f
    var tipo = 1
    var ancho = 0f
    var alto = 0f
    var incXg = 2
    var incYg = 2
    var incXm = 5
    var incYm = 5
    var incXch = 8
    var incYch = 8
    var imagen : Bitmap?=null


    constructor(x: Int, y: Int, radio: Int) : this() {
        this.x = x.toFloat()
        this.y = y.toFloat()
        this.radio = radio.toFloat()
    }
    constructor(bitmap: Bitmap, x: Int,y: Int) : this(){
        imagen=bitmap
        this.x=x.toFloat()
        this.y=y.toFloat()
        tipo = 2
        ancho = imagen!!.width.toFloat()
        alto = imagen!!.height.toFloat()
    }


    fun pintar(c: Canvas, p: Paint) {
        when (tipo) {
            1 -> {
                c.drawCircle(x, y, radio, p)
            }
            2->{
                c.drawBitmap(imagen!!,x,y,p)
            }
        }
    }
    fun selectArea(event: MotionEvent) : Boolean {
        when (tipo) {
            1 -> {
                if (event.x >= x - radio && event.x <= x + radio) {
                    if (event.y >= y - radio && event.y <= y + radio) {
                        return true
                    }
                }
            }
        }
        return false
    }

    fun arrastrar(event: MotionEvent) {
        when (tipo) {
            1 -> {
                x = event.x
                y = event.y
            }
        }
    }

    fun rebotech(ancho:Int, alto:Int){
        x+= incXch
        if(x<=-100 || x>=ancho){
            incXch *= -1
        }
        y+= incYch
        if(y<=-100 || y>=alto){
            incYch *= -1
        }
    }

    fun rebotem(ancho:Int, alto:Int){
        x+= incXm
        if(x<=-100 || x>=ancho){
            incXm *= -1
        }
        y+= incYm
        if(y<=-100 || y>=alto){
            incYm *= -1
        }
    }
    fun reboteg(ancho:Int, alto:Int){
        x+= incXg
        if(x<=-100 || x>=ancho){
            incXg *= -1
        }
        y+= incYg
        if(y<=-100 || y>=alto){
            incYg *= -1
        }
    }

}