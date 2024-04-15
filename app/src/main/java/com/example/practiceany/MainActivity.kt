import android.os.Bundle
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val recyclerView = RecyclerView(this)
        recyclerView.layoutManager = LinearLayoutManager(this)
        setContentView(recyclerView)

        val data = listOf("Tarjeta 1", "Tarjeta 2", "Tarjeta 3")
        val adapter = MyAdapter(data)
        recyclerView.adapter = adapter
    }

    class MyAdapter(private val data: List<String>) : RecyclerView.Adapter<MyViewHolder>() {

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
            val context = parent.context
            val linearLayout = LinearLayout(context)
            linearLayout.orientation = LinearLayout.VERTICAL
            val layoutParams = RecyclerView.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
            )
            linearLayout.layoutParams = layoutParams
            linearLayout.setPadding(16, 16, 16, 16)

            val titleTextView = TextView(context)
            val descriptionTextView = TextView(context)
            linearLayout.addView(titleTextView)
            linearLayout.addView(descriptionTextView)

            return MyViewHolder(linearLayout, titleTextView, descriptionTextView)
        }

        override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
            holder.bind(data[position])
        }

        override fun getItemCount(): Int {
            return data.size
        }
    }

    class MyViewHolder(
        itemView: LinearLayout,
        private val titleTextView: TextView,
        private val descriptionTextView: TextView
    ) : RecyclerView.ViewHolder(itemView) {

        fun bind(item: String) {
            titleTextView.text = item
            descriptionTextView.text = "Descripción de $item"
        }
    }
}
