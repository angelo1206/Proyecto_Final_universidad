package com.unicaldas.petitspotins

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import org.imaginativeworld.whynotimagecarousel.CarouselItem
import org.imaginativeworld.whynotimagecarousel.ImageCarousel
import org.imaginativeworld.whynotimagecarousel.OnItemClickListener

class GalleryActivity : AppCompatActivity() {

    private val List = mutableListOf<CarouselItem>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_gallery)

        val carousel : ImageCarousel = findViewById(R.id.carousel)

        List.add(CarouselItem("https://www.persianasclassic.com/wp-content/uploads/10_persianas_romanas_estancia_demo01.jpg", "ROMANAS: Ideal para dar claridad a los ambientes."))
        List.add(CarouselItem("https://www.persianasclassic.com/wp-content/uploads/sheer_elegance_persianas_min_demo01.jpg","BLACK OUT: Se usa para dar oscuridad con variedad de estilos."))
        List.add(CarouselItem("https://www.persianasclassic.com/wp-content/uploads/panel_japones_persianas_min_demo01.jpg","PANEL JAPONÉS: Ideal para amplios ventanales ó dividir cualquier espacio."))
        List.add(CarouselItem("https://www.persianasclassic.com/wp-content/uploads/10_persianas_cellular_blancas_demo01.jpg","CELLULAR SHADES: Combina confort y suavidad con eficiencia en ahorro térmico."))
        carousel.addData(List)

        carousel.onItemClickListener = object : OnItemClickListener {
            override fun onClick(position: Int, carouselItem: CarouselItem) {
                Toast.makeText(this@GalleryActivity,"Auto: ${carouselItem.caption}", Toast.LENGTH_SHORT).show()
            }

            override fun onLongClick(position: Int, dataObject: CarouselItem) {
                TODO("Not yet implemented")
            }
        }

    }
}