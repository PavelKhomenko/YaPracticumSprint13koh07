package ru.yandex.practicum.sprint13koh07

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import ru.yandex.practicum.sprint13koh07.databinding.VCatalogItemBinding

data class CatalogItemViewData(
    val item: CatalogItem,
    val count: Int?,
){
    val id = item.id
}

class CatalogItemViewHolder(
    parent: ViewGroup,
    val binding: VCatalogItemBinding = VCatalogItemBinding.inflate(
        LayoutInflater.from(
            parent.context
        ), parent, false
    )
) : RecyclerView.ViewHolder(
    binding.root
) {

    fun bind(viewData: CatalogItemViewData) {
        binding.root

        Glide
            .with(binding.root.context)
            .load(viewData.item.imageUrl)
            .into(binding.image)
        binding.title.text = viewData.item.name
        binding.price.text = binding.price.context.getString(R.string.price_builder, (viewData.item.price / 100).toString(), viewData.item.unit)

        if (viewData.count != null) {
            binding.addToCart.visibility = View.GONE
            binding.countContainer.visibility = View.VISIBLE
            binding.count.text = viewData.count.toString()
        }
    }

}