package com.unicaldas.petitspotins

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.room.*
import com.google.firebase.firestore.FirebaseFirestore
import com.unicaldas.room_database.ToDoDatabase
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [ToDoFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ToDoFragment : Fragment() {
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
        return inflater.inflate(R.layout.fragment_to_do, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val recyclerTodoList: RecyclerView = view.findViewById(R.id.recyclerTodoList)

        var datos: ArrayList<Task> = ArrayList()

        // datos firebase

        /*val dbFirebase = FirebaseFirestore.getInstance()
        dbFirebase.collection("Venta").get().addOnSuccessListener {

            for(todo in it){
                var id = todo.id

                datos.add(Task(id.toInt(),todo.get("codigo_venta") as String,todo.get("cc_vendedor") as String,todo.get("fecha_venta") as String,
                    todo.get("nombre_cliente") as String,todo.get("cc_cliente") as String,todo.get("tipo_articulo") as String,
                    todo.get("largo") as String,todo.get("ancho") as String,"0","0","0","0","0"))
            }

            var taskAdapter = TaskAdapter(datos){
                val datos = Bundle()
                datos.putInt("id",it.id)

                datos.putString("areaCortina", it.area)
                datos.putString("cuotaCortina", it.cuota)
                datos.putString("abonoCortina", it.abono)
                datos.putString("saldoPendiente",it.saldopen)
                datos.putString("saldoTotal", it.saldototal)

                activity?.supportFragmentManager?.beginTransaction()
                    ?.replace(R.id.fragmentContainerView5, DetailFragment::class.java, datos, "detail")
                    ?.addToBackStack("")
                    ?.commit()


            }

            recyclerTodoList.setHasFixedSize(true)
            recyclerTodoList.adapter = taskAdapter




        }*/


       // datos por room

        val room: ToDoDatabase = Room.databaseBuilder(context?.applicationContext!!,
            ToDoDatabase::class.java,"ToDoDatabase").build()

        var todoDao = room.todoDao()
        runBlocking {
            launch {
                var result = todoDao.getAllTasks()
                for(todo in result){

                    //se calcula el area

                    val largo = todo.largo
                    val ancho = todo.ancho
                    val area = largo * ancho

                    //se valida mediante el if el tipo de cortina para poder definir su precio y las cuotas

                    if (todo.tipo_articulo == "blackOut"){

                        val valor_black = 60000
                        val saldo_tot= valor_black * area
                        val valor_cuota = (valor_black * area ) * (0.2)
                        val cuot = saldo_tot / valor_cuota

                        datos.add(Task(todo.id,todo.codigo_venta,todo.cc_vendedor,todo.fecha_venta,todo.nombre_cliente,
                            todo.cc_cliente,todo.tipo_articulo,todo.largo.toString(),todo.ancho.toString(),
                            ""+area+" m^2",""+cuot,"0",""+saldo_tot,""+saldo_tot))

                    }else if(todo.tipo_articulo == "Panel Japones"){

                        val valor_japones = 30000
                        val saldo_tot= valor_japones * area
                        val valor_cuota = (valor_japones * area ) * (0.2)
                        val cuot = saldo_tot / valor_cuota

                        datos.add(Task(todo.id,todo.codigo_venta,todo.cc_vendedor,todo.fecha_venta,todo.nombre_cliente,
                            todo.cc_cliente,todo.tipo_articulo,todo.largo.toString(),todo.ancho.toString(),
                            ""+area+" m^2",""+cuot,"0",""+saldo_tot,""+saldo_tot))


                    }else if(todo.tipo_articulo == "Sheer Elegance"){

                        val valor_Elegance = 70000
                        val saldo_tot= valor_Elegance * area
                        val valor_cuota = (valor_Elegance * area ) * (0.2)
                        val cuot = saldo_tot / valor_cuota

                        datos.add(Task(todo.id,todo.codigo_venta,todo.cc_vendedor,todo.fecha_venta,todo.nombre_cliente,
                            todo.cc_cliente,todo.tipo_articulo,todo.largo.toString(),todo.ancho.toString(),
                            ""+area+" m^2",""+cuot,"0",""+saldo_tot,""+saldo_tot))


                    }else{

                        datos.add(Task(todo.id,todo.codigo_venta,todo.cc_vendedor,todo.fecha_venta,todo.nombre_cliente,
                            todo.cc_cliente,todo.tipo_articulo,todo.largo.toString(),todo.ancho.toString(),
                            ""+area+" m^2","0","0","0","0"))


                    }



                }
            }
        }

        // datos seteados

        /*datos.add(Task("10001", "B0009", "10/11/2021","Johan Zuluaga","16/11/2003","black"
            ,"6","4","24","null","null","null","null"))

        datos.add(Task("10002", "B00010", "12/11/2021","Angelo Lopez","2000","blue"
            ,"8","6","48","null","null","null","null"))

        datos.add(Task("10003", "B00011", "18/11/2021","Yuliana Riveros","2000","white"
            ,"5","4","20","null","null","null","null"))

        datos.add(Task("10004", "B00012", "25/11/2021","Shesman Murcia","2000","orange"
            ,"10","7","70","null","null","null","null"))

        datos.add(Task("10005", "B00013", "29/11/2021","Paola Padilla","2000","coffe"
            ,"7","3","21","null","null","null","null"))

        datos.add(Task("10006", "B00014", "2/12/2021","Juana","2000","Yellow"
            ,"7","3","21","null","null","null","null"))*/

        // adaptador de room

       var taskAdapter = TaskAdapter(datos){
            val datos = Bundle()
            datos.putInt("id",it.id)

            datos.putString("areaCortina", it.area)
            datos.putString("cuotaCortina", it.cuota)
            datos.putString("abonoCortina", it.abono)
            datos.putString("saldoPendiente",it.saldopen)
            datos.putString("saldoTotal", it.saldototal)

            /*datos.putString("codigoVenta", it.codven)
            datos.putString("codigoVendedor", it.codvende)
            datos.putString("fechaVenta", it.fechven)
            datos.putString("nombreCliente",it.nameclient)
            datos.putString("fechaCliente", it.fechclient)
            datos.putString("tipoCortina", it.tipocort)
            datos.putString("largoCortina", it.largo)
            datos.putString("anchoCortina",it.ancho)
            datos.putString("areaCortina", it.area)
            datos.putString("cuotaCortina", it.cuota)
            datos.putString("abonoCortina", it.abono)
            datos.putString("saldoPendiente",it.saldopen)
            datos.putString("saldoTotal", it.saldototal)*/



            activity?.supportFragmentManager?.beginTransaction()
                ?.replace(R.id.fragmentContainerView5, DetailFragment::class.java, datos, "detail")
                ?.addToBackStack("")
                ?.commit()


        }
        recyclerTodoList.setHasFixedSize(true)
        recyclerTodoList.adapter = taskAdapter




    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment ToDoFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            ToDoFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}