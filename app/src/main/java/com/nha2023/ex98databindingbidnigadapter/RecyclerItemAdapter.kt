package com.nha2023.ex98databindingbidnigadapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.nha2023.ex98databindingbidnigadapter.databinding.RecyclerItemBinding

class RecyclerItemAdapter(val context:Context, val items:List<Item>) : Adapter<RecyclerItemAdapter.VH>(){

    inner class VH(val binding : RecyclerItemBinding) : ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        val binding : RecyclerItemBinding = DataBindingUtil.inflate(LayoutInflater.from(context),R.layout.recycler_item,parent,false)
        return VH(binding)
    }

    override fun getItemCount(): Int {
      return items.size
    }

    override fun onBindViewHolder(holder: VH, position: Int) {
      //데이터 바인딩 되어 있기에 xml에 선언한 변수 item에 객체값만 설정해주면 알아서 모든 뷰들에 바인딩 된다.
        holder.binding.item = items[position]

        //아이템 클릭 이벤트 처리 -- 뷰바인딩...
        holder.binding.root.setOnClickListener {
            Toast.makeText(context, "${items[position]}", Toast.LENGTH_SHORT).show()
        }
    }

}

//ObservableXXX는 몇가지 단점이 있음.
//1.새로 set하는 객체가 변경되지 않으면 화면갱신이 안됨.
//2.액티비티나 프래그먼트의 라이프사이클을 고려하지않고 데이터 변경에 반응함
//3. 라이프사이클을 고려하지 않고 데이터변경에 반응함. 화면이 종료되는 상황에서도 갱신을 시도함.
//이런 단점을 개선하기위해 JetPack 라이브러리로 배포된 LiveData라는 녀석이 등장함.