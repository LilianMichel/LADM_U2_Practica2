package mx.edu.ittepic.ladm_u2_practica2

import android.view.View

class Hilo (p:MainActivity) : Thread() {
    var puntero = p

    override fun run() {
        super.run()

        while (true) {
            sleep(10)
            puntero.runOnUiThread {
                puntero.lienzo!!.reboteCirculoChico()
            }
            puntero.runOnUiThread {
                puntero.lienzo!!.reboteCirculoMediano()
            }
            puntero.runOnUiThread {
                puntero.lienzo!!.reboteCirculoGrande()
            }
        }
    }

}