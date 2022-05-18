package com.unicaldas.petitspotins

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.room.*
import com.google.firebase.firestore.FirebaseFirestore
import com.unicaldas.room_database.*
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [VentaFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class VentaFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_venta, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val edtCodiVen: EditText = view.findViewById(R.id.edtCodiVen)
        val edtFechVen: EditText = view.findViewById(R.id.edtFechVen)
        val edtCcVen: EditText = view.findViewById(R.id.edtCcVen)
        val edtNameClient: EditText = view.findViewById(R.id.edtNameClient)
        val edtCcClient: EditText = view.findViewById(R.id.edtCcClient)
        val edtDireccion: EditText = view.findViewById(R.id.edtDireccion)
        val edtLatitud: EditText = view.findViewById(R.id.edtLatitud)
        val edtLongitud: EditText = view.findViewById(R.id.edtLongitud)
        val edtTipoArt: EditText = view.findViewById(R.id.edtTipoArt)
        val edtAncho: EditText = view.findViewById(R.id.edtAncho)
        val edtLargo: EditText = view.findViewById(R.id.edtLargo)

        val btnVenta: Button = view.findViewById(R.id.btnVenta)

        btnVenta.setOnClickListener{

            val room: ToDoDatabase = Room.databaseBuilder(context?.applicationContext!!,
                    ToDoDatabase::class.java,"ToDoDatabase").build()

            var todoDao = room.todoDao()
            var task = ToDo(0,edtCodiVen.text.toString(),edtFechVen.text.toString(),edtCcVen.text.toString(),edtNameClient.text.toString(),
                            edtCcClient.text.toString(),edtDireccion.text.toString(),edtLatitud.text.toString().toFloat(),edtLongitud.text.toString().toFloat(),
                            edtTipoArt.text.toString(),edtAncho.text.toString().toFloat(),edtLargo.text.toString().toFloat())

            val dbFirebase = FirebaseFirestore.getInstance()

            runBlocking {
                launch {
                    var result = todoDao.insertTask(task)
                    if(result != -1L){
                        dbFirebase.collection("Venta")
                            .document(result.toString())
                            .set(
                                hashMapOf(
                                    "codigo_venta" to edtCodiVen.text.toString(),
                                    "fecha_venta" to edtFechVen.text.toString(),
                                    "cc_vendedor" to edtCcVen.text.toString(),
                                    "nombre_cliente" to edtNameClient.text.toString(),
                                    "cc_cliente" to edtCcClient.text.toString(),
                                    "direccion" to edtDireccion.text.toString(),
                                    "latitud" to edtLatitud.text.toString().toFloat(),
                                    "longitud" to edtLongitud.text.toString().toFloat(),
                                    "tipo_articulo" to edtTipoArt.text.toString(),
                                    "ancho" to edtAncho.text.toString().toFloat(),
                                    "largo" to edtLargo.text.toString().toFloat()
                                )
                            )

                    }
                    Toast.makeText(context?.applicationContext!!,""+result,Toast.LENGTH_LONG).show()
                }
            }

        }



    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment VentaFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            VentaFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}